package com.ittalent.csn.util

import java.time.LocalDate

class RequestValidatorTest extends spock.lang.Specification {
    void setup() {
    }

    void cleanup() {
    }

    def "IsValidDateRequest"() {
        setup:
        def startTime = LocalDate.parse("2019-10-01")
        def endTime = LocalDate.parse("2019-10-14")
        def requestValidator = new RequestValidator()

        when:
        requestValidator.isValidDateRequest(startTime,endTime)

        then:
        notThrown(IllegalArgumentException)
    }

    def "IsNotValidDateRequest"(){
        setup:
        def startTime = LocalDate.parse("2019-10-25")
        def endTime = LocalDate.parse("2019-10-14")
        def requestValidator = new RequestValidator()

        when:
        requestValidator.isValidDateRequest(startTime,endTime)

        then:
        thrown(IllegalArgumentException)
    }

    def "NotEqualCountries"() {
        setup:
        def countryA = "CHILE"
        def countryB = "USA"
        def requestValidator = new RequestValidator()

        when:
        requestValidator.notEqualCountries(countryA,countryB)

        then:
        notThrown(IllegalArgumentException)
    }

    def "EqualCountries"() {
        setup:
        def countryA = "CHILE"
        def countryB = "CHILE"
        def requestValidator = new RequestValidator()

        when:
        requestValidator.notEqualCountries(countryA,countryB)

        then:
        thrown(IllegalArgumentException)
    }
}
