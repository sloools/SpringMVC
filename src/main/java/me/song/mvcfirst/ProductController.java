package me.song.mvcfirst;

import me.song.mvcfirst.beans.Product;

import me.song.mvcfirst.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{cd}")
    Product getProduct(@PathVariable("cd") Long cd){
        System.out.println("checking ~~~~~~~~~~~~~~~~~~~");
        return productService.getProduct(cd).orElse(new Product(-1L, "", 0, false));

    }

//    @GetMapping("/product/{cd}")
//    Product getProduct(@PathVariable("cd") Long cd){
//        return productService.getProduct(cd).orElseGet(()->  // orElse(객체만 반환) + 로직
//            new Product(-1L, "", 0, false)
//        );
//
//    }

    @PostMapping("/product")
    String putProduct(@RequestBody Product product){
        return productService.putProduct(product);
    }
}
