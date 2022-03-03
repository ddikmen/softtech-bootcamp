package com.softtech.softtech2ndassignment.converter;

import com.softtech.softtech2ndassignment.dto.AddressResponseDto;
import com.softtech.softtech2ndassignment.dto.AddressSaveRequestDto;
import com.softtech.softtech2ndassignment.entity.Address;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    Address convertToAddress(AddressSaveRequestDto addressSaveRequestDto);

    AddressResponseDto convertToAddressResponseDto(Address address);

}
