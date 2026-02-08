import api from "../api/api.config.ts";
import type {CreateDestinationDto} from "../interfaces/destinations/create-destination.dto.ts";

/**
 * @function requestIndexDestinations
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const requestIndexDestinations = async () => {
    return await api.get("/destinations");
};

/**
 * @function requestCreateDestination
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const requestCreateDestination = async (destination: CreateDestinationDto) => {
    return await api.post("/destinations", destination);
};