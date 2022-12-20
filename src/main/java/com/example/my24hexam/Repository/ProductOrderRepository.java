package com.example.my24hexam.Repository;

import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Entity.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {
}
