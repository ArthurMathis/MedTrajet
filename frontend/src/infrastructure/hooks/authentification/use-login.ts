import { useMutation } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import type { LoginUserDto } from "../../interfaces/users/login-user.dto.ts";
import { requestLogin } from "../../services/authentification.service.ts";

/**
 * @function useLogin
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useLogin = () => {
    const navigate = useNavigate();

    return useMutation({
        mutationFn: (credentials: LoginUserDto) => requestLogin(credentials),
        onSuccess: () => {
            alert("✅Authentification réussie");
            navigate('/dashboard/me');
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            alert("❌Identifiants incorrects");
        }
    });
};
