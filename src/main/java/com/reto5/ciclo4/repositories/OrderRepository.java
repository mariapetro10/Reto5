package com.reto5.ciclo4.repositories;

import com.reto5.ciclo4.entities.Order;
import com.reto5.ciclo4.repositories.crud.OrderCrudRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria Petro
 */
@Repository
public class OrderRepository {
    @Autowired
    private OrderCrudRepository orderCRUD ;
    
    public List<Order> getAll() {
        return orderCRUD.findAll();
    }
    
    public List<Order> getAllByZone(String zone) {
        return orderCRUD.findAllBySalesManZone(zone);
    }
    
    public List<Order> getAllBySalesman(Integer id) {
        return orderCRUD.findAllBySalesManId(id);
    } 
    
    public List<Order> getAllByRegisterDayAndSalesmanId(Date registerDay, Integer id) {
        return orderCRUD.findAllByRegisterDayAndSalesManId(registerDay, id);
    }
    
    public List<Order> getAllByStatusAndSalesmanId(String status, Integer id) {
        return orderCRUD.findAllByStatusAndSalesManId(status, id);
    }
    
    public Optional<Order> getById(Integer id) {
        return orderCRUD.findById(id);
    }
    
    public Order save(Order order) {
        return orderCRUD.save(order);
    }
    
    public void delete(Integer id) {
        orderCRUD.deleteById(id);
    }
}
