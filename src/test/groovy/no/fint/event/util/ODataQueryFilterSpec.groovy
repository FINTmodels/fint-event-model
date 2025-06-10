package no.fint.event.util

import spock.lang.Specification

class ODataQueryFilterSpec extends Specification {

    def "maskFilter masks only the \$filter parameter inside a query string"() {
        expect:
        ODataQueryFilter.maskFilter('$top=10&$filter=name eq \'Ola\'&$orderby=name') ==
                '$top=10&$filter=***&$orderby=name'
    }

    def "maskFilter masks leading \$filter without other parameters"() {
        expect:
        ODataQueryFilter.maskFilter('$filter=name eq \'bob\'') == '$filter=***'
    }

    def "maskFilter returns null when given null"() {
        expect:
        ODataQueryFilter.maskFilter(null) == null
    }

    def "maskFilter masks \$filter in arbitrary text with no & delimiter"() {
        expect:
        ODataQueryFilter.maskFilter('No case found for query: $filter=tittel eq \'bob\'') ==
                'No case found for query: $filter=***'
    }

    def "maskFilter masks \$filter and text after in arbitrary text with no & delimiter"() {
        expect:
        ODataQueryFilter.maskFilter('No case found for query: $filter=tittel eq \'bob\' in a perfect world, I would not be censored') ==
                'No case found for query: $filter=***'
    }

    def "maskFilter masks \$filter at end of URL without trailing &"() {
        expect:
        ODataQueryFilter.maskFilter('https://example/api?$select=id&$filter=age gt 18 and eq \'bob\'') ==
                'https://example/api?$select=id&$filter=***'
    }

    def "maskFilter is case-insensitive"() {
        expect:
        ODataQueryFilter.maskFilter('$FILTER=secret') == '$FILTER=***'
    }

    def "maskFilter leaves strings without \$filter unchanged"() {
        expect:
        ODataQueryFilter.maskFilter('$top=5&$orderby=name') == '$top=5&$orderby=name'
    }
}
