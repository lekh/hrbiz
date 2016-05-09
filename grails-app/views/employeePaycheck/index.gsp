
<%@ page import="cscie56.hrbiz.EmployeePaycheck" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeePaycheck.label', default: 'EmployeePaycheck')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-employeePaycheck" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-employeePaycheck" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-striped table-hover">
			<thead>
					<tr>
					
						<th><g:message code="employeePaycheck.employee.label" default="Employee" /></th>

						<g:sortableColumn property="payDate" title="${message(code: 'employeePaycheck.payDate.label', default: 'Pay Date')}" />

						<g:sortableColumn property="grossPay" title="${message(code: 'employeePaycheck.grossPay.label', default: 'Gross Pay')}" />

						<g:sortableColumn property="taxAmount" title="${message(code: 'employeePaycheck.taxAmount.label', default: 'Tax Amount')}" />

						<g:sortableColumn property="netPay" title="${message(code: 'employeePaycheck.netPay.label', default: 'Net Pay')}" />

					</tr>
				</thead>
				<tbody>
				<g:each in="${employeePaycheckInstanceList}" status="i" var="employeePaycheckInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

						<td><g:formatDate date="${employeePaycheckInstance.payDate}" /></td>

						<td><g:link action="show" id="${employeePaycheckInstance.id}">${fieldValue(bean: employeePaycheckInstance, field: "employee")}</g:link></td>
					
						<td>${fieldValue(bean: employeePaycheckInstance, field: "grossPay")}</td>
					
						<td>${fieldValue(bean: employeePaycheckInstance, field: "taxAmount")}</td>

						<td>${fieldValue(bean: employeePaycheckInstance, field: "netPay")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${employeePaycheckInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
