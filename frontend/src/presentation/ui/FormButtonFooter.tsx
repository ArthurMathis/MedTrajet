import type {ReactNode} from "react";

interface FormButtonFooterProps {
    children: ReactNode;
}

/**
 * @function FormButtonFooter
 * @author Arthur MATHIS <mathis.arthur.dev@gmail.com>
 */
const FormButtonFooter = ({ children }: FormButtonFooterProps) => {
    return (
        <footer className="flex gap-2 w-full mt-4">
            {children}
        </footer>
    )
}

export default FormButtonFooter;