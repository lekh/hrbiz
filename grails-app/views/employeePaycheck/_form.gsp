<%@ page import="cscie56.hrbiz.EmployeePaycheck" %>



<div class="fieldcontain ${hasErrors(bean: employeePaycheckInstance, field: 'employee', 'error')} required">
	<label for="employee">
		<g:message code="employeePaycheck.employee.label" default="Employee" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="employee" name="employee.id" from="${cscie56.hrbiz.Employee.list()}" optionKey="id" required="" value="${employeePaycheckInstance?.employee?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeePaycheckInstance, field: 'grossPay', 'error')} required">
	<label for="grossPay">
		<g:message code="employeePaycheck.grossPay.label" default="Gross Pay" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="grossPay" type="number" value="${employeePaycheckInstance.grossPay}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeePaycheckInstance, field: 'netPay', 'error')} required">
	<label for="netPay">
		<g:message code="employeePaycheck.netPay.label" default="Net Pay" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="netPay" type="number" value="${employeePaycheckInstance.netPay}" required=""/>

</div>

<div class="fieldcontain ${hasErrors(bean: employeePaycheckInstance, field: 'payDate', 'error')} required">
	<label for="payDate">
		<g:message code="employeePaycheck.payDate.label" default="Pay Date" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="payDate" precision="day"  value="${employeePaycheckInstance?.payDate}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: employeePaycheckInstance, field: 'taxAmount', 'error')} required">
	<label for="taxAmount">
		<g:message code="employeePaycheck.taxAmount.label" default="Tax Amount" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="taxAmount" type="number" value="${employeePaycheckInstance.taxAmount}" required=""/>

</div>

