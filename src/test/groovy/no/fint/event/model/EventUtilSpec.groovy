package no.fint.event.model

import com.fasterxml.jackson.core.JsonProcessingException
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
        List<TestDto> eventData = EventUtil.convertEventData(event)

        then:
        eventData.size() == 1
        eventData[0].value == 'test'
    }

    def "Return null when unable to convert from event to json"() {
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

}
