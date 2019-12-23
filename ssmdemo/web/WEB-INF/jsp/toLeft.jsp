<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/8/29
  Time: 10:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p>
        <a href="${pageContext.request.contextPath}/user/queryAll" target="main">用户管理</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/gender/toList" target="main">班级管理</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/student/queryStudent" target="main">学生管理</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/student/querySource" target="main">成绩管理</a>
    </p>
    <p>
        <a href="">课程管理</a>
    </p>
    <p>
        <a href="${pageContext.request.contextPath}/user/logOut" target="_top">退出</a>
    </p>
</div>

</body>
</html>
