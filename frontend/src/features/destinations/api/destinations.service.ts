import api from "../../../core/api.config.ts";
import type {CreateDestinationDto} from "../interfaces/create-destination.dto.ts";

/**
 * @const DestinationService
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const DestinationService = {

    requestIndexDestinations: async () => {
        return await api.get("/destinations");
    },

    requestCreateDestination: async (destination: CreateDestinationDto) => {
        return await api.post("/destinations", destination);
    }

} as const;