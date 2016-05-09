package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Secured('ROLE_USER')
@Transactional(readOnly = true)
class EmployeeAddressController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond EmployeeAddress.list(params), model:[employeeAddressInstanceCount: EmployeeAddress.count()]
    }

    def show(EmployeeAddress employeeAddressInstance) {
        respond employeeAddressInstance
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    def create() {
        respond new EmployeeAddress(params)
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    @Transactional
    def save(EmployeeAddress employeeAddressInstance) {
        if (employeeAddressInstance == null) {
            notFound()
            return
        }

        if (employeeAddressInstance.hasErrors()) {
            respond employeeAddressInstance.errors, view:'create'
            return
        }

        employeeAddressInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'employeeAddress.label', default: 'EmployeeAddress'), employeeAddressInstance.id])
                redirect employeeAddressInstance
            }
            '*' { respond employeeAddressInstance, [status: CREATED] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    def edit(EmployeeAddress employeeAddressInstance) {
        respond employeeAddressInstance
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    @Transactional
    def update(EmployeeAddress employeeAddressInstance) {
        if (employeeAddressInstance == null) {
            notFound()
            return
        }

        if (employeeAddressInstance.hasErrors()) {
            respond employeeAddressInstance.errors, view:'edit'
            return
        }

        employeeAddressInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'EmployeeAddress.label', default: 'EmployeeAddress'), employeeAddressInstance.id])
                redirect employeeAddressInstance
            }
            '*'{ respond employeeAddressInstance, [status: OK] }
        }
    }

    @Secured(['ROLE_ADMIN', 'ROLE_HR'])
    @Transactional
    def delete(EmployeeAddress employeeAddressInstance) {

        if (employeeAddressInstance == null) {
            notFound()
            return
        }

        employeeAddressInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'EmployeeAddress.label', default: 'EmployeeAddress'), employeeAddressInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'employeeAddress.label', default: 'EmployeeAddress'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
