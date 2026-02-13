import type { UserDto } from "../../features/authentification/interfaces/user.dto.ts";

/**
 * @interface AuthContextType
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export interface AuthContextType {
    user: UserDto | null;
    setUser: (user: UserDto|null) => void;
}