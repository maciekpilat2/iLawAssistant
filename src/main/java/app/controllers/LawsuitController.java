/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import app.repositories.LawsuitRepository;
import app.models.Lawsuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import app.services.UserService;
import app.models.Party;

/**
 *
 * @author Pilat
 */
@Controller
public class LawsuitController {
    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    UserService userService;
    
    
    @GetMapping("/addlawsuit")
    public String getAddLawsuit(Model model){
        Lawsuit lawsuit = new Lawsuit();
        model.addAttribute("lawsuit", lawsuit);
        return "addlawsuit";
    }
    
    @PostMapping("/addlawsuit")
    public String postAddLawsuit(@ModelAttribute Lawsuit lawsuit){
        lawsuit.setUser(userService.getLoggedInUser());
        lawsuitRepository.save(lawsuit);
        return "addperson";
    }
    
}
