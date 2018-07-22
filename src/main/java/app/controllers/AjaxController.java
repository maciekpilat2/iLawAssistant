/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.repositories.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import app.models.Address;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.services.GusService;
import app.services.KrsService;
/**
 *
 * @author Pilat
 */
@RestController
public class AjaxController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    GusService gusService;
    @Autowired
    KrsService krsService;

    @RequestMapping("/userpanel/ajax/clientaddress")
    public List<Address> userpanelClientAddress(@RequestParam Long clientId) {        
        List<Address> list = addressRepository.findAddressByPersonId(clientId);
        
        gusService.gusFindOne();
        krsService.krsJsonParser(krsService.krsSearch("7010542083", "NIP"));
                
        
        return list;
    }

}
