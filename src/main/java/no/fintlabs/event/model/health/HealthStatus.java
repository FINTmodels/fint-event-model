package no.fintlabs.event.model.health;

public enum HealthStatus {
    /**
     * The health check has been sent from the consumer to the provider
     */
    SENT_FROM_CONSUMER_TO_PROVIDER,

    /**
     * The health check was received in the provider from the consumer
     */
    RECEIVED_IN_PROVIDER_FROM_CONSUMER,

    /**
     * The health check was sent from the provider to the adapter
     */
    SENT_FROM_PROVIDER_TO_ADAPTER,

    /**
     * The health check was received in provider from the adapter
     */
    RECEIVED_IN_PROVIDER_FROM_ADAPTER,

    /**
     * The health check was sent from the provider to the consumer
     */
    SENT_FROM_PROVIDER_TO_CONSUMER,

    /**
     *The health check was received in the consumer from the provider
     */
    RECEIVED_IN_CONSUMER_FROM_PROVIDER,

    /**
     * Indicates that the adapter can communicate with the application and everything should work as expected
     */
    APPLICATION_HEALTHY,
    /**
     * Indicates that there are problems with the communication from the adapter to the application
     */
    APPLICATION_UNHEALTHY
}
