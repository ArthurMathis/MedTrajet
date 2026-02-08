import type {LoginUserDto} from "../interfaces/users/login-user.dto.ts";
import api from "../api/api.config.ts";

export const requestAuthentification = async (credentials: LoginUserDto) :Promise<void> => {
    const response = await api.post('/auth', credentials);
    return response.data;
};