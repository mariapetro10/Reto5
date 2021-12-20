package com.reto5.ciclo4.services;

import com.reto5.ciclo4.entities.Clothe;
import com.reto5.ciclo4.repositories.ClotheRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Maria Petro
 */
@Service
public class ClotheService {

    @Autowired
    private ClotheRepository clotheRepository;

    public List<Clothe> getAll() {
        return clotheRepository.getAll();
    }
       
    public Optional<Clothe> getByReference(String reference) {
        return clotheRepository.getByReference(reference);
    }
    public List<Clothe> getByPrice(Integer price) {
        return clotheRepository.getByPrice(price);
    }
    public List<Clothe> getByClotheContaining(String word) {
        return clotheRepository.getByClotheContaining(word);
    }
    
    public Clothe save(Clothe clothe) {

        if (clothe.getReference() == null) {
            return clothe;
        }

        Optional<Clothe> existeClothe = clotheRepository.getByReference(clothe.getReference());

        if (existeClothe.isPresent()) {
            return clothe;
        }

        clotheRepository.save(clothe);
        return null;
    }

    public Clothe update(Clothe clothe) {

        if (clothe.getReference() == null) {
            return clothe;
        }

        Optional<Clothe> existeClothe = clotheRepository.getByReference(clothe.getReference());

        if (existeClothe.isPresent() == false) {
            return clothe;
        }

        if (clothe.getReference() != null) {
        } else {
            clothe.setReference(existeClothe.get().getReference());
        }
        if (clothe.getCategory() == null) {
            clothe.setCategory(existeClothe.get().getCategory());
        }
        if (clothe.getSize() != null) {
        } else {
            clothe.setSize(existeClothe.get().getSize());
        }
        if (clothe.getDescription() == null) {
            clothe.setDescription(existeClothe.get().getDescription());
        }
        if (clothe.getPrice() <= 0) {
            clothe.setPrice(existeClothe.get().getPrice());
        }
        if (clothe.getQuantity() == null) {
            clothe.setQuantity(existeClothe.get().getQuantity());
        }
        if (clothe.getPhotography() == null) {
            clothe.setPhotography(existeClothe.get().getPhotography());
        }

        clotheRepository.save(clothe);
        return null;
    }

    public void delete(String reference) {
        clotheRepository.delete(reference);
    }

}
