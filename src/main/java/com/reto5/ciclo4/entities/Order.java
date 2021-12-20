package com.reto5.ciclo4.entities;

import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
/**
 *
 * @author Maria Petro
 */
@Document(collection = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Order {

    public static String PENDING = "Pendiente";
    public static String APROVED = "Aprobada";
    public static String REJECTED = "Rechazada";
    @Id
    private Integer id;
    private Date registerDay;
    private String status;
    private User salesMan;
    private Map<String, Clothe> products;
    private Map<String, Integer> quantities;
}
