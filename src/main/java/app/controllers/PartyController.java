package app.controllers;

import app.formswrapper.AddLawsuitWrapper;
import app.models.Lawsuit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.repositories.CourtDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import app.repositories.PartyTypeRepository;
import app.repositories.LawsuitRepository;
import app.services.UserService;
import app.repositories.PersonRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import app.models.Person;

@Controller
@SessionAttributes("lawsuit")
public class PartyController {

//    @Autowired
//    PartyTypeRepository partyTypeRepository;
//    @Autowired
//    LawsuitRepository lawsuitRepository;
//    @Autowired
//    UserService userService;
//    @Autowired
//    PartyRepository partyRepository;
//    @Autowired
//    PersonRepository personRepository;
//    @Autowired
//    CourtDepartmentRepository courtDepartmentRepository;
//
//    @GetMapping("/addparty")
//    public String getAddParty(Model model, @RequestParam("lawsuitId")Long lawsuitId) {
//       
//        AddLawsuitWrapper addLawsuitWrapper = new AddLawsuitWrapper();
//        model.addAttribute("addLawsuitWrapper", addLawsuitWrapper);
//        
//        Lawsuit lawsuit = lawsuitRepository.findOne(lawsuitId);
//        model.addAttribute("lawsuit", lawsuit);
// 
//        model.addAttribute("partyTypeList", partyTypeRepository.findAll());
//
//        return "addparty";
//    }
//
//    @PostMapping("/addparty")
//    public String postAddParty(@ModelAttribute AddLawsuitWrapper addLawsuitWrapper,@SessionAttribute("lawsuit") Lawsuit lawsuit, RedirectAttributes redirectAttributes) {
//        
//        addLawsuitWrapper.getParty().setLawsuit(lawsuit);
//        
//        addLawsuitWrapper.getPerson().setParty(addLawsuitWrapper.getParty());//
//        
//        List<Person> person = new ArrayList();
//        person.add(addLawsuitWrapper.getPerson());
//        
//        addLawsuitWrapper.getParty().setPerson(person);
//        
//        partyRepository.save(addLawsuitWrapper.getParty());
//        
//        redirectAttributes.addAttribute("lawsuitId", lawsuit.getId());
//        return "redirect:lawsuitpanel";
//    }
}
