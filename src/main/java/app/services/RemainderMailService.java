package app.services;

import app.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainderMailService {

    private static final long ONE_HOUR = 3600000;
    // TODO dodac crona zeby robil to codziennie rano

    @Autowired
    EventService eventService;

    @Autowired
    MailService mailService;

    @Scheduled(fixedDelay = ONE_HOUR)
    public void sendEventReminders(){

        List<Event> allEventsForRemind = eventService.getAllEventsForRemind();

        for(Event event :allEventsForRemind){
            System.out.println("Wysyłam powiadomienie do: "+event.getLawsuit().getUser().getEmail());
            System.out.println("Treść: " + event.getNote());
            mailService.sendMail(
                    event.getLawsuit().getUser().getEmail(),
                    "Przypomnienie o nadchodzącym wydarzeniu " + event.getEventType(),
                    "Nasz schowany w szafie mudżin przypomina o nadchodzącym zdarzeniu \n" +
                            " " + event.getEventType() + ": " +event.getEventDate() + ", uwagi: " +event.getNote()
            );


        }


    }



}
