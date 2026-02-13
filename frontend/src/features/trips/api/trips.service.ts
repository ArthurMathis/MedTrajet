import api from "../../../core/api.config.ts";
import type { TripDto } from "../interfaces/trip.dto.ts";
import type { StartTripDto } from "../interfaces/start-trip.dto.ts";
import type {EndTripDto} from "../interfaces/end-trip.dto.ts";

const basedUrl = "/trips";

/**
 * @const TripService
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const TripService = {

    requestCurrentTrip: async () => {
        return await api.get<TripDto|null>(`${basedUrl}/me/current`);
    },

    startTrip: async (trip: StartTripDto) => {
        return await api.post(`${basedUrl}`, trip);
    },

    endTrip: async (trip: EndTripDto) => {
        return await api.put(`${basedUrl}`, trip);
    },

} as const;