<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>Employee List</title>
</head>

<body>
<div class="container-fluid">

    <div id="department">
        <h2>Employees</h2>

        <table class='table table-bordered table-striped table-hover'>
            <theader>
                <tr id='table-header'>
                    <th>Name</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Title</th>
                    <th>Type</th>
                    <th>Seniority</th>
                </tr>
            </theader>
            <tbody>
                <employee:list department="${department}" />
            </tbody>
        </table>
    </div>
</div>

<!-- employee Modal -->
<div id="employeeModal" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <!-- content -->
        </div>
    </div>
</div>

</body>
</html>
