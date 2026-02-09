import { Check, X } from "lucide-react";

/**
 * @function CurrentWayAlert
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export const CurrentWayAlert = () => {
    return (
        <div
            role="alert"
            className="
                alert alert-info alert-soft
                flex
                w-auto mx-4 my-2 lg:max-w-128 lg:mx-auto
                animate-appear
            "
        >
            <span className="flex-1">Un trajet est en cours...</span>

            <div className="flex gap-2">
                <button className="btn btn-sm btn-error">
                    <X size={20} />
                    <span className="hidden lg:inline">Annuler</span>
                </button>
                <button className="btn btn-sm btn-success">
                    <Check size={20} />
                    <span className="hidden lg:inline">Terminer</span>
                </button>
            </div>
        </div>
    )
};

export default CurrentWayAlert;