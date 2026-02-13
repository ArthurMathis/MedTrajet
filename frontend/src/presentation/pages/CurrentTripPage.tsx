import EndTripForm from "../../features/trips/components/EndTripForm.tsx";
import FormCard from "../ui/FormCard.tsx";
import HeroSection from "../ui/HeroSection.tsx";

/**
 * @function CurrentTripPage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const CurrentTripPage = () => {
    return (
        <HeroSection>
            <div className="w-full text-left lg:max-w-2xl">
                <h1 className="text-2xl font-bold lg:text-5xl">Fin de trajet</h1>
                <p className="pt-2 text-sm lg:pt-5 lg:text-base">
                    Inscris ton kilométrage de fin pour cloturer ton trajet ! 🏎️
                </p>
                <p className="pt-1 text-sm lg:text-base">
                    Tu pourras ensuite <b>le consulter ton historique de trajet</b> à tout moment. 💡
                </p>
            </div>
            <FormCard children={<EndTripForm />} large={true} />
        </HeroSection>
    )
}

export default CurrentTripPage;