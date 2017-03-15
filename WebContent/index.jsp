<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="http://ajax.microsoft.com/ajax/jquery/jquery-1.4.min.js"></script>
</head>
<body>
	<a href="${pageContext.request.contextPath }/test.action">测试</a><br/>
	<a href="${pageContext.request.contextPath }/role_list.action">岗位管理</a><br/>
	<a href="${pageContext.request.contextPath }/department_list.action">部门管理</a><br/>
	<a href="${pageContext.request.contextPath }/user_list.action">用户管理</a><br/>
</body>
</html>