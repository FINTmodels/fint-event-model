package no.fint.event.model.health;

public enum HealthStatus {
    /**
     * Indicates that the adapter can communicate with the application and everything should work as expected
     */
    APPLICATION_HEALTHY,
    /**
     * Indicates that there are problems with the communication from the adapter to the application
     */
    APPLICATION_UNHEALTHY
}
