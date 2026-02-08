import Header from "../ui/Header.tsx";
import Dock from "../ui/Dock.tsx";
import DestinationForm from "../ui/Form/DestinationForm.tsx";

/**
 * @function CreationDestinationPage
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const CreationDestinationPage = () => {
    return (
        <main className="min-h-screen flex flex-col">
            <Header />
            <DestinationForm />
            <Dock />
        </main>
    )
};

export default CreationDestinationPage;