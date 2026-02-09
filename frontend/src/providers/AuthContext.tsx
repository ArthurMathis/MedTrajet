import { createContext, useEffect, useState } from "react";
import type { AuthContextType } from "./auth-context.type.ts";
import type { UserDto } from "../features/authentification/interfaces/user.dto.ts";
import * as React from "react";
import {AuthentificationService} from "../features/authentification/api/authentification.service.ts";

const AuthContext = createContext<AuthContextType | undefined>(undefined);

/**
 * @function AuthProvider
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const AuthProvider = ({ children }: { children: React.ReactNode }) => {
    const [user, setUser] = useState<UserDto | null>(null);
    const [isLoading, setIsLoading] = useState(true);

    const checkAuth = async () => {
        setIsLoading(true);
        try {
            const userData = await AuthentificationService.getCurrentUser();
            setUser(userData);
        } catch {
            setUser(null);
        } finally {
            setIsLoading(false);
        }
    };

    useEffect(() => {
        checkAuth();
    }, []);

    // useEffect(() => {
    //     requestCurrentUser()
    //         .then((userData: UserDto) => setUser(userData))
    //         .catch(() => setUser(null))
    //         .finally(() => setIsLoading(false));
    // }, []);

    return (
        <AuthContext.Provider value={{ user, isLoading, setUser, checkAuth }}>
            {children}
        </AuthContext.Provider>
    )
}

export { AuthContext, AuthProvider };