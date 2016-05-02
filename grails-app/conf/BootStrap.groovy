import com.google.common.eventbus.DeadEvent
import cscie56.project.Company
import cscie56.project.Department
import cscie56.project.Employee
import cscie56.project.Role
import cscie56.project.User
import cscie56.project.UserRole
import groovy.time.TimeCategory

class BootStrap {

    def static ADMIN_ROLE;
    def static USER_ROLE;
    def static MANAGER_ROLE;

    def init = { servletContext ->

        // Initialize roles
        ADMIN_ROLE = new Role('ROLE_ADMIN').save()
        USER_ROLE = new Role('ROLE_USER').save()
        MANAGER_ROLE = new Role('ROLE_MANAGER').save()

        // Test User - has all roles
        def testUser = new User(username: 'me', password: 'password').save()

        UserRole.create testUser, ADMIN_ROLE, true
        UserRole.create(testUser, USER_ROLE, true)
        UserRole.create(testUser, MANAGER_ROLE, true)

        assert User.count() == 1
        assert Role.count() == 3
        assert UserRole.count() == 3

        // Create company
        Company company = new Company(name: 'A1 Company', domainName: 'a1company.com').save(flush: true)

        // Create departments and employees
        createDepartments(company)
        createEmployees(company)
    }

    def static createDepartments(Company company) {
        ['Accounting', 'IT', 'Finance', 'Engineer', 'HR', 'Management'].each {
            new Department(company: company, name: it).save()
        }
    }

    def static createEmployees(Company company) {
        [
                new Employee(firstName: 'Bob', lastName: 'Ng'),
                new Employee(firstName: 'Samuel', middleName: 'John', lastName: 'Adams'),
                new Employee(firstName: 'Avery', lastName: 'Bradley'),
                new Employee(firstName: 'Jae', lastName: 'Crowder'),
                new Employee(firstName: 'Terry', middleName: 'Henry', lastName: 'Rozier'),
                new Employee(firstName: 'Amir', lastName: 'Johnson'),
                new Employee(firstName: 'Jake', lastName: 'Hamilton'),
                new Employee(firstName: 'Chris', middleName: 'Snoop', lastName: 'James'),
                new Employee(firstName: 'Brian', lastName: 'Miles'),
                new Employee(firstName: 'Lekh', lastName: 'Pokharel')
        ].each {
            it.department = getRandomDepartment()
            it.dob = getRandomBirthDate()
            it.ssn = 1111111111
            it.email = getEmailAddress(it, company)
            it.title = 'Staff'
            it.type = getRandomType()
            it.dateHired = new Date("01/01/2012")
            it.annualSalary = getRandomNumber(250000, 40000)
            it.username = getUserName(it)
            it.password = 'password'
            it.pictureLocation = "employees/${getRandomNumber(10, 1)}.png"
            it.aboutMe = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            it.save()

            // Create role
            UserRole.create(it, USER_ROLE, true)
        }
    }

    def static getRandomDepartment() {
        List<Department> list = Department.list()
        int index = getRandomNumber(list.size() - 1, 0)
        list.get(index)
    }

    def static getRandomType() {
        List<String> titles = ['full-time', 'part-time', 'intern', 'contractor']
        int index = getRandomNumber(titles.size() - 1, 0)
        titles.get(index)
    }


    def static getRandomBirthDate() {
        int randMonth = getRandomNumber(12, 1)
        int randDay = getRandomNumber(30, 1)
        int randYear = getRandomNumber(21, 1)

        Date birthDate = null
        use(TimeCategory) {
            birthDate = new Date("01/01/1977") + randYear.year + randMonth.month + randDay.day
        }
        birthDate
    }

    def static getUserName(Employee employee) {
        String firstInitial = employee.firstName[0]
        "${firstInitial}${employee.lastName}".toLowerCase()
    }

    def static getEmailAddress(Employee employee, Company company) {
        String userName = getUserName(employee)
        "${userName}@${company.domainName}".toLowerCase()
    }

    // Pick a random number between max and min
    def static int getRandomNumber(int max, int min) {
        if (max == 0) {
            return 0
        }
        new Random().nextInt(max - min + 1) + min
    }


    def destroy = {
    }
}
