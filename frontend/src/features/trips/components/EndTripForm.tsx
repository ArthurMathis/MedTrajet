import { useNavigate } from "react-router-dom";
import { ArrowLeft, Car, Loader2 } from "lucide-react";
import FormButtonFooter from "../../../presentation/ui/FormButtonFooter.tsx";
import { useGetCurrentTripHook } from "../hooks/use-get-current-trip.hook.ts";
import { useGetDestinationHook } from "../../destinations/hooks/use-get-destination.hook.ts";

/**
 * @function EndTripForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const EndTripForm = () => {
    const navigate = useNavigate();

    const { data: currentTrip, isLoading: isTripLoading } = useGetCurrentTripHook();
    const { data: destination, isLoading: isDestinationLoading } = useGetDestinationHook(currentTrip!.destinationId);

    return (
        <form className="lg:card-body">
            <fieldset className="fieldset">
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
                    value={currentTrip?.startMileage}
                />

                <FormButtonFooter>
                    <button
                        type="submit"
                        className="btn btn-soft w-1/2"
                        onClick={() => { navigate("/dashboard/me")}}
                    >
                        <ArrowLeft size={18} />
                        Retour
                    </button>

                    <button
                        type="submit"
                        className="btn btn-success w-1/2"
                    >
                        {isTripLoading || isDestinationLoading ? <Loader2 className="animate-spin" /> : <Car size={20} />}
                        {isTripLoading || isDestinationLoading ? "Arrivée..." : "Terminer"}
                    </button>
                </FormButtonFooter>
            </fieldset>
        </form>
    )
};

export default EndTripForm;