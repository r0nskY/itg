package com.example.itgexam.account.mapper;

import com.example.itgexam.account.dto.AccountReportDto;
import com.example.itgexam.account.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AccountReportDtoMapper {

    AccountReportDtoMapper INSTANCE = Mappers.getMapper(AccountReportDtoMapper.class);


    AccountReportDto entityToDto(Account entity);


    Account dtoToEntity(AccountReportDto accountReportDto);


}
