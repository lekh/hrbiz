package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
@Transactional(readOnly = true)
class EmployeePaycheckController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmployeePaycheck.list(params), model:[employeePaycheckInstanceCount: EmployeePaycheck.count()]
    }

    def show(EmployeePaycheck employeePaycheckInstance) {
        respond employeePaycheckInstance
    }

    @Secured('ROLE_HR')
    def create() {
        respond new EmployeePaycheck(params)
    }

    @Secured('ROLE_HR')
    @Transactional
    def save(EmployeePaycheck employeePaycheckInstance) {
        if (employeePaycheckInstance == null) {
            notFound()
            return
        }

        if (employeePaycheckInstance.hasErrors()) {
            respond employeePaycheckInstance.errors, view:'create'
            return
        }

        employeePaycheckInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employeePaycheck.label', default: 'EmployeePaycheck'), employeePaycheckInstance.id])
                redirect employeePaycheckInstance
            }
            '*' { respond employeePaycheckInstance, [status: CREATED] }
        }
    }

    @Secured('ROLE_HR')
    def edit(EmployeePaycheck employeePaycheckInstance) {
        respond employeePaycheckInstance
    }

    @Secured('ROLE_HR')
    @Transactional
    def update(EmployeePaycheck employeePaycheckInstance) {
        if (employeePaycheckInstance == null) {
            notFound()
            return
        }

        if (employeePaycheckInstance.hasErrors()) {
            respond employeePaycheckInstance.errors, view:'edit'
            return
        }

        employeePaycheckInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EmployeePaycheck.label', default: 'EmployeePaycheck'), employeePaycheckInstance.id])
                redirect employeePaycheckInstance
            }
            '*'{ respond employeePaycheckInstance, [status: OK] }
        }
    }

    @Secured('ROLE_HR')
    @Transactional
    def delete(EmployeePaycheck employeePaycheckInstance) {

        if (employeePaycheckInstance == null) {
            notFound()
            return
        }

        employeePaycheckInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EmployeePaycheck.label', default: 'EmployeePaycheck'), employeePaycheckInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeePaycheck.label', default: 'EmployeePaycheck'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
