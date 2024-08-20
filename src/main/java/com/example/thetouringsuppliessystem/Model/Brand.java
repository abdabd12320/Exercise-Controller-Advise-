package com.example.thetouringsuppliessystem.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty")
    @Size(min = 3,max = 30,message = "name should be contain between 3 and 30 characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL UNIQUE")
    private String name;

    @NotEmpty(message = "madeIn should not be empty")
    @Size(min = 3,max = 30,message = "madeIn should be contain between 3 and 30 characters")
    @Column(columnDefinition = "VARCHAR(30) NOT NULL")
    private String madeIn;
}
