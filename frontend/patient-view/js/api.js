// ===============================
// api.js
// Handles all Backend API Calls
// ===============================

// Backend Base URL
const API_BASE_URL = "http://localhost:8080/api";

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

/**
 * Sample Data
 * Used only if backend is unavailable
 */
export const sampleData = [
    {
        id: 65,
        name: "karthick",
        dateOfBirth: "2025-04-03",
        weight: 45,
        mobileNumber: "9360607300"
    },
    {
        id: 66,
        name: "karthick-2",
        dateOfBirth: "2025-04-03",
        weight: 45,
        mobileNumber: "9360607300"
    }
];

/**
 * Fetch All Patients
 */
export async function fetchPatients() {

    try {

        const response = await fetch(
            `${API_BASE_URL}/patients`,
            {
                method: "GET",
                headers: getAuthHeaders()
            }
        );

        if (!response.ok) {

            throw new Error(
                `Failed to fetch patients (${response.status})`
            );

        }

        return await response.json();

    } catch (error) {

        console.warn("Using fallback patient data", error);

        return {
            statusCode: 200,
            message: "Offline Mode",
            data: sampleData
        };

    }

}

/**
 * Search Patients
 */
export async function searchPatientsByName(name) {

    try {

        if (!name || name.trim() === "") {
            return fetchPatients();
        }

        const response = await fetch(

            `${API_BASE_URL}/prescriptions/search?name=${encodeURIComponent(name)}`,

            {
                method: "GET",
                headers: getAuthHeaders()
            }

        );

        if (!response.ok) {

            throw new Error(
                `Search failed (${response.status})`
            );

        }

        return await response.json();

    }

    catch (error) {

        console.warn(error);

        return {

            statusCode: 200,

            message: "Offline Search",

            data: sampleData.filter(patient =>

                patient.name
                    .toLowerCase()
                    .includes(name.toLowerCase())

            )

        };

    }

}

/**
 * Create Patient
 */
export async function createPatient(patientData) {

    try {

        const response = await fetch(

            `${API_BASE_URL}/patients`,

            {

                method: "POST",

                headers: getAuthHeaders(),

                body: JSON.stringify(patientData)

            }

        );

        const result = await response.json();

        console.log("Create Patient Response:", result);

        if (!response.ok) {

            throw new Error(
                result.message || "Failed to create patient"
            );

        }

        return result;

    }

    catch (error) {

        console.error(error);

        throw error;

    }

}
/**
 * Fetch Prescriptions by Patient ID
 */
export async function fetchPrescriptionsByPatientId(patientId) {

    try {

        const response = await fetch(

            `${API_BASE_URL}/prescriptions/patient/${patientId}`,

            {
                method: "GET",
                headers: getAuthHeaders()
            }

        );

        if (!response.ok) {

            throw new Error(
                `Failed to fetch prescriptions (${response.status})`
            );

        }

        const result = await response.json();

        // If backend returns wrapped response
        if (result.statusCode === 200 && result.data) {

            const prescriptions = result.data.prescriptions || [];

            return prescriptions.map(prescription => ({

                patientId: result.data.patientId,

                symptoms: prescription.symptoms || "",

                findings: prescription.findings || "",

                diagnosis: prescription.diagnosis || "",

                date: prescription.date || new Date().toISOString(),

                medications: (prescription.medications || []).map(med => ({

                    medicationName: med.name || med.medicationName || "",

                    name: med.name || med.medicationName || "",

                    dosage: med.dosage || "",

                    duration: med.duration || "",

                    frequency: med.frequency || med.notes || "",

                    notes: med.notes || ""

                }))

            }));

        }

        // If backend returns array directly
        return Array.isArray(result) ? result : [result];

    }

    catch (error) {

        console.error("Prescription Error:", error);

        return [];

    }

}

/**
 * Generate Patient ID (Offline Mode Only)
 */
export function generatePatientCode() {

    return Math.floor(
        1000 + Math.random() * 9000
    );

}

/**
 * Offline Prescription Data
 */
export function getPrescriptionData(patientId) {

    return {

        patientId,

        symptoms: "Fever, Headache",

        findings: "Mild Viral Infection",

        diagnosis: "Viral Fever",

        medications: [

            {

                medicationName: "Paracetamol",

                dosage: "500mg",

                duration: "5 Days",

                frequency: "Twice Daily",

                notes: "After Food"

            }

        ]

    };

}

/**
 * Calculate Patient Age
 */
export function calculateAge(dateOfBirth) {

    if (!dateOfBirth) return "";

    const birthDate = new Date(dateOfBirth);

    const today = new Date();

    let age = today.getFullYear() - birthDate.getFullYear();

    const monthDifference =
        today.getMonth() - birthDate.getMonth();

    if (

        monthDifference < 0 ||

        (

            monthDifference === 0 &&

            today.getDate() < birthDate.getDate()

        )

    ) {

        age--;

    }

    return age;

}

/**
 * Save JWT after Login
 */
export function saveToken(token) {

    localStorage.setItem("token", token);

}

/**
 * Read JWT
 */
export function getToken() {

    return localStorage.getItem("token");

}

/**
 * Logout User
 */
export function logout() {

    localStorage.removeItem("token");

    window.location.href = "login.html";

}