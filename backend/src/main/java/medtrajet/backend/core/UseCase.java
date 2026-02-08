package medtrajet.backend.core;

/**
 * Interface that represents a UseCase
 *
 * @param <Request> The Request data type
 * @param <Response> The Response data type
 * @author Arthur MATHIS - arthur.mathis@diaconat-mulhouse.fr
 */
public interface UseCase<Request, Response> {

    /**
     * Method that execute the UseCase
     *
     * @param request The request data
     * @return
     */
    Response execute(Request request);
}