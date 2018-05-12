
package app.models;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Pilat
 */
@Entity
@Table
public class EventType extends Model{
    
    private String eventTypeName;

    /**
     * @return the eventTypeName
     */
    public String getEventTypeName() {
        return eventTypeName;
    }

    /**
     * @param eventTypeName the eventTypeName to set
     */
    public void setEventTypeName(String eventTypeName) {
        this.eventTypeName = eventTypeName;
    }
    
    
    
}
