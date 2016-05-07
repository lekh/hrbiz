<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal">&times;</button>
    <h4 class="modal-title">${employee.getName()}</h4>
</div>

<div class="modal-body">

    <div class="container">
        <div class="row">
            <div class="col-md-2">
                <asset:image src="${employee.pictureLocation}" alt="${employee.getName()}"
                             height="185" width="230"/>
            </div>

            <div class="col-md-10">
                <dl class="dl-horizontal">
                    <dt>Full Name:</dt>
                    <dd>${employee.getName()}</dd>

                    <dt>Email:</dt>
                    <dd><a href="mailto:${employee.email}">${employee.email}</a></dd>

                    <dt>Phone:</dt>
                    <dd><td><phone:formatNumber number="${employee.phoneNumber}" /></td></dd>

                    <dt>Title:<dt>
                    <dd>${employee.title}</dd>

                    <dt>Type:<dt>
                    <dd>${employee.type}</dd>

                    <dt>Reports To:<dt>
                    <dd>${employee.manager?.getName()}</dd>
                </dl>
            </div>
        </div>
    </div>

    <div>
        <h3>About Me</h3>
        <p>${employee.aboutMe}</p>
    </div>

</div>

<div class="modal-footer">
    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
</div>
