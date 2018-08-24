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
public class ScanInformationKeyWords extends Model{
    
    private String informationType;
    private String keyWords;

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
     * @return the keyWords
     */
    public String getKeyWords() {
        return keyWords;
    }

    /**
     * @param keyWords the keyWords to set
     */
    public void setKeyWords(String keyWords) {
        this.keyWords = keyWords;
    }
    
    
}
