import {useNavigate} from "react-router-dom";
import {useMutation, useQueryClient} from "@tanstack/react-query";
import type {CreateDestinationDto} from "../../interfaces/destinations/create-destination.dto.ts";
import {requestCreateDestination} from "../../services/destinations.service.ts";
import toast from "react-hot-toast";

/**
 * @function useCreateDestination
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useCreateDestination = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (destination: CreateDestinationDto)=> requestCreateDestination(destination),
        onSuccess: () => {
            toast.success("Destination enregistrée !");
            queryClient.invalidateQueries({ queryKey: [ "destinations" ] })
            navigate("/dashboard/me");
        },
        onError: (error: never) => {
            console.error("Erreur d'authentification :", error);
            toast.error("Erreur lors de la création");
        }
    });
}