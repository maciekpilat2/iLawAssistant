/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Event;
import app.repositories.LawsuitRepository;
import app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Lawsuit;
import app.repositories.EventRepository;
import app.repositories.PersonRepository;
import app.repositories.SubjectRepository;
import app.services.EventService;

/**
 *
 * @author Pilat
 */
@Controller
public class UserPanelController {
@Autowired
LawsuitRepository lawsuitRepository;
@Autowired
UserService userService;
@Autowired
EventRepository eventRepository;
@Autowired
SubjectRepository subjectRepository;
@Autowired
PersonRepository personRepository;
        
    @GetMapping("/userpanel")
    public String getUserPanel(Model model) {
        List<Lawsuit> userLawsuitList = lawsuitRepository.findAllLawsuitsByUserId(userService.loggedUserId());
        model.addAttribute("userLawsuitList", userLawsuitList);
        model.addAttribute("listAllUserNonLawsuitEventToRemind", eventRepository.getAllUserLawsuitEventToRemind(userService.loggedUserId(), true));
        model.addAttribute("subjectList", subjectRepository.allUserSubjects(userService.loggedUserId()));
        model.addAttribute("clientList", personRepository.allUserClient(userService.loggedUserId()));
        model.addAttribute("listAllUserLawsuitEventToRemind", eventRepository.getAllUserNonLawsuitEventToRemind(userService.loggedUserId(), true));

        return "userpanel";
    }

}
