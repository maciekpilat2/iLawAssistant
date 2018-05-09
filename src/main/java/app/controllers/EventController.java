/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.Event;
import app.models.Lawsuit;
import app.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.repositories.LawsuitRepository;
import java.sql.Timestamp;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pilat
 */
@Controller
public class EventController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    EventRepository eventRepository;
    
    @GetMapping("/addevent")
    public String getAddEvent(@RequestParam("lawsuitId") Long lawsuitId, Model model) {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("lawsuitId", lawsuitId);
        return "addevent";
    }

    @PostMapping("/addevent")
    public String postAddEvent(Model model,
            @ModelAttribute("event") Event event,
            @ModelAttribute("lawsuitId") Long lawsuitId,
            @RequestParam("startDate") Timestamp startDate,
            @RequestParam("endDate") Timestamp endDate) {
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        System.out.println("Wydarzenie: " + event.toString());
        event.setLawsuit(lawsuitRepository.findOne(lawsuitId));
        eventRepository.save(event);
        return "redirect:addevent";
    }

}
