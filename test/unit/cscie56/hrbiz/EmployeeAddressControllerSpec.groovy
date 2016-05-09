package cscie56.hrbiz



import grails.test.mixin.*
import spock.lang.*

@TestFor(EmployeeAddressController)
@Mock(EmployeeAddress)
class EmployeeAddressControllerSpec extends Specification {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...

        Company company = new Company(name: 'A1 Company')
        Department department = new Department(company: company, name: 'Accounting')
        Employee employee = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000, username: 'bng', password: 'password')

        params["employee"] = employee
        params["address1"] = '123 Main Street'
        params["address2"] = 'Apt 44'
        params["city"] = 'Boston'
        params["state"] = 'MA'
        params["zipCode"] = '02474'
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.employeeAddressInstanceList
            model.employeeAddressInstanceCount == 0
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.employeeAddressInstance!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def employeeAddress = new EmployeeAddress()
            employeeAddress.validate()
            controller.save(employeeAddress)

        then:"The create view is rendered again with the correct model"
            model.employeeAddressInstance!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            employeeAddress = new EmployeeAddress(params)

            controller.save(employeeAddress)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/employeeAddress/show/1'
            controller.flash.message != null
            EmployeeAddress.count() == 1
    }

    void "Test that the show action returns the correct model"() {
        when:"The show action is executed with a null domain"
            controller.show(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the show action"
            populateValidParams(params)
            def employeeAddress = new EmployeeAddress(params)
            controller.show(employeeAddress)

        then:"A model is populated containing the domain instance"
            model.employeeAddressInstance == employeeAddress
    }

    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def employeeAddress = new EmployeeAddress(params)
            controller.edit(employeeAddress)

        then:"A model is populated containing the domain instance"
            model.employeeAddressInstance == employeeAddress
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/employeeAddress/index'
            flash.message != null


        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def employeeAddress = new EmployeeAddress()
            employeeAddress.validate()
            controller.update(employeeAddress)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.employeeAddressInstance == employeeAddress

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            employeeAddress = new EmployeeAddress(params).save(flush: true)
            controller.update(employeeAddress)

        then:"A redirect is issues to the show action"
            response.redirectedUrl == "/employeeAddress/show/$employeeAddress.id"
            flash.message != null
    }

    void "Test that the delete action deletes an instance if it exists"() {
        when:"The delete action is called for a null instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'DELETE'
            controller.delete(null)

        then:"A 404 is returned"
            response.redirectedUrl == '/employeeAddress/index'
            flash.message != null

        when:"A domain instance is created"
            response.reset()
            populateValidParams(params)
            def employeeAddress = new EmployeeAddress(params).save(flush: true)

        then:"It exists"
            EmployeeAddress.count() == 1

        when:"The domain instance is passed to the delete action"
            controller.delete(employeeAddress)

        then:"The instance is deleted"
            EmployeeAddress.count() == 0
            response.redirectedUrl == '/employeeAddress/index'
            flash.message != null
    }
}
