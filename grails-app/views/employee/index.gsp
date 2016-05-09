
<%@ page import="cscie56.hrbiz.Employee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employee" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-striped table-hover">
			<thead>
					<tr>

						<g:sortableColumn property="username" title="${message(code: 'employee.username.label', default: 'Username')}" />

						<g:sortableColumn property="firstName" title="${message(code: 'employee.firstName.label', default: 'First Name')}" />

						<g:sortableColumn property="lastName" title="${message(code: 'employee.lastName.label', default: 'Last Name')}" />

						<th><g:message code="employee.department.label" default="Department" /></th>

						<th><g:message code="employee.manager.label" default="Manager" /></th>

						<g:sortableColumn property="email" title="${message(code: 'employee.email.label', default: 'Email')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeInstanceList}" status="i" var="employeeInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${employeeInstance.id}">${fieldValue(bean: employeeInstance, field: "username")}</g:link></td>

						<td>${fieldValue(bean: employeeInstance, field: "firstName")}</td>

						<td>${fieldValue(bean: employeeInstance, field: "lastName")}</td>

						<td>${fieldValue(bean: employeeInstance, field: "department")}</td>

						<td>${fieldValue(bean: employeeInstance, field: "manager")}</td>

						<td>${fieldValue(bean: employeeInstance, field: "email")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
