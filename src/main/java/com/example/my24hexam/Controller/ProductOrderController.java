package com.example.my24hexam.Controller;


import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Entity.ProductOrder;
import com.example.my24hexam.Service.DeliveryService;
import com.example.my24hexam.Service.ProductOrderService;
import com.example.my24hexam.Service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RestController
@CrossOrigin
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    private final DeliveryService deliveryService;

    private final ProductService productService;

    @Autowired
    public ProductOrderController(ProductOrderService productOrderService, DeliveryService deliveryService, ProductService productService) {
        this.productOrderService = productOrderService;
        this.deliveryService = deliveryService;
        this.productService = productService;
    }

    @GetMapping("/order")
    public List<ProductOrder> getAllProductOrder(){
        return productOrderService.getAllProductOrder();
    }



}





