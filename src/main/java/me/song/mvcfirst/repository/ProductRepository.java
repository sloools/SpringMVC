package me.song.mvcfirst.repository;

import me.song.mvcfirst.beans.Product;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap; // HashMap이랑 같은 기능. but HashMap은 multi thread 환경에서 thread safe 하지 않다

@Repository
public class ProductRepository {
    private static ConcurrentHashMap<Long, Product> DB;

    @PostConstruct
    void postConstruct(){
        DB = new ConcurrentHashMap<>();
        DB.putIfAbsent(1L, new Product(1L, "Samsung", 100, true));
        DB.putIfAbsent(2L, new Product(2L, "LG", 200, false));
        DB.putIfAbsent(3L, new Product(3L, "Apple", 130, true));

    }

    public Optional<Product> getProduct(Long cd){
        return Optional.ofNullable(DB.getOrDefault(1L,null));
    }

    public String putProduct(Product product){

        if (DB.containsKey(product.getCd())){
            return "N";
        }else{
            DB.put(product.getCd(), product);
            return "Y";
        }
    }
}
