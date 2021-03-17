package com.medesta.service.impl;

import com.medesta.model.entity.Product;
import com.medesta.model.enums.ProductCategory;
import com.medesta.model.service.ProductServiceModel;
import com.medesta.repository.ProductRepository;
import com.medesta.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ModelMapper modelMapper;
    private final ProductRepository productRepository;

    public ProductServiceImpl(ModelMapper modelMapper, ProductRepository productRepository) {
        this.modelMapper = modelMapper;
        this.productRepository = productRepository;
    }

    @Override
    public void addProduct(ProductServiceModel productServiceModel) {
        Product product =modelMapper.map(productServiceModel,Product.class);


        productRepository.save(product);
    }
}
