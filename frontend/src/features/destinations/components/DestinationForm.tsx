import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { ArrowLeft, Save } from "lucide-react";
import type { CreateDestinationDto } from "../interfaces/create-destination.dto.ts";
import { useCreateDestinationHook } from "../hooks/use-create-destination.hook.ts";

/**
 * @function DestinationForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const DestinationForm = () => {
    const { register, handleSubmit, formState: { errors } } = useForm<CreateDestinationDto>();
    const navigate = useNavigate();

    const { mutate, isPending } = useCreateDestinationHook();

    const onSubmit = (data: CreateDestinationDto) => {
        mutate(data);
    };

    return(
        <div className="hero bg-base-100 w-full h-full lg:flex-1 lg:mb-6">
            <div className=" hero-content flex-col w-full lg:gap-4">
                <div className="w-full text-left lg:max-w-2xl">
                    <h1 className="text-2xl font-bold lg:text-5xl">Nouvelle destination</h1>
                    <p className="pt-2 text-sm lg:pt-5 lg:text-base">
                        Inscris une <b>nouvelle destination</b> pour suivre tes kilomètres ! 🗺️
                    </p>
                    <p className="pt-1 text-sm lg:text-base">
                        Tu pourras ensuite <b>l'annuler à tout moment</b> ou le <b>confirmer</b>, une fois arrivé. 💡
                    </p>
                </div>

                <div className="w-full mt-2 lg:mt-0 lg:card lg:max-w-2xl lg:shrink-0 lg:shadow-2xl lg:mt-6">
                    <form
                        className="lg:card-body"
                        onSubmit={handleSubmit(onSubmit)}
                    >
                        <fieldset className="fieldset">
                            <label className="label">Destination</label>
                            <input
                                type="text"
                                className="input w-full"
                                placeholder="Chez mon fils préféré"
                                {...register("name", {
                                    required: "La destination est requise",
                                    minLength: { value: 2, message: "Minimum 2 caractères" }
                                })}
                            />
                            {errors.name && <span className="text-error text-xs">{errors.name.message}</span>}

                            <footer className="flex gap-2 w-full mt-4">
                                <button
                                    type="submit"
                                    className="btn btn-soft w-1/2"
                                    disabled={isPending}
                                    onClick={() => { navigate("/dashboard/me")}}
                                >
                                    <ArrowLeft size={18} />
                                    Retour
                                </button>

                                <button
                                    type="submit"
                                    className="btn btn-success w-1/2"
                                    disabled={isPending}
                                >
                                    {isPending ? (
                                        <span className="loading loading-spinner"></span>
                                    ) : (
                                        <>
                                            <Save size={18} />
                                            Inscrire
                                        </>
                                    )}
                                </button>
                            </footer>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    )
};

export default DestinationForm;