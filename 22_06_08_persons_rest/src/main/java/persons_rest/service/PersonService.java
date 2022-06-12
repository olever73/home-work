package persons_rest.service;



import org.springframework.stereotype.Service;

import persons_rest.model.Person;
import persons_rest.repo.PersonRepo;

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