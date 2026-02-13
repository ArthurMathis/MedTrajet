import { createContext, useState } from "react";
import type { AuthContextType } from "./auth-context.type.ts";
import type { UserDto } from "../../features/authentification/interfaces/user.dto.ts";
import * as React from "react";

const AuthContext = createContext<AuthContextType | undefined>(undefined);

/**
 * @function AuthProvider
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const AuthProvider = ({ children, initialUser }: { children: React.ReactNode, initialUser: UserDto }) => {
    const [user, setUser] = useState<UserDto|null>(initialUser);

    return (
        <AuthContext.Provider value={{ user, setUser }}>
            {children}
        </AuthContext.Provider>
    )
}

export { AuthContext, AuthProvider };