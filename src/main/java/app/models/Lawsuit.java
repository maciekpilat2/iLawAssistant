/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import app.models.Model;
import javax.persistence.Entity;
import javax.persistence.Table;
import app.models.User;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import app.models.CourtDepartment;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Lawsuit extends Model {

    private String courtFileReference;
    private String description;

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "lawsuit", cascade = CascadeType.MERGE)
    private List<Event> event;

    @ManyToOne(cascade = CascadeType.ALL)
    private CourtDepartment courtDepartment;
 
    @OneToMany(mappedBy = "lawsuit", cascade = CascadeType.MERGE)
    private List<Person> person;
    
    @ManyToOne
    private Subject subject;
    

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    
    
    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
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
     * @return the courtFileReference
     */
    public String getCourtFileReference() {
        return courtFileReference;
    }

    /**
     * @param courtFileReference the courtFileReference to set
     */
    public void setCourtFileReference(String courtFileReference) {
        this.courtFileReference = courtFileReference;
    }

    /**
     * @return the courtDepartment
     */
    public CourtDepartment getCourtDepartment() {
        return courtDepartment;
    }

    /**
     * @param courtDepartment the courtDepartment to set
     */
    public void setCourtDepartment(CourtDepartment courtDepartment) {
        this.courtDepartment = courtDepartment;
    }

    /**
     * @return the person
     */
    public List<Person> getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(List<Person> person) {
        this.person = person;
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
