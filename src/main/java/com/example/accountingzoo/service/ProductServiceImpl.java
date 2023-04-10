package com.example.accountingzoo.service;

import com.example.accountingzoo.model.Animal;
import com.example.accountingzoo.model.Product;
import com.example.accountingzoo.repository.ProductRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.module.ResolutionException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository;

    @Override
    @NonNull
    @Transactional
    public List<Product> findAllProducts() {
        return productRepository.findAll().stream().map(p ->
                new Product(p.getId(),
                        p.getName(),
                        p.getType(),
                        p.getCurrentQuantity(),
                        p.getMeasureType())).collect(Collectors.toList());
    }

    @Override
    @NonNull
    @Transactional
    public Product getProductId (Long id) {
        return productRepository.findById(id).map(w ->
                new Product(w.getId(), w.getName(), w.getType(), w.getCurrentQuantity(), w.getMeasureType())).orElseGet(null);
    }

    @Override
    @NonNull
    public Product createProduct (Product request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setMeasureType(product.getMeasureType());
        product.setCurrentQuantity(product.getCurrentQuantity());

        return product;
    }

    @Override
    @NonNull
    public Product updateProduct (Long id, @NonNull Product request) {
        Optional<Product> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setName(request.getName());
            product.setType(request.getType());
            product.setMeasureType(request.getMeasureType());
            product.setCurrentQuantity(request.getCurrentQuantity());

            productRepository.save(product);
        } else throw new ResolutionException();

        return productOptional.get();
    }

    @Override
    public void deleteProduct (Long id) {
        Product product = productRepository.getReferenceById(id);
        productRepository.delete(product);
    }
}