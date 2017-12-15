package no.fint.event.model;

import java.util.List;

public class EventResponse {

    /**
     * This message should be set if something goes wrong. It should typically describe what went wrong,
     * for example a stack trace or an error message.
     */
    private String message;

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
}
