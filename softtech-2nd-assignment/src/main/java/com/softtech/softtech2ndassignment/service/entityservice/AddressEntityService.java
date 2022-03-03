package com.softtech.softtech2ndassignment.service.entityservice;

import com.softtech.softtech2ndassignment.converter.AddressMapper;
import com.softtech.softtech2ndassignment.dto.AddressResponseDto;
import com.softtech.softtech2ndassignment.dto.AddressSaveRequestDto;
import com.softtech.softtech2ndassignment.entity.Address;
import com.softtech.softtech2ndassignment.repository.AddressDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressEntityService {

    private final AddressDao addressDao;

    public AddressResponseDto save(AddressSaveRequestDto addressSaveRequestDto){

        Address address = AddressMapper.INSTANCE.convertToAddress(addressSaveRequestDto);

        address = addressDao.save(address);

        AddressResponseDto addressResponseDto = AddressMapper.INSTANCE.convertToAddressResponseDto(address);

        return addressResponseDto;

    }

    public void delete(Long id){

        Address address = getById(id);

        addressDao.delete(address);

    }

    public AddressResponseDto findAddressById(Long id){

        Address address = getById(id);

        AddressResponseDto addressResponseDto = AddressMapper.INSTANCE.convertToAddressResponseDto(address);

        return addressResponseDto;

    }

    private Address getById(Long id) {
        Optional<Address> optionalAddress = addressDao.findById(id);

        Address address;
        if(optionalAddress.isPresent()){
            address = optionalAddress.get();
        }else{
            throw new RuntimeException("Item not found!");
        }

        return address;
    }
}
