
package app.enums;

/**
 *
 * @author Pilat
 */
public enum DocumentTypeEnum {
    
    POSTANOWIENIE("Postanowienie"),
    WYROK("Wyrok"),
    WNIOSEK("Wniosek"),
    ZAWIADOMIENIE("Zawiadomienie")
    ;

    private String name;

    private DocumentTypeEnum(String name) {
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