import StartTripForm from "../../features/trips/components/StartTripForm.tsx";
import CurrentTripAlert from "../../features/trips/components/CurrentTripAlert.tsx";
import FormCard from "../ui/FormCard.tsx";
import HeroSection from "../ui/HeroSection.tsx";

/**
 * @function HomePage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const HomePage = () => {
    return (
        <>
            <CurrentTripAlert />
            <HeroSection largeMode={true}>
                <div className="text-left">
                    <h1 className="text-2xl font-bold lg:text-5xl">Nouveau trajet</h1>
                    <p className="pt-2 text-sm lg:pt-5 lg:text-base">
                        Enregistre ton Nouveau départ ! 🏎️
                    </p>
                    <p className="pt-1 text-sm lg:text-base">
                        Tu pourras ensuite <b>l'annuler à tout moment</b> ou le <b>confirmer</b>, une fois arrivé. 💡
                    </p>
                </div>
                <FormCard children={<StartTripForm />} />
            </HeroSection>
        </>
    )
};

export default HomePage;