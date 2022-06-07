package de.telran_persons.controller;

import de.telran_persons.model.Person;
import de.telran_persons.service.PersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/")
    @ResponseBody
    public String home() {

        return "";
    }



    @GetMapping("/new-person")
    public String newPerson(Model model) {
        model.addAttribute("person", new Person());
        return "edit-person";
    }

    @PostMapping("/save-person")
    public String savePerson(@ModelAttribute Person person) {
        personService.save(person);
        return "redirect:/new-person";
    }
    @GetMapping("/person/add")
    public String addPersonPage(Model model) {
        model.addAttribute("person", new Person());
        return "edit-person";
    }

    @GetMapping("/persons")
    public String persons(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);
        // the name of the template
        return "persons";
    }

    @GetMapping("/person/{id}/delete")
    public String removePerson(@PathVariable Person id) {
        personService.remove(id);
        return "redirect:/persons";
    }

    @GetMapping("/person/{id}/edit")
    public String editPersonPage(@PathVariable Integer id, Model model) {
        Person person = personService.get(id);
        model.addAttribute("person", person);
        return "person-form";
    }

    @GetMapping("/person/{id}")
    public String getPerson(@PathVariable int id, Model model) {
        Person person = personService.get(id);
        model.addAttribute("person", person);
        return "person";
    }


}