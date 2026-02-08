import api from "../api/api.config.ts";

/**
 * @function requestDestinations
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const requestDestinations = async () => {
    return await api.get("/destinations");
};
