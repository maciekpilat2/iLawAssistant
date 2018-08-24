/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class ScanSection extends Model{

private Long sectionTop;
private Long sectionBottom;
private Long sectionLeft;
private Long sectionRight;
private String informationType;
private String note;

    /**
     * @return the sectionTop
     */
    public Long getSectionTop() {
        return sectionTop;
    }

    /**
     * @param sectionTop the sectionTop to set
     */
    public void setSectionTop(Long sectionTop) {
        this.sectionTop = sectionTop;
    }

    /**
     * @return the sectionBottom
     */
    public Long getSectionBottom() {
        return sectionBottom;
    }

    /**
     * @param sectionBottom the sectionBottom to set
     */
    public void setSectionBottom(Long sectionBottom) {
        this.sectionBottom = sectionBottom;
    }

    /**
     * @return the sectionLeft
     */
    public Long getSectionLeft() {
        return sectionLeft;
    }

    /**
     * @param sectionLeft the sectionLeft to set
     */
    public void setSectionLeft(Long sectionLeft) {
        this.sectionLeft = sectionLeft;
    }

    /**
     * @return the sectionRight
     */
    public Long getSectionRight() {
        return sectionRight;
    }

    /**
     * @param sectionRight the sectionRight to set
     */
    public void setSectionRight(Long sectionRight) {
        this.sectionRight = sectionRight;
    }

    /**
     * @return the informationType
     */
    public String getInformationType() {
        return informationType;
    }

    /**
     * @param informationType the informationType to set
     */
    public void setInformationType(String informationType) {
        this.informationType = informationType;
    }

    /**
     * @return the note
     */
    public String getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(String note) {
        this.note = note;
    }



}
