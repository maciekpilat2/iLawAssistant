/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import app.models.Model;
import app.models.Address;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class CourtDepartment extends Model{

    private String courtDepartmentName;
    
    @OneToMany(mappedBy = "courtDepartment")
    private List<Address> address;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Court court;
    
    @OneToMany(mappedBy = "courtDepartment")
    private List<Lawsuit> lawsuit;

    
    
    /**
     * @return the courtDepartmentName
     */
    public String getCourtDepartmentName() {
        return courtDepartmentName;
    }

    /**
     * @param courtDepartmentName the courtDepartmentName to set
     */
    public void setCourtDepartmentName(String courtDepartmentName) {
        this.courtDepartmentName = courtDepartmentName;
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
     * @return the court
     */
    public Court getCourt() {
        return court;
    }

    /**
     * @param court the court to set
     */
    public void setCourt(Court court) {
        this.court = court;
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
