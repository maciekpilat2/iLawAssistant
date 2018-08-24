/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.repositories.DocumentKeyWordRepository;
import app.services.DocumentService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author Pilat
 */
@Controller
public class TestController {

    @Autowired
    DocumentKeyWordRepository documentKeyWordRepository;

    @GetMapping("/test")
    String getTestController() {
        System.out.println("Jestem uruchomionym testowym kontrollerem!");
        System.out.println("To jest z query to string: " + documentKeyWordRepository.allCombinationsOfType("POSTANOWIENIE").toString());

        for (Object a : documentKeyWordRepository.allCombinationsOfType("POSTANOWIENIE")) {
            System.out.println("Z to array: " + a.toString());
        }



        List pairList = documentKeyWordRepository.allCombinationsOfType("POSTANOWIENIE");
        //DocumentService.handleDocument(document, pairList);
        return "test";
    }
}
