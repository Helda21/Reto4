/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Web.repositorio;

import Reto3_Web.interfaces.InterfaceOrder;
import Reto3_Web.modelo.Order;
import Reto3_Web.modelo.User;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author david
 */
@Repository
public class OrderRepositorio {

    @Autowired
    private InterfaceOrder repository;
    
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Order> getAll() {
        return (List<Order>) repository.findAll();
    }

    public Optional<Order> getOrder(int id) {
        return repository.findById(id);
    }

    public Order create(Order order) {
        return repository.save(order);
    }

    public void update(Order order) {
        repository.save(order);
    }

    public void delete(Order order) {
        repository.delete(order);
    }
    
    public Optional<Order> lastUserId(){
        return repository.findTopByOrderByIdDesc();
    }
    
    public List<Order> findByZone(String zona) {
        return repository.findByZone(zona);
    }
    
    
    
    //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    public List<Order> ordersSalesManByID(Integer id) {
        Query query = new Query();
        
        Criteria criterio = Criteria.where("salesMan.id").is(id);
        query.addCriteria(criterio);
        
        List<Order> orders = mongoTemplate.find(query, Order.class);
        
        return orders;
        
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    public List<Order> ordersSalesManByState(String state, Integer id) {
        Query query = new Query();
        Criteria criterio = Criteria.where("salesMan.id").is(id)
                            .and("status").is(state);
        
        query.addCriteria(criterio);
        
        List<Order> orders = mongoTemplate.find(query,Order.class);
        
        return orders;
    }
    
    //Reto 4: Ordenes de un asesor x Fecha
    public List<Order> ordersSalesManByDate(String dateStr, Integer id) {
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Query query = new Query();
        
        Criteria dateCriteria = Criteria.where("registerDay")
			.gte(LocalDate.parse(dateStr, dtf).minusDays(1).atStartOfDay())
			.lt(LocalDate.parse(dateStr, dtf).plusDays(1).atStartOfDay())
			.and("salesMan.id").is(id);
        
        query.addCriteria(dateCriteria);
        
        List<Order> orders = mongoTemplate.find(query,Order.class);
        
        return orders;       
    }
}
