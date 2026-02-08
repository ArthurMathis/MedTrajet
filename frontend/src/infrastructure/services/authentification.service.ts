import type { LoginUserDto } from "../interfaces/users/login-user.dto.ts";
import api from "../api/api.config.ts";

/**
 * @function requestLogin
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const requestLogin = async (credentials: LoginUserDto) :Promise<void> => {
    const response = await api.post('/auth/login', credentials);
    return response.data;
};

/**
 * @function requestLogout
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const requestLogout = async () => {
    return await api.post("/auth/logout");
};