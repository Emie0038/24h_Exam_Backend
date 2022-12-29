package com.example.my24hexam.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Table(name="delivery")

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="deliveryDate")
    @DateTimeFormat(pattern= "yyyy/MM/dd")
    private LocalDate date;

    @Column(name="fromWarehouse")
    private String fromWarehouse;

    @Column(name = "destination")
    private String destination;



    @ManyToOne
    @JoinColumn(name="productOrder_id")
    private ProductOrder productOrder;


    public Delivery(LocalDate date, String fromWarehouse, String destination, ProductOrder productOrder) {
        this.date = date;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
        this.productOrder = productOrder;
    }

    public Delivery(LocalDate date, String fromWarehouse, String destination) {
        this.date = date;
        this.fromWarehouse = fromWarehouse;
        this.destination = destination;
    }
}
