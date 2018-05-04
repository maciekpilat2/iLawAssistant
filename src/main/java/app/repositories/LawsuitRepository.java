/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import app.models.Lawsuit;
/**
 *
 * @author Pilat
 */
@Repository
public interface LawsuitRepository extends CrudRepository<Lawsuit, Long>{
    
}
