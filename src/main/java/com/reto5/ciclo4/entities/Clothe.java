package com.reto5.ciclo4.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Maria Petro
 */
@Document(collection = "clothes")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Clothe {

    @Id
    private String reference;
    private String category;
    private String size;
    private String description;
    private boolean availability = true;
    private double price;
    private Integer quantity;
    private String photography;

}
