package com.example.my24hexam.Service;

import com.example.my24hexam.Entity.Product;
import com.example.my24hexam.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }
    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public void deleteProductById(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProduct(Long id, Product newProduct) {
        if(productRepository.findById(id).isEmpty()) {
            return null;
        }

        return productRepository.save(newProduct);
    }
    public List <Product> findByKeyword(String keyword) {
        if (keyword != null) {
            return productRepository.findByKeyword(keyword);
        }
        return productRepository.findAll();
    }
}
