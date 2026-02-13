import api from "../../../core/api.config.ts";
import type { TripDto } from "../interfaces/trip.dto.ts";
import type { StartTripDto } from "../interfaces/start-trip.dto.ts";

/**
 * @const TripService
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const TripService = {

    requestCurrentTrip: async () => {
        return await api.get<TripDto|null>("/trips/me/current");
    },

    startTrip: async (trip: StartTripDto) => {
        return await api.post("/trips", trip);
    },

} as const;