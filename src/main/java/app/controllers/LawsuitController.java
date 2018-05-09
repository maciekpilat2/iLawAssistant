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
import org.springframework.web.bind.annotation.SessionAttributes;


/**
 *
 * @author Pilat
 */
@SessionAttributes("lawsuit")
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
    public String postAddLawsuit(@ModelAttribute("lawsuit") Lawsuit lawsuit){
        // dodaje userId
        lawsuit.setUser(userService.getLoggedInUser());
        //nie spisuje bo zapisze się przy zapiesie Party inaczej będzie konflikt istnienia rekordu
        return "redirect:addparty";
    }
    
}
