/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Party extends Model {

    private Long partyType;

    @ManyToOne(cascade = CascadeType.ALL)
    private Lawsuit lawsuit;
    
    @OneToMany(mappedBy = "party", cascade = CascadeType.ALL)
    private List<Person> person;
    
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
     * @return the partyType
     */
    public Long getPartyType() {
        return partyType;
    }

    /**
     * @param partyType the partyType to set
     */
    public void setPartyType(Long partyType) {
        this.partyType = partyType;
    }

      
}
