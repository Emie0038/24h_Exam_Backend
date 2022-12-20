package com.example.my24hexam.Repository;

import com.example.my24hexam.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    void deleteByName(String name);

    Product findByName(String name);

    @Query("SELECT p FROM Product p WHERE p.name LIKE %?1% OR p.weight LIKE %?1%")
    List<Product> findByKeyword(String keyword);

}
