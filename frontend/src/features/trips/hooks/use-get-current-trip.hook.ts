import {useQuery} from "@tanstack/react-query";
import type {TripDto} from "../interfaces/trip.dto.ts";
import {TripService} from "../api/trips.service.ts";

/**
 * @function useGetCurrentTripHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useGetCurrentTripHook = () => {
    return useQuery({
        queryKey: [ 'current-trip' ],
        queryFn: async (): Promise<TripDto|null> => {
            const { data } = await TripService.requestCurrentTrip();
            return data;
        }
    });
}