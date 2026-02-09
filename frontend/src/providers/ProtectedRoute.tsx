import { Navigate } from 'react-router-dom';
import { useAuthContext } from "./use-auth-context.ts";
import * as React from "react";

export const ProtectedRoute = ({ children }: { children: React.ReactNode }) => {
    const { user, isLoading } = useAuthContext();

    if (isLoading) {
        return <p>Chargement...</p>;
    }

    if (!user) {
        return <Navigate to="/auth" replace />;
    }

    return <>{children}</>;
};
