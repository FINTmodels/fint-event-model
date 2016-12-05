package no.fint.event.model

import no.fint.event.model.testutils.TestDto
import spock.lang.Specification


class EventUtilSpec extends Specification {

    def "Convert JSON string to Event object" () {
        given:
        String json = "{\"corrId\": \"9b71b7ab-c06d-400a-bca3-f06659006000\",  \"action\": \"GET_ALL_EMPLOYEES\",  \"status\": \"DOWNSTREAM_QUEUE\",  \"time\": 1479909169834,  \"orgId\": \"rogfk.no\",  \"source\": \"employee\",  \"client\": \"vfs\",  \"message\": null,  \"data\": [  ]}"

        when:
        Event event = EventUtil.toEvent(json)

        then:
        event != null
        event.action == "GET_ALL_EMPLOYEES"
    }

    def "Convert Event object to JSON" () {
        given:
        Event event = new Event("rogfk.no", "fk", "GET_ALL", "myClient")

        when:
        String json = EventUtil.toJson(event)

        then:
        json.startsWith("{")
        json.endsWith("}")
        json.contains("rogfk.no")
    }

    def "Convert Event data"() {
        given:
        Map<String, String> data = new LinkedHashMap<>()
        data.put("value", "test")
        Event event = new Event("rogfk.no", "fk", "GET_ALL", "myClient")
        event.addData(data)

        when:
        def eventData = EventUtil.convertEventData(event, TestDto)

        then:
        eventData.size() == 1
        eventData[0].value == "test"
    }

}
