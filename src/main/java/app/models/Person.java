/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.OneToOne;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

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
    private String nickname;
    private Long partyType;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE)
    private List<Address> address;
    
    @ManyToOne()
    private Lawsuit lawsuit;
    
    @OneToOne(mappedBy = "person", cascade = CascadeType.MERGE)
    private Contact contact;
    
    @OneToMany(mappedBy = "person", cascade = CascadeType.MERGE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<Subject> subject;
    
    @ManyToOne
    private User user;

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

    /**
     * @return the address
     */
    public List<Address> getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(List<Address> address) {
        this.address = address;
    }

    /**
     * @return the contact
     */
    public Contact getContact() {
        return contact;
    }

    /**
     * @param contact the contact to set
     */
    public void setContact(Contact contact) {
        this.contact = contact;
    }


    /**
     * @return the nickname
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * @param nickname the nickname to set
     */
    public void setNickname(String nickname) {
        this.nickname = nickname;
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
     * @return the subject
     */
    public List<Subject> getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

}
