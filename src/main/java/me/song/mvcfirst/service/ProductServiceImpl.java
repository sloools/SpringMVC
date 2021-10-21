package me.song.mvcfirst.service;

import me.song.mvcfirst.beans.Product;
import me.song.mvcfirst.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public Optional<Product> getProduct(Long cd) {
        return productRepository.getProduct(cd);
    }

    @Override
    public String putProduct(Product prd) {
        return productRepository.putProduct(prd);
    }
}
