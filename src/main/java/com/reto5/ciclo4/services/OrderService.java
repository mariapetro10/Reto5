package com.reto5.ciclo4.services;

import com.reto5.ciclo4.entities.Order;
import com.reto5.ciclo4.repositories.OrderRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maria Petro
 */
@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
    
    public List<Order> getAllByZone(String zone){
        return orderRepository.getAllByZone(zone);
    }
    
    
    public List<Order> getAllBySalesman(Integer id){
        return orderRepository.getAllBySalesman(id);
    }
    
    public List<Order> getAllByRegisterDayAndSalesmanId(String registerDay, Integer id) {
        SimpleDateFormat parser = new  SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = parser.parse(registerDay);
            
        } catch (Exception e) {
        }
        return orderRepository.getAllByRegisterDayAndSalesmanId(date, id);
    }
    
    public List<Order> getAllByStatusAndSalesmanId(String status, Integer id) {
        return orderRepository.getAllByStatusAndSalesmanId(status, id);
    }
    
    public Order getById(Integer id) {
        return orderRepository.getById(id).orElse(null);
    }
      
    public Optional<Order> save(Order order) {
        
        if (order.getId() == null) 
            return Optional.of(order);
        
        Optional<Order> existeOrder = orderRepository.getById(order.getId());
        
        if (existeOrder.isPresent()) 
            return Optional.of(order);
        
        orderRepository.save(order);
        return Optional.empty();
    }
    
    public Order updates(Order order) {
        
          if (order.getId() == null)
            return order;
        
        Optional<Order> existeOrder = orderRepository.getById(order.getId());
        
        if (existeOrder.isPresent() == false)
            return order;

        orderRepository.save(order);
        return null;
    }
    public Order update(Order order){
        if(order.getId()!=null){
            Optional<Order> resultado = orderRepository.getById(order.getId());
            if(resultado.isPresent()){
                if(order.getStatus()!=null){
                    resultado.get().setStatus(order.getStatus());
                }
                orderRepository.save(resultado.get());
                return resultado.get();
            }else{
                return order;
            }
        }else{
            return order;
        }
    }
    public void delete(Integer id) {
        orderRepository.delete(id);
    }
}
