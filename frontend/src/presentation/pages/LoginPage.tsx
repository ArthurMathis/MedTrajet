import LoginForm from "../../features/authentification/components/LoginForm.tsx";
import FormCard from "../ui/FormCard.tsx";

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
                <FormCard children={<LoginForm />} />
            </div>
        </div>
    );
}

export default LoginPage;