package cscie56.hrbiz

import grails.plugin.springsecurity.annotation.Secured

@Secured('ROLE_MANAGER')
class ManagerController {

    def index() {
        println "in manager controller"
    }
}
