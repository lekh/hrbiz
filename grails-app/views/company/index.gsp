
<%@ page import="cscie56.hrbiz.Company" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'company.label', default: 'Company')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-company" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-company" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table class="table table-bordered table-striped table-hover">
			<thead>
					<tr>
					
						<g:sortableColumn property="name" title="${message(code: 'company.name.label', default: 'Name')}" />
					
						<g:sortableColumn property="description" title="${message(code: 'company.description.label', default: 'Description')}" />
					
						<g:sortableColumn property="domainName" title="${message(code: 'company.domainName.label', default: 'Domain Name')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${companyInstanceList}" status="i" var="companyInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${companyInstance.id}">${fieldValue(bean: companyInstance, field: "name")}</g:link></td>
					
						<td>${fieldValue(bean: companyInstance, field: "description")}</td>
					
						<td>${fieldValue(bean: companyInstance, field: "domainName")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${companyInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
