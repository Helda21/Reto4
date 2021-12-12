/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Web.controlador;

import Reto3_Web.modelo.Order;
import Reto3_Web.servicio.OrderServicio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author david
 */
@RestController
@RequestMapping("/api/order")
@CrossOrigin("*")
public class OrderController {

    @Autowired
    private OrderServicio orderServicio;

    @GetMapping("/all")
    public List<Order> getAll() {
        return orderServicio.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrder(@PathVariable("id") int id) {
        return orderServicio.getOrder(id);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Order create(@RequestBody Order gadget) {
        return orderServicio.create(gadget);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Order update(@RequestBody Order gadget) {
        return orderServicio.update(gadget);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return orderServicio.delete(id);
    }
    

    
     //Reto 3:Ordenes de pedido asociadas a los asesores de una zona
    @GetMapping("/zona/{zona}")
    public List<Order> findByZone(@PathVariable("zona") String zona) {
        return orderServicio.findByZone(zona);
    }
    
      //Métodos del reto 4
    //Reto 4: Ordenes de un asesor
    @GetMapping("/salesman/{id}")
    public List<Order> ordersSalesManByID(@PathVariable("id") Integer id){
        return orderServicio.ordersSalesManByID(id);
    }
    
    //Reto 4: Ordenes de un asesor x Estado
    @GetMapping("/state/{state}/{id}")
    public List<Order> ordersSalesManByState(@PathVariable("state") String state, @PathVariable("id") Integer id){
        return orderServicio.ordersSalesManByState(state, id);
    }
    
    //Reto 4: Ordenes de un asesor x fecha
    @GetMapping("/date/{date}/{id}")
    public List<Order> ordersSalesManByDate(@PathVariable("date") String dateStr, @PathVariable("id") Integer id) {
        return orderServicio.ordersSalesManByDate(dateStr,id);
    }

}
