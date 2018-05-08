/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Pilat
 */
@Controller
public class EventController {
    
    @GetMapping("/addevent")
    public String getAddEvent(@RequestParam("lawsuitId") Long lawsuitId){
        System.out.println("Wyświetlam id procesu22: " + lawsuitId);
        return "redirect:addevent";
    }
}
