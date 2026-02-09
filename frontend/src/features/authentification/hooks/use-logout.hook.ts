import { useMutation, useQueryClient } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import toast from "react-hot-toast";
import { AuthentificationService } from "../api/authentification.service.ts";

/**
 * @function useLogoutHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useLogoutHook = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: ( ) => AuthentificationService.logout(),
        onSettled: () => {
            queryClient.clear();
            navigate('/auth', { replace: true });
            toast.success("Déconnexion réussie");
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            toast.error("Échec de déconnexion");
        }
    });
};
