
<%@ page import="cscie56.hrbiz.Employee" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employee.label', default: 'Employee')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employee" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employee">
			
				<g:if test="${employeeInstance?.annualSalary}">
				<li class="fieldcontain">
					<span id="annualSalary-label" class="property-label"><g:message code="employee.annualSalary.label" default="Annual Salary" /></span>
					
						<span class="property-value" aria-labelledby="annualSalary-label"><g:fieldValue bean="${employeeInstance}" field="annualSalary"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.pictureLocation}">
				<li class="fieldcontain">
					<span id="pictureLocation-label" class="property-label"><g:message code="employee.pictureLocation.label" default="Picture Location" /></span>
					
						<span class="property-value" aria-labelledby="pictureLocation-label"><g:fieldValue bean="${employeeInstance}" field="pictureLocation"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.dateHired}">
				<li class="fieldcontain">
					<span id="dateHired-label" class="property-label"><g:message code="employee.dateHired.label" default="Date Hired" /></span>
					
						<span class="property-value" aria-labelledby="dateHired-label"><g:formatDate date="${employeeInstance?.dateHired}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.department}">
				<li class="fieldcontain">
					<span id="department-label" class="property-label"><g:message code="employee.department.label" default="Department" /></span>
					
						<span class="property-value" aria-labelledby="department-label"><g:link controller="department" action="show" id="${employeeInstance?.department?.id}">${employeeInstance?.department?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.dob}">
				<li class="fieldcontain">
					<span id="dob-label" class="property-label"><g:message code="employee.dob.label" default="Dob" /></span>
					
						<span class="property-value" aria-labelledby="dob-label"><g:formatDate date="${employeeInstance?.dob}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.email}">
				<li class="fieldcontain">
					<span id="email-label" class="property-label"><g:message code="employee.email.label" default="Email" /></span>
					
						<span class="property-value" aria-labelledby="email-label"><g:fieldValue bean="${employeeInstance}" field="email"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.firstName}">
				<li class="fieldcontain">
					<span id="firstName-label" class="property-label"><g:message code="employee.firstName.label" default="First Name" /></span>
					
						<span class="property-value" aria-labelledby="firstName-label"><g:fieldValue bean="${employeeInstance}" field="firstName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.lastName}">
				<li class="fieldcontain">
					<span id="lastName-label" class="property-label"><g:message code="employee.lastName.label" default="Last Name" /></span>
					
						<span class="property-value" aria-labelledby="lastName-label"><g:fieldValue bean="${employeeInstance}" field="lastName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.manager}">
				<li class="fieldcontain">
					<span id="manager-label" class="property-label"><g:message code="employee.manager.label" default="Manager" /></span>
					
						<span class="property-value" aria-labelledby="manager-label"><g:link controller="employee" action="show" id="${employeeInstance?.manager?.id}">${employeeInstance?.manager?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.middleName}">
				<li class="fieldcontain">
					<span id="middleName-label" class="property-label"><g:message code="employee.middleName.label" default="Middle Name" /></span>
					
						<span class="property-value" aria-labelledby="middleName-label"><g:fieldValue bean="${employeeInstance}" field="middleName"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.ssn}">
				<li class="fieldcontain">
					<span id="ssn-label" class="property-label"><g:message code="employee.ssn.label" default="Ssn" /></span>
					
						<span class="property-value" aria-labelledby="ssn-label"><g:fieldValue bean="${employeeInstance}" field="ssn"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeInstance?.title}">
				<li class="fieldcontain">
					<span id="title-label" class="property-label"><g:message code="employee.title.label" default="Title" /></span>
					
						<span class="property-value" aria-labelledby="title-label"><g:fieldValue bean="${employeeInstance}" field="title"/></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:employeeInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${employeeInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
