import { useNavigate } from "react-router-dom";
import { useForm } from "react-hook-form";
import { ArrowLeft, Car, Loader2 } from "lucide-react";
import FormButtonFooter from "../../../presentation/ui/FormButtonFooter.tsx";
import type { EndTripDto } from "../interfaces/end-trip.dto.ts";
import { useGetCurrentTripHook } from "../hooks/use-get-current-trip.hook.ts";
import { useGetDestinationHook } from "../../destinations/hooks/use-get-destination.hook.ts";
import { useEndTripHook } from "../hooks/use-end-trip.hook.ts";

/**
 * @function EndTripForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const EndTripForm = () => {
    const navigate = useNavigate();

    const { mutate: endTrip, isPending } = useEndTripHook(() => {
        navigate('/dashboard/me')
    });

    const { data: currentTrip, isLoading: isTripLoading } = useGetCurrentTripHook();
    const { data: destination, isLoading: isDestinationLoading } = useGetDestinationHook(currentTrip!.destinationId);

    const { register, handleSubmit, formState: { errors } } = useForm<EndTripDto>();

    const onSubmit = (trip: EndTripDto) => endTrip(trip);

    const isDisabled = () => {
        return isTripLoading || isDestinationLoading || isPending;
    }

    return (
        <form
            className="lg:card-body"
            onSubmit={handleSubmit(onSubmit)}
        >
            <fieldset className="fieldset">
                <input
                    type="number"
                    className="hidden"
                    value={currentTrip?.id}
                    disabled={true}
                    {...register("id", {
                        required: "L'identifiant du trajet est requis",
                        min : { value : 0, message : "L'identifiant du trajet est requis" }
                    })}
                />

                <label className="label">Destination</label>
                <input
                    type="text"
                    className="input w-full"
                    value={destination?.name}
                    disabled={true}
                />

                <label className="label mt-1">Kilométrage au départ</label>
                <input
                    type="number"
                    className="input w-full"
                    value={currentTrip?.startMileage}
                    disabled={true}
                />

                <label className="label mt-1">Kilométrage à l'arrivée</label>
                <input
                    type="number"
                    className="input w-full"
                    defaultValue={currentTrip?.startMileage}
                    {...register("endMileage", {
                        required: "Le kilométrage est requis",
                        min : { value : currentTrip!.startMileage, message : "Le kilométrage ne peut pas être négatif" }
                    })}
                />
                {errors.endMileage && (
                    <span className="text-error text-xs mt-1">{errors.endMileage.message}</span>
                )}

                <FormButtonFooter>
                    <button
                        type="submit"
                        className="btn btn-soft w-1/2"
                        onClick={() => { navigate("/dashboard/me") }}
                    >
                        <ArrowLeft size={18} />
                        Retour
                    </button>

                    <button
                        type="submit"
                        className="btn btn-success w-1/2"
                    >
                        {isDisabled() ? <Loader2 className="animate-spin" /> : <Car size={20} />}
                        {isDisabled() ? "Arrivée..." : "Terminer"}
                    </button>
                </FormButtonFooter>
            </fieldset>
        </form>
    )
};

export default EndTripForm;