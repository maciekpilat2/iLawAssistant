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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.data.rest.core.config.Projection;

/**
 *
 * @author Pilat
 */
@Entity
@Table
@Projection (name = "subject", types = { Person.class })
public class Subject extends Model {

    private String title;
    private String shortNote;
    @Lob
    private String longNote;
    private Timestamp startDate;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE)
    private List<SubEvent> subEvent;

    @ManyToOne
    private Person person;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Event> event;
    
    @OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Lawsuit> lawsuit;
    
    
    
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
     * @return the shortNote
     */
    public String getShortNote() {
        return shortNote;
    }

    /**
     * @param shortNote the shortNote to set
     */
    public void setShortNote(String shortNote) {
        this.shortNote = shortNote;
    }

    /**
     * @return the longNote
     */
    public String getLongNote() {
        return longNote;
    }

    /**
     * @param longNote the longNote to set
     */
    public void setLongNote(String longNote) {
        this.longNote = longNote;
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
     * @return the subEvent
     */
    public List<SubEvent> getSubEvent() {
        return subEvent;
    }

    /**
     * @param subEvent the subEvent to set
     */
    public void setSubEvent(List<SubEvent> subEvent) {
        this.subEvent = subEvent;
    }

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the event
     */
    public List<Event> getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(List<Event> event) {
        this.event = event;
    }

    /**
     * @return the lawsuit
     */
    public List<Lawsuit> getLawsuit() {
        return lawsuit;
    }

    /**
     * @param lawsuit the lawsuit to set
     */
    public void setLawsuit(List<Lawsuit> lawsuit) {
        this.lawsuit = lawsuit;
    }

}
