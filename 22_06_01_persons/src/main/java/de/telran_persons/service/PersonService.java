package de.telran_persons.service;

import de.telran_persons.model.Person;
import de.telran_persons.repo.PersonRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Person remove(Person person) {
        return personRepo.delete(person.getId());
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public Person get(int id) {
        return personRepo.find(id).orElseThrow();
    }


}