package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VendorStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "stock should not be null")
    @PositiveOrZero(message = "stock should be positive or zero")
    @Column(columnDefinition = "INT NOT NULL")
    private int stock;

    @NotNull(message = "vendorID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer vendorID;

    @NotNull(message = "productID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer productID;
}
