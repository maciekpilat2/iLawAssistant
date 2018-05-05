/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;
import app.models.Model;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class PartyType extends Model{
    private String name;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
}
