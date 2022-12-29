package com.example.my24hexam.Controller;


import com.example.my24hexam.Entity.Delivery;
import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Repository.ProductRepository;
import com.example.my24hexam.Service.ProductService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class ProductController {

  //Dependencies
    private final ProductService productService;



    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;

    }


    //Return all products is working
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    //Create a method that returns a single product by name is working
    @GetMapping("/products/search/{name}")
    public ResponseEntity<Product> getProductByName(@PathVariable("name") String name) {
        Product product = productService.getProductByName(name);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    //Return single product by Id is working
    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long id) {
        Product product = productService.getProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);

    }

    //find by keyword is working
    @GetMapping("/products/search/{keyword}")
    public List<Product> findByKeyword(@PathVariable("keyword") String keyword){
        return productService.findByKeyword(keyword);
    }


    //Create an product is working
    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody Product product){
        Product newProduct = productService.createProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    //Update an product is working
    @PutMapping("/products/{id}")
    public ResponseEntity<Product> updateProduct(@RequestBody Product newProduct, @PathVariable("id") Long id) {
        return new ResponseEntity<>(productService.updateProduct(id, newProduct), HttpStatus.OK);
    }

    //Delete an product is not working
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(value= "id") Long id){
        productService.deleteProductById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}