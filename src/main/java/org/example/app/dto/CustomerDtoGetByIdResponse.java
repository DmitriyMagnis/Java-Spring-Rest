package org.example.app.dto;

import org.example.app.entity.Customer;
import org.springframework.http.HttpStatus;

public record CustomerDtoGetByIdResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        Customer customer) {

    public static final String SUCCESS_MESSAGE = "Customer with id %s has been updated successfully.";
    public static final String FAILURE_MESSAGE = "Customer with id %s has not been found!";

    public static CustomerDtoGetByIdResponse of(Long id, boolean isCustomerFound, Customer customerUpdated) {
        HttpStatus httpStatus = isCustomerFound ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        String message = (isCustomerFound ? SUCCESS_MESSAGE : FAILURE_MESSAGE).formatted(id);

        return new CustomerDtoGetByIdResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                isCustomerFound,
                message,
                customerUpdated
        );
    }
}