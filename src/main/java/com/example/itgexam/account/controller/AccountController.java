package com.example.itgexam.account.controller;

import com.example.itgexam.account.dto.AccountCreationResponseDto;
import com.example.itgexam.account.dto.CustomerReportDto;
import com.example.itgexam.account.entity.Customer;
import com.example.itgexam.account.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

import static com.example.itgexam.account.constant.TransactionConstants.*;

@RestController
@RequestMapping("api/v1/account")
@NoArgsConstructor
@AllArgsConstructor
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public AccountCreationResponseDto createAccount(@RequestBody Customer customer) {
        if(customer.getCustomerEmail() ==  null){
            AccountCreationResponseDto accountReportDto = new AccountCreationResponseDto();
            accountReportDto.setTransactionCode(TRANS_CODE_BAD_REQUEST);
            accountReportDto.setTransactionStatusDescription(TRANS_EMAIL_BAD_REQUEST);
            return accountReportDto;
        }

        return accountService.createAccount(customer);
    }

    @GetMapping("{customer}")
    public com.example.itgexam.account.dto.CustomerReportDto getCustomer(@PathVariable(name = "customer") Long customerNumber){
        try {
            return accountService.getCustomer(customerNumber);
        }catch (EntityNotFoundException e){

            com.example.itgexam.account.dto.CustomerReportDto customerReportDto = new com.example.itgexam.account.dto.CustomerReportDto();
            customerReportDto.setTransactionCode(TRANS_CODE_NOT_FOUND);
            customerReportDto.setTransactionStatusDescription(TRANS_CUSTOMER_NOT_FOUND);

            return customerReportDto;

        }
    }


}
