/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.models.EventType;
/**
 *
 * @author Pilat
 */
public interface EventTypeRepository extends JpaRepository<EventType, Long>{
    
}
