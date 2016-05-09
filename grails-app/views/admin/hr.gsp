<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>HR Menu</title>
</head>

<body>
<div class="container-fluid">

    <div id="admin">
        <div id="controller-list" role="navigation">
            <h2>HR Menu:</h2>
            <ul>
                <li class="controller"><g:link controller="employee">Manage Employee</g:link></li>
                <li class="controller"><g:link controller="employeeAddress">Manage Employee Address</g:link></li>
                <li class="controller"><g:link controller="employeePaycheck">Manage Employee Pay Check</g:link></li>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
