package com.example.itgexam.account.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerReportDto extends TransactionBaseDto{

    private String customerNumber;

    private String customerName;

    private String customerMobile;

    @Email()
    private String customerEmail;

    private String address1;

    private String address2;

    private List<AccountReportDto> savings;
}
