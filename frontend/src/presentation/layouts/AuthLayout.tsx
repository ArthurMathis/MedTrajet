import { Outlet } from "react-router-dom";

/**
 * @function MainLayout
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const AuthLayout = ()=> {
    return (
        <main className="min-h-screen flex flex-col">
            <Outlet />
        </main>
    )
}

export default AuthLayout;