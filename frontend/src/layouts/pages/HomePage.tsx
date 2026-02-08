import CurrentWayAlert from "../ui/CurrentWayAlert.tsx";
import Dock from "../ui/Dock.tsx";
import Header from "../ui/Header.tsx";
import WayForm from "../ui/Form/WayForm.tsx";

/**
 * @function HomePage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const HomePage = () => {
    return (
        <main className="min-h-screen flex flex-col">
            <Header />
            <CurrentWayAlert />
            <WayForm />
            <Dock />
        </main>
    )
};

export default HomePage;