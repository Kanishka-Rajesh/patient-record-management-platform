import { loginUser } from "./api.js";

document.addEventListener("DOMContentLoaded", () => {

    console.log("DOM.JS IS RUNNING");

    const loginForm = document.querySelector(".login-form");
    const emailInput = document.getElementById("email");
    const passwordInput = document.getElementById("password");

    loginForm.addEventListener("submit", async (event) => {

        event.preventDefault();

        const username = emailInput.value.trim();
        const password = passwordInput.value;

        if (!username || !password) {
            window.alertSystem.error("Please enter username and password.");
            return;
        }

        try {

            const { status, data } = await loginUser(username, password);

            console.log(status);
            console.log(data);

            if (status === 200) {

                localStorage.setItem("token", data.token);
                localStorage.setItem("username", data.username);
                localStorage.setItem("role", data.role);

                window.alertSystem.success("Login Successful");

                setTimeout(() => {

                    const role = data.role;

                    if (role === "ROLE_ADMIN" || role === "ROLE_DOCTOR") {

                        window.location.href = "../Doctor-dashboard/index.html";

                    } else if (role === "ROLE_RECEPTIONIST") {

                        window.location.href = "../Receptionst-dashboard/index.html";

                    } else if (role === "ROLE_PATIENT") {

                        window.location.href = "../Patient-dashboard/index.html";

                    } else {

                        window.alertSystem.error("Unknown Role : " + role);

                    }

                }, 1200);

            } else {

                window.alertSystem.error(
                    data.message || "Login failed. Please try again."
                );

            }

        } catch (err) {

            console.error(err);
            window.alertSystem.error("Something went wrong.");

        }

    });

});