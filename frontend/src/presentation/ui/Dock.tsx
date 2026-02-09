import { Link, useLocation } from "react-router-dom";
import { Home, Inbox, Settings } from "lucide-react";

/**
 * @function Dock
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const Dock = () => {
    const location = useLocation();

    const isActive = (path: string) => {
        return location.pathname === path ? "dock-active" : "";
    };

    return (
        <div className="dock dock-sm">
            <Link to="/ways/me" className={isActive("/ways/me")}>
                <Inbox size={20} />
            </Link>

            <Link to="/dashboard/me" className={isActive("/dashboard/me")}>
                <Home size={20} />
            </Link>

            <Link to="/parameters/me" className={isActive("/parameters/me")}>
                <Settings size={20} />
            </Link>
        </div>
    )
};

export default Dock;