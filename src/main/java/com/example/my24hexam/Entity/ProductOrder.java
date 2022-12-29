package com.example.my24hexam.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
public class ProductOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name = "quantity")
    private String quantity;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;




    public ProductOrder(String quantity, Product product) {

        this.quantity = quantity;
        this.product = product;
    }
}
