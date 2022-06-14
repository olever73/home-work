package de.telran.persons_rest.repo;

import de.telran.persons_rest.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface PersonRepo extends JpaRepository<Person, Integer> {

    // select * from person p where p.name like `Vasya`
    @Query("select p from Person p where p.name = ?1")
    Collection<Person> findAllByName(String name);



}