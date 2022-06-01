package person_list_spring.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import person_list_spring.model.Person;
import person_list_spring.model.PersonCreationDto;
import person_list_spring.model.PersonDto;
import person_list_spring.service.PersonService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ControllerPersonDto {


    @GetMapping("/all")
    public String showAll(Model model) {
        model.addAttribute("persons", PersonService.findAll());
        return "allPerson";
    }
    @GetMapping(value = "/edit")
    public String showEditForm(Model model) {
        List<Person> persons = new ArrayList<>();
        PersonService.findAll()
                .iterator()
                .forEachRemaining(persons::add);

        model.addAttribute("form", new PersonCreationDto(persons));

        return "editPersonsForm";
    }

    @PostMapping(value = "/save")
    public String saveBooks(@ModelAttribute PersonCreationDto form, Model model) {
        PersonService.saveAll(form.getPersons());

        model.addAttribute("persons", PersonService.findAll());

        return "redirect:/persons/all";
    }

}
