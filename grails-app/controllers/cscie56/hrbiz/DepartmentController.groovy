package cscie56.hrbiz

import cscie56.hrbiz.Department
import cscie56.hrbiz.Employee
import cscie56.hrbiz.User
import grails.plugin.springsecurity.annotation.Secured

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

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

    def list() {
        User user = springSecurityService.currentUser
        Employee employee = Employee.findById(user.id)
        List<Department> departments = Department.findAllByCompany(employee.department.company)

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
