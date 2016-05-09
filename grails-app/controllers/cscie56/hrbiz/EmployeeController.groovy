package cscie56.hrbiz

import grails.plugin.cache.Cacheable
import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
@Transactional(readOnly = true)
class EmployeeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService
    def employeeService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Employee.list(params), model:[employeeInstanceCount: Employee.count()]
    }

    def show(Employee employeeInstance) {
        respond employeeInstance
    }

    /**
     * List all employees. If department id is passed, it'll list all employees within
     * that department
     */
    @Cacheable('employees')
    def list() {
        employeeService.listEmployee(Department.findById(params.departmentId))
    }

    /**
     * Show basic employee info. This will not show salary, bank account
     * and other sensitive information
     */
    def showBasicInfo() {
        Employee employee = Employee.findById(params.id)
        if (employee != null) {
            render(template: "modalBasicInfo", model: [employee: employee])
        } else {
            render status: 404
        }
    }

    /**
     * Show currently logged in user profile. This will show everything about the user
     */
    def profile() {
        Employee employee = Employee.findById(springSecurityService.currentUserId)
        def address = EmployeeAddress.findByEmployee(employee)
        if (address == null) {
            address = ''
        }
        ['profile': employee, 'address': address]
    }

    /**
     * Displays modal for editing basic information
     */
    def editProfile() {
        Employee employee = Employee.findById(springSecurityService.currentUserId)
        EmployeeAddress address = EmployeeAddress.findByEmployee(employee)

        if (address == null) {
            address = new EmployeeAddress(employee: employee)
        }
        render(template: "modalEditProfile", model: [employee: employee, address: address])
    }

    /**
     * Updated basic information on currently logged in user
     */
    def ajaxSaveProfile() {
        employeeService.saveProfile(params)
        render status: 204
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    def create() {
        respond new Employee(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
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

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    def edit(Employee employeeInstance) {
        respond employeeInstance
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
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

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
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
