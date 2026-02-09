import type { LoginUserDto } from "../interfaces/login-user.dto.ts";
import api from "../../../core/api.config.ts";
import type { UserDto } from "../interfaces/user.dto.ts";

/**
 * @const AuthentificationService
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const AuthentificationService = {

    getCurrentUser: async (): Promise<UserDto> => {
        const { data } = await api.get<UserDto>('/auth/me');
        return data;
    },

    login: async (credentials: LoginUserDto): Promise<void> => {
        await api.post('/auth/login', credentials);
    },

    logout: async (): Promise<void> => {
        await api.post('/auth/logout');
    }

} as const;