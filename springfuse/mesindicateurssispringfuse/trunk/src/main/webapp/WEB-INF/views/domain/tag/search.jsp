<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3-sd:src/main/webapp/WEB-INF/views/domain/search.e.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
	<title><fmt:message key="tag" />: <fmt:message key="crud.functionalities.example" /></title>
</head>
<body>
	<span class="ui-state-highlight button button-search"><fmt:message key="tag" /></span> 
	<a href="${pageContext.request.contextPath}/domain/tag/create" class="button button-create"><fmt:message key="crud.functionalities.create" /></a> 
	<a href="${pageContext.request.contextPath}/domain/tag/showcase" class="button button-create"><fmt:message key="crud.functionalities.showcase" /></a>

	<form:form action="${pageContext.request.contextPath}/domain/tag/list" modelAttribute="tagSearchForm" class="search">
		<table class="show">
			<tbody>
				<tr>
					<th><fmt:message key="tag_name" /></th>
					<td>
						<form:input path="tag.name"/>
						<form:errors path="tag.name" cssClass="error"/>
					</td>
				</tr>
			</tbody>
			<tfoot>
				<tr>
					<td colspan="2">
						<input type="submit" class="button button-search" value="<fmt:message key="crud.search.button" />"/>
					</td>
				</tr>
			</tfoot>
		</table>
	</form:form>
	<div id="result"/>
</body>
