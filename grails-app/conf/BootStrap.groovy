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
    }

    def destroy = {
    }
}
