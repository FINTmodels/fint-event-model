package no.fint.event.model;

import lombok.ToString;

import java.io.Serializable;

@ToString
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
