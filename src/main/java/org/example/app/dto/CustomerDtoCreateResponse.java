package org.example.app.dto;

import org.example.app.entity.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoCreateResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer customer) {

    public static final String SUCCESS_MESSAGE = "Customer has been created successfully.";
    public static final String FAILURE_MESSAGE = "Customer has not been created!";

    public static CustomerDtoCreateResponse of(boolean isCustomerCreated, Customer customer) {
        HttpStatus httpStatus = isCustomerCreated ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        String message = isCustomerCreated ? SUCCESS_MESSAGE : FAILURE_MESSAGE;

        return new CustomerDtoCreateResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                isCustomerCreated, message, customer);
    }
}