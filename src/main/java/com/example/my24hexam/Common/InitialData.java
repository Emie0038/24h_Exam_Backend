package com.example.my24hexam.Common;

import com.example.my24hexam.Entity.Delivery;
import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Entity.ProductOrder;
import com.example.my24hexam.Repository.DeliveryRepository;
import com.example.my24hexam.Repository.ProductOrderRepository;
import com.example.my24hexam.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.time.LocalDate;

//@Component
public class InitialData implements CommandLineRunner {

    private ProductRepository productRepository;
    private DeliveryRepository deliveryRepository;

    private ProductOrderRepository productOrderRepository;



    public InitialData(ProductRepository productRepository, DeliveryRepository deliveryRepository, ProductOrderRepository productOrderRepository) {
        this.productRepository = productRepository;
        this.deliveryRepository = deliveryRepository;
        this.productOrderRepository = productOrderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Product p1 = new Product("Rice", 35.0, "500");
        Product p2 = new Product("Garlic", 10.0, "200");
        Product p3 = new Product("Avocado", 29.0, "250");
        Product p4 = new Product("Ginger", 4.0, "100");
        Product p5 = new Product("milk", 13.0, "750");


        productRepository.save(p1);
        productRepository.save(p2);
        productRepository.save(p3);
        productRepository.save(p4);
        productRepository.save(p5);

        Delivery d1 = new Delivery(LocalDate.of(2022, 12, 23), "Hellerup", "Norrebro");
        Delivery d2 = new Delivery(LocalDate.of(2022, 12, 25), "Hellerup", "Valby");

        deliveryRepository.save(d1);
        deliveryRepository.save(d2);


        ProductOrder pO1 = new ProductOrder("4.5kg", p1);
        ProductOrder pO2 = new ProductOrder("4.5kg", p3);
        ProductOrder pO3 = new ProductOrder("4.5kg", p2);
        productOrderRepository.save(pO1);
        productOrderRepository.save(pO2);
        productOrderRepository.save(pO3);
    }
}
