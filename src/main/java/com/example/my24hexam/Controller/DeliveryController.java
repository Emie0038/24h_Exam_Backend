package com.example.my24hexam.Controller;


import com.example.my24hexam.Entity.Delivery;
import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Repository.ProductOrderRepository;
import com.example.my24hexam.Repository.ProductRepository;
import com.example.my24hexam.Service.DeliveryService;
import com.example.my24hexam.Service.ProductOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DeliveryController {

    private final DeliveryService deliveryService;
     private final ProductOrderService productOrderService;

    @Autowired
    public DeliveryController(DeliveryService deliveryService, ProductOrderService productOrderService) {
        this.deliveryService = deliveryService;
        this.productOrderService = productOrderService;
    }
    //Create new delivery
    @PostMapping("/deliveries")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery){
        Delivery newDelivery = deliveryService.createDelivery(delivery);
        return new ResponseEntity<>(newDelivery, HttpStatus.CREATED);
    }

    @GetMapping("/deliveries")
    public List<Delivery> getAllDeliveries()
    {
        return deliveryService.getAllDeliveries();
    }
    //Get list of specific delivery, including assigned productOrders by date)
    @GetMapping("/deliveries/search/{date}")
    public List<Delivery> searchForDate(@PathVariable("date") String date)
    {
        return deliveryService.searchedDeliveries(deliveryService.getAllDeliveries(), date);
    }

}