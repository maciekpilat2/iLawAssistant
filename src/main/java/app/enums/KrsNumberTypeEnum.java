/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.enums;

/**
 *
 * @author Pilat
 */
public enum KrsNumberTypeEnum {

    NAZWA ("Nazwa"),
    NIP ("Numer NIP"),
    REGON ("Numer REGON"),
    KRS("Numer KRS")
    ;

    private String name;

    private KrsNumberTypeEnum(String name) {
        this.name = name;
    }

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
