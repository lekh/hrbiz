
<%@ page import="cscie56.hrbiz.EmployeePaycheck" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeePaycheck.label', default: 'EmployeePaycheck')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employeePaycheck" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employeePaycheck" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employeePaycheck">
			
				<g:if test="${employeePaycheckInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="employeePaycheck.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${employeePaycheckInstance?.employee?.id}">${employeePaycheckInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeePaycheckInstance?.grossPay}">
				<li class="fieldcontain">
					<span id="grossPay-label" class="property-label"><g:message code="employeePaycheck.grossPay.label" default="Gross Pay" /></span>
					
						<span class="property-value" aria-labelledby="grossPay-label"><g:fieldValue bean="${employeePaycheckInstance}" field="grossPay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeePaycheckInstance?.netPay}">
				<li class="fieldcontain">
					<span id="netPay-label" class="property-label"><g:message code="employeePaycheck.netPay.label" default="Net Pay" /></span>
					
						<span class="property-value" aria-labelledby="netPay-label"><g:fieldValue bean="${employeePaycheckInstance}" field="netPay"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeePaycheckInstance?.payDate}">
				<li class="fieldcontain">
					<span id="payDate-label" class="property-label"><g:message code="employeePaycheck.payDate.label" default="Pay Date" /></span>
					
						<span class="property-value" aria-labelledby="payDate-label"><g:formatDate date="${employeePaycheckInstance?.payDate}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeePaycheckInstance?.taxAmount}">
				<li class="fieldcontain">
					<span id="taxAmount-label" class="property-label"><g:message code="employeePaycheck.taxAmount.label" default="Tax Amount" /></span>
					
						<span class="property-value" aria-labelledby="taxAmount-label"><g:fieldValue bean="${employeePaycheckInstance}" field="taxAmount"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:employeePaycheckInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${employeePaycheckInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
