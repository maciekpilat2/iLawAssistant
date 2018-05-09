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

    @OneToMany(mappedBy = "lawsuit", cascade = CascadeType.ALL)
    private List<Event> event;

    @OneToMany(mappedBy = "lawsuit", cascade = CascadeType.ALL)
    private List<Party> party;


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
     * @return the party
     */
    public List<Party> getParty() {
        return party;
    }

    /**
     * @param party the party to set
     */
    public void setParty(List<Party> party) {
        this.party = party;
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

}
