/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import app.models.Address;

/**
 *
 * @author Pilat
 */
@Controller
public class AddressController {
    
    @GetMapping("/addaddress")
    public String getAddAddress(Model model){
        
        Address address = new Address();
        
        model.addAttribute("address", address);
        System.out.println("TESTET");
        return "addaddress";
    }
    
}
