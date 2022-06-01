package person_list_spring.model;

import java.util.List;

public class PersonDto {
    private List<Person> persons;

    // default and parameterized constructor

    public PersonDto(List<Person> persons) {
        this.persons = persons;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }

    public void addPerson(Person person) {
        this.persons.add(person);
    }

    }
