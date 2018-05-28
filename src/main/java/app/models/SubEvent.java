/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.sql.Timestamp;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class SubEvent extends Model{
    private String title;
    private String depiction;
    private Timestamp startDate;
    
    @OneToMany(mappedBy = "subEvent", cascade = CascadeType.MERGE)
    private List<Scan> scan;
    
    @ManyToOne
    private Subject subject;

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the depiction
     */
    public String getDepiction() {
        return depiction;
    }

    /**
     * @param depiction the depiction to set
     */
    public void setDepiction(String depiction) {
        this.depiction = depiction;
    }

    /**
     * @return the startDate
     */
    public Timestamp getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the scan
     */
    public List<Scan> getScan() {
        return scan;
    }

    /**
     * @param scan the scan to set
     */
    public void setScan(List<Scan> scan) {
        this.scan = scan;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(Subject subject) {
        this.subject = subject;
    }
    
    
}
