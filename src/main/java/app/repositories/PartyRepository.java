/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;
import app.models.Party;
import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pilat
 */
@Repository
public interface PartyRepository extends CrudRepository<Party, Long>{
    
}