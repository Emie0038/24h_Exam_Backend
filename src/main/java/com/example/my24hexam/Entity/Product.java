package com.example.my24hexam.Entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="price")
    private Double price;

    @Column(name="weight")
    private String weight;

   /* @JsonIgnore
    @ManyToMany(mappedBy = "ProductOrder")
    private Set<ProductOrder> productsOrder = new HashSet<>();*/

    public Product(String name, Double price, String weight) {
        this.name = name;
        this.price = price;
        this.weight = weight;
    }
}
