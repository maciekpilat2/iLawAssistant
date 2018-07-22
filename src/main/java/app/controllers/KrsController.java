/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.enums.KrsNumberTypeEnum;
import app.services.KrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import app.models.KrsDataModel;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Pilat
 */
@Controller
public class KrsController {

    @Autowired
    KrsService krsService;

    @GetMapping("/krs")
    public String getKrs(Model model, @ModelAttribute("krsDataModel") KrsDataModel krsDataModelRedirect) {

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

//        KrsDataModel krsDataModel = new KrsDataModel();
//        model.addAttribute("krsNumberTypeEnum", KrsNumberTypeEnum.values());
//        model.addAttribute("krsDataModel", krsDataModel);
        return "krs";
    }

    @PostMapping("/krs")
    public String postKrs(@RequestParam("krsDataType") String krsDataType, @RequestParam("krsData") String krsData, Model model, RedirectAttributes redirectAttributes) {

        KrsDataModel krsDataModel = null;

        try {
            krsDataModel = krsService.krsJsonParser(krsService.krsSearch(krsData, krsDataType));
            model.addAttribute("krsDataModel", krsDataModel);
            redirectAttributes.addFlashAttribute("krsDataModel", krsDataModel);
        } catch (Exception e) {
            System.out.println("Brak danych znalezionych w bazie!");
            model.addAttribute("krsDataModel", krsDataModel);

        }
        return "redirect:krs";
    }
}
