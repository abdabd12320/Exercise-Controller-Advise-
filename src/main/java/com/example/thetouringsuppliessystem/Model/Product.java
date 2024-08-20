package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 3,max = 30,message = "name should be contain between 3 and 30 characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String name;

    @NotEmpty(message = "details should not be empty")
    @Column(columnDefinition = "VARCHAR(500) NOT NULL")
    private String details;

    @NotNull(message = "price should not be empty")
    @PositiveOrZero(message = "price should be positive or zero")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double price;

    @Column(columnDefinition = "BOOLEAN")
    private boolean rent;

    @NotNull(message = "brandID should not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer brandID;

    @NotNull(message = "categoryID should not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer categoryID;

    @NotNull(message = "vendorID should not be empty")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer vendorID;
}
