package com.example.my24hexam.Service;

import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Entity.ProductOrder;
import com.example.my24hexam.Repository.ProductOrderRepository;
import com.example.my24hexam.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductOrderService {
        private final ProductOrderRepository productOrderRepository;

        private final ProductRepository productRepository;

        @Autowired

    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductRepository productRepository) {
        this.productOrderRepository = productOrderRepository;
        this.productRepository = productRepository;
    }

    //Find all order

    public List<ProductOrder> getAllProductOrder(){
            return productOrderRepository.findAll();
    }
}
