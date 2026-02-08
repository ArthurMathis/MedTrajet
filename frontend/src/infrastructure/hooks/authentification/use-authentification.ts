import { useMutation } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import type { LoginUserDto } from "../../interfaces/users/login-user.dto.ts";
import { requestAuthentification } from "../../services/authentification.service.ts";

/**
 * @function useAuthentification
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useAuthentification = () => {
    const navigate = useNavigate();

    return useMutation({
        mutationFn: (credentials: LoginUserDto) => requestAuthentification(credentials),
        onSuccess: () => {
            alert("✅Authentification réussie");
            navigate('/dashboard');
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            alert("❌Identifiants incorrects");
        }
    });
};
