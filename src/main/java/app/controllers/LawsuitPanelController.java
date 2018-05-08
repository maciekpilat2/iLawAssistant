/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.repositories.EventRepository;
import app.repositories.LawsuitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

/**
 *
 * @author Pilat
 */
@Controller
public class LawsuitPanelController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    EventRepository eventRepository;

    @GetMapping("/lawsuitpanel")
    public String postLawsuitEvents(@RequestParam("lawsuitId") Long lawsuitId, Model model) {
        model.addAttribute("lawsuit", lawsuitRepository.findOne(lawsuitId));
        return "lawsuitpanel";
    }

}
