import { useMutation, useQueryClient } from '@tanstack/react-query';
import { useNavigate } from 'react-router-dom';
import { requestLogout } from "../../services/authentification.service.ts";
import toast from "react-hot-toast";

/**
 * @function useLogout
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useLogout = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: ( ) => requestLogout(),
        onSuccess: () => {
            toast.success("Déconnexion réussie");
            queryClient.clear();
            navigate('/auth');
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            toast.error("Échec de déconnexion");
        }
    });
};
