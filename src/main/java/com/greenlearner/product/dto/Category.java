package com.greenlearner.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Category {

    private Integer id;
    private String name;
    private String brand;

}
