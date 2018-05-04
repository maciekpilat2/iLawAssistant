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
import app.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Pilat
 */
@Controller
public class AddressController {
    @Autowired
    AddressRepository addressRepository;
    
    @GetMapping("/addaddress")
    public String getAddAddress(Model model){
        
        Address address = new Address();
        model.addAttribute("address", address);
        return "addaddress";
    }
    
    @PostMapping("/addaddress")
    public String postAddAddress(@ModelAttribute Address address){    
        addressRepository.save(address);
        return "redirect:addaddress";
    }
    
}
