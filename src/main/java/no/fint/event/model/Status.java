package no.fint.event.model;

/**
 * The Status Enum indicates what step the {@link Event} is at. The steps can be:
 * <ul>
 *  <li>{@link #NEW}</li>
 *  <li>{@link #DOWNSTREAM_QUEUE}</li>
 *  <li>{@link #DELIVERED_TO_ADAPTER}</li>
 *  <li>{@link #ADAPTER_ACCEPTED}</li>
 *  <li>{@link #ADAPTER_NOT_CONFIRMED}</li>
 *  <li>{@link #UNABLE_TO_DELIVER}</li>
 *  <li>{@link #NO_RESPONSE_FROM_ADAPTER}</li>
 *  <li>{@link #ADAPTER_REJECTED}</li>
 *  <li>{@link #ADAPTER_RESPONSE}</li>
 *  <li>{@link #UPSTREAM_QUEUE}</li>
 *  <li>{@link #TEMP_UPSTREAM_QUEUE}</li>
 *  <li>{@link #SENT_TO_CLIENT}</li>
 *  <li>{@link #CACHE}</li>
 *  <li>{@link #CACHE_RESPONSE}</li>
 * </ul>
 */
public enum Status {
    /**
     * Indicates that the event is just created.
     */
    NEW(10),

    /**
     * Indicates that the event is put in the downstream event queue.
     */
    DOWNSTREAM_QUEUE(11),

    /**
     * Indicates that the event is delivered to the adapter, but we don't know if
     * the adapter will process the event yet.
     */
    DELIVERED_TO_ADAPTER(12),

    /**
     * Indicates that the event is accepted and understood by the adapter. The adapter will
     * process the event.
     */
    ADAPTER_ACCEPTED(13),

    /**
     * Indicates that we never to a confirmation from the adapter after delivering it according
     * to the TTL value.
     */
    ADAPTER_NOT_CONFIRMED(103),

    /**
     * Indicates that the event could not be delivered to the adapter.
     */
    UNABLE_TO_DELIVER(104),

    /**
     * Indicates that the event is delivered to the adapter, but the adapter never responded
     * according to the TTL value.
     */
    NO_RESPONSE_FROM_ADAPTER(101),

    /**
     * Indicates that the adapter recieved the event, but could not process it. Reasons could be:
     * - could not understand the event
     * - could not communicate with the source system
     */
    ADAPTER_REJECTED(102),

    /**
     * Indicates that the event is the response from the adapter.
     */
    ADAPTER_RESPONSE(14),

    /**
     * Indicates that the event is put in the upstream event queue.
     */
    UPSTREAM_QUEUE(15),

    /**
     * Indicates that the event is put int the temp upstream event queue.
     */
    TEMP_UPSTREAM_QUEUE(16),

    /**
     * Indicates that the event is sent back to the client. This is the last step for the event.
     */
    SENT_TO_CLIENT(49),

    /**
     * Indicates that the event is delivered to the cache service.
     */
    CACHE(50),
    /**
     * Indicates that the event is the response form the cache service.
     */
    CACHE_RESPONSE(51),
    /**
     * Indicates that something went wrong with the event. The message field should be set when this
     * status is set.
     */
    ERROR(1000),
    /**
     * Indicates that we cannot find any corresponding events.
     */
    ADAPTER_RESPONSE_ORPHANED(100);

    private final int index;

    Status(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}