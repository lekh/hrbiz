package cscie56.hrbiz

class PhoneTagLib {

    static defaultEncodeAs = [taglib: 'text']

    static namespace = "phone"

    def formatNumber = { attrs, body ->
        String phone = attrs.number
        def formatted =
                "(".concat(phone.substring(0, 3)).concat(") ")
                        .concat(phone.substring(3, 6)).concat("-").concat(phone.substring(6))
        out << formatted
    }
}
