import { Outlet, useLoaderData } from "react-router-dom";
import { AuthProvider } from "../../providers/authentification/AuthContext.tsx";
import type { UserDto}  from "../../features/authentification/interfaces/user.dto.ts";
import Header from "../ui/Header.tsx";
import Dock from "../ui/Dock.tsx";

/**
 * @function MainLayout
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const MainLayout = ()=> {
    const user = useLoaderData() as UserDto;

    return (
        <main className="min-h-screen flex flex-col">
            <AuthProvider initialUser={user}>
                <Header />
                <Outlet />
                <Dock />
            </AuthProvider>
        </main>
    )
}

export default MainLayout;