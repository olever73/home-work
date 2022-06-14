package de.telran.persons_rest.service;

import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.repo.PersonRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonRepo personRepo;

    public PersonService( @Autowired PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public Person save(Person person) {
        return personRepo.save(person);
    }

    public Person remove(int id) {
        Person person = get(id);
        personRepo.delete(person);
        return person;
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public Person get(int id) {
        return personRepo.findById(id).orElseThrow();

    }


    public List<Person> getAllByName(String name) {
        return new ArrayList<>(personRepo.findAllByName(name));
    }




}