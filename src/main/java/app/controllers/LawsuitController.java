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

/**
 *
 * @author Pilat
 */
//@SessionAttributes("lawsuit")
@SessionAttributes("addLawsuitWrapper")
@Controller
public class LawsuitController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    UserService userService;
    @Autowired
    CourtRepository courtRepository;
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;

    @GetMapping("/addlawsuit")
    public String getAddLawsuit(Model model) {

        AddLawsuitWrapper addLawsuitWrapper = new AddLawsuitWrapper();
        model.addAttribute("addLawsuitWrapper", addLawsuitWrapper);

        model.addAttribute("courtList", courtRepository.findAll());
        model.addAttribute("courtDepartmentList", courtDepartmentRepository.findAll());
        return "addlawsuit";
    }

    @PostMapping("/addlawsuit")
    public String postAddLawsuit(@ModelAttribute AddLawsuitWrapper addLawsuitWrapper) {        
        addLawsuitWrapper.getLawsuit().setUser(userService.getLoggedInUser());
        addLawsuitWrapper.setCourtDepartment(courtDepartmentRepository.findOne(addLawsuitWrapper.getCourtDepartment().getId()));
        addLawsuitWrapper.setCourt(courtRepository.findOne(addLawsuitWrapper.getCourt().getId()));
        
//nie spisuje bo zapisze się przy zapiesie Party inaczej będzie konflikt istnienia rekordu
        return "redirect:addparty";
    }

}
