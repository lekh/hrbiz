<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">${employee.getName()}</h4>
</div>

<div class="modal-body">

    <h4>Address and Phone</h4>
    <dl class="dl-horizontal">
        <dt>Address 1:</dt>
        <dd><input type="text" name="address1" value="${address.address1}" /></dd>

        <dt>Address 1:</dt>
        <dd><input type="text" name="address2" value="${address.address2}" /></dd>

        <dt>City:</dt>
        <dd><input type="text" name="city" value="${address.city}" /></dd>

        <dt>State:</dt>
        <dd><input type="text" name="state" value="${address.state}" /></dd>

        <dt>Zip:</dt>
        <dd><input type="text" name="zip" value="${address.zipCode}" /></dd>

        <dt>Phone:</dt>
        <dd><input type="text" name="phone" value="${employee.phoneNumber}" /></dd>
    </dl>

    <h4>Bank Information</h4>
    <dl class="dl-horizontal">
        <dt>Bank Name:</dt>
        <dd><input type="text" name="bankName" value="${employee.bankName}" /></dd>

        <dt>Routing number:</dt>
        <dd><input type="text" name="routingNumber" value="${employee.routingNo}" /></dd>

        <dt>Account number:</dt>
        <dd><input type="text" name="accountNumber" value="${employee.accountNo}" /></dd>
    </dl>

    <h4>About Me</h4>
    <div>
        <textarea id="aboutMe" placeholder="Write something about yourself" style="width: 400px; height: 150px; border:solid 1px;">${employee.aboutMe}</textarea>
    </div>
</div>

<div class="modal-footer">
    <button type="button" class="btn btn-default pull-left" data-dismiss="modal" onclick="saveProfile();">Save</button>
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>

<!-- JS Handlers -->
<script type="text/javascript">

    // Save Profile
    function saveProfile() {
        $.ajax({
            type: "POST",
            url: "/hrbiz/employee/ajaxSaveProfile",
            data: {
                "address1": $('input[name=address1]').val().trim(),
                "address2": $('input[name=address2]').val().trim(),
                "city": $('input[name=city]').val().trim(),
                "state": $('input[name=state]').val().trim(),
                "zip": $('input[name=zip]').val().trim(),
                "phone": $('input[name=phone]').val().trim(),
                "bankName": $('input[name=bankName]').val().trim(),
                "routingNumber": $('input[name=routingNumber]').val().trim(),
                "accountNumber": $('input[name=accountNumber]').val().trim(),
                "aboutMe": $('#aboutMe').val()
            },
            success: function(data) {
                console.log("Date saved");
                location.reload()
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log('error');
            }
        });
    }
</script>
