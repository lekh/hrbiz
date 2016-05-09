<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>Employee List</title>
</head>

<body>
<div class="container-fluid">

    <div id="department">
        <h2>${listType} Employees</h2>

        <!--<table id="employeeTable" class='table table-bordered table-striped table-hover dt-responsive nowrap'>-->
        <table id="employeeTable" class="table table-bordered table-striped table-hover display">
            <thead>
                <tr id='table-header'>
                    <th>Name</th>
                    <th>Title</th>
                    <th>Department</th>
                    <th>Manager</th>
                    <th class="hidden-xs">Email</th>
                    <th class="hidden-xs hidden-sm">Phone</th>
                    <th class="hidden-xs hidden-sm">Type</th>
                    <th class="hidden-xs hidden-sm">Seniority</th>
                </tr>
            </thead>
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

<script type="text/javascript">

    $(document).ready(function(){
        $('#employeeTable').DataTable({
            paging: false
        });
    });

    // For modal
    $('body').on('hidden.bs.modal', '.modal', function () {
        $(this).removeData('bs.modal');
    });

</script>

</body>
</html>
