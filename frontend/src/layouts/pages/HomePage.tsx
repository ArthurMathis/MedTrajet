import CurrentWayAlert from "../ui/CurrentWayAlert.tsx";
import Dock from "../ui/Dock.tsx";
import Header from "../ui/Header.tsx";

/**
 * @function HomePage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const HomePage = () => {
    return (
        <main className="min-h-screen flex flex-col">
            <Header />
            <CurrentWayAlert />
            <div className="hero bg-base-100 w-full lg:flex-1">
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
                        <form className="w-full lg:card-body">
                            <fieldset className="fieldset">
                                <label className="label">Destination</label>
                                <input
                                    type="text"
                                    className="input w-full"
                                    placeholder="Cabinet"
                                />

                                <label className="label">Kilométrage</label>
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
            <Dock />
        </main>
    )
};

export default HomePage;