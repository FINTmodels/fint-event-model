package no.fint.event.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Health check object, can be created for each step of the health check process.
 */
@Getter
@AllArgsConstructor
public class Health {
    /**
     * The current component
     */
    private String component;
    /**
     * Status for the current step of the health check
     */
    private String status;
    /**
     * When the instance of the Health object was created
     */
    private long timestamp;

    public Health() {
        this.timestamp = System.currentTimeMillis();
    }

    public Health(String status) {
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public Health(String component, String status) {
        this.component = component;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    /**
     * Creates a ISO-8601 (2011-12-03T10:15:30Z) representation of the timestamp value.
     *
     * @return The ISO-8601 formatted time
     */
    public String getTime() {
        ZonedDateTime dateTime = ZonedDateTime.ofInstant(Instant.ofEpochMilli(timestamp), ZoneId.systemDefault());
        return dateTime.format(DateTimeFormatter.ISO_INSTANT);
    }
}
