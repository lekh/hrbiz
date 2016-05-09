package cscie56.hrbiz

class PhoneTagLib {

    static defaultEncodeAs = [taglib: 'text']

    static namespace = "phone"

    /**
     * Formats a given US phone number to: (area code) xxx-xxxx
     */
    def formatNumber = { attrs, body ->
        String phone = attrs.number

        if (phone != null && !phone.trim().isEmpty()) {
            out << "(".concat(phone.substring(0, 3)).concat(") ")
                    .concat(phone.substring(3, 6)).concat("-").concat(phone.substring(6))
        }
    }
}
