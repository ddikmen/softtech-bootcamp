package com.softtech.softtech3rdassignment.app.service.entityservice;

import com.softtech.softtech3rdassignment.app.converter.ProductMapper;
import com.softtech.softtech3rdassignment.app.dao.ProductDao;
import com.softtech.softtech3rdassignment.app.dto.requestdto.ProductPriceUpdateRequestDto;
import com.softtech.softtech3rdassignment.app.dto.requestdto.ProductSaveRequestDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductGetResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductPriceUpdateResponseDto;
import com.softtech.softtech3rdassignment.app.dto.responsedto.ProductSaveResponseDto;
import com.softtech.softtech3rdassignment.app.entity.Account;
import com.softtech.softtech3rdassignment.app.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductEntityService {

    private final ProductDao productDao;

    public ProductSaveResponseDto save(ProductSaveRequestDto productToSave){

        Product product = ProductMapper.INSTANCE.convertToProduct(productToSave);

        productDao.save(product);

        ProductSaveResponseDto productSaveResponseDto = ProductMapper.INSTANCE.convertToProductSaveResponseDto(product);

        return productSaveResponseDto;
    }

    public List<ProductGetResponseDto> getProductList(){

        List<Product> productList = productDao.findAll();

        List<ProductGetResponseDto> productGetResponseDtoList = ProductMapper.INSTANCE.convertToProductGetRepsonseDtoList(productList);

        return productGetResponseDtoList;
    }

    public ProductGetResponseDto findProductById(Long id){

        Optional<Product> productOptional = productDao.findById(id);

        Product product = getProduct(productOptional);

        ProductGetResponseDto productGetResponseDto = ProductMapper.INSTANCE.convertToGetResponseDto(product);

        return productGetResponseDto;
    }

    public void delete(Long id){

        Optional<Product> productOptional = productDao.findById(id);

        Product product = getProduct(productOptional);

        productDao.delete(product);
    }

    public ProductPriceUpdateResponseDto updatePrice(Long id, ProductPriceUpdateRequestDto price){

        Optional<Product> productOptional = productDao.findById(id);

        Product product = getProduct(productOptional);

        product.setPrice(price.getPrice());

        ProductPriceUpdateResponseDto productPriceUpdateResponseDto = ProductMapper.INSTANCE.convertToProductPriceUpdateResponseDto(product);

        product = productDao.save(product);

        return productPriceUpdateResponseDto;
    }

    public Product findById(Long id){

        Optional<Product> optionalProduct = productDao.findById(id);

        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            return null;
        }

    }

    private Product getProduct(Optional<Product> productOptional) {

        if(productOptional.isPresent()){
            Product product = productOptional.get();
            return product;
        }else{
            throw new RuntimeException("Item not found!");
        }
    }

}
