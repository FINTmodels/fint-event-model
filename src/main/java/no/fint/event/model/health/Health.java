package no.fint.event.model.health;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Health check object, can be created for each step of the health check process.
 */
@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Health implements Serializable {
    private static final long serialVersionUID = -4363132400859528104L;
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

    public Health(HealthStatus healthStatus) {
        this(healthStatus.name());
    }

    public Health(String component, String status) {
        this.component = component;
        this.status = status;
        this.timestamp = System.currentTimeMillis();
    }

    public Health(String component, HealthStatus healthStatus) {
        this(component, healthStatus.name());
    }

    public Health(String component, HealthStatus healthStatus, long timestamp) {
        this(component, healthStatus.name(), timestamp);
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
