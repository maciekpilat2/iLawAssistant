/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.models.Event;
import app.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *
 * @author Pilat
 */
@Service
public class EventService {

    @Autowired
    EventRepository eventRepository;



    public List<Event> getAllEventsForRemind(){
        return eventRepository.getAllEventsToRemind();
    }



    
}
