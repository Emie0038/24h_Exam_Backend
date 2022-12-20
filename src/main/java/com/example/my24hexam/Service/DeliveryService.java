package com.example.my24hexam.Service;

import com.example.my24hexam.Entity.Delivery;
import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Repository.DeliveryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

    @Service
    public class DeliveryService {
        private final DeliveryRepository deliveryRepository;
        private final ProductService productService;

        @Autowired
        public DeliveryService(DeliveryRepository deliveryRepository, ProductService productService)
        {
            this.deliveryRepository = deliveryRepository;
            this.productService = productService;
        }

        // Find all deliveries
        public List<Delivery> getAllDeliveries() {
            return deliveryRepository.findAll();
        }

        // Find delivery by id
        public Delivery getDeliveriesById(Long id) {
            return deliveryRepository.findById(id).orElse(null);
        }

        public Delivery createDelivery(Delivery delivery) {
            return deliveryRepository.save(delivery);
        }

        //Search Delivery by date, used in DeliveryController
        public List<Delivery> searchedDeliveries(List<Delivery> deliveryList,String date) {
            List<Delivery> searchedDeliveries = new ArrayList<>();

            String[] result = date.split("-");
            int year = Integer.parseInt(result[0]);
            int month = Integer.parseInt(result[1]);
            int day = Integer.parseInt(result[2]);

            LocalDate localDate = LocalDate.of(year, month, day);

            for (Delivery delivery : deliveryList
            ) {
                if (delivery.getDate().isEqual(localDate)) {
                    searchedDeliveries.add(delivery);
                }
            }
            return searchedDeliveries;
        }


    }

