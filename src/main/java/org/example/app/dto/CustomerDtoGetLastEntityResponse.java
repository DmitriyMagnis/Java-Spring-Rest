package org.example.app.dto;

import org.example.app.entity.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoGetLastEntityResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer customer) {

    public static final String SUCCESS_MESSAGE = "Customer has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Customer has not been found!";

    public static CustomerDtoGetLastEntityResponse of(boolean isCustomerFound, Customer customer) {
        HttpStatus httpStatus = isCustomerFound ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        String message = isCustomerFound ? SUCCESS_MESSAGE : FAILURE_MESSAGE;

        return new CustomerDtoGetLastEntityResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                isCustomerFound, message, customer);
    }
}
