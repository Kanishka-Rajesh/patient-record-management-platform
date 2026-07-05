const API_BASE_URL = "https://patient-record-management-platform-production.up.railway.app/api";

/**
 * Get JWT Authentication Headers
 */
function getAuthHeaders() {
    const token = localStorage.getItem("token");

    return {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    };
}
import {
  addMenuItemEventListener,
  setupInitialState,
  setupLogout,
} from "./dom.js";

addMenuItemEventListener();
setupInitialState();
setupLogout(); // Make sure this is called


export async function fetchAppointments() {
  try {
    const response = await fetch(`${API_BASE_URL}/appointments`, {
      method: "GET",
      headers: getAuthHeaders(),
    });

    if (!response.ok) {
      throw new Error("Failed to fetch appointments");
    }

    return await response.json();
  } catch (error) {
    console.error("Fetch Appointment Error:", error);

    return [];
  }
}

export async function createAppointment(appointmentData) {
  try {
    const response = await fetch(`${API_BASE_URL}/appointments`, {
      method: "POST",
      headers: getAuthHeaders(),
      body: JSON.stringify(appointmentData),
    });

    if (!response.ok) {
      const error = await response.text();
      throw new Error(error);
    }

    return await response.json();
  } catch (error) {
    console.error("Create Appointment Error:", error);
    throw error;
  }
}

export async function updateAppointment(id, appointmentData) {
  try {
    const response = await fetch(`${API_BASE_URL}/appointments/${id}`, {
      method: "PUT",
      headers: getAuthHeaders(),
      body: JSON.stringify(appointmentData),
    });

    if (!response.ok) {
      throw new Error("Failed to update appointment");
    }

    return await response.json();
  } catch (error) {
    console.error("Update Appointment Error:", error);
    throw error;
  }
}

export async function deleteAppointment(id) {
  try {
    const response = await fetch(`${API_BASE_URL}/appointments/${id}`, {
      method: "DELETE",
      headers: getAuthHeaders(),
    });

    if (!response.ok) {
      throw new Error("Failed to delete appointment");
    }

    return await response.text();
  } catch (error) {
    console.error("Delete Appointment Error:", error);
    throw error;
  }
}

