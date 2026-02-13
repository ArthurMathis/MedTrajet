import api from "../../../core/api.config.ts";
import type { CreateDestinationDto } from "../interfaces/create-destination.dto.ts";
import type { DestinationDto } from "../interfaces/destination.dto.ts";

const basedUrl = "/destinations";

/**
 * @const DestinationService
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const DestinationService = {

    indexDestinations: async () => {
        return await api.get<DestinationDto[]>(basedUrl);
    },

    getDestination: async (destinationId: number) => {
        return await api.get<DestinationDto>(`${basedUrl}/${destinationId}`);
    },

    createDestination: async (destination: CreateDestinationDto) => {
        return await api.post(basedUrl, destination);
    }

} as const;