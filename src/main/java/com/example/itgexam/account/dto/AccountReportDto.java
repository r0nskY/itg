package com.example.itgexam.account.dto;


import com.example.itgexam.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountReportDto extends TransactionBaseDto{

    private Long accountNumber;

    private Account.AccountType accountType;

    private Double availableBalance;

    private Long customerNumber;

}
