package com.tracledger.web.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class APIResponseService {
    public APIResponse createSuccessResponse(Boolean result, Integer statusCode, String description, Object response) {
        APIResponse successResponse = new APIResponse();

        successResponse.setResult(result);
        successResponse.setStatusCode(statusCode);
        successResponse.setStatusCodeDescription(description);
        successResponse.setResponse(response);

        return successResponse;
    }

    public APIResponse createResponse(Boolean result, Integer statusCode, String description, String message, Object response) {
        APIResponse successResponse = new APIResponse();

        successResponse.setResult(result);
        successResponse.setStatusCode(statusCode);
        successResponse.setStatusCodeDescription(description);
        successResponse.setResponse(response);
        successResponse.setMessage(message);

        return successResponse;
    }

    public APIResponse createErrorResponse(Boolean result, Integer statusCode, String description, String message) {
        APIResponse errorResponse = new APIResponse();

        errorResponse.setResult(result);
        errorResponse.setStatusCode(statusCode);
        errorResponse.setStatusCodeDescription(description);
        errorResponse.setMessage(message);

        return errorResponse;
    }

    public APIResponse buildAPIResponse(HttpStatus httpStatus, String message) {
        Boolean result = httpStatus.value() == 201 || httpStatus.value() == 200;
        return createErrorResponse(result, httpStatus.value(), httpStatus.getReasonPhrase(), message);
    }

    public APIResponse buildAPIResponse(HttpStatus httpStatus, Object response) {
        return createSuccessResponse(true, httpStatus.value(), httpStatus.getReasonPhrase(), response);
    }

    public APIResponse buildAPIResponse (HttpStatus httpStatus, String message, Object response) {
        Boolean result = httpStatus.value() == 201 || httpStatus.value() == 200;
        return createResponse(result, httpStatus.value(), httpStatus.getReasonPhrase(), message, response);
    }
}


