package com.example.itgexam.account.service.impl;

import com.example.itgexam.account.dto.AccountCreationResponseDto;
import com.example.itgexam.account.dto.CustomerReportDto;
import com.example.itgexam.account.entity.Customer;
//import com.example.itgexam.account.mapper.AccountReportDtoMapper;
import com.example.itgexam.account.mapper.CustomerReportDtoMapper;
import com.example.itgexam.account.repository.AccountRepository;
import com.example.itgexam.account.repository.CustomerRepository;
import com.example.itgexam.account.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

import static com.example.itgexam.account.constant.TransactionConstants.*;

@AllArgsConstructor
@NoArgsConstructor
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CustomerReportDtoMapper customerReportDtoMapper;

    @Override
    public AccountCreationResponseDto createAccount(Customer customer) {
        AccountCreationResponseDto accountCreationResponseDto = new AccountCreationResponseDto();
        if(customerRepository.existsByCustomerEmail(customer.getCustomerEmail())){
            accountCreationResponseDto.setTransactionCode(TRANS_CODE_DUPPLICATE);
            accountCreationResponseDto.setTransactionStatusDescription(TRANS_CUSTOMER_DUPPLICATE_EMAIL);
            return accountCreationResponseDto;
        }
        Customer savedCustomer = customerRepository.save(customer);

        accountCreationResponseDto.setCustomerNumber(savedCustomer.getId());
        accountCreationResponseDto.setTransactionCode(TRANS_CODE_CREATED_SUCCESSFUL);
        accountCreationResponseDto.setTransactionStatusDescription(TRANS_CUSTOMER_CREATED_SUCCESSFUL);
        return accountCreationResponseDto;
    }

    @Override
    public com.example.itgexam.account.dto.CustomerReportDto getCustomer(Long customerNumber) {
        Customer customer = customerRepository.findById(customerNumber)
                .orElseThrow(()-> new EntityNotFoundException("Customer not found"));
        com.example.itgexam.account.dto.CustomerReportDto customerReportDto = customerReportDtoMapper.entityToDto(customer);
        customerReportDto.setTransactionCode(TRANS_CODE_FOUND);
        customerReportDto.setTransactionStatusDescription(TRANS_CUSTOMER_FOUND);
        return customerReportDto;
    }



}
