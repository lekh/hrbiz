<%@ page import="cscie56.hrbiz.EmployeeAddress" %>



<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'address1', 'error')} ">
	<label for="address1">
		<g:message code="employeeAddress.address1.label" default="Address1" />
		
	</label>
	<g:textField name="address1" value="${employeeAddressInstance?.address1}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'city', 'error')} required">
	<label for="city">
		<g:message code="employeeAddress.city.label" default="City" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="city" required="" value="${employeeAddressInstance?.city}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'state', 'error')} required">
	<label for="state">
		<g:message code="employeeAddress.state.label" default="State" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="state" required="" value="${employeeAddressInstance?.state}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'zipCode', 'error')} required">
	<label for="zipCode">
		<g:message code="employeeAddress.zipCode.label" default="Zip Code" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="zipCode" required="" value="${employeeAddressInstance?.zipCode}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'address2', 'error')} required">
	<label for="address2">
		<g:message code="employeeAddress.address2.label" default="Address2" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="address2" required="" value="${employeeAddressInstance?.address2}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeeAddressInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="employeeAddress.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${cscie56.hrbiz.Employee.list()}" optionKey="id" required="" value="${employeeAddressInstance?.employee?.id}" class="many-to-one"/>

</div>

