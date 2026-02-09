import {useNavigate} from "react-router-dom";
import { useMutation, useQueryClient}  from "@tanstack/react-query";
import type { CreateDestinationDto } from "../interfaces/create-destination.dto.ts";
import toast from "react-hot-toast";
import { DestinationService } from "../api/destinations.service.ts";

/**
 * @function useCreateDestinationHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useCreateDestinationHook = () => {
    const navigate = useNavigate();
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (destination: CreateDestinationDto)=> DestinationService.requestCreateDestination(destination),
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