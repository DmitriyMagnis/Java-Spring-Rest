package org.example.app.service;

import org.example.app.dto.CustomerDtoRequest;
import org.example.app.entity.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer, CustomerDtoRequest> {
    Customer create(CustomerDtoRequest request);
    List<Customer> fetchAll();
    Customer fetchById(Long id);
    Customer updateById(Long id, CustomerDtoRequest request);
    boolean deleteById(Long id);
    Customer getLastEntity();

    // ---- Query Params ----------------------
    List<Customer> fetchByFirstName(String firstName);
    List<Customer> fetchByPhoneNumber(String phone);
    List<Customer> fetchAllOrderBy(String orderBy);
}
