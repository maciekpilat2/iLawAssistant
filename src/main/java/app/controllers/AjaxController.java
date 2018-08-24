/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.repositories.AddressRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import app.models.Address;
import app.models.AlmightySerch;
import app.repositories.EventRepository;
import app.repositories.LawsuitRepository;
import app.repositories.PersonRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.services.KrsService;
import app.models.Lawsuit;
import net.minidev.json.annotate.JsonIgnore;

/**
 *
 * @author Pilat
 */
@RestController
public class AjaxController {

    @Autowired
    AddressRepository addressRepository;
    @Autowired
    KrsService krsService;
    @Autowired
    LawsuitRepository lawsuitRepository;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    EventRepository eventRepository;

    @RequestMapping("/userpanel/ajax/clientaddress")
//        @RequestMapping("/userpanel")
    public List<Address> userpanelClientAddress(@RequestParam Long clientId) {

        List<Address> list = addressRepository.findAddressByPersonId(clientId);
        krsService.krsJsonParser(krsService.krsSearch("7010542083", "NIP"));

        return list;
    }

    @RequestMapping("/userpanel/ajax/almightyserch")
    public AlmightySerch userPanelAlmightySerch(Long userId) {
        AlmightySerch almightySerch = new AlmightySerch();
        almightySerch.setLawsuit(lawsuitRepository.findAllLawsuitsByUserId(userId));
       // almightySerch.setPerson(personRepository.allUserClient(userId));
        return almightySerch;
    }
}
