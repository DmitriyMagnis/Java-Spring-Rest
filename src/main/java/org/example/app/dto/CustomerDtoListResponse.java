package org.example.app.dto;

import org.example.app.entity.Customer;
import org.springframework.http.HttpStatus;

import java.util.Collections;
import java.util.List;

public record CustomerDtoListResponse(
        int statusCode,
        String reasonPhrase,
        boolean success,
        String message,
        List<Customer> customerList) {

    public static final String SUCCESS_MESSAGE = "Customer list has been fetched successfully.";
    public static final String FAILURE_MESSAGE = "Customer list has not been found!";

    public static CustomerDtoListResponse of(boolean isCustomerListEmpty, List<Customer> customerList) {
        HttpStatus httpStatus = isCustomerListEmpty ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        String message = isCustomerListEmpty ? FAILURE_MESSAGE : SUCCESS_MESSAGE;

        return new CustomerDtoListResponse(
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                !isCustomerListEmpty,
                message,
                customerList);
    }
}

