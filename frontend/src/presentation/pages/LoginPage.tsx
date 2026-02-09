import LoginForm from "../../features/authentification/components/LoginForm.tsx";

/**
 * @function LoginPage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const LoginPage = () => {
    return (
        <div className="hero bg-base-100 min-h-screen">
            <div className="hero-content flex-col w-full">
                <div className="text-center">
                    <h1 className="text-5xl font-bold">MedTrajet</h1>
                    <p className="py-6">Connecte-toi pour accéder à l'application.</p>
                </div>
                <div className="w-full lg:card lg:bg-base-100 max-w-sm lg:max-w-xl lg:shrink-0 lg:shadow-2xl">
                    <div className="lg:card-body">
                        <LoginForm />
                    </div>
                </div>
            </div>
        </div>
    );
}

export default LoginPage;