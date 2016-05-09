
<%@ page import="cscie56.hrbiz.EmployeeAddress" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'employeeAddress.label', default: 'EmployeeAddress')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-employeeAddress" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-employeeAddress" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list employeeAddress">
			
				<g:if test="${employeeAddressInstance?.address1}">
				<li class="fieldcontain">
					<span id="address1-label" class="property-label"><g:message code="employeeAddress.address1.label" default="Address1" /></span>
					
						<span class="property-value" aria-labelledby="address1-label"><g:fieldValue bean="${employeeAddressInstance}" field="address1"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeAddressInstance?.city}">
				<li class="fieldcontain">
					<span id="city-label" class="property-label"><g:message code="employeeAddress.city.label" default="City" /></span>
					
						<span class="property-value" aria-labelledby="city-label"><g:fieldValue bean="${employeeAddressInstance}" field="city"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeAddressInstance?.state}">
				<li class="fieldcontain">
					<span id="state-label" class="property-label"><g:message code="employeeAddress.state.label" default="State" /></span>
					
						<span class="property-value" aria-labelledby="state-label"><g:fieldValue bean="${employeeAddressInstance}" field="state"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeAddressInstance?.zipCode}">
				<li class="fieldcontain">
					<span id="zipCode-label" class="property-label"><g:message code="employeeAddress.zipCode.label" default="Zip Code" /></span>
					
						<span class="property-value" aria-labelledby="zipCode-label"><g:fieldValue bean="${employeeAddressInstance}" field="zipCode"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeAddressInstance?.address2}">
				<li class="fieldcontain">
					<span id="address2-label" class="property-label"><g:message code="employeeAddress.address2.label" default="Address2" /></span>
					
						<span class="property-value" aria-labelledby="address2-label"><g:fieldValue bean="${employeeAddressInstance}" field="address2"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${employeeAddressInstance?.employee}">
				<li class="fieldcontain">
					<span id="employee-label" class="property-label"><g:message code="employeeAddress.employee.label" default="Employee" /></span>
					
						<span class="property-value" aria-labelledby="employee-label"><g:link controller="employee" action="show" id="${employeeAddressInstance?.employee?.id}">${employeeAddressInstance?.employee?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:employeeAddressInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${employeeAddressInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
