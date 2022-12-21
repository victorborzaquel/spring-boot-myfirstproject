package com.victor.myfirstproject.repositories;

import com.victor.myfirstproject.entities.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepository {
    Map<Long, Product> map = new HashMap<>();

    public void save(Product product) {
        map.put(product.getId(), product);
    }

    public Product findById(Long id) {
        return map.get(id);
    }

    public List<Product> findAll() {
        return new ArrayList<>(map.values());
    }
}
