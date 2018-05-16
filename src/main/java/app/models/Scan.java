
package app.models;

import javax.persistence.*;

import app.models.Event;
import java.util.List;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class Scan extends Model{
    
    private String scanName;
    private String scanUrl;
    @Column(columnDefinition = "TEXT")
    private String scanJSON;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Event event;
    private String signature;
    @Column(columnDefinition = "TEXT")
    private String parsedText;


    @Override
    public String toString() {
        return "Scan{" + "scanName=" + scanName + ", scanUrl=" + scanUrl + ", scanJSON=" + scanJSON + ", event=" + event + '}';
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    /**
     * @return the scanName
     */
    public String getScanName() {
        return scanName;
    }

    /**
     * @param scanName the scanName to set
     */
    public void setScanName(String scanName) {
        this.scanName = scanName;
    }

    /**
     * @return the scanUrl
     */
    public String getScanUrl() {
        return scanUrl;
    }

    /**
     * @param scanUrl the scanUrl to set
     */
    public void setScanUrl(String scanUrl) {
        this.scanUrl = scanUrl;
    }

    /**
     * @return the scanJSON
     */
    public String getScanJSON() {
        return scanJSON;
    }

    /**
     * @param scanJSON the scanJSON to set
     */
    public void setScanJSON(String scanJSON) {
        this.scanJSON = scanJSON;
    }

    /**
     * @return the event
     */
    public Event getEvent() {
        return event;
    }

    /**
     * @param event the event to set
     */
    public void setEvent(Event event) {
        this.event = event;
    }
    
}