package com.softtech.softtech3rdassignment.app.dto.responsedto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductSaveResponseDto {

    private Long id;
    private String name;
    private String description;
    private BigDecimal price;

}
