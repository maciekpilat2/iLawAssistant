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

}