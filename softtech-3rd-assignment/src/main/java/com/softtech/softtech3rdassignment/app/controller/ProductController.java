package com.softtech.softtech3rdassignment.app.controller;

import com.softtech.softtech3rdassignment.app.dto.RestResponse;
import com.softtech.softtech3rdassignment.app.dto.requestdto.ProductPriceUpdateRequestDto;
import com.softtech.softtech3rdassignment.app.dto.requestdto.ProductSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductPriceUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductSaveResponseDto;
import com.softtech.softtech3rdassignment.app.service.entityservice.ProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductEntityService productEntityService;

    @PostMapping()
    public ResponseEntity save(@RequestBody ProductSaveRequestDto productToSave){

        ProductSaveResponseDto productSaveResponseDto = productEntityService.save(productToSave);

        return ResponseEntity.ok(RestResponse.of(productSaveResponseDto));
    }

    @GetMapping()
    public ResponseEntity getProductlist(){

        List<ProductGetResponseDto> productGetResponseDtoList = productEntityService.getProductList();

        return ResponseEntity.ok(RestResponse.of(productGetResponseDtoList));
    }

    @GetMapping("/{id}")
    public ResponseEntity getProductById(@PathVariable Long id){

        ProductGetResponseDto productGetResponseDto = productEntityService.findProductById(id);

        return ResponseEntity.ok(RestResponse.of(productGetResponseDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){

        productEntityService.delete(id);

        return ResponseEntity.ok(RestResponse.empty());
    }

    @PatchMapping("/{id}")
    public ResponseEntity updateProductPrice(@PathVariable Long id, @RequestBody ProductPriceUpdateRequestDto productPriceUpdateRequestDto){

        ProductPriceUpdateResponseDto productPriceUpdateResponseDto = productEntityService.updatePrice(id, productPriceUpdateRequestDto);

        return ResponseEntity.ok(RestResponse.of(productPriceUpdateResponseDto));
    }


}
