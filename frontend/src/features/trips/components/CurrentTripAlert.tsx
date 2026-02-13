import { useNavigate } from "react-router-dom";
import { Info } from "lucide-react";
import { useGetCurrentTripHook } from "../hooks/use-get-current-trip.hook.ts";

/**
 * @function CurrentTripAlert
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const CurrentTripAlert = () => {
    const navigate = useNavigate();

    const { data: currentTrip, isLoading } = useGetCurrentTripHook();

    if (isLoading || !currentTrip) {
        return null;
    }

    return (
        <div
            role="alert"
            className="
            alert alert-info alert-soft
            flex
            w-auto mx-4 my-2 lg:min-w-xl lg:max-w-2xl lg:mx-auto
            animate-appear
        "
        >
            <span className="flex-1">Un trajet est en cours...</span>

            <button
                className="btn btn-sm btn-outline btn-info"
                onClick={() => navigate("/trips/current")}
            >
                <Info size={20} />
                <span className="hidden lg:inline">Consulter</span>
            </button>
        </div>
    )
};

export default CurrentTripAlert;