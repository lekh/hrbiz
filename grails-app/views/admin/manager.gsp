<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/html">
<head>
    <meta name="layout" content="main">
    <title>Manager Menu</title>
</head>

<body>
<div class="container-fluid">

    <div id="admin">
        <div id="controller-list" role="navigation">
            <h2>My Employees</h2>
            <ul>
                <g:each in="${employees}">
                    <li>${it.getName()}</li>
                </g:each>
            </ul>
        </div>
    </div>
</div>
</body>
</html>
