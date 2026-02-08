import { User, LogOut } from "lucide-react";
import {useLogout} from "../../infrastructure/hooks/authentification/use-logout.ts";

/**
 * @function Header
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const Header = () => {
    const { mutate: logout, isPending } = useLogout();

    return (
        <div className="navbar bg-base-100 px-4">
            <h1 className="flex-1 text-xl font-bold">MedTrajet</h1>

            <div className="dropdown dropdown-end">
                <div tabIndex={0} role="button" className="btn btn-ghost btn-circle avatar">
                    <div className="w-10 rounded-full bg-success/20 text-success flex items-center justify-center">
                        <User size={20} strokeWidth={2.5} />
                    </div>
                </div>
                <ul className="menu menu-sm dropdown-content bg-base-100 rounded-box z-1 mt-3 w-52 p-2 shadow">
                    <button
                        className="text-error flex items-center gap-2"
                        onClick={() => logout()}
                        disabled={ isPending }
                    >
                        <LogOut size={16} />
                        { isPending ? 'Déconnexion...' : 'Se déconnecter'}
                    </button>
                </ul>
            </div>
        </div>
    )
};

export default Header;