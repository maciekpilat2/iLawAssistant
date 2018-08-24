package app.models;

import java.util.List;

/**
 *
 * @author Pilat
 */
public class AlmightySerch extends Model{
    private List<Lawsuit> lawsuit;
    private List<Person> person;



    /**
     * @return the person
     */
    public List<Person> getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(List<Person> person) {
        this.person = person;
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
