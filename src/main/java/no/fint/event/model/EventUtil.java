package no.fint.event.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Setter;

import java.io.IOException;
import java.util.List;

/**
 * Utility methods for converting events.
 */
public enum EventUtil {
    ;

    @Setter
    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * Returns a Event object from a JSON string.
     *
     * @param json JSON string
     * @return {@link Event}
     */
    public static Event toEvent(String json) {
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * Converts the data field in the Event to a class of <i>type</i>.
     *
     * @param event The Event to convert data from.
     * @param <T>   Type of data
     * @return A list of objects of the type specified.
     */
    public static <T> List<T> convertEventData(Event event) {
        return objectMapper.convertValue(event.getData(), new TypeReference<List<T>>() {
        });
    }

    /**
     * Returns a JSON string of the Event.
     *
     * @param event Event object
     * @return Event object as a JSON string.
     */
    public static String toJson(Event event) {
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}