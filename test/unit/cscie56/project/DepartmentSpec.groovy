package cscie56.project

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Department)
class DepartmentSpec extends Specification {

    Company company

    def setup() {
        company = new Company(name: 'A1 Company')
    }

    def cleanup() {
    }

    void "test valid department"() {
        when:
            Department d = new Department(company: company, name: 'Accounting')
        then:
            d.validate()
    }

    void "test invalid department"() {
        when:
            Department d1 = new Department(company: company, name: null)
        then:
            !d1.validate()

        when:
            Department d2 = new Department(company: company, name: 'SomeUnknown')
        then:
            !d2.validate()

        when:
            Department d3 = new Department(company: null, name: '   ')
        then:
            !d3.validate()
    }
}
