package com.example.itgexam.account.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionBaseDto {
    private Integer transactionCode;
    private String transactionStatusDescription;
}
