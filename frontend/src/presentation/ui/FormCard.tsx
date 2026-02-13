import type { ReactNode } from "react";

interface FormCardProps {
    children: ReactNode;
    large?: boolean;
}

/**
 * @function Formcard
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const FormCard = ({ children, large = false }: FormCardProps) => {
    return (
        <div className={`
            w-full mt-2
            lg:card lg:shrink-0 lg:shadow-2xl lg:mt-6
            ${large ? "lg:max-w-2xl" : "lg:max-w-xl"}
      `}>
            {children}
        </div>
    );
};

export default FormCard;