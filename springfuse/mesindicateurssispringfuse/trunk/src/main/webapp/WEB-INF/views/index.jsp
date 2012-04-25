<%--
 | (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 | Source code generated by Celerio, a Jaxio product
 | Want to use Celerio within your company? email us at info@jaxio.com
 | Follow us on twitter: @springfuse
 | Template pack-mvc-3-sd:src/main/webapp/WEB-INF/views/index.p.vm.jsp
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"
%><%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"
%><%@ taglib prefix="tags" tagdir="/WEB-INF/tags"
%><%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"
%><%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"
%><%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"
%><head>
<title><fmt:message key="homepage.title" /></title>
</head>
<body>
	<div class="span-24 last">
		<h2>
			<fmt:message key="homepage.congratulations.title" />
			<security:authorize ifAllGranted="ROLE_USER">${userContext.username}</security:authorize>
		</h2>
		<p>
			<fmt:message key="homepage.congratulations" />
		</p>
		<h2>
			<fmt:message key="homepage.recommendations.title" />
		</h2>
		<p>
			<fmt:message key="homepage.recommendations" />
		</p>
		<security:authorize ifAllGranted="ROLE_ADMIN">
			<h2><fmt:message key="homepage.your.entities.title" /></h2>
			<ul class="inline">
				<li><a href="${pageContext.request.contextPath}/domain/account/search">account</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/address/search">address</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/book/search">book</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/document/search">document</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/legacy/search">legacy</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/moretypesdemo/search">moreTypesDemo</a></li>
				<li><a href="${pageContext.request.contextPath}/domain/role/search">role</a></li>
			</ul>
		</security:authorize> 
	</div>
	<hr>
	<div class="span-11 border">
		<h2>
			<fmt:message key="homepage.what.next.title" />
		</h2>
		<p>
			<fmt:message key="homepage.what.next" />
		</p>
	</div>
	<div class="span-12 last">
		<h2>
			<fmt:message key="homepage.support.title" />
		</h2>
		<p>
			<fmt:message key="homepage.support" />
		</p>
	</div>
</body>