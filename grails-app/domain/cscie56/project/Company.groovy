package cscie56.project

class Company {

    String name
    String domainName

    static constraints = {
        name(blank: false, nullable: false, unique: true)
        domainName nullable: true
    }

    @Override
    public String toString() {
        name
    }
}
