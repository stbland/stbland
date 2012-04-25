<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3-sd:src/main/webapp/WEB-INF/views/domain/create.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="spring" uri="http://www.springframework.org/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="tags" />: <fmt:message key="crud.functionalities.create" /></title>
</head>
<body>
	<a href="${pageContext.request.contextPath}/domain/tags/search" class="ajaxy button button-search"><fmt:message key="tags" /></a>
	<span class="ui-state-highlight button button-create"><fmt:message key="crud.functionalities.create" /></span>
	<form:form action="${pageContext.request.contextPath}/domain/tags/create" modelAttribute="tags" method="POST">
		<form:errors cssClass="error"/>
		<table class="create">
			<tbody>
				<tr>
					<th><fmt:message key="tags_name" /></th>
					<td>
						<form:input path="name" cssClass="{maxlength: 56}" maxlength="56" size="100"/>
						<form:errors path="name" cssClass="error"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="button button-save" value="<fmt:message key="crud.save.button" />"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
</body>
