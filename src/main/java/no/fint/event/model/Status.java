package no.fint.event.model;

/**
 * The Status Enum indicates what step the {@link Event} is at. The steps can be:
 * <ul>
 *  <li>{@link #NEW}</li>
 *  <li>{@link #INBOUND_QUEUE}</li>
 *  <li>{@link #DELIVERED_TO_PROVIDER}</li>
 *  <li>{@link #PROVIDER_ACCEPTED}</li>
 *  <li>{@link #PROVIDER_NOT_CONFIRMED}</li>
 *  <li>{@link #UNABLE_TO_DELIVER}</li>
 *  <li>{@link #NO_RESPONSE_FOR_PROVIDER}</li>
 *  <li>{@link #PROVIDER_REJECTED}</li>
 *  <li>{@link #PROVIDER_RESPONSE}</li>
 *  <li>{@link #OUTBOUND_QUEUE}</li>
 *  <li>{@link #SENT_TO_CLIENT}</li>
 *  <li>{@link #CACHE}</li>
 *  <li>{@link #CACHE_RESPONSE}</li>
 * </ul>
 */

public enum Status {
    /**
     * Indicates that the event is just created.
     */
    NEW,

    /**
     * Indicates that the event is put in the inbound event queue.
     */
    INBOUND_QUEUE,

    /**
     * Indicates that the event is delivered to the provider, but we don't know if
     * the provider will process the event yet.
     */
    DELIVERED_TO_PROVIDER,

    /**
     * Indicates that the event is accepted and understood by the adapter. The adapter will
     * process the event.
     */
    PROVIDER_ACCEPTED,

    /**
     * Indicates that we never to a confirmation from the provider after delivering it according
     * to the TTL value.
     */
    PROVIDER_NOT_CONFIRMED,

    /**
     * Indicates that the event could not be delivered to the provider.
     */
    UNABLE_TO_DELIVER,

    /**
     * Indicates that the event is delivered to the provider, but the provider never responded
     * according to the TTL value.
     */
    NO_RESPONSE_FOR_PROVIDER,

    /**
     * Indicates that the provider recieved the event, but could not process it. Reasons could be:
     * - could not understand the event
     * - could not communicate with the source system
     */
    PROVIDER_REJECTED,

    /**
     * Indicates that the event is the response from the provider.
     */
    PROVIDER_RESPONSE,

    /**
     * Indicates that the event is put in the outbound event queue.
     */
    OUTBOUND_QUEUE,

    /**
     * Indicates that the event is sent back to the client. This is the last step for the event.
     */
    SENT_TO_CLIENT,

    /**
     * Indicates that the event is delivered to the cache service.
     */
    CACHE,
    /**
     * Indicates that the event is the response form the cache service.
     */
    CACHE_RESPONSE
}