package medtrajet.backend.presentation.apiResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ApiResponseUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void jsonError(HttpServletResponse httpServletResponse, ApiError apiError) throws IOException {
        httpServletResponse.setStatus(apiError.getStatusCode());
        httpServletResponse.setContentType("application/json");
        mapper.writeValue(httpServletResponse.getOutputStream(), apiError);
    }

}
