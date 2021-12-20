package com.reto5.ciclo4.repositories.crud;

import com.reto5.ciclo4.entities.Clothe;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Maria Petro
 */
public interface ClotheCrudRepository  extends MongoRepository<Clothe, Integer>{
    public Optional<Clothe> findByReference(String reference);
    public List<Clothe> findByPriceLessThanEqual(Integer price);
    public List<Clothe> findByDescriptionContainingIgnoreCase(String word);
    public void deleteByReference(String reference);
}
