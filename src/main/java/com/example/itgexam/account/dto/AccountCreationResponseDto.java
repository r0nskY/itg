package com.example.itgexam.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountCreationResponseDto extends TransactionBaseDto {
    private Long customerNumber;

}
