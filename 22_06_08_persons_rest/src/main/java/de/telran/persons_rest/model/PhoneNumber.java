package de.telran.persons_rest.model;


import javax.persistence.*;

@Entity
public class PhoneNumber {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String number;
     String countryCode;

    @ManyToOne
    private Person person;

    public PhoneNumber() {

    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public PhoneNumber(String number, String countryCode, Person person) {
        this.id = id;
        this.number = number;
        this.countryCode = countryCode;
        this.person = person;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public Person getPerson() {
        return person;
    }

}
