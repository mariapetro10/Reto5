package com.reto5.ciclo4.controllers;

import com.reto5.ciclo4.entities.Clothe;
import com.reto5.ciclo4.services.ClotheService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * @author Maria Petro
 */
@RestController
@RequestMapping("/api/clothe")
@CrossOrigin(origins = "*")
public class ClotheController {
    
    @Autowired
    private ClotheService clotheService;

    @GetMapping("/all")
    public List<Clothe> getAll() {
        return clotheService.getAll();
    }

    @GetMapping("/{reference}")
    public Optional<Clothe> getByReference(@PathVariable("reference") String reference){
        return clotheService.getByReference(reference);
    }
    
    @GetMapping("/price/{price}")
    public List<Clothe> getByPrice(@PathVariable("price") Integer price){
        return clotheService.getByPrice(price);
    }
    
    @GetMapping("/description/{word}")
    public List<Clothe> getByClotheContaining(@PathVariable("word") String word){
        return clotheService.getByClotheContaining(word);
    }
    
    @PostMapping("/new")
    public ResponseEntity<Clothe> save(@RequestBody Clothe clothe) {
        Clothe p = clotheService.save(clothe);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Clothe> update(@RequestBody Clothe clothe) {
        Clothe p = clotheService.update(clothe);
        return new ResponseEntity(p, HttpStatus.CREATED);
    }


    @DeleteMapping("/{reference}")
    public ResponseEntity delete(@PathVariable String reference) {
        clotheService.delete(reference);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
    
}
