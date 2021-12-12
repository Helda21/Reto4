/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto3_Web.servicio;

import Reto3_Web.modelo.Fragance;
import Reto3_Web.repositorio.FraganceRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Helio David Espinosa Contreras
 * Por favor ver el siguiente link:
 * en ese link se encuentra fronend y el backend
 * https://drive.google.com/drive/folders/1YvH1DRKhxE6g0bAHcwfrfODXxu8nBXdx?usp=sharing
 */
@Service
public class FraganceService {
     @Autowired
    private FraganceRepositorio clotheRepository;
     
     @Autowired
    private MongoTemplate mongoTemplate;

    public List<Fragance> getAll() {
        return clotheRepository.getAll();
    }

   public Optional<Fragance> getClothe(String reference) {
        return clotheRepository.getClothe(reference);
    }

    public Fragance create(Fragance accesory) {
        if (accesory.getReference() == null) {
            return accesory;
        } else {
            return clotheRepository.create(accesory);
        }
    }

    public Fragance update(Fragance accesory) {
/**
 *
 * @author Helio David Espinosa Contreras
 * realiza las caracteriscas de descripciones
 */
        
        
        if (accesory.getReference() != null) {
            Optional<Fragance> accesoryDb = clotheRepository.getClothe(accesory.getReference());
            if (!accesoryDb.isEmpty()) {
                
                if (accesory.getBrand()!= null) {
                    accesoryDb.get().setBrand(accesory.getBrand());
                }
                if (accesory.getCategory() != null) {
                    accesoryDb.get().setCategory(accesory.getCategory());
                }
                if (accesory.getPresentation() != null) {
                    accesoryDb.get().setPresentation(accesory.getPresentation());
                }              
                
                if (accesory.getDescription() != null) {
                    accesoryDb.get().setDescription(accesory.getDescription());
                }
                if (accesory.getPrice() != 0.0) {
                    accesoryDb.get().setPrice(accesory.getPrice());
                }
                if (accesory.getQuantity() != 0) {
                    accesoryDb.get().setQuantity(accesory.getQuantity());
                }
                if (accesory.getPhotography() != null) {
                    accesoryDb.get().setPhotography(accesory.getPhotography());
                }
                accesoryDb.get().setAvailability(accesory.isAvailability());
                clotheRepository.update(accesoryDb.get());
                return accesoryDb.get();
            } else {
                return accesory;
            }
        } else {
            return accesory;
        }
    }

    public boolean delete(String reference) {
        Boolean aBoolean = getClothe(reference).map(accesory -> {
            clotheRepository.delete(accesory);
            return true;
        }).orElse(false);
        return aBoolean;
    }
    
    
}
