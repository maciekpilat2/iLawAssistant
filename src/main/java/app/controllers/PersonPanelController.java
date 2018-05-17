/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pilat
 */
@Controller
public class PersonPanelController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/personpanel")
public String getPersonPalnel(Model model, @RequestParam("personId") Long personId){
    model.addAttribute("person", personRepository.findOne(personId));
    return "personpanel";
}    
}