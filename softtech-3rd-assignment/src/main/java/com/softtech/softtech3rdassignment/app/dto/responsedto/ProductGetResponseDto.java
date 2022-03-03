package com.softtech.softtech3rdassignment.app.dto.responsedto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProductGetResponseDto {

    private String name;
    private BigDecimal price;

}
