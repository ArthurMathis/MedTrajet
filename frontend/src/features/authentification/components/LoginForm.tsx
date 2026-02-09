import { useForm } from "react-hook-form";
import { useLoginHook } from "../hooks/use-login.hook.ts";
import type { LoginUserDto } from "../interfaces/login-user.dto.ts";


/**
 * @function LoginForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export default function LoginForm() {
    const { register, handleSubmit, formState: { errors } } = useForm<LoginUserDto>();
    const { mutate, isPending } = useLoginHook();

    const onSubmit = (data: LoginUserDto) => mutate(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <fieldset className="fieldset">
                <label className="label">Email</label>
                <input
                    type="email"
                    className={`input w-full ${errors.email ? 'input-error' : ''}`}
                    placeholder="Email"
                    {...register("email", { required: "L'email est requis" })}
                />
                {errors.email && <span className="text-error text-xs">{errors.email.message}</span>}

                <label className="label">Password</label>
                <input
                    type="password"
                    className={`input w-full ${errors.password ? 'input-error' : ''}`}
                    placeholder="Password"
                    {...register("password", { required: "Requis" })}
                />

                <button className="btn btn-success mt-4" disabled={isPending}>
                    {isPending ? <span className="loading loading-spinner"></span> : "Login"}
                </button>
            </fieldset>
        </form>
    );
}