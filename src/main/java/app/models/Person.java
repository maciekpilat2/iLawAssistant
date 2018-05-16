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
    private Long partyType;

    @ManyToOne()
    private Lawsuit lawsuit;

    @Override
    public String toString() {
        return "Person{" + "personTitle=" + personTitle + ", personFirstName=" + personFirstName + ", personLastName=" + personLastName + ", personCompanyName=" + personCompanyName + ", partyType=" + partyType + ", lawsuit=" + lawsuit + '}';
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
