package person_list_spring.model;

import java.util.ArrayList;
import java.util.List;

public class PersonCreationDto {

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public PersonCreationDto() {
        this.persons = new ArrayList<>();
    }

    public PersonCreationDto(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }
}