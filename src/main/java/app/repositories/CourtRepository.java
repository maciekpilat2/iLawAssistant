/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import app.models.Court;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author Pilat
 */
public interface CourtRepository extends JpaRepository<Court, Long>{
    
}
