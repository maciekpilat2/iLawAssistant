/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Subject;
import app.repositories.PersonRepository;
import app.repositories.SubjectRepository;
import app.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
public class SubjectController {
@Autowired
UserService userService;
@Autowired
SubjectRepository subjectRepository;
@Autowired
PersonRepository personRepository;

    @GetMapping("/addsubject")
    public String getAddSubject(Model model){
        Subject subject = new Subject();
        model.addAttribute("subject", subject);
        return "addsubject";
    }
    @PostMapping("/addsubject")
    public String postAddSubject(@ModelAttribute Subject subject, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("userId",userService.loggedUserId());
        subject.setPerson(personRepository.findOne(userService.loggedUserId()));
        subjectRepository.save(subject);
        return "redirect:userpanel";
    }
    @GetMapping("/subjectpanel")
    public String getSubjectPanel(Model model, @RequestParam("subjectId") Long subjectId){
        model.addAttribute("subject", subjectRepository.findOne(subjectId));
        return "subjectpanel";
    }
}
