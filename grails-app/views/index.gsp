<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main"/>
    <title>Welcome to ${company}</title>
</head>

<body>

<sec:ifNotLoggedIn>
    <div id="page-body" role="main">
        <h1>Welcome to HRBIZ</h1>
        <p>Final project for CSCI E-56. The purpose of this project is to create a employee portal for small business.</p>
    </div>
    <div>
        <g:link controller="login" action="auth">Click here to login to your company profile</g:link>
    </div>
</sec:ifNotLoggedIn>

<sec:ifLoggedIn>
    <div id="page-body" role="main">
        <h1>Welcome to ${company}</h1>
        <p>Final project for CSCI E-56. The purpose of this project is to create a employee portal for small business.</p>

        <h2>About Us</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pulvinar tortor ut tincidunt rhoncus.
        Sed ligula mi, elementum vel risus id, fermentum tincidunt sem. Cras vitae fermentum nisi. Suspendisse
        vel ligula eu turpis mollis accumsan ac et lectus. Proin luctus mi at odio posuere, sed porttitor metus
        ornare. Suspendisse potenti. Vestibulum bibendum tincidunt tellus et fringilla. Vivamus vel nisi et purus
        pretium ultrices nec eu velit. Quisque sed ullamcorper lorem. Pellentesque semper enim sed urna fermentum,
        sit amet scelerisque mi placerat. Integer ultricies commodo justo, vel tempus urna malesuada nec. Integer
        quis lorem libero. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam blandit sed nibh
        lacinia tincidunt.</p>

        <h2>Employee Policy</h2>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pulvinar tortor ut tincidunt rhoncus.
        Sed ligula mi, elementum vel risus id, fermentum tincidunt sem. Cras vitae fermentum nisi. Suspendisse
        vel ligula eu turpis mollis accumsan ac et lectus. Proin luctus mi at odio posuere, sed porttitor metus
        ornare. Suspendisse potenti. Vestibulum bibendum tincidunt tellus et fringilla. Vivamus vel nisi et purus
        pretium ultrices nec eu velit. Quisque sed ullamcorper lorem. Pellentesque semper enim sed urna fermentum,
        sit amet scelerisque mi placerat. Integer ultricies commodo justo, vel tempus urna malesuada nec. Integer
        quis lorem libero. Interdum et malesuada fames ac ante ipsum primis in faucibus. Nullam blandit sed nibh
        lacinia tincidunt.</p>

        <h2>Holiday Calendar</h2>
        <table class="table table-bordered table-striped table-hover">
            <thead>
                <tr>
                    <td>Date</td>
                    <td>Holiday</td>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td>Friday January 1</td>
                    <td>New Year's Day</td>
                </tr>
                <tr>
                    <td>Monday January 18</td>
                    <td>Martin Luther King Jr's Day	</td>
                </tr>
                <tr>
                    <td>Lorem ipsum</td>
                    <td>Lorem ipsum</td>
                </tr>
                <tr>
                    <td>Lorem ipsum</td>
                    <td>Lorem ipsum</td>
                </tr>
                <tr>
                    <td>Lorem ipsum</td>
                    <td>Lorem ipsum</td>
                </tr>
                <tr>
                    <td>Lorem ipsum</td>
                    <td>Lorem ipsum</td>
                </tr>
            </tbody>
        </table>
    </div>
</sec:ifLoggedIn>
</body>
</html>
