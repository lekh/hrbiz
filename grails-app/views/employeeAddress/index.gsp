
<%@ page import="cscie56.hrbiz.EmployeeAddress" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeAddress.label', default: 'EmployeeAddress')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employeeAddress" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employeeAddress" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-striped table-hover">
			<thead>
					<tr>
						<th><g:message code="employeeAddress.employee.label" default="Employee" /></th>

						<g:sortableColumn property="address1" title="${message(code: 'employeeAddress.address1.label', default: 'Address1')}" />

						<g:sortableColumn property="address2" title="${message(code: 'employeeAddress.address2.label', default: 'Address2')}" />

						<g:sortableColumn property="city" title="${message(code: 'employeeAddress.city.label', default: 'City')}" />
					
						<g:sortableColumn property="state" title="${message(code: 'employeeAddress.state.label', default: 'State')}" />
					
						<g:sortableColumn property="zipCode" title="${message(code: 'employeeAddress.zipCode.label', default: 'Zip Code')}" />
					</tr>
				</thead>
				<tbody>
				<g:each in="${employeeAddressInstanceList}" status="i" var="employeeAddressInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:link action="show" id="${employeeAddressInstance.id}">${fieldValue(bean: employeeAddressInstance, field: "employee")}</g:link></td>
					
						<td>${fieldValue(bean: employeeAddressInstance, field: "address1")}</td>

						<td>${fieldValue(bean: employeeAddressInstance, field: "address2")}</td>
					
						<td>${fieldValue(bean: employeeAddressInstance, field: "city")}</td>
					
						<td>${fieldValue(bean: employeeAddressInstance, field: "state")}</td>
					
						<td>${fieldValue(bean: employeeAddressInstance, field: "zipCode")}</td>

					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeeAddressInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
