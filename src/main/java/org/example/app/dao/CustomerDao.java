package org.example.app.dao;

import org.example.app.dto.CustomerDtoRequest;
import org.example.app.entity.Customer;

import java.util.List;
import java.util.Optional;

public interface CustomerDao extends BaseDao<Customer, CustomerDtoRequest> {
    boolean create(CustomerDtoRequest request);
    Optional<List<Customer>> fetchAll();
    Optional<Customer> fetchById(Long id);
    boolean updateById(Long id, CustomerDtoRequest request);
    boolean deleteById(Long id);
    Optional<Customer> getLastEntity();

    // ---- Query Params ----------------------
    Optional<List<Customer>> fetchByFirstName(String firstName);
    Optional<List<Customer>> fetchByPhoneNumber(String phone);
    Optional<List<Customer>> fetchAllOrderBy(String orderBy);
}
