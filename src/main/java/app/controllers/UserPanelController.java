/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.enums.KrsNumberTypeEnum;
import app.models.Event;
import app.models.KrsDataModel;
import app.repositories.LawsuitRepository;
import app.services.UserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Lawsuit;
import app.repositories.EventRepository;
import app.repositories.PersonRepository;
import app.repositories.SubjectRepository;
import app.services.EventService;
import app.services.KrsService;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
public class UserPanelController {

    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    UserService userService;
    @Autowired
    EventRepository eventRepository;
    @Autowired
    SubjectRepository subjectRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    KrsService krsService;

    @GetMapping("/userpanel")
    public String getUserPanel(Model model, @ModelAttribute("krsDataModel") KrsDataModel krsDataModelRedirect) {
        List<Lawsuit> userLawsuitList = lawsuitRepository.findAllLawsuitsByUserId(userService.loggedUserId());
        model.addAttribute("userLawsuitList", userLawsuitList);
        model.addAttribute("listAllUserNonLawsuitEventToRemind", eventRepository.getAllUserLawsuitEventToRemind(userService.loggedUserId(), true));
        model.addAttribute("subjectList", subjectRepository.allUserSubjects(userService.loggedUserId()));
        model.addAttribute("clientList", personRepository.allUserClient(userService.loggedUserId()));
        model.addAttribute("listAllUserLawsuitEventToRemind", eventRepository.getAllUserNonLawsuitEventToRemind(userService.loggedUserId(), true));
        model.addAttribute("userId", userService.loggedUserId());
// wyszukiwanie krs
        try {
            KrsDataModel krsDataModel = new KrsDataModel();
            model.addAttribute("krsNumberTypeEnum", KrsNumberTypeEnum.values());
            if (krsDataModelRedirect.equals(null)) {
                model.addAttribute("krsDataModel", krsDataModel);
            } else {
                model.addAttribute("krsDataModel", krsDataModelRedirect);
            }
        } catch (Exception e) {
            model.addAttribute("krsNumberTypeEnum", KrsNumberTypeEnum.values());
            model.addAttribute("krsDataModel", krsDataModelRedirect);

        }
// json for easy autocomplete
//        JSONObject jSONObject = new JSONObject(personRepository.allUserClient(userService.loggedUserId()));
//        System.out.println("JSON: " + jSONObject.toString());
        
        return "userpanel";
    }

    @PostMapping("/userpanel")
    public String postaUserPanel(@RequestParam("krsDataType") String krsDataType, @RequestParam("krsData") String krsData, Model model, RedirectAttributes redirectAttributes) {

        KrsDataModel krsDataModel = null;

        try {
            krsDataModel = krsService.krsJsonParser(krsService.krsSearch(krsData, krsDataType));
            model.addAttribute("krsDataModel", krsDataModel);
            redirectAttributes.addFlashAttribute("krsDataModel", krsDataModel);
        } catch (Exception e) {
            System.out.println("Brak danych znalezionych w bazie!");
            model.addAttribute("krsDataModel", krsDataModel);

        }

        return "redirect:userpanel";
    }

}
