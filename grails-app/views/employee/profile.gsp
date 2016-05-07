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

                    <dt>Annual Salary:<dt>
                    <dd><g:formatNumber number="${profile.annualSalary}" type="currency" currencyCode="USD" /></dd>

                    <dt>Supervisor:<dt>
                    <dd>${profile.manager?.getName()}</dd>
                </dl>
                <h4>About me</h4>
                <div>
                    <textarea id="textAboutMe" placeholder="Write something about yourself" style="width: 400px; height: 150px; border:solid 1px;">${profile.aboutMe}</textarea>
                </div>
                <div>
                    <button type="button" class="btn btn-sm" onclick="saveAboutMe();">Save</button>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- employee Modal -->
<div id="profileModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- content -->
        </div>
    </div>
</div>

<!-- JS Handlers -->
<script type="text/javascript">

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
