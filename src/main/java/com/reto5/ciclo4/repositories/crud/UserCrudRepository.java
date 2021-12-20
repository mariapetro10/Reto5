package com.reto5.ciclo4.repositories.crud;

import com.reto5.ciclo4.entities.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Maria Petro
 */
public interface UserCrudRepository extends CrudRepository<User, Integer>{
    @Query
    public Optional<User> findByEmail(String email);   

    public User findByEmailAndPassword(String email, String password);

    public List<User> findByMonthBirthtDay(String id);
}
