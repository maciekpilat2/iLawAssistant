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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pilat
 */
@SessionAttributes({"lawsuit", "editEvent"})
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
        Lawsuit lawsuit = new Lawsuit();
        lawsuit.setId(lawsuitId);
        model.addAttribute("lawsuit", lawsuit);
        return "addevent";
    }

    @PostMapping("/addevent")
    public String postAddEvent(
            @ModelAttribute Event event,
            @SessionAttribute("lawsuit") Lawsuit lawsuit,
            @RequestParam("startDate") Timestamp startDate,
            @RequestParam("endDate") Timestamp endDate
    ) {

        System.out.println("Z lawsuit po drugiej stronie: " + lawsuit.getId().toString());
        event.setStartDate(startDate);
        event.setEndDate(endDate);
        event.setLawsuit(lawsuitRepository.findOne(lawsuit.getId()));
        eventRepository.save(event);
        return "addevent";
    }

    @GetMapping("/editevent")
    public String getEditEvent(@RequestParam("eventId") Long eventId, Model model) {
        Event editEvent = eventRepository.findOne(eventId);
        model.addAttribute("editEvent", editEvent);
        return "editevent";
    }

    @PostMapping("/editevent")
    public String postEditEvent(
            @SessionAttribute("editEvent") Event sessionEditEvent,
            @ModelAttribute Event editEvent,
            @RequestParam("startDate") Timestamp startDate,
            @RequestParam("endDate") Timestamp endDate
    ) {
        editEvent.setStartDate(startDate);
        editEvent.setEndDate(endDate);
        editEvent.setLawsuit(sessionEditEvent.getLawsuit());
        editEvent.setId(sessionEditEvent.getId());
        eventRepository.save(editEvent);

        return "forward:/lawsuitpanel?lawsuitId=" + editEvent.getLawsuit().getId().toString();
    }

    @RequestMapping("/delete/event")
    public String deleteEvent(@RequestParam("eventId") Long eventId) {
        Long lawsuitId = lawsuitRepository.findOne(eventRepository.findOne(eventId).getLawsuit().getId()).getId();
        eventRepository.delete(eventId);
        return "forward:/lawsuitpanel?lawsuitId=" + lawsuitId;
    }
}
