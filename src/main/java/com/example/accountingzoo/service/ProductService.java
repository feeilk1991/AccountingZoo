package com.example.accountingzoo.service;

import com.example.accountingzoo.exception.ResourceNotFoundException;
import com.example.accountingzoo.model.Product;
import com.example.accountingzoo.repository.ProductRepository;
import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById (Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
    }

    public Product createProduct (Product product) {
        return productRepository.save(product);
    }

    public Product updateAnimal(Long id, @Nonnull Product updateProduct) {
        Product product = getProductById(id);
        if (product != null) {
            product.setName(updateProduct.getName());
            product.setType(updateProduct.getType());
            product.setMeasureType(updateProduct.getMeasureType());
        }

        return productRepository.save(product);
    }

    public void deleteProduct (Long id) {
        productRepository.deleteById(id);
    }
}
