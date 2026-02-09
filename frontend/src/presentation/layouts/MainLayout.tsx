import * as React from "react";
import Header from "../ui/Header.tsx";
import Dock from "../ui/Dock.tsx";

/**
 * @function MainLayout
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
export default function MainLayout({ children }: { children: React.ReactNode }){
    return (
        <main className="min-h-screen flex flex-col">
            <Header />
            {children}
            <Dock />
        </main>
    )
}