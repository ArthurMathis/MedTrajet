import axios from 'axios';
import toast from "react-hot-toast";

const api = axios.create({
    baseURL: 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
    },
    withCredentials: true,
});

api.interceptors.response.use(
    (response) => response,
    (error) => {
        const status = error.response?.status;

        if (status === 401) {
            toast.error("Session expirée ou non autorisée");
            console.error("Session expirée ou non autorisée");
        }

        if (status === 500) {
            toast.error("Le serveur est en panne");
            console.error("Le serveur est en panne");
        }

        return Promise.reject(error);
    }
);

export default api;