
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
import app.repositories.PersonRepository;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

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
    @Autowired
    PersonRepository personRepository;

    @GetMapping("/addparty")
     public String getAddParty(Model model) {
        Party party = new Party();
        model.addAttribute("party", party);
        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
        return "addparty";
    }

    @PostMapping("/addparty")
      public String postAddParty(@ModelAttribute Party party, @SessionAttribute("lawsuit")Lawsuit lawsuit){        
        party.setLawsuit(lawsuit);
        partyRepository.save(party);
        return "redirect:addparty";
    }
}
