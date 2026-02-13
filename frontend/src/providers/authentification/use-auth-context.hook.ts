import {useContext} from "react";
import { AuthContext } from "./AuthContext.tsx";

/**
 * @function useAuthContextHook
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const useAuthContextHook = () => {
    const context = useContext(AuthContext);
    if (!context) {
        throw new Error("useAuth doit être utilisé dans un AuthProvider");
    }
    return context;
};