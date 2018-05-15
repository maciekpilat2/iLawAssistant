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
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author Pilat
 */
@Repository
public interface LawsuitRepository extends JpaRepository<Lawsuit, Long>{

@Query("select l from Lawsuit l where l.user.id =?1")
    List<Lawsuit> findAllLawsuitsByUserId(Long userId);
    
@Query("select l from Lawsuit l where l.courtFileReference =?1")
    Lawsuit findOneLawsuitsByCourtFileReference(String courtFileReference);    
}
