/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import app.repositories.LawsuitRepository;
import app.models.Lawsuit;
import app.repositories.CourtDepartmentRepository;
import app.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.services.UserService;
import org.springframework.web.bind.annotation.SessionAttributes;
import app.formswrapper.AddLawsuitWrapper;
import app.repositories.SubjectRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import app.models.Subject;
import app.repositories.PersonRepository;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@SessionAttributes("subject")
public class LawsuitController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    UserService userService;
    @Autowired
    CourtRepository courtRepository;
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/addlawsuit")
    public String getAddLawsuit(Model model, @RequestParam("subjectId") Long subjectId) {

        AddLawsuitWrapper addLawsuitWrapper = new AddLawsuitWrapper();
        model.addAttribute("addLawsuitWrapper", addLawsuitWrapper);
        model.addAttribute("courtList", courtRepository.findAll());
        model.addAttribute("courtDepartmentList", courtDepartmentRepository.findAll());
        model.addAttribute("subject", subjectRepository.findOne(subjectId));
        return "addlawsuit";
    }

    @PostMapping("/addlawsuit")
    public String postAddLawsuit(@ModelAttribute AddLawsuitWrapper addLawsuitWrapper, @SessionAttribute("subject") Subject subject, RedirectAttributes redirectAttributes) {

        addLawsuitWrapper.getLawsuit().setUser(userService.getLoggedInUser());
        addLawsuitWrapper.getLawsuit().setCourtDepartment(courtDepartmentRepository.findOne(addLawsuitWrapper.getCourtDepartment().getId()));
        addLawsuitWrapper.getLawsuit().setSubject(subject);
        lawsuitRepository.save(addLawsuitWrapper.getLawsuit());
        redirectAttributes.addAttribute("subjectId", subject.getId());
        return "redirect:subjectpanel";
    }

    @GetMapping("/addlawsuituesrpanel")
    public String getAddLawsuitUserpanel(Model model) {
        model.addAttribute("clientList", personRepository.allUserClient(userService.loggedUserId()));
        model.addAttribute("subjectList", subjectRepository.allUserSubjects(userService.loggedUserId()));
        model.addAttribute("courtList", courtRepository.findAll());
        model.addAttribute("courtDepartmentList", courtDepartmentRepository.findAll());
        Lawsuit lawsuit = new Lawsuit();
        model.addAttribute("lawsuit", lawsuit);
        return "userpaneladdlawsuit";
    }

    @PostMapping("/addlawsuituesrpanel")
    public String postAddLawsuitUserpanel(Model model, @ModelAttribute Lawsuit lawsuit, RedirectAttributes redirectAttributes) {
        lawsuit.setCourtDepartment(courtDepartmentRepository.findOne(lawsuit.getCourtDepartment().getId()));
        lawsuit.setUser(userService.getLoggedInUser());
        lawsuit.setSubject(subjectRepository.findOne(lawsuit.getSubject().getId()));
        lawsuitRepository.save(lawsuit);
        redirectAttributes.addAttribute("userId", userService.loggedUserId());
        return "redirect:userpanel";
    }
}
