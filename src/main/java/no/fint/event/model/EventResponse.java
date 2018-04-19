package no.fint.event.model;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class EventResponse implements Serializable {

    /**
     * This message should be set if something goes wrong. It should typically describe what went wrong,
     * for example a stack trace or an error message.
     */
    private String message;

    /**
     * This status code should be set to some code that can be used to trace the origin of the error
     * in the back end system.
     */
    private String statusCode;

    /**
     * Shows the status of the event that was processed by the adapter.
     */
    private ResponseStatus responseStatus;

    /**
     * Shows the problems the system has found when processing this event's request.
     */
    private List<Problem> problems;
}
