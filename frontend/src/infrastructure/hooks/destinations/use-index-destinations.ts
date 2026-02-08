import { useQuery } from "@tanstack/react-query";
import { requestIndexDestinations } from "../../services/destinations.service.ts";
import type { DestinationDto } from "../../interfaces/destinations/destination.dto.ts";

/**
 * @function useIndexDestinations
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useIndexDestinations = () => {
    return useQuery({
        queryKey: [ "destinations" ],
        queryFn: async (): Promise<DestinationDto[]> => {
            const { data } = await requestIndexDestinations();
            return data;
        },
    });
};