package cscie56.hrbiz

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Company)
class CompanySpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test valid company"() {
        when:
            Company c1 = new Company(name: 'A1 Company')
        then:
            c1.validate()

        when:
            Company c2 = new Company(name: 'New Company', description: 'Food and Beverage', domainName: 'newcompany.com')
        then:
            c2.validate()
    }

    void "test invalid company"() {
        when:
            Company c1 = new Company(name: null)
        then:
            !c1.validate()

        when:
            Company c2 = new Company(name: '   ')
        then:
            !c2.validate()
    }
}
