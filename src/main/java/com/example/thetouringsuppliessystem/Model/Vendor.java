package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name should not be empty")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    private String name;

    @NotEmpty(message = "email should not be empty")
    @Email(message = "this is not email")
    @Column(columnDefinition = "VARCHAR(25) NOT NULL UNIQUE")
    private String email;

    @NotEmpty(message = "phone number should not be empty")
    @Pattern(regexp = "^(05)(\\d){8}$",message = "phone number is wrong")
    @Column(columnDefinition = "VARCHAR(11) NOT NULL")
    private String phoneNumber;

    @NotEmpty(message = "city should not be empty")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String city;
}
