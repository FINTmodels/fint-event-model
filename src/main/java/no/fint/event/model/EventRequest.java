package no.fint.event.model;

public class EventRequest {

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
