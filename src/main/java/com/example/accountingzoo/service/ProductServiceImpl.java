package com.example.accountingzoo.service;

import com.example.accountingzoo.dao.ProductDao;
import com.example.accountingzoo.model.Product;
import com.example.accountingzoo.model.ProductMapper;
import com.example.accountingzoo.model.ProductRequest;
import com.example.accountingzoo.model.ProductResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import javax.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService {
    private final ProductDao productDao;

    @Override
    @Transactional(readOnly = true)
    public List<ProductResponse> findAll() {
        return productDao.findAll().stream()
                .map(ProductMapper::productResponse).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductResponse getById (Long id) {
        var product = getProduct(id);
        return ProductMapper.productResponse(product);
    }

    @Override
    @Transactional
    public Long createProduct(ProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setType(request.getType());
        product.setMeasureType(request.getMeasureType());
        product.setCurrentQuantity(request.getCurrentQuantity());

        return productDao.create(product);
    }

    @Override
    @Transactional
    public ProductResponse updateProduct (Long id, ProductRequest request) {
        var product = getProduct(id);
        product.setId(id);
        var updateProduct = productDao.update(product);
        return ProductMapper.productResponse(updateProduct);
    }

    @Override
    @Transactional
    public void deleteProduct (Long id) {
        productDao.delete(id);
    }

    private Product getProduct(Long id) {
        var product = productDao.findById(id);
        if (product == null) {
            throw new EntityNotFoundException("Product with id " + id + " not found");
        }
        return product;
    }
}