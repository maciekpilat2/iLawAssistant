/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.services.EventService;
import app.services.RemainderMailService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.repositories.EventRepository;
import app.repositories.LawsuitRepository;
import app.repositories.PersonRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import app.services.UserService;

/**
 *
 * @author Pilat
 */
@Controller
public class LawsuitPanelController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    UserService userService;
    @Autowired
    RemainderMailService remainderMailService;

    @RequestMapping("/lawsuitpanel")
    public String postLawsuitEvents(@RequestParam("lawsuitId") Long lawsuitId, Model model) {
        model.addAttribute("lawsuit", lawsuitRepository.findOne(lawsuitId));
        model.addAttribute("personPlaintiffList", personRepository.allPlaintiffToLawsuit(lawsuitId));
        model.addAttribute("personDefendantList", personRepository.allDefendantToLawsuit(lawsuitId));
        model.addAttribute("eventToRemindList", eventRepository.userEventToRemind(userService.loggedUserId(), true, lawsuitId));
       // remainderMailService.sendEventReminders();

        return "lawsuitpanel";
    }

}
