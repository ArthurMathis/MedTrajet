import DestinationForm from "../../features/destinations/components/DestinationForm.tsx";
import FormCard from "../ui/FormCard.tsx";
import HeroSection from "../ui/HeroSection.tsx";

/**
 * @function CreateDestinationPage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const CreateDestinationPage = () => {
    return (
        <HeroSection>
            <div className="w-full text-left lg:max-w-2xl">
                <h1 className="text-2xl font-bold lg:text-5xl">Nouvelle destination</h1>
                <p className="pt-2 text-sm lg:pt-5 lg:text-base">
                    Inscris une <b>nouvelle destination</b> pour suivre tes kilomètres ! 🗺️
                </p>
                <p className="pt-1 text-sm lg:text-base">
                    Tu pourras ensuite <b>l'annuler à tout moment</b> ou le <b>confirmer</b>, une fois arrivé. 💡
                </p>
            </div>
            <FormCard children={<DestinationForm />} large={true} />
        </HeroSection>
    )
};

export default CreateDestinationPage;