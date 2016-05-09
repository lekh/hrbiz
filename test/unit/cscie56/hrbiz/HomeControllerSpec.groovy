package cscie56.hrbiz

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(HomeController)
@Mock(Employee)
class HomeControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test index action"() {
        given:
            def springSecurityService = mockFor(SpringSecurityService, true)
            controller.springSecurityService = springSecurityService.createMock()
        when:
            controller.index()
        then:
            view == '/index'
            response.status == 200
    }

}
