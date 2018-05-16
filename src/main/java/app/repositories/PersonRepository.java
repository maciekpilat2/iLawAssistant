/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.repository.CrudRepository;
import app.models.Person;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pilat
 */
@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

    @Query("select p from Person p where p.lawsuit.id=?1")
    List<Person> allPersonToLawsuit(Long lawsuitId);

    @Query("select p from Person p where p.lawsuit.id=?1 and p.partyType=1")
    List<Person> allPlaintiffToLawsuit(Long lawsuitId);

    @Query("select p from Person p where p.lawsuit.id=?1 and p.partyType=2")
    List<Person> allDefendantToLawsuit(Long lawsuitId);

}
