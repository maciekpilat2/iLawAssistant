/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Person extends Model {

    private String personTitle;
    private String personFirstName;
    private String personLastName;
    private String personCompanyName;

    @ManyToOne(cascade = CascadeType.ALL)
    private Party party;

    @Override
    public String toString() {
        return "Person{" + "personTitle=" + personTitle + ", personFirstName=" + personFirstName + ", personLastName=" + personLastName + ", personCompanyName=" + personCompanyName + ", party=" + party + '}';
    }

    /**
     * @return the personTitle
     */
    public String getPersonTitle() {
        return personTitle;
    }

    /**
     * @param personTitle the personTitle to set
     */
    public void setPersonTitle(String personTitle) {
        this.personTitle = personTitle;
    }

    /**
     * @return the personFirstName
     */
    public String getPersonFirstName() {
        return personFirstName;
    }

    /**
     * @param personFirstName the personFirstName to set
     */
    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    /**
     * @return the personLastName
     */
    public String getPersonLastName() {
        return personLastName;
    }

    /**
     * @param personLastName the personLastName to set
     */
    public void setPersonLastName(String personLastName) {
        this.personLastName = personLastName;
    }

    /**
     * @return the personCompanyName
     */
    public String getPersonCompanyName() {
        return personCompanyName;
    }

    /**
     * @param personCompanyName the personCompanyName to set
     */
    public void setPersonCompanyName(String personCompanyName) {
        this.personCompanyName = personCompanyName;
    }

    /**
     * @return the party
     */
    public Party getParty() {
        return party;
    }

    /**
     * @param party the party to set
     */
    public void setParty(Party party) {
        this.party = party;
    }

}
