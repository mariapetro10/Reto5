package com.reto5.ciclo4.repositories.crud;

import com.reto5.ciclo4.entities.Order;
import java.util.Date;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Maria Petro
 */
public interface OrderCrudRepository  extends MongoRepository<Order, Integer>{
    public List<Order> findAllBySalesManZone(String zone);
    public List<Order> findAllBySalesManId(Integer id);
    public List<Order> findAllByRegisterDayAndSalesManId(Date registerDay, Integer id);
    public List<Order> findAllByStatusAndSalesManId(String status, Integer id);
}
