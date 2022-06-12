package persons_rest.controller;

import persons_rest.model.Person;
import org. springframework.web.bind.annotation.DeleteMapping;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import persons_rest.service.PersonService;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

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
    @ResponseStatus(HttpStatus.OK)
    public void edit(@RequestBody Person person) {
        personService.save(person);

    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable  int id) {

        personService.remove(personService.get(id));

    }

    @GetMapping
    public List<Person> getAll() {
        return personService.getAll();
    }

}
