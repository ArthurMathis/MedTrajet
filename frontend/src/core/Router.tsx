import {createBrowserRouter, redirect} from "react-router-dom";
import { AuthentificationService } from "../features/authentification/api/authentification.service.ts";
import AuthLayout from "../presentation/layouts/AuthLayout.tsx";
import MainLayout from "../presentation/layouts/MainLayout.tsx";
import LoginPage from "../presentation/pages/LoginPage.tsx";
import HomePage from "../presentation/pages/HomePage.tsx";
import NotFoundPage from "../presentation/pages/NotFoundPage.tsx";
import CurrentTripPage from "../presentation/pages/CurrentTripPage.tsx";
import CreateDestinationPage from "../presentation/pages/CreateDestinationPage.tsx";

async function requireAuth() {
    try {
        return await AuthentificationService.getCurrentUser();
    } catch {
        throw redirect("/auth");
    }
}

export const router = createBrowserRouter([
    {
        path: "/",
        loader: () => redirect("/dashboard/me"),
    },
    {
        path: "/auth",
        element: <AuthLayout />,
        children: [
            {
                index: true,
                element: <LoginPage />
            },
        ],
    },
    {
        path: "/",
        element: <MainLayout />,
        loader: requireAuth,
        children: [
            {
                path: "/dashboard/me",
                element: <HomePage />
            },
            {
                path: "destinations/form",
                element: <CreateDestinationPage />
            },
            {
                path: "trips",
                children: [
                    {
                        index: true,
                        // todo : trips list
                    },
                    {
                        path: "current",
                        element: <CurrentTripPage />
                    }
                ]
            }
        ],
    },
    {
        path: "*",
        element: <NotFoundPage />,
    },
]);