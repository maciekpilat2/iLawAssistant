
package app.formswrapper;

import app.models.PartyType;
import app.models.Person;
import app.models.Lawsuit;


public class PartyTypePersonWrap {
    
    private Lawsuit lawsuit;
    private PartyType partyType;
    private Person person;

    

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the partyType
     */
    public PartyType getPartyType() {
        return partyType;
    }

    /**
     * @param partyType the partyType to set
     */
    public void setPartyType(PartyType partyType) {
        this.partyType = partyType;
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



}
