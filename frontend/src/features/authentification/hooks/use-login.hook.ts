import { useMutation, useQueryClient } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import toast from "react-hot-toast";
import type { LoginUserDto } from "../interfaces/login-user.dto.ts";
import { AuthentificationService } from "../api/authentification.service.ts";
import type { AxiosError } from "axios";

/**
 * @function useLoginHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useLoginHook = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (credentials: LoginUserDto) => AuthentificationService.login(credentials),
        onSuccess: async () => {
            await queryClient.refetchQueries({ queryKey: ['auth-me'] });

            toast.success("Connexion réussie !");
            navigate('/dashboard/me');
        },
        onError: (error: AxiosError<{ message: string }>) => {
            const errorMessage = error.response?.data?.message || "Identifiants incorrects";

            console.error("Erreur d'authentification :", error);
            toast.error(errorMessage);
        }
    });
};
