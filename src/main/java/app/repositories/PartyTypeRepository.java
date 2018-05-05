/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import app.models.PartyType;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
/**
 *
 * @author Pilat
 */
public interface PartyTypeRepository extends CrudRepository<PartyType, Long>{
    
}
