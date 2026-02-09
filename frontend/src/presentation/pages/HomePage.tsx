import MainLayout from "../layouts/MainLayout.tsx";
import TripForm from "../../features/trips/components/TripForm.tsx";
import CurrentWayAlert from "../ui/CurrentWayAlert.tsx";

/**
 * @function HomePage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const HomePage = () => {
    return (
        <MainLayout>
            <CurrentWayAlert />
            <TripForm />
        </MainLayout>
    )
};

export default HomePage;