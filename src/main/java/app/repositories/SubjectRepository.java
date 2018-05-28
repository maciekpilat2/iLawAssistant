/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import app.models.Subject;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Pilat
 */
@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long>{

    @Query("select s from Subject s where s.person.id=?1")
    List<Subject> allUserSubjects(Long userId);
    
//    @Query("select s from Subject s where s.person.id=?1 and")
//    List<Subject> allUserClientSubjects(Long userId, Long clientId);
}
