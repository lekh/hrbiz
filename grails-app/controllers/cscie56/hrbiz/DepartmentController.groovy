package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

import static org.springframework.http.HttpStatus.*

@Secured('ROLE_USER')
@Transactional(readOnly = true)
class DepartmentController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def springSecurityService

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Department.list(params), model:[departmentInstanceCount: Department.count()]
    }

    def show(Department departmentInstance) {
        respond departmentInstance
    }

    /**
     * List all departments. Each department will have a link to list all of its employees
     */
    def list() {
        Employee employee = Employee.findById(springSecurityService.currentUserId)
        List<Department> departments = Department.findAllByCompany(employee?.department?.company)
        ['departments': departments]
    }

    @Secured('ROLE_ADMIN')
    def create() {
        respond new Department(params)
    }

    @Secured('ROLE_ADMIN')
    @Transactional
    def save(Department departmentInstance) {
        if (departmentInstance == null) {
            notFound()
            return
        }

        if (departmentInstance.hasErrors()) {
            respond departmentInstance.errors, view:'create'
            return
        }

        departmentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'department.label', default: 'Department'), departmentInstance.id])
                redirect departmentInstance
            }
            '*' { respond departmentInstance, [status: CREATED] }
        }
    }

    @Secured('ROLE_ADMIN')
    def edit(Department departmentInstance) {
        respond departmentInstance
    }

    @Secured('ROLE_ADMIN')
    @Transactional
    def update(Department departmentInstance) {
        if (departmentInstance == null) {
            notFound()
            return
        }

        if (departmentInstance.hasErrors()) {
            respond departmentInstance.errors, view:'edit'
            return
        }

        departmentInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Department.label', default: 'Department'), departmentInstance.id])
                redirect departmentInstance
            }
            '*'{ respond departmentInstance, [status: OK] }
        }
    }

    @Secured('ROLE_ADMIN')
    @Transactional
    def delete(Department departmentInstance) {

        if (departmentInstance == null) {
            notFound()
            return
        }

        departmentInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Department.label', default: 'Department'), departmentInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'department.label', default: 'Department'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
