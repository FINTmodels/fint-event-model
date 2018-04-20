package no.fint.event.model

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import no.fint.event.model.testutils.TestDto
import spock.lang.Specification


class EventUtilSpec extends Specification {

    def "Convert JSON string to Event object"() {
        given:
        def input = new Event('rogfk.no', 'employee', 'GET_ALL', 'vfs')
        def json = new ObjectMapper().writeValueAsString(input)

        when:
        Event event = EventUtil.toEvent(json)

        then:
        event != null
        event.action == 'GET_ALL'
    }

    def "Print Event to stdout"() {
        given:
        Event event = new Event('rogfk.no', 'fk', 'GET_ALL', 'myClient')

        when:
        println(event)
        println(EventUtil.toJson(event))

        then:
        true
    }

    def "Convert Event object to JSON"() {
        given:
        Event event = new Event('rogfk.no', 'fk', 'GET_ALL', 'myClient')

        when:
        String json = EventUtil.toJson(event)
        def output = new ObjectMapper().readValue(json, Event)

        then:
        output.orgId == 'rogfk.no'
    }

    def "Convert Event data"() {
        given:
        Map<String, String> data = new LinkedHashMap<>()
        data.put('value', 'test')
        Event event = new Event('rogfk.no', 'fk', 'GET_ALL', 'myClient')
        event.addData(data)

        when:
        List<TestDto> eventData = EventUtil.convertEventData(event, new TypeReference<List<TestDto>>() {})

        then:
        eventData.size() == 1
        eventData.get(0).class == TestDto
        eventData[0].value == 'test'
    }

    def "Return null when trying to convert from Event to json and JsonProcessingException is thrown "() {
        given:
        def objectMapper = Mock(ObjectMapper) {
            writeValueAsString(_ as Event) >> {
                throw new JsonProcessingException('Test exception')
            }
        }

        when:
        def json = EventUtil.toJson(objectMapper, new Event())

        then:
        json == null
    }

    def "Return null when trying to covert from json to Event and IOException is thrown"() {
        when:
        def event = EventUtil.toEvent('test')

        then:
        event == null
    }

    def "Read Event from event.json"() {
        given:
        def objectMapper = new ObjectMapper()
        def json = "{\n" +
                "  \"corrId\": \"a91cdb9b-0292-4baf-9a27-578642634129\",\n" +
                "  \"action\": \"GET_ALL\",\n" +
                "  \"status\": \"NEW\",\n" +
                "  \"time\": 1524131147134,\n" +
                "  \"orgId\": \"rogfk.no\",\n" +
                "  \"source\": \"fk\",\n" +
                "  \"client\": \"myClient\",\n" +
                "  \"data\": [],\n" +
                "  \"message\": \"There is a disturbance in the Force\",\n" +
                "  \"query\": \"what\",\n" +
                "  \"problems\": [\n" +
                "    {\n" +
                "      \"field\": \"monkey\",\n" +
                "      \"message\": \"Only chimpanzees allowed\",\n" +
                "      \"code\": \"9999\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"field\": \"jedi\",\n" +
                "      \"message\": \"Luke not found\",\n" +
                "      \"code\": \"44\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"statusCode\": \"JEDI-XX\",\n" +
                "  \"responseStatus\": \"ERROR\"\n" +
                "}"

        when:
        def event = objectMapper.readValue(getClass().getResourceAsStream("/event.json"), Event)

        then:
        event
        event.problems.size() == 2
        event.status == Status.NEW
        event.responseStatus == ResponseStatus.ERROR
        event.statusCode == "JEDI-XX"
    }
}
