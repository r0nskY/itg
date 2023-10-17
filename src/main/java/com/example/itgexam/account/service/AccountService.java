package com.example.itgexam.account.service;

import com.example.itgexam.account.dto.AccountCreationResponseDto;
import com.example.itgexam.account.dto.CustomerReportDto;
import com.example.itgexam.account.entity.Customer;


public interface AccountService {

    AccountCreationResponseDto createAccount(Customer customer);

    CustomerReportDto getCustomer(Long customerNumber);


}
