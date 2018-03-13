package no.fint.event.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
public class EventRequest implements Serializable {

    /**
     * The query value is set when@ the consumer needs to send a value to the provider and adapter.
     */
    private String query;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }
}
