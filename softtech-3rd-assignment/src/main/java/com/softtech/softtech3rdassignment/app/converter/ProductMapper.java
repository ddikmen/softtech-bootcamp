package com.softtech.softtech3rdassignment.app.converter;

import com.softtech.softtech3rdassignment.app.dto.requestdto.ProductSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductPriceUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductSaveResponseDto;
import com.softtech.softtech3rdassignment.app.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product convertToProduct(ProductSaveRequestDto productSaveRequestDto);

    ProductSaveResponseDto convertToProductSaveResponseDto(Product product);

    ProductGetResponseDto convertToGetResponseDto(Product product);

    List<ProductGetResponseDto> convertToProductGetRepsonseDtoList(List<Product> product);

    ProductPriceUpdateResponseDto convertToProductPriceUpdateResponseDto(Product product);

}
