package de.telran.persons_rest.controller;


import de.telran.persons_rest.model.Person;
import de.telran.persons_rest.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class PersonController {
    @Autowired
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    /**
     * Get the person by id
     */
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Person get(@PathVariable Integer id) {
        return personService.get(id);
    }

    /**
     * Greate a new person
     */
    @PostMapping
    public Person create(@RequestBody Person person) {
        return personService.save(person);
    }

    @PutMapping
    public void edit(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        personService.remove(id);
    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

    @GetMapping("/persons/name/{name}")
    public List<Person> getAllByName(@PathVariable String name) {
        List<Person> persons = personService.getAllByName(name);
        return persons.stream()
                .map(person -> new Person(person.getId(), person.getName(), person.getLastname(), person.getAge()))
                .collect(Collectors.toList());

    }



// TODO create an endpoint, finding all persons with such a lastname
        // TODO create an endpoint finding all persons with the age larger some query parameter

}