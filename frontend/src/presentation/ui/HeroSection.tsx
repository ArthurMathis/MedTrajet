import type {ReactNode} from "react";

interface HeroSectionProps {
    children: ReactNode;
    largeMode?: boolean;
}

/**
 * @function HeroSection
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const HeroSection = ({ children, largeMode = false }: HeroSectionProps) => {
    return (
        <div className="hero bg-base-100 w-full lg:flex-1 lg:mb-6">
            <div className={`
                hero-content flex-col w-full
                ${largeMode ? "lg:flex-row-reverse lg:gap-10" : ""}
            `}>
                {children}
            </div>
        </div>
    )
}

export default HeroSection;