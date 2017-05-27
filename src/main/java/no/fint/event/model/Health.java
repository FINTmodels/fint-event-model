package no.fint.event.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Health check object, can be created for each step of the health check process.
 */
@Data
@AllArgsConstructor
public class Health {
    /**
     * Status for the current step of the health check
     */
    private String status;
    /**
     * When the instance of the Health object was created
     */
    private long timestamp;

    public Health() {
        timestamp = System.currentTimeMillis();
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
