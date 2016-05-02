<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to HRbiz</title>
</head>

<body>
<div id="page-body" role="main">
    <h1>Welcome to HRbiz</h1>

    <p>HRbiz is an application to manage employees in a small company. This is a final project for CSCI E-56. At the moment
    this is the default page. Below is a list of controllers that are currently deployed in this application,
    click on each to execute its default action:</p>
</div>

<sec:ifNotLoggedIn>
    <div>
        <g:link controller="login" action="auth">Click here to login to your company profile</g:link>
    </div>
</sec:ifNotLoggedIn>
</body>
</html>
