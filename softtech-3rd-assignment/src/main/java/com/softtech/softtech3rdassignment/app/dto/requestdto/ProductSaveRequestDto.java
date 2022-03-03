package com.softtech.softtech3rdassignment.app.dto.requestdto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSaveRequestDto {

    private String name;
    private String description;
    private BigDecimal price;

}
