package com.softtech.softtech3rdassignment.app.service.entityservice;

import com.softtech.softtech3rdassignment.app.converter.AccountMapper;
import com.softtech.softtech3rdassignment.app.dao.AccountDao;
import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountUpdateRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountSaveResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountEntityService {

    private final AccountDao accountDao;

    public AccountSaveResponseDto save(AccountSaveRequestDto accountSaveRequestDto){

        Account account = convertToAccount(accountSaveRequestDto);

        accountDao.save(account);

        AccountSaveResponseDto accountSaveResponseDto = convertToAccountResponseDto(account);

        return accountSaveResponseDto;
    }


    public List<AccountGetResponseDto> getAllAccounts(){

        List<Account> accountList = accountDao.findAll();

        List<AccountGetResponseDto> accountGetResponseDtoList = convertToAccountDtoList(accountList);

        return accountGetResponseDtoList;

    }

    public AccountGetResponseDto getAccountByUserName(String name){

        Account account = accountDao.findByUserName(name);

        AccountGetResponseDto accountGetResponseDto = convertToAccountGetResponseDto(account);

        return accountGetResponseDto;

    }

    public AccountGetResponseDto getAccountById(Long id){
        Optional<Account> accountOptional = accountDao.findById(id);

        Account account = getAccount(accountOptional);

        AccountGetResponseDto accountGetResponseDto = convertToAccountGetResponseDto(account);

        return accountGetResponseDto;
    }

    public Account findById(Long id){

        Optional<Account> optionalAccount = accountDao.findById(id);

        if(optionalAccount.isPresent()){
            return optionalAccount.get();
        }else{
            return null;
        }

    }


    public void deleteAccount(String name, String phone){

        Account account = accountDao.findByUserName(name);

        String accountPhone = account.getPhoneNumber();

        if(accountPhone.equals(phone)){
            accountDao.delete(account);
        }else{
            throw new RuntimeException("User and phone mismatch!");
        }
    }

    public AccountUpdateResponseDto updateAccount(String name, AccountUpdateRequestDto accountUpdateRequestDto){

        Account account = accountDao.findByUserName(name);

        Long id = account.getId();

        account = convertToAccount(accountUpdateRequestDto);

        account.setId(id);

        accountDao.save(account);

        AccountUpdateResponseDto accountUpdateResponseDto = convertToAccountUpdateResponseDto(account);

        return accountUpdateResponseDto;
    }

    private Account getAccount(Optional<Account> accountOptional) {

        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            return account;
        }else{
            throw new RuntimeException("Item not found!");
        }
    }

    private Account convertToAccount(AccountSaveRequestDto accountSaveRequestDto) {
        return AccountMapper.INSTANCE.convertToAccount(accountSaveRequestDto);
    }

    private AccountGetResponseDto convertToAccountGetResponseDto(Account account) {
        return AccountMapper.INSTANCE.convertToAccountGetResponseDto(account);
    }

    private Account convertToAccount(AccountUpdateRequestDto accountUpdateRequestDto) {
        return AccountMapper.INSTANCE.convertToAccount(accountUpdateRequestDto);
    }

    private List<AccountGetResponseDto> convertToAccountDtoList(List<Account> accountList) {
        return AccountMapper.INSTANCE.convertToAccountGetResponseDtoList(accountList);
    }

    private AccountSaveResponseDto convertToAccountResponseDto(Account account) {
        return AccountMapper.INSTANCE.convertToAccountResponseDto(account);
    }

    private AccountUpdateResponseDto convertToAccountUpdateResponseDto(Account account) {
        return AccountMapper.INSTANCE.convertToAccountUpdateResponseDto(account);
    }
}
