/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Address;
import app.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.enums.AddressTypeEnum;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.Person;
import app.repositories.PersonRepository;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
@SessionAttributes("person")
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    PersonRepository personRepository;
    
    @GetMapping("/addaddress")
    public String getAddAddress(Model model, @RequestParam("personId") Long persinId){
        
        Address address = new Address();
        model.addAttribute("address", address);
        model.addAttribute("addressTypeList", AddressTypeEnum.values());
        Person person = new Person();
        person.setId(persinId);
        model.addAttribute("person", person);
        
        return "addaddress";
    }
    
    @PostMapping("/addaddress")
    public String postAddAddress(@ModelAttribute Address address, @SessionAttribute("person") Person person, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("personId", person.getId());
        address.setPerson(personRepository.findOne(person.getId()));
        addressRepository.save(address);
        return "redirect:personpanel";
    }
    
}
