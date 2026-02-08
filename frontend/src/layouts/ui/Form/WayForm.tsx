import { useIndexDestinations } from "../../../infrastructure/hooks/destinations/use-index-destinations.ts";
import { useState } from "react";
import type {DestinationDto} from "../../../infrastructure/interfaces/destinations/destination.dto.ts";
import {useNavigate} from "react-router-dom"; // todo : remplace by useForm

// todo: add new destination

/**
 * @function WayForm
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const WayForm = () => {
    const navigate = useNavigate();

    const { data: destinations, isLoading } = useIndexDestinations();

    const [destination, setDestination] = useState("");

    return (
        <div className="hero bg-base-100 w-full lg:flex-1 lg:mb-6">
            <div className="hero-content flex-col w-full lg:flex-row-reverse lg:gap-10">
                <div className="text-left">
                    <h1 className="text-2xl font-bold lg:text-5xl">Nouveau trajet</h1>
                    <p className="pt-2 text-sm lg:pt-5 lg:text-base">
                        Enregistre ton Nouveau départ ! 🏎️
                    </p>
                    <p className="pt-1 text-sm lg:text-base">
                        Tu pourras ensuite <b>l'annuler à tout moment</b> ou le <b>confirmer</b>, une fois arrivé. 💡
                    </p>
                </div>

                <div className="w-full mt-2 lg:mt-0 lg:card lg:max-w-xl lg:shrink-0 lg:shadow-2xl lg:mt-6">
                    <form className="lg:card-body">
                        <fieldset className="fieldset">
                            <label className="label">Destination</label>
                            <input
                                type="text"
                                className="input w-full"
                                placeholder={isLoading ? "Chargement..." : "Cabinet"}
                                list="destinations-list"
                                value={destination}
                                onChange={(e) => setDestination(e.target.value)}
                                disabled={isLoading}
                            />
                            <span onClick={() => { navigate("/destinations/form") }}>
                                <p className="link link-hover">Saisir un nouvelle destination</p>
                            </span>
                            <datalist id="destinations-list">
                                {destinations?.map((dest: DestinationDto) => (
                                    <option key={dest.id} value={dest.name} />
                                ))}
                            </datalist>

                            <label className="label mt-1">Kilométrage au départ</label>
                            <input
                                type="number"
                                className="input w-full"
                                placeholder="1 200 Km"
                            />

                            <button
                                type="submit"
                                className="btn btn-success mt-4"
                            >
                                Nouveau trajet
                            </button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    )
};

export default WayForm;