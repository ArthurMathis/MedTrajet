import { useQuery } from "@tanstack/react-query";
import { DestinationService } from "../api/destinations.service.ts";

/**
 * @function useGetDestinationHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useGetDestinationHook= (destinationId: number) => {
    return useQuery({
        queryKey: [ "get-destination", destinationId ],
        queryFn: async () => {
            const { data } = await DestinationService.getDestination(destinationId);
            return data;
        }
    });
};