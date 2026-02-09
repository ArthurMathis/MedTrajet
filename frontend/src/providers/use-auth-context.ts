import {useContext} from "react";
import { AuthContext } from "./AuthContext.tsx";

/**
 * @function useAuthContext
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useAuthContext = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth doit être utilisé dans un AuthProvider");
    }
    return context;
};