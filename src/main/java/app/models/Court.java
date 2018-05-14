/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Court extends Model{

    private String courtName;
    
    @OneToMany(mappedBy = "court")
    private List<CourtDepartment> courtDepartment;

    /**
     * @return the courtName
     */
    public String getCourtName() {
        return courtName;
    }

    /**
     * @param courtName the courtName to set
     */
    public void setCourtName(String courtName) {
        this.courtName = courtName;
    }

    /**
     * @return the courtDepartment
     */
    public List<CourtDepartment> getCourtDepartment() {
        return courtDepartment;
    }

    /**
     * @param courtDepartment the courtDepartment to set
     */
    public void setCourtDepartment(List<CourtDepartment> courtDepartment) {
        this.courtDepartment = courtDepartment;
    }
    
    
}
