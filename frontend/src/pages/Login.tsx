import type {LoginUserDto} from "../infrastructure/interfaces/users/login-user.dto.ts";
import {useForm} from "react-hook-form";
import {useAuthentification} from "../infrastructure/hooks/authentification/use-authentification.ts";

/**
 * @function Login
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
function Login() {
    const { register, handleSubmit, formState: { errors } } = useForm<LoginUserDto>();

    const { mutate, isPending } = useAuthentification();

    const onSubmit = (data: LoginUserDto) => {
        mutate(data);
    };

    return (
        <div className="hero bg-base-100 min-h-screen min-w-screen">
            <div className="hero-content flex-col w-full">
                <div className="text-center lg:text-left">
                    <h1 className="text-5xl font-bold">MedTrajet</h1>
                    <p className="py-6">
                        Connecte-toi pour accéder à l'application.
                    </p>
                </div>
                <div className="card bg-base-100 w-full max-w-sm lg:max-w-xl shrink-0 shadow-2xl">
                    <form
                        className="card-body"
                        onSubmit={handleSubmit(onSubmit)}
                    >
                        <fieldset className="fieldset">
                            <label className="label">Email</label>
                            <input
                                type="email"
                                className="input w-full"
                                placeholder="Email"
                                {...register("email", {
                                    required: "L'email est requis",
                                    pattern: { value: /^\S+@\S+$/i, message: "Email invalide" }
                                })}
                            />
                            {errors.email && <span className="text-error text-xs">{errors.email.message}</span>}

                            <label className="label">Password</label>
                            <input
                                type="password"
                                className="input w-full"
                                placeholder="Password"
                                {...register("password", {
                                    required: "Le mot de passe est requis",
                                    minLength: { value: 6, message: "Minimum 6 caractères" }
                                })}
                            />
                            {errors.password && <span className="text-error text-xs">{errors.password.message}</span>}

                            <div><a className="link link-hover">Forgot password?</a></div>
                            <button
                                type="submit"
                                className="btn btn-success mt-4"
                                disabled={isPending}
                            >
                                {isPending ? (
                                    <span className="loading loading-spinner"></span>
                                ) : "Login"}
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    )
}

export default Login;