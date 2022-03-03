package com.softtech.softtech2ndassignment.controller;

import com.softtech.softtech2ndassignment.dto.AddressResponseDto;
import com.softtech.softtech2ndassignment.dto.AddressSaveRequestDto;
import com.softtech.softtech2ndassignment.service.entityservice.AddressEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressEntityService addressEntityService;

    @PostMapping()
    public ResponseEntity saveAddress(@RequestBody AddressSaveRequestDto addressSaveRequestDto){

        AddressResponseDto addressResponseDto = addressEntityService.save(addressSaveRequestDto);

        return ResponseEntity.ok(addressResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id){

        addressEntityService.delete(id);

        return ResponseEntity.ok(Void.TYPE);
    }

    @GetMapping("/{id}")
    public ResponseEntity getAddressById(@PathVariable Long id){

        AddressResponseDto addressResponseDto = addressEntityService.findAddressById(id);

        return ResponseEntity.ok(addressResponseDto);
    }

}
