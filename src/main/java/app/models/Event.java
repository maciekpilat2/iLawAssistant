/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.sql.Timestamp;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Event extends Model {

    private String note;
    private Timestamp eventDate;
    private Long eventType;
    private boolean reminder;

    @ManyToOne(fetch = FetchType.EAGER)
    private Lawsuit lawsuit;
    
    @OneToMany(mappedBy = "event", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Scan> scan;

    @Override
    public String toString() {
        return "Event{" + "note=" + note + ", eventDate=" + eventDate + ", eventType=" + eventType + ", reminder=" + reminder + ", lawsuit=" + lawsuit + ", scan=" + scan + '}';
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * @return the eventDate
     */
    public Timestamp getEventDate() {
        return eventDate;
    }

    /**
     * @param eventDate the eventDate to set
     */
    public void setEventDate(Timestamp eventDate) {
        this.eventDate = eventDate;
    }

    /**
     * @return the lawsuit
     */
    public Lawsuit getLawsuit() {
        return lawsuit;
    }

    /**
     * @param lawsuit the lawsuit to set
     */
    public void setLawsuit(Lawsuit lawsuit) {
        this.lawsuit = lawsuit;
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
     * @return the eventType
     */
    public Long getEventType() {
        return eventType;
    }

    /**
     * @param eventType the eventType to set
     */
    public void setEventType(Long eventType) {
        this.eventType = eventType;
    }

    /**
     * @return the reminder
     */
    public boolean isReminder() {
        return reminder;
    }

    /**
     * @param reminder the reminder to set
     */
    public void setReminder(boolean reminder) {
        this.reminder = reminder;
    }

}
