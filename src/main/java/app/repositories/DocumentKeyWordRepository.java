/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import app.models.DocumentKeyWord;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pilat
 */
public interface DocumentKeyWordRepository extends JpaRepository<DocumentKeyWord, Long>{

    @Query("select d.keyWords from DocumentKeyWord d where d.documentType = ?1")
    List<String> allCombinationsOfType(String documentType);    
}
