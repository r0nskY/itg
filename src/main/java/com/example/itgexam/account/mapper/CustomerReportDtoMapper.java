package com.example.itgexam.account.mapper;


import com.example.itgexam.account.dto.AccountReportDto;
import com.example.itgexam.account.entity.Account;
import com.example.itgexam.account.entity.Customer;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface CustomerReportDtoMapper {

    @Mapping(target = "customerNumber",source = "entity.id")
    com.example.itgexam.account.dto.CustomerReportDto entityToDto(Customer entity);

    @Mapping(target = "accounts", ignore = true)
    @Mapping(target = "id", ignore = true)
    Customer dtoToEntity(com.example.itgexam.account.dto.CustomerReportDto customerReportDto);

    @AfterMapping
    default void mapAccountsToSavings(Customer customer, @MappingTarget com.example.itgexam.account.dto.CustomerReportDto dto) {
        List<AccountReportDto> savings = new ArrayList<>();
        for (Account account : customer.getAccounts()) {
            AccountReportDto savingsDto = AccountReportDtoMapper.INSTANCE.entityToDto(account);
            savings.add(savingsDto);
        }
        dto.setSavings(savings);
    }

}
