/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Lawsuit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Party;
import org.springframework.beans.factory.annotation.Autowired;
import app.repositories.PartyTypeRepository;
import app.repositories.LawsuitRepository;
import app.services.UserService;
import app.repositories.PartyRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

/**
 *
 * @author Pilat
 */
@Controller
@SessionAttributes("lawsuit")
public class PartyController {

    @Autowired
    PartyTypeRepository partyTypeRepository;
    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    UserService userService;
    @Autowired
    PartyRepository partyRepository;

    @GetMapping("/addparty")
    public String getAddParty(Model model, @ModelAttribute("lawsuit") Lawsuit lawsuit) {
        Party party = new Party();
        model.addAttribute("party", party);
        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
        model.addAttribute("lawsuitList", lawsuitRepository.findAllLawsuitsByUserId(userService.getLoggedInUser().getId()));
        return "addparty";
    }

    @PostMapping("/addparty")
    public String postAddParty(@ModelAttribute Party party, @ModelAttribute("lawsuit") Lawsuit lawsuit){
        party.setLawsuit(lawsuitRepository.findOneLawsuitsByCourtFileReference(lawsuit.getCourtFileReference()));
        System.out.println("Zawartosc lawsuit2: " + lawsuit.toString());
        partyRepository.save(party);
        return "redirect:addparty";
    }
}
