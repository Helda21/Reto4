/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Web.controlador;

import Reto3_Web.servicio.FraganceService;
import Reto3_Web.modelo.Fragance;
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
 * @author USUARIO
 */
@RestController
@RequestMapping("/api/fragance")
@CrossOrigin("*")
public class FraganceController {
    @Autowired
    private FraganceService accessoryService;
       
     @GetMapping("/all")
    public List<Fragance> getAll() {
        return accessoryService.getAll();
    }
    
    @GetMapping("/{reference}")
    public Optional<Fragance> getClothe(@PathVariable("reference") String reference) {
        return accessoryService.getClothe(reference);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance create(@RequestBody Fragance gadget) {
        return accessoryService.create(gadget);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Fragance update(@RequestBody Fragance gadget) {
        return accessoryService.update(gadget);
    }

    @DeleteMapping("/{reference}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("reference") String reference) {
        return accessoryService.delete(reference);
    } 
    
}
