import { useMutation } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import type { LoginUserDto } from "../../interfaces/users/login-user.dto.ts";
import { requestLogin } from "../../services/authentification.service.ts";
import toast from "react-hot-toast";

/**
 * @function useLogin
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useLogin = () => {
    const navigate = useNavigate();

    return useMutation({
        mutationFn: (credentials: LoginUserDto) => requestLogin(credentials),
        onSuccess: () => {
            toast.success("Connexion réussie !");
            navigate('/dashboard/me');
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            toast.error("Identifiants incorrects");
        }
    });
};
