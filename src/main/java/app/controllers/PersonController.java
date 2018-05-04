/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import app.repositories.PersonRepository;
import org.springframework.ui.Model;

/**
 *
 * @author Pilat
 */
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;
//@Autowired

    @GetMapping("/addperson")
    public String getAddPerson(Model model) {
        
        Person person = new Person();
        model.addAttribute("person", person);
        
        return "addperson";
    }

    @PostMapping("/addperson")
    public String postAddPerson(@ModelAttribute Person person, Model model) {
        personRepository.save(person);
        return "redirect:addperson";
    }

}
