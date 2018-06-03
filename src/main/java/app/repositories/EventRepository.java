/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import app.models.Event;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

//public interface EventRepository extends CrudRepository<Event, Long>{
public interface EventRepository extends JpaRepository<Event, Long> {

    @Query("select e from Event e where e.id=?1")
    List<Event> lawsuitEventsList(Long id);

    @Query("select e from Event e JOIN FETCH e.lawsuit where e.lawsuit.user.id=?1 and e.reminder=?2 and e.eventDate>=SYSDATE() and e.lawsuit.id=?3")
    List<Event> userEventToRemind(Long userId, boolean remind, Long lawsuitId);

    @Query("select e from Event e JOIN FETCH e.lawsuit where e.reminder=true and e.eventDate>=SYSDATE()")
    List<Event> getAllEventsToRemind();

    @Query("select e from Event e JOIN FETCH e.lawsuit where e.lawsuit.user.id=?1 and e.reminder=?2 and e.eventDate>=SYSDATE()")
    List<Event> getAllUserLawsuitEventToRemind(Long userId, boolean remind);

    @Query("select e from Event e JOIN FETCH e.subject s JOIN FETCH s.person p where p.user.id=?1 and e.reminder=?2 and e.eventDate>=SYSDATE()")
    List<Event> getAllUserNonLawsuitEventToRemind(Long userId, boolean remind);
}
// and e.eventDate<=SYSDATE()
