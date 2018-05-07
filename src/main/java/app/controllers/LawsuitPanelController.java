/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Params;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;
import app.models.Params;
import app.repositories.LawsuitRepository;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Pilat
 */
@Controller
public class LawsuitPanelController {

    @Autowired
    LawsuitRepository lawsuitRepository;

    @GetMapping("/lawsuitpanel/{lawsuitId}")
    public String postLawsuitEvents(Model model, @PathVariable Long lawsuitId) {

//        model.addAttribute("eventsList", lawsuitRepository.findOne(lawsuitId));
        System.out.println("Wyswietlam przekazany parametr: " + lawsuitId);

        return "lawsuitepanel";
        }

}
