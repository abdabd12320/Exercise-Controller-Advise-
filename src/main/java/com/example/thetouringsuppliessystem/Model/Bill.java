package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Bill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "typeOfOrder should not be null")
    @Pattern(regexp = "NULL|BOUGHT|RENT|RENTEXPIRED",message = "typeOfOrder should be NULL, RENTEXPIRED, RENT or BOUGHT")
    @Column(columnDefinition = "VARCHAR(15) NOT NULL")
    private String typeOfOrder;

    @NotNull(message = "stockOrder should not be null")
    @PositiveOrZero(message = "stockOrder should be positive or zero")
    @Column(columnDefinition = "INT NOT NULL")
    private int stockOrder;

    @NotNull(message = "total should not be null")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double total;

    @NotNull(message = "userID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer productID;

    @NotNull(message = "userID should not be null")
    @Column(columnDefinition = "INT NOT NULL")
    private Integer userID;
}
