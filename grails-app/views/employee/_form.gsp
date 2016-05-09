<%@ page import="cscie56.hrbiz.Employee" %>



<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'username', 'error')} required">
	<label for="username">
		<g:message code="employee.username.label" default="Username" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="username" required="" value="${employeeInstance?.username}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'password', 'error')} required">
	<label for="password">
		<g:message code="employee.password.label" default="Password" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="password" required="" value="${employeeInstance?.password}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'manager', 'error')} ">
	<label for="manager">
		<g:message code="employee.manager.label" default="Manager" />
		
	</label>
	<g:select id="manager" name="manager.id" from="${cscie56.hrbiz.Employee.list()}" optionKey="id" value="${employeeInstance?.manager?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'department', 'error')} required">
	<label for="department">
		<g:message code="employee.department.label" default="Department" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="department" name="department.id" from="${cscie56.hrbiz.Department.list()}" optionKey="id" required="" value="${employeeInstance?.department?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'address', 'error')} ">
	<label for="address">
		<g:message code="employee.address.label" default="Address" />
		
	</label>
	<g:select id="address" name="address.id" from="${cscie56.hrbiz.EmployeeAddress.list()}" optionKey="id" value="${employeeInstance?.address?.id}" class="many-to-one" noSelection="['null': '']"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'firstName', 'error')} required">
	<label for="firstName">
		<g:message code="employee.firstName.label" default="First Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="firstName" required="" value="${employeeInstance?.firstName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'middleName', 'error')} ">
	<label for="middleName">
		<g:message code="employee.middleName.label" default="Middle Name" />
		
	</label>
	<g:textField name="middleName" value="${employeeInstance?.middleName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'lastName', 'error')} required">
	<label for="lastName">
		<g:message code="employee.lastName.label" default="Last Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="lastName" required="" value="${employeeInstance?.lastName}"/>

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
	<g:field type="email" name="email" required="" value="${employeeInstance?.email}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'phoneNumber', 'error')} ">
	<label for="phoneNumber">
		<g:message code="employee.phoneNumber.label" default="Phone Number" />
		
	</label>
	<g:textField name="phoneNumber" value="${employeeInstance?.phoneNumber}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'title', 'error')} required">
	<label for="title">
		<g:message code="employee.title.label" default="Title" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="title" required="" value="${employeeInstance?.title}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'type', 'error')} required">
	<label for="type">
		<g:message code="employee.type.label" default="Type" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="type" from="${employeeInstance.constraints.type.inList}" required="" value="${employeeInstance?.type}" valueMessagePrefix="employee.type"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'dateHired', 'error')} required">
	<label for="dateHired">
		<g:message code="employee.dateHired.label" default="Date Hired" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateHired" precision="day"  value="${employeeInstance?.dateHired}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'annualSalary', 'error')} required">
	<label for="annualSalary">
		<g:message code="employee.annualSalary.label" default="Annual Salary" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="annualSalary" type="number" min="0" value="${employeeInstance.annualSalary}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'pictureLocation', 'error')} ">
	<label for="pictureLocation">
		<g:message code="employee.pictureLocation.label" default="Picture Location" />
		
	</label>
	<g:textField name="pictureLocation" value="${employeeInstance?.pictureLocation}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'aboutMe', 'error')} ">
	<label for="aboutMe">
		<g:message code="employee.aboutMe.label" default="About Me" />
		
	</label>
	<g:textField name="aboutMe" value="${employeeInstance?.aboutMe}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'ssn', 'error')} required">
	<label for="ssn">
		<g:message code="employee.ssn.label" default="Ssn" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="ssn" type="number" value="${employeeInstance.ssn}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'bankName', 'error')} ">
	<label for="bankName">
		<g:message code="employee.bankName.label" default="Bank Name" />
		
	</label>
	<g:textField name="bankName" value="${employeeInstance?.bankName}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'accountNo', 'error')} ">
	<label for="accountNo">
		<g:message code="employee.accountNo.label" default="Account No" />
		
	</label>
	<g:field name="accountNo" type="number" value="${employeeInstance.accountNo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'routingNo', 'error')} ">
	<label for="routingNo">
		<g:message code="employee.routingNo.label" default="Routing No" />
		
	</label>
	<g:field name="routingNo" type="number" value="${employeeInstance.routingNo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'accountExpired', 'error')} ">
	<label for="accountExpired">
		<g:message code="employee.accountExpired.label" default="Account Expired" />
		
	</label>
	<g:checkBox name="accountExpired" value="${employeeInstance?.accountExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'accountLocked', 'error')} ">
	<label for="accountLocked">
		<g:message code="employee.accountLocked.label" default="Account Locked" />
		
	</label>
	<g:checkBox name="accountLocked" value="${employeeInstance?.accountLocked}" />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'enabled', 'error')} ">
	<label for="enabled">
		<g:message code="employee.enabled.label" default="Enabled" />
		
	</label>
	<g:checkBox name="enabled" value="${employeeInstance?.enabled}" />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'passwordExpired', 'error')} ">
	<label for="passwordExpired">
		<g:message code="employee.passwordExpired.label" default="Password Expired" />
		
	</label>
	<g:checkBox name="passwordExpired" value="${employeeInstance?.passwordExpired}" />

</div>

<div class="fieldcontain ${hasErrors(bean: employeeInstance, field: 'paychecks', 'error')} ">
	<label for="paychecks">
		<g:message code="employee.paychecks.label" default="Paychecks" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${employeeInstance?.paychecks?}" var="p">
    <li><g:link controller="employeePaycheck" action="show" id="${p.id}">${p?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="employeePaycheck" action="create" params="['employee.id': employeeInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'employeePaycheck.label', default: 'EmployeePaycheck')])}</g:link>
</li>
</ul>


</div>

