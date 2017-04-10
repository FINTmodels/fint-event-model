package no.fint.event.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Utility methods for converting events.
 */
public enum EventUtil {
    ;

    /**
     * Returns a Event object from a JSON string.
     *
     * @param json JSON string
     * @return {@link Event}
     */
    public static Event toEvent(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
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
     * @param type Type of data
     * @param <T> Type of data
     * @return A list of objects of the type specified.
     */
    public static <T> List<T> convertEventData(Event event, Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> dataList = event.getData();

        return dataList.stream().map(employee ->
                objectMapper.convertValue(employee, type)
        ).collect(Collectors.toList());
    }


    /**
     * Returns a JSON string of the Event.
     * @param event Event object
     * @return Event object as a JSON string.
     */
    public static String toJson(Event event) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}