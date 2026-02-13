import { useMutation, useQueryClient } from "@tanstack/react-query";
import toast from "react-hot-toast";
import type { AxiosError } from "axios";
import type { StartTripDto } from "../interfaces/start-trip.dto.ts";
import { TripService } from "../api/trips.service.ts";

export const useStartTripHook = (onSuccessCallback?: () => void) => {
    const queryClient = useQueryClient();

    return useMutation({
        mutationFn: (trip: StartTripDto) => TripService.startTrip(trip),
        onSuccess: async () =>  {
            await queryClient.refetchQueries({ queryKey: [ 'current-trip' ] });
            toast.success("Trajet démarré !");

            if(onSuccessCallback) {
                onSuccessCallback();
            }
        },
        onError: (error: AxiosError<{ message: string }>) => {
            const errorMessage = error.response?.data?.message || "Une erreur est survenue";

            console.error("Erreur de création d'un trajet : ", error);
            toast.error(errorMessage);
        }
    });
};