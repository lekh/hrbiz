import com.google.common.eventbus.DeadEvent
import cscie56.project.Company
import cscie56.project.Department
import cscie56.project.Employee
import cscie56.project.Role
import cscie56.project.User
import cscie56.project.UserRole

class BootStrap {

    def static ADMIN_ROLE;
    def static USER_ROLE;
    def static MANAGER_ROLE;

    def init = { servletContext ->

        // Initialize roles
        ADMIN_ROLE = new Role('ROLE_ADMIN').save()
        USER_ROLE = new Role('ROLE_USER').save()
        MANAGER_ROLE = new Role('ROLE_MANAGER').save()

        // Test user - has all roles
        def testUser = new User(username: 'me', password: 'password').save()

        UserRole.create testUser, ADMIN_ROLE, true
        UserRole.create(testUser, USER_ROLE, true)
        UserRole.create(testUser, MANAGER_ROLE, true)

        assert User.count() == 1
        assert Role.count() == 3
        assert UserRole.count() == 3

        // Bootstrap some Data
        Company company = new Company(name: 'A1 Company').save()
        Department department = new Department(company: company, name: 'Accounting').save()

        Employee e1 = new Employee(department: department, firstName: 'Bob', lastName: 'Ng', dob: new Date("02/01/1986"),
                ssn: 1111111111, email: 'bng@a1company.com', title: 'Auditor', type: 'full-time',
                dateHired: new Date("01/01/2012"), annualSalary: 40000).save()
    }

    def destroy = {
    }
}
