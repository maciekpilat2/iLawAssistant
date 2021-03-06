/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import app.models.Scan;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
/**
 *
 * @author Pilat
 */
public interface ScanRepository extends JpaRepository<Scan, Long>{
    @Query("select s from Scan s where s.event.id=?1")
    public List<Scan> findAllScanToEvent(Long eventId);
}
