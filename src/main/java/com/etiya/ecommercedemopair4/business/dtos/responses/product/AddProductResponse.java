package com.etiya.ecommercedemopair4.business.dtos.responses.product;

import com.etiya.ecommercedemopair4.entities.concretes.Supplier;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddProductResponse {
    private int id;
    private String name;
    private Supplier supplier;
    private String description;
}
