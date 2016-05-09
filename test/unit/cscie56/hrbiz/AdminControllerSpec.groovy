package cscie56.hrbiz

import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(AdminController)
@Mock(Employee)
class AdminControllerSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test admin index action"() {
        when:
            controller.index()
        then:
            view == '/admin/index'
            response.status == 200
    }

    void "test manager action"() {
        given:
            def springSecurityService = mockFor(SpringSecurityService, true)
            controller.springSecurityService = springSecurityService.createMock()
        when:
            controller.manager()
        then:
            view == '/admin/manager'
            response.status == 200
    }

    void "test hr action"() {
        when:
            controller.hr()
        then:
            view == '/admin/hr'
            response.status == 200
    }

}
