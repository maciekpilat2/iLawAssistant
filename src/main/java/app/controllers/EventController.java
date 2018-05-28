/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.enums.EventTypeEnum;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.Event;
import app.models.Lawsuit;
import app.repositories.EventRepository;
import app.repositories.EventTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.repositories.LawsuitRepository;
import app.repositories.SubjectRepository;
import java.sql.Timestamp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import app.models.Subject;

/**
 *
 * @author Pilat
 */
@SessionAttributes({"lawsuit", "editEvent", "subject"})
@Controller
public class EventController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    EventTypeRepository eventTypeRepository;
    @Autowired
    SubjectRepository subjectRepository;

    @GetMapping("/addevent")
    public String getAddEvent(@RequestParam("lawsuitId") Long lawsuitId, Model model) {
        model.addAttribute("eventTypeEnum", EventTypeEnum.values());
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("eventType", eventTypeRepository.findAll());
        Lawsuit lawsuit = new Lawsuit();
        lawsuit.setId(lawsuitId);
        model.addAttribute("lawsuit", lawsuit);
        return "addevent";
    }

    @PostMapping("/addevent")
    public String postAddEvent(
            @ModelAttribute Event event,
            @SessionAttribute("lawsuit") Lawsuit lawsuit,
            @RequestParam("eventDate") Timestamp eventDate,
            RedirectAttributes redirectAttributes
    ) {
        redirectAttributes.addAttribute("lawsuitId", lawsuit.getId());
        event.setEventDate(eventDate);
        event.setLawsuit(lawsuitRepository.findOne(lawsuit.getId()));
        eventRepository.save(event);
        return "redirect:lawsuitpanel";
    }

    @GetMapping("/editevent")
    public String getEditEvent(@RequestParam("eventId") Long eventId, @RequestParam("subjectId") Long subjectId, Model model) {
        Event editEvent = eventRepository.findOne(eventId);
        model.addAttribute("editEvent", editEvent);
        model.addAttribute("subject", subjectRepository.findOne(subjectId));
        return "editevent";
    }

    @PostMapping("/editevent")
    public String postEditEvent(
            @SessionAttribute("editEvent") Event sessionEditEvent,
            @SessionAttribute("subject") Subject subject,
            @ModelAttribute Event editEvent,
            @RequestParam("eventDate") Timestamp eventDate,
            RedirectAttributes redirectAttributes
    ) {
        editEvent.setEventDate(eventDate);
        editEvent.setLawsuit(sessionEditEvent.getLawsuit());
        editEvent.setId(sessionEditEvent.getId());
        editEvent.setSubject(subject);
        eventRepository.save(editEvent);
        redirectAttributes.addAttribute("subjectId", subject.getId());
        return "redirect:subjectpanel";
    }

    @RequestMapping("/delete/event")
    public String deleteEvent(@RequestParam("eventId") Long eventId, @RequestParam("subjectId") Long subjectId, RedirectAttributes redirectAttributes) {
        //Long lawsuitId = lawsuitRepository.findOne(eventRepository.findOne(eventId).getLawsuit().getId()).getId();
        eventRepository.delete(eventId);
        redirectAttributes.addAttribute("subjectId", subjectId);
        return "redirect:/subjectpanel";
    }

    @GetMapping("/addnonlawsuitevent")
    public String getAddNonLawsuitEvent(Model model, @RequestParam("subjectId") Long subjectId) {
        Event event = new Event();
        model.addAttribute("event", event);
        model.addAttribute("subject", subjectRepository.findOne(subjectId));
        return "addnonlawsuitevent";
    }

    @PostMapping("/addnonlawsuitevent")
    public String postAddNonLawsuitEvent(@ModelAttribute Event event, RedirectAttributes redirectAttributes, @SessionAttribute("subject") Subject subject) {
        event.setSubject(subject);
        eventRepository.save(event);
        redirectAttributes.addAttribute("subjectId", subject.getId());
        return "redirect:subjectpanel";
    }

}
