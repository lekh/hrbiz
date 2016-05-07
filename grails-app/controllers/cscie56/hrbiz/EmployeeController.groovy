package cscie56.hrbiz

import cscie56.hrbiz.Department
import cscie56.hrbiz.Employee
import cscie56.hrbiz.User
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured('ROLE_USER')
@Transactional(readOnly = true)
class EmployeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Employee.list(params), model:[employeeInstanceCount: Employee.count()]
    }

    def show(Employee employeeInstance) {
        respond employeeInstance
    }

    def list() {
        Department department
        String listType = 'All'
        if (params.departmentId != null) {
            department = Department.findById(params.departmentId)
            listType = department.name
        }
        ['department': department, 'listType': listType]
    }

    def showBasicInfo() {
        Employee employee = Employee.findById(params.id)
        render(template: "modalBasicInfo", model: [employee: employee])
    }

    def profile() {
        User user = springSecurityService.currentUser
        Employee employee = Employee.findById(user.id)
        ['profile': employee]
    }

    def ajaxSaveAboutMe() {
        String aboutMe = params.aboutMe as String

        // Validate
        if (aboutMe == null || aboutMe.trim().isEmpty()) {
            render status: 400
        }

        // Save
        User user = springSecurityService.currentUser
        Employee employee = Employee.findById(user.id)
        employee.aboutMe = aboutMe
        employee.save(flush: true)

        render status: 204
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
    def create() {
        respond new Employee(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
    @Transactional
    def save(Employee employeeInstance) {
        if (employeeInstance == null) {
            notFound()
            return
        }

        if (employeeInstance.hasErrors()) {
            respond employeeInstance.errors, view:'create'
            return
        }

        employeeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employee.label', default: 'Employee'), employeeInstance.id])
                redirect employeeInstance
            }
            '*' { respond employeeInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
    def edit(Employee employeeInstance) {
        respond employeeInstance
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
    @Transactional
    def update(Employee employeeInstance) {
        if (employeeInstance == null) {
            notFound()
            return
        }

        if (employeeInstance.hasErrors()) {
            respond employeeInstance.errors, view:'edit'
            return
        }

        employeeInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Employee.label', default: 'Employee'), employeeInstance.id])
                redirect employeeInstance
            }
            '*'{ respond employeeInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_MANAGER'])
    @Transactional
    def delete(Employee employeeInstance) {

        if (employeeInstance == null) {
            notFound()
            return
        }

        employeeInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Employee.label', default: 'Employee'), employeeInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employee.label', default: 'Employee'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
