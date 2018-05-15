/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.formswrapper;
import app.models.Lawsuit;
import app.models.Court;
        import app.models.CourtDepartment;
/**
 *
 * @author Pilat
 */
public class AddLawsuitWrapper {
    private Lawsuit lawsuit;
    private Court court;
    private CourtDepartment courtDepartment;

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
    
    
}
