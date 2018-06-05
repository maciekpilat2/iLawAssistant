/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.repositories.ContatctRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.Contact;
import app.repositories.PersonRepository;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import app.models.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pilat
 */
@Controller
@SessionAttributes("person")
public class ContactController {

    @Autowired
    ContatctRepository contatctRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/addcontact")
    public String getAddContact(Long personId, Model model) {
        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        Person person = new Person();
        person.setId(personId);
        model.addAttribute("person", person);
        return "addcontact";
    }

    @PostMapping("/addcontact")
    public String postAddContact(@SessionAttribute("person") Person person, @ModelAttribute Contact contact, RedirectAttributes redirectAttributes) {
        contact.setPerson(personRepository.findOne(person.getId()));
        contatctRepository.save(contact);
        redirectAttributes.addAttribute("personId", person.getId());
        return "redirect:personpanel";
    }
}
