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
public enum EventTypeEnum {

    SEND_MAIL("Wysłana poczta"),
    PHONE_CALL("Rozmowa telefoniczna"),
    HEARING("Rozprawa"),
    LAWSUIT_FILING("Wniesienie pozwu"),
    RECEIVING_LAWSUIT("Otrzymanie pozwu"),
    STATEMENT_OF_DEFENCE("Odpowiedź na pozew"),
    RECEIVING_STATEMENT_OF_DEFENCE("Otrzymanie odpowiedzi na pozew"),
    SUMMON_TO_HEARING("Wezwanie na rozprawę"),
    NEUTRAL("Ogólny")
    ;

    private String name;

    private EventTypeEnum(String name) {
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
