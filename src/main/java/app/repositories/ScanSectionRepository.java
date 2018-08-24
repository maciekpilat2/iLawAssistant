/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import app.models.DocumentKeyWord;
import app.models.ScanSection;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Pilat
 */
public interface ScanSectionRepository extends JpaRepository<ScanSection, Long>{

    @Query("select s from ScanSection s where s.informationType=?1")
    public List<ScanSection> getScanSectionsOfSelectedType(String informationType);
}
