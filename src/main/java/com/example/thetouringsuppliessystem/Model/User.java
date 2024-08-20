package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "username should not be empty")
    @Size(min = 4,max = 30,message = "username should be contain between 4 and 30 characters")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String username;

    @NotEmpty(message = "password should not be empty")
    @Column(columnDefinition = "VARCHAR(20) NOT NULL")
    private String password;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "this is not email")
    @Column(columnDefinition = "VARCHAR(25) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "role should not be empty")
    @Pattern(regexp = "CUSTOMER|ADMIN",message = "role should be either CUSTOMER or ADMIN")
    @Column(columnDefinition = "VARCHAR(8) NOT NULL")
    private String role;

    @NotNull(message = "balance should not be empty")
    @Column(columnDefinition = "DOUBLE NOT NULL")
    private double balance;

    @NotEmpty(message = "city should not be empty")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String city;

    @NotNull(message = "numberOfPurchases should not be empty")
    @PositiveOrZero(message = "numberOfPurchases should be positive or zero")
    @Column(columnDefinition = "INT NOT NULL DEFAULT 0")
    private int numberOfPurchases;
}
