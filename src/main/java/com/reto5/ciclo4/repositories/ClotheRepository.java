/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.reto5.ciclo4.repositories;

import com.reto5.ciclo4.entities.Clothe;
import com.reto5.ciclo4.repositories.crud.ClotheCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Maria Petro
 */
@Repository
public class ClotheRepository {
    @Autowired
    private ClotheCrudRepository clotheCRUD ;
    
    public List<Clothe> getAll() {
        return clotheCRUD.findAll();
    }
    
    public Optional<Clothe> getByReference(String reference) {
        return clotheCRUD.findByReference(reference);
    }
    public List<Clothe> getByPrice(Integer price) {
        return clotheCRUD.findByPriceLessThanEqual(price);
    }
    public List<Clothe> getByClotheContaining(String word) {
        return clotheCRUD.findByDescriptionContainingIgnoreCase(word);
    }
    public Clothe save(Clothe clothe) {
        return clotheCRUD.save(clothe);
    }
    
    public void delete(String reference) {
        clotheCRUD.deleteByReference(reference);
    }
    
}
