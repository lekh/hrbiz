package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_ADMIN')
class AdminController {

    def springSecurityService

    // Default admin view
    def index() {
        render(view: 'index')
    }

    // Manager view
    @Secured('ROLE_MANAGER')
    def manager() {
        Employee manager = Employee.findById(springSecurityService.currentUserId)
        List<Employee> allEmployees = Employee.findAllByManager(manager)
        render(view: 'manager', model: [employees: allEmployees])
    }

    // HR view
    @Secured('ROLE_HR')
    def hr() {
        render(view: 'hr')
    }
}
