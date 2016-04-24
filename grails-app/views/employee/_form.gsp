<%@ page import="cscie56.project.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'annualSalary', 'error')} required">
	<label for="annualSalary">
		<g:message code="employee.annualSalary.label" default="Annual Salary" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="annualSalary" type="number" min="1" value="${employeeInstance.annualSalary}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'pictureLocation', 'error')} ">
	<label for="pictureLocation">
		<g:message code="employee.pictureLocation.label" default="Picture Location" />
		
	</label>
	<g:textField name="pictureLocation" value="${employeeInstance?.pictureLocation}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'dateHired', 'error')} required">
	<label for="dateHired">
		<g:message code="employee.dateHired.label" default="Date Hired" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateHired" precision="day"  value="${employeeInstance?.dateHired}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'department', 'error')} required">
	<label for="department">
		<g:message code="employee.department.label" default="Department" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="department" name="department.id" from="${cscie56.project.Department.list()}" optionKey="id" required="" value="${employeeInstance?.department?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'dob', 'error')} required">
	<label for="dob">
		<g:message code="employee.dob.label" default="Dob" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dob" precision="day"  value="${employeeInstance?.dob}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'email', 'error')} required">
	<label for="email">
		<g:message code="employee.email.label" default="Email" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="email" required="" value="${employeeInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="employee.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${employeeInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="employee.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${employeeInstance?.lastName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'manager', 'error')} required">
	<label for="manager">
		<g:message code="employee.manager.label" default="Manager" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="manager" name="manager.id" from="${cscie56.project.Employee.list()}" optionKey="id" required="" value="${employeeInstance?.manager?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'middleName', 'error')} required">
	<label for="middleName">
		<g:message code="employee.middleName.label" default="Middle Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="middleName" required="" value="${employeeInstance?.middleName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'ssn', 'error')} required">
	<label for="ssn">
		<g:message code="employee.ssn.label" default="Ssn" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ssn" type="number" value="${employeeInstance.ssn}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="employee.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${employeeInstance?.title}"/>

</div>

