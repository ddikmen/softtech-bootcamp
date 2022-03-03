package com.softtech.softtech3rdassignment.app.controller;

import com.softtech.softtech3rdassignment.app.dto.RestResponse;
import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.requestdto.AccountUpdateRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountSaveResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.AccountUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.service.entityservice.AccountEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountEntityService accountEntityService;

    @PostMapping()
    public ResponseEntity save(@RequestBody AccountSaveRequestDto accountSaveRequestDto){

        AccountSaveResponseDto accountSaveResponseDto = accountEntityService.save(accountSaveRequestDto);

        return ResponseEntity.ok(RestResponse.of(accountSaveResponseDto));
    }

    @GetMapping()
    public ResponseEntity getAllAccounts(){

        List<AccountGetResponseDto> accountGetResponseDtoList = accountEntityService.getAllAccounts();

        return ResponseEntity.ok(RestResponse.of(accountGetResponseDtoList));
    }

    @GetMapping("/by")
    public ResponseEntity getAccountByUserName(@RequestParam String name){

        AccountGetResponseDto accountGetResponseDto = accountEntityService.getAccountByUserName(name);

        return ResponseEntity.ok(RestResponse.of(accountGetResponseDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity getAccountById(@PathVariable Long id){

        AccountGetResponseDto accountGetResponseDto = accountEntityService.getAccountById(id);

        return ResponseEntity.ok(RestResponse.of(accountGetResponseDto));
    }

    @DeleteMapping("/by")
    public ResponseEntity deleteAccount(@RequestParam String name, @RequestParam String phone){

        accountEntityService.deleteAccount(name, phone);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping("/by")
    public ResponseEntity updateAccount(@RequestParam String name, @RequestBody AccountUpdateRequestDto accountUpdateRequestDto){

        AccountUpdateResponseDto accountUpdateResponseDto = accountEntityService.updateAccount(name, accountUpdateRequestDto);

        return  ResponseEntity.ok(RestResponse.of(accountUpdateResponseDto));
    }

}
