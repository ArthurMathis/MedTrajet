import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { ArrowLeft, Save } from "lucide-react";
import type { CreateDestinationDto } from "../interfaces/create-destination.dto.ts";
import { useCreateDestinationHook } from "../hooks/use-create-destination.hook.ts";
import FormButtonFooter from "../../../presentation/ui/FormButtonFooter.tsx";

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

                <FormButtonFooter>
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
                    </FormButtonFooter>
            </fieldset>
        </form>
    )
};

export default DestinationForm;