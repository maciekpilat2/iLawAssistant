/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.repositories.CourtDepartmentRepository;
import app.repositories.CourtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pilat
 */
@Controller
public class courtDepartmentController {
    
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;
    @Autowired
    CourtRepository courtRepository;
    
    @GetMapping("/addcourtdepartment")
    public String getAddCourtDepartment(Model model){
        model.addAttribute("courtDepartmentList", courtDepartmentRepository.findAll());
        model.addAttribute("courtList", courtRepository.findAll());
        return "addcourtdepartment";
    }
    
        @PostMapping("/addcourtdepartment")
    public String postAddCourtDepartment(){
        return "redirect:addcourtdepartment";
    }
}
