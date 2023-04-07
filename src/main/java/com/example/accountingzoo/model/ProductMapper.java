package com.example.accountingzoo.model;

public class ProductMapper {
    public static ProductResponse productResponse(Product product) {
        return new ProductResponse(product.getId(), product.getName(),
                product.getCurrentQuantity(), product.getMeasureType(), product.getType());
    }

    public static Product toDAO(ProductRequest request) {
        var product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setCurrentQuantity(request.getCurrentQuantity());
        product.setMeasureType(request.getMeasureType());
        return product;
    }
}
