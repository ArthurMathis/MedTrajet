import { useMutation, useQueryClient } from "@tanstack/react-query";
import toast from "react-hot-toast";
import type { AxiosError } from "axios";
import type { EndTripDto } from "../interfaces/end-trip.dto.ts";
import { TripService } from "../api/trips.service.ts";

export const useEndTripHook = (onSuccessCallback?: () => void) => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (trip: EndTripDto) => TripService.endTrip(trip),
        onSuccess: async () =>  {
            await queryClient.refetchQueries({ queryKey: [ 'current-trip' ] });
            toast.success("Trajet terminé !");

            onSuccessCallback?.();
        },
        onError: (error: AxiosError<{ message: string }>) => {
            const errorMessage = error.response?.data?.message || "Une erreur est survenue";

            console.error("Erreur de création d'un trajet : ", error);
            toast.error(errorMessage);
        }
    });
};