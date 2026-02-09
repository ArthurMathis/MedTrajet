import MainLayout from "../layouts/MainLayout.tsx";
import DestinationForm from "../../features/destinations/components/DestinationForm.tsx";

/**
 * @function CreationDestinationPage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const CreationDestinationPage = () => {
    return (
        <MainLayout>
            <DestinationForm />
        </MainLayout>
    )
};

export default CreationDestinationPage;