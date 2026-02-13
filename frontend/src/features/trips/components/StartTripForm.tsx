import { useForm } from "react-hook-form";
import { useNavigate } from "react-router-dom";
import { Car, Loader2 } from "lucide-react";
import type { DestinationDto } from "../../destinations/interfaces/destination.dto.ts";
import type { StartTripDto } from "../interfaces/start-trip.dto.ts";
import { useIndexDestinationsHook } from "../../destinations/hooks/use-index-destinations.hook.ts";
import { useStartTripHook } from "../hooks/use-start-trip.hook.ts";
import { useAuthContextHook } from "../../../providers/authentification/use-auth-context.hook.ts";
import { useGetCurrentTripHook } from "../hooks/use-get-current-trip.hook.ts";

/**
 * @function StartTripForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const StartTripForm = () => {
    const navigate = useNavigate();

    const { user } = useAuthContextHook();

    const { data: destinations, isLoading } = useIndexDestinationsHook();
    const { data: currentTrip } = useGetCurrentTripHook();

    const { mutate: startTrip, isPending } = useStartTripHook();

    const { register, handleSubmit, formState: { errors } } = useForm<StartTripDto>();

    const onSubmit = (data: StartTripDto) => {
        const tripPayload = {
            userId: user?.id,
            destinationId: data.destinationId,
            startMileage: data.startMileage,
        };

        startTrip(tripPayload as StartTripDto, {
        });
    };

    return (
        <form
            className="lg:card-body"
            onSubmit={handleSubmit(onSubmit)}
        >
            <fieldset className="fieldset">
                <label className="label">Destination</label>
                <select
                    className="select w-full"
                    disabled={isLoading}
                    {...register("destinationId", {
                        required: "La destination est requise"
                    })}
                >
                    <option disabled={true} selected={true}>Sélectionnez une destination</option>
                    {destinations?.map((dest: DestinationDto) => (
                        <option key={dest.id} value={dest.id}>{dest.name}</option>
                    ))}
                </select>


                <span onClick={() => { navigate("/destinations/form") }}>
                    <p className="link link-hover">Saisir un nouvelle destination</p>
                </span>

                <label className="label mt-1">Kilométrage au départ</label>
                <input
                    type="number"
                    className="input w-full"
                    placeholder="1 200 Km"
                    {...register("startMileage", {
                        required: "Le kilométrage est requis",
                        min : { value : 0, message : "Le kilométrage ne peut pas être négatif" }
                    })}
                />
                {errors.startMileage && (
                    <span className="text-error text-xs mt-1">{errors.startMileage.message}</span>
                )}

                <button
                    type="submit"
                    className="btn btn-success mt-4"
                    disabled={currentTrip == null}
                >
                    {isPending ? <Loader2 className="animate-spin" /> : <Car size={20} />}
                    {isPending ? "Démarrage..." : "Commencer"}
                </button>
            </fieldset>
        </form>
    )
};

export default StartTripForm;