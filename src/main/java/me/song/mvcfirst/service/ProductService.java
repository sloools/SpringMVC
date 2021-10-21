package me.song.mvcfirst.service;

import me.song.mvcfirst.beans.Product;

import java.util.Optional;

public interface ProductService {
    Optional<Product> getProduct(Long cd);
    String putProduct(Product prd);
}
