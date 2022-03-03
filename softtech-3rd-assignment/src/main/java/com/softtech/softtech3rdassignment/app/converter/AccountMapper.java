package com.softtech.softtech3rdassignment.app.converter;

import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountUpdateRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountSaveResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountMapper {

    AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);

    Account convertToAccount(AccountSaveRequestDto accountSaveRequestDto);

    AccountSaveResponseDto convertToAccountResponseDto(Account account);

    List<AccountGetResponseDto> convertToAccountGetResponseDtoList(List<Account> accountList);

    Account convertToAccount(AccountUpdateRequestDto accountUpdateRequestDto);

    AccountGetResponseDto convertToAccountGetResponseDto(Account account);

    AccountUpdateResponseDto convertToAccountUpdateResponseDto(Account account);

}
