/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.models.Event;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pilat
 */
@Service
public class ListService {

    public List<List> everySecondPosition(List<Event> eventList) {

        List<Event> evenList = null;
        List<Event> oddList = null;
        List<List> bothList = null;

        for (int i = 0; i <= eventList.size(); i += 2) {
            evenList.add(eventList.get(i));
        }

        for (int i = 0; i <= eventList.size(); i++) {
            evenList.add(oddList.get(i));
        }

        bothList.add(evenList);
        bothList.add(oddList);
        return bothList;
    }
}
