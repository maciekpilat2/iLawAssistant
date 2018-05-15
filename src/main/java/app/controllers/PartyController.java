
package app.controllers;

import app.formswrapper.AddLawsuitWrapper;
import app.models.Lawsuit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Party;
import app.repositories.CourtDepartmentRepository;
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
    @Autowired
    CourtDepartmentRepository courtDepartmentRepository;

    @GetMapping("/addparty")
     public String getAddParty(Model model) {
        Party party = new Party();
        model.addAttribute("party", party);
        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
        return "addparty";
    }

    @PostMapping("/addparty")
      public String postAddParty(@ModelAttribute Party party, @SessionAttribute("addLawsuitWrapper") AddLawsuitWrapper addLawsuitWrapper){        
        party.setLawsuit(addLawsuitWrapper.getLawsuit());
        addLawsuitWrapper.getCourtDepartment().setCourt(addLawsuitWrapper.getCourt());
        partyRepository.save(party);
        courtDepartmentRepository.save(addLawsuitWrapper.getCourtDepartment());
        return "redirect:addparty";
    }
}
