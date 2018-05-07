/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Party;
import org.springframework.beans.factory.annotation.Autowired;
import app.repositories.PartyTypeRepository;
import app.repositories.LawsuitRepository;
import app.services.UserService;
import java.util.ArrayList;
import java.util.List;
import app.models.Person;
import app.repositories.PartyRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
/**
 *
 * @author Pilat
 */
@Controller
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
    public String getAddParty(Model model) {
        Party party = new Party();
        model.addAttribute("party", party);
        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
        model.addAttribute("lawsuitList", lawsuitRepository.findAllLawsuitsByUserId(userService.getLoggedInUser().getId()));
        return "addparty";
    }
    @PostMapping("/addparty")
    public String postAddParty(@ModelAttribute Party party){
        partyRepository.save(party);
        return "redirect:addparty";
    }
}
