import { useQuery } from "@tanstack/react-query";
import type { DestinationDto } from "../interfaces/destination.dto.ts";
import { DestinationService } from "../api/destinations.service.ts";

/**
 * @function useIndexDestinationsHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useIndexDestinationsHook = () => {
    return useQuery({
        queryKey: [ "destinations" ],
        queryFn: async (): Promise<DestinationDto[]> => {
            const { data } = await DestinationService.requestIndexDestinations();
            return data;
        },
    });
};