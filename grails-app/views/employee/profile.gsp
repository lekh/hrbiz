<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>${profile.getName()}</title>
</head>

<body>
<div class="container-fluid">

    <div id="profile">
        <h2>${profile.getName()}</h2>

        <div>
            <a class="btn btn-default pull-right" href="/hrbiz/employee/editProfile" data-toggle="modal" data-target="#editProfileModal">Edit Profile</a>
        </div>

        <div class="row">
            <div class="col-sm-3">
                <asset:image src="${profile.pictureLocation}" alt="${profile.getName()}"
                             height="185" width="230"/>
            </div>

            <div class="col-sm-9">
                <dl class="dl-horizontal">
                    <dt>Full Name:</dt>
                    <dd>${profile.getName()}</dd>

                    <dt>Email:</dt>
                    <dd><a href="mailto:${profile.email}">${profile.email}</a></dd>

                    <dt>Phone:</dt>
                    <dd><phone:formatNumber number="${profile.phoneNumber}" /></dd>

                    <dt>Title:<dt>
                    <dd>${profile.title}</dd>

                    <dt>Type:<dt>
                    <dd>${profile.type}</dd>

                    <dt>Date Hired:<dt>
                    <dd><g:formatDate format="yyyy-MM-dd" date="${profile.dateHired}"/></dd>

                    <dt>Social Security No:</dt>
                    <dd>${profile.ssn}</dd>

                    <dt>Annual Salary:<dt>
                    <dd><g:formatNumber number="${profile.annualSalary}" type="currency" currencyCode="USD" /></dd>

                    <dt>Supervisor:<dt>
                    <dd>${profile.manager?.getName()}</dd>

                    <dt>Address:</dt>
                    <dd>${address}</dd>

                    <dt>Bank Name:<dt>
                    <dd>${profile.bankName}</dd>

                    <dt>Routing No:<dt>
                    <dd>${profile.routingNo}</dd>

                    <dt>Account No:<dt>
                    <dd>${profile.accountNo}</dd>

                </dl>
                <h4>About me</h4>
                <p>${profile.aboutMe}</p>

                <h4>Pay History</h4>
                <pay:history/>

                <h4>W2</h4>
                <pay:w2/>

            </div>
        </div>
    </div>
</div>

<!-- employee Modal -->
<div id="editProfileModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- content -->
        </div>
    </div>
</div>



<!-- JS Handlers -->
<script type="text/javascript">

    // For modal
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(this).removeData('bs.modal');
    });

    function saveAboutMe() {
        var aboutMe = $('#textAboutMe').val();
        $.ajax({
            type: "POST",
            url: "/hrbiz/employee/ajaxSaveAboutMe",
            data: {
                "aboutMe": aboutMe
            },
            beforeSend: function() {
                return $('#textAboutMe').val().trim().length > 0;
            },
            success: function(data) {
                console.log("Date saved");
            },
            error: function(jqXHR, textStatus, errorThrown) {
                console.log('error');
            }
        });

    }

</script>

</body>
</html>
