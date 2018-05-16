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
import app.formswrapper.PartyTypePersonWrap;
import app.repositories.PartyTypeRepository;
import app.models.Lawsuit;
import app.repositories.LawsuitRepository;
import java.util.ArrayList;
import java.util.List;
import app.services.UserService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
@SessionAttributes("lawsuit")
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PartyTypeRepository partyTypeRepository;
    @Autowired
    LawsuitRepository lawsuiteRepository;
    @Autowired
    UserService userService;

    @GetMapping("/addperson")
    public String getAddPerson(Model model, @RequestParam("lawsuitId") Long lawsuitId) {
        System.out.println("get lawsuitId: " + lawsuitId);
        
        Person person = new Person();
        model.addAttribute("person", person);
        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
        Lawsuit lawsuit = new Lawsuit();
        lawsuit.setId(lawsuitId);
        model.addAttribute("lawsuit", lawsuit);
        return "addperson";
    }

    @PostMapping("/addperson")
    public String postAddPerson(@ModelAttribute Person person, @SessionAttribute("lawsuit") Lawsuit lawsuit, RedirectAttributes redirectAttributes) {
        System.out.println("LawsuitId: " + lawsuit.getId());
        person.setLawsuit(lawsuiteRepository.findOne(lawsuit.getId()));
        personRepository.save(person);
        redirectAttributes.addAttribute("lawsuitId", lawsuit.getId());
        return "redirect:lawsuitpanel";
    }

}
