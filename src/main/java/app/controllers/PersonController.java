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
import app.models.Party;
import app.repositories.LawsuitRepository;
import app.repositories.PartyRepository;
import java.util.ArrayList;
import java.util.List;
import app.services.UserService;

/**
 *
 * @author Pilat
 */
@Controller
public class PersonController {

    @Autowired
    PersonRepository personRepository;
    @Autowired
    PartyTypeRepository partyTypeRepository;
    @Autowired
    PartyRepository partyRepository;
    @Autowired
    LawsuitRepository lawsuiteRepository;
    @Autowired
    UserService userService;

    @GetMapping("/addperson")
    public String getAddPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "addperson";
    }

    @PostMapping("/addperson")
    public String postAddPerson(@ModelAttribute Person person) {
        personRepository.save(person);
        return "redirect:addperson";
    }

    // dziala ale na razie bez potrzeby bo to robi Party
//    @GetMapping("/addpersonasparty")
//    public String getAddPersonAsParty(Model model) {
//        PartyTypePersonWrap partyTypePersonWrap = new PartyTypePersonWrap();
//        model.addAttribute("partyTypePersonWrap", partyTypePersonWrap);
//        model.addAttribute("lawsuitList", lawsuiteRepository.findAllLawsuitsByUserId(userService.getLoggedInUser().getId()));
//        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
//        return "addpersonasparty";
//    }
//
//    @PostMapping("/addpersonasparty")
//    public String postAddPersonAsParty(@ModelAttribute PartyTypePersonWrap partyTypePersonWrap) {
//     Party party = new Party();
//   
//        Person person = new Person();
//        person.setPersonFirstName(partyTypePersonWrap.getPerson().getPersonFirstName());
//        person.setPersonLastName(partyTypePersonWrap.getPerson().getPersonLastName());
//        person.setPersonTitle(partyTypePersonWrap.getPerson().getPersonTitle());
//        person.setPersonCompanyName(partyTypePersonWrap.getPerson().getPersonCompanyName());
//        //person.setParty(partyTypePersonWrap.get);
//        
//        List<Person> personList = new ArrayList<>();
//        personList.add(partyTypePersonWrap.getPerson());
//              
//        party.setPartyType(partyTypePersonWrap.getPartyType().getId());
//        party.setPerson(personList);
//        partyRepository.save(party);
//        personRepository.save(partyTypePersonWrap.getPerson());
//         return "redirect:addpersonasparty";
//    }

}
