package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured

@Secured(['ROLE_ANONYMOUS', 'ROLE_USER'])
class HomeController {

    def springSecurityService

    def index() {
        if (springSecurityService.loggedIn) {
            Employee emp = Employee.findById(springSecurityService.currentUserId)
            Company company = emp.department.company
            render(view: '/index', model: [company: company.name])
        } else {
            render(view: '/index')
        }
    }

}
