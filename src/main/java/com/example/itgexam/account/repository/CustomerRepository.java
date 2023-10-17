package com.example.itgexam.account.repository;

import com.example.itgexam.account.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {
    boolean existsByCustomerEmail(String customerEmail);



}
