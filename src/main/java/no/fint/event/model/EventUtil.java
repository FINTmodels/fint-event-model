package no.fint.event.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public enum EventUtil {
    ;

    public static Event toEvent(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Event.class);
        } catch (IOException e) {
            return null;
        }
    }


    public static <T> List<T> convertEventData(Event event, Class<T> type) {
        ObjectMapper objectMapper = new ObjectMapper();
        List<?> dataList = event.getData();

        return dataList.stream().map(employee ->
                objectMapper.convertValue(employee, type)
        ).collect(Collectors.toList());
    }


    public static String toJson(Event event) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            return null;
        }
    }
}