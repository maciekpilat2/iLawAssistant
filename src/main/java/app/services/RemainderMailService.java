package app.services;

import app.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RemainderMailService {

    private static final long ONE_HOUR = 3600000;
    private final String EVERYDAY_AT_6AM = "0 0 6 1 * *";

    @Autowired
    EventService eventService;

    @Autowired
    MailService mailService;

    @Scheduled(cron = EVERYDAY_AT_6AM)
    public void sendEventReminders(){

        List<Event> allEventsForRemind = eventService.getAllEventsForRemind();

        for(Event event :allEventsForRemind){
            System.out.println("Wysyłam powiadomienie do: "+event.getLawsuit().getUser().getEmail());
            System.out.println("Treść: " + event.getNote());
            mailService.sendMail(
                    event.getLawsuit().getUser().getEmail(),
                    "Przypomnienie o nadchodzącym wydarzeniu " + event.getEventType(),
                    "Przypominamy o nadchodzącym zdarzeniu \n" +
                            " " + event.getEventType() + ": " +event.getEventDate() + ", uwagi: " +event.getNote()
            );
        }
    }



}
