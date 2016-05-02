<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>Department List</title>
</head>

<body>
<div class="container-fluid">

    <div id="department">
        <h2>Departments</h2>

        <div>
            <ul>
                <g:each in="${departments}">
                    <li><a href="/hrbiz/employee/list?departmentId=${it.id}">${it.name}</a></li>
                </g:each>
            </ul>
        </div>

    </div>
</div>
</body>
</html>
