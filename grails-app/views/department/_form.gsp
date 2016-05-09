<%@ page import="cscie56.hrbiz.Department" %>



<div class="fieldcontain ${hasErrors(bean: departmentInstance, field: 'name', 'error')} required">
	<label for="name">
		<g:message code="department.name.label" default="Name" />
		<span class="required-indicator">*</span>
	</label>
	<g:select name="name" from="${departmentInstance.constraints.name.inList}" required="" value="${departmentInstance?.name}" valueMessagePrefix="department.name"/>

</div>

<div class="fieldcontain ${hasErrors(bean: departmentInstance, field: 'company', 'error')} required">
	<label for="company">
		<g:message code="department.company.label" default="Company" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="company" name="company.id" from="${cscie56.hrbiz.Company.list()}" optionKey="id" required="" value="${departmentInstance?.company?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: departmentInstance, field: 'employees', 'error')} ">
	<label for="employees">
		<g:message code="department.employees.label" default="Employees" />
		
	</label>
	
<ul class="one-to-many">
<g:each in="${departmentInstance?.employees?}" var="e">
    <li><g:link controller="employee" action="show" id="${e.id}">${e?.encodeAsHTML()}</g:link></li>
</g:each>
<li class="add">
<g:link controller="employee" action="create" params="['department.id': departmentInstance?.id]">${message(code: 'default.add.label', args: [message(code: 'employee.label', default: 'Employee')])}</g:link>
</li>
</ul>


</div>

