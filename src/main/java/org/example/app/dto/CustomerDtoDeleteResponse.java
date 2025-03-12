package org.example.app.dto;

import org.springframework.http.HttpStatus;

public record CustomerDtoDeleteResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message) {

    public static final String SUCCESS_MESSAGE = "Customer with id %s has been deleted successfully.";
    public static final String FAILURE_MESSAGE = "Customer with id %s has not been found!";

    public static CustomerDtoDeleteResponse of(Long id, boolean isCustomerFound) {
        HttpStatus httpStatus = isCustomerFound ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        String message = (isCustomerFound ? SUCCESS_MESSAGE : FAILURE_MESSAGE).formatted(id);

        return new CustomerDtoDeleteResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                isCustomerFound,
                message.formatted(id));
    }
}
