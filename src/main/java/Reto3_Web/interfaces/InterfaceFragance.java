/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto3_Web.interfaces;


import Reto3_Web.modelo.Fragance;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author USUARIO
 */
public interface InterfaceFragance extends MongoRepository<Fragance, String> {
    
}
