import com.google.common.eventbus.DeadEvent
import cscie56.hrbiz.Company
import cscie56.hrbiz.Department
import cscie56.hrbiz.Employee
import cscie56.hrbiz.Role
import cscie56.hrbiz.User
import cscie56.hrbiz.UserRole
import groovy.time.TimeCategory

class BootStrap {

    def static ADMIN_ROLE;
    def static USER_ROLE;
    def static MANAGER_ROLE;
    def static HR_ROLE;

    def init = { servletContext ->

        // Initialize roles
        ADMIN_ROLE = new Role('ROLE_ADMIN').save()
        USER_ROLE = new Role('ROLE_USER').save()
        MANAGER_ROLE = new Role('ROLE_MANAGER').save()
        HR_ROLE = new Role('ROLE_HR').save()

        // Create company
        Company company = new Company(name: 'A1 Company', domainName: 'a1company.com').save(flush: true)

        // Create departments and employees
        createDepartmentAndEmployees(company)
    }

    def static createDepartmentAndEmployees(Company company) {
        Department management = new Department(company: company, name: 'Management').save()
        Department technology = new Department(company: company, name: 'Technology').save()
        Department finance = new Department(company: company, name: 'Finance').save()
        Department hrDept = new Department(company: company, name: 'HR').save()
        Department accounting = new Department(company: company, name: 'Accounting').save()

        Employee ceo = new Employee(firstName: 'Bob', lastName: 'Ng', department: management, title: 'CEO', type: 'full-time', dateHired: new Date("01/01/2012"));
        Employee dir = new Employee(firstName: 'Samuel', middleName: 'John', lastName: 'Adams', department: management, title: 'Director', type: 'full-time', manager: ceo, dateHired: new Date("05/10/2010"))
        Employee hr = new Employee(firstName: 'Avery', lastName: 'Bradley', department: hrDept, title: 'Director of HR', type: 'full-time', manager: ceo, dateHired: new Date("03/02/2015"))
        Employee acct = new Employee(firstName: 'Jae', lastName: 'Crowder', department: accounting, title: 'Senior Accountant', type: 'full-time', manager: dir, dateHired: new Date("12/01/2012"))
        Employee cfo = new Employee(firstName: 'Terry', middleName: 'Henry', lastName: 'Rozier', department: finance, title: 'CFO', type: 'full-time', manager: ceo, dateHired: new Date("08/20/2012"))
        Employee cto = new Employee(firstName: 'Amir', lastName: 'Johnson', department: technology, title: 'CTO', type: 'full-time', manager: ceo, dateHired: new Date("05/01/2010"))
        Employee se1 = new Employee(firstName: 'Jake', lastName: 'Hamilton', department: technology, title: 'Software Engineer', type: 'intern', manager: cto, dateHired: new Date("10/04/2009"))
        Employee dir1 = new Employee(firstName: 'Chris', middleName: 'Snoop', lastName: 'James', department: management, title: 'Assistant Director', type: 'part-time', manager: dir, dateHired: new Date("06/03/2014"))
        Employee webdev = new Employee(firstName: 'Brian', lastName: 'Miles', department: technology, title: 'Web Developer', type: 'contractor', manager: cto, dateHired: new Date("02/02/2012"))
        Employee sysadmin = new Employee(firstName: 'Lekh', lastName: 'Pokharel', department: technology, title: 'System Admin', type: 'full-time', manager: cto, dateHired: new Date("09/09/2010"))

        [ceo, dir, hr, acct, cfo, cto, se1, dir1, webdev, sysadmin].eachWithIndex { it, index ->
            it.dob = getRandomBirthDate()
            it.ssn = 1111111111
            it.email = getEmailAddress(it, company)
            it.phoneNumber = getRandomPhoneNo()
            it.annualSalary = getRandomNumber(250000, 40000)
            it.username = getUserName(it)
            it.password = 'password'
            it.pictureLocation = "employees/${index + 1}.png"
            it.aboutMe = "Lorem ipsum dolor sit amet, consectetur adipiscing elit."
            it.save(flush: true)

            // Create role
            UserRole.create(it, USER_ROLE, true)
        }

        // Assign more roles
        UserRole.create(ceo, MANAGER_ROLE, true)
        UserRole.create(dir, MANAGER_ROLE, true)
        UserRole.create(hr, HR_ROLE, true)
        UserRole.create(cto, MANAGER_ROLE, true)
        UserRole.create(cto, ADMIN_ROLE, true)
        UserRole.create(sysadmin, ADMIN_ROLE, true)
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

    def static getRandomPhoneNo() {
        List areaCodes = [339, 351, 413, 508, 617, 774, 781, 857, 978]
        int index = getRandomNumber(areaCodes.size() - 1, 0)
        int code = areaCodes.get(index)
        int phNo = getRandomNumber(9999999, 1111111)
        "${code}${phNo}"
    }

    // User name is first inital + last name (lowercase)
    def static getUserName(Employee employee) {
        String firstInitial = employee.firstName[0]
        "${firstInitial}${employee.lastName}".toLowerCase()
    }

    // Email address is username@<companydomain.com>
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
