package no.fint.event.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import no.fint.event.util.ODataQueryFilter;

import java.io.Serializable;

@Data
public class EventRequest implements Serializable {

    private static final long serialVersionUID = 654101444176994015L;
    /**
     * The query value is set when the consumer needs to send a value to the provider and adapter.
     */
    private String query;

    @JsonIgnore
    public String getFilteredQuery() {
    return ODataQueryFilter.maskFilter(query);
    }

}
