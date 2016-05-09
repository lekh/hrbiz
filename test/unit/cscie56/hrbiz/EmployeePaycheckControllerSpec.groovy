package cscie56.hrbiz

import grails.test.mixin.*
import spock.lang.*

@TestFor(EmployeePaycheckController)
@Mock(EmployeePaycheck)
class EmployeePaycheckControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...

        Company company = new Company(name: 'A1 Company')
        Department department = new Department(company: company, name: 'Accounting')
        Employee employee = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')

        params["employee"] = employee
        params["payDate"] = new Date()
        params["grossPay"] = 5000
        params["taxAmount"] = 1000
        params["netPay"] = 4000
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.employeePaycheckInstanceList
            model.employeePaycheckInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.employeePaycheckInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def employeePaycheck = new EmployeePaycheck()
            employeePaycheck.validate()
            controller.save(employeePaycheck)

        then:"The create view is rendered again with the correct model"
            model.employeePaycheckInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            employeePaycheck = new EmployeePaycheck(params)

            controller.save(employeePaycheck)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/employeePaycheck/show/1'
            controller.flash.message != null
            EmployeePaycheck.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def employeePaycheck = new EmployeePaycheck(params)
            controller.show(employeePaycheck)

        then:"A model is populated containing the domain instance"
            model.employeePaycheckInstance == employeePaycheck
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def employeePaycheck = new EmployeePaycheck(params)
            controller.edit(employeePaycheck)

        then:"A model is populated containing the domain instance"
            model.employeePaycheckInstance == employeePaycheck
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/employeePaycheck/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def employeePaycheck = new EmployeePaycheck()
            employeePaycheck.validate()
            controller.update(employeePaycheck)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.employeePaycheckInstance == employeePaycheck

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            employeePaycheck = new EmployeePaycheck(params).save(flush: true)
            controller.update(employeePaycheck)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/employeePaycheck/show/$employeePaycheck.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/employeePaycheck/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def employeePaycheck = new EmployeePaycheck(params).save(flush: true)

        then:"It exists"
            EmployeePaycheck.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(employeePaycheck)

        then:"The instance is deleted"
            EmployeePaycheck.count() == 0
            response.redirectedUrl == '/employeePaycheck/index'
            flash.message != null
    }
}
