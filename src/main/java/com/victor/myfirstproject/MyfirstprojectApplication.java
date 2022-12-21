package com.victor.myfirstproject;

import com.victor.myfirstproject.entities.Category;
import com.victor.myfirstproject.entities.Product;
import com.victor.myfirstproject.repositories.CategoryRepository;
import com.victor.myfirstproject.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class MyfirstprojectApplication implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyfirstprojectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Category cat1 = new Category(1L, "Electronics");
        Category cat2 = new Category(2L, "Books");

        Product p1 = new Product(1L, "The Lord of the Rings", 90.5, cat2);
        Product p2 = new Product(2L, "Smart TV", 2190.0, cat1);
        Product p3 = new Product(3L, "Macbook Pro", 1250.0, cat1);
        Product p4 = new Product(4L, "PC Gamer", 1200.0, cat2);

        cat1.getProducts().addAll(Arrays.asList(p2, p3));
        cat2.getProducts().addAll(Arrays.asList(p1, p4));

        categoryRepository.save(cat1);
        categoryRepository.save(cat2);

        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
    }
}
