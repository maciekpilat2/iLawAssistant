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
import app.repositories.SubjectRepository;
import app.repositories.UserRepository;
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
    @Autowired
    SubjectRepository subjectRepository;

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

    @GetMapping("/addclient")
    public String getAddClient(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addclient";
    }

    @PostMapping("/addclient")
    public String postAddClient(@ModelAttribute Person person, RedirectAttributes redirectAttributes) {
        person.setUser(userService.getLoggedInUser());
        redirectAttributes.addAttribute("userId", userService.loggedUserId());
        personRepository.save(person);
        return "redirect:userpanel";
    }

    @GetMapping("/clientpanel")
    public String getClientPanel(Model model, @RequestParam("clientId") Long clientId){
        model.addAttribute("person", personRepository.findOne(clientId));
    return "clientpanel";
    }
}
