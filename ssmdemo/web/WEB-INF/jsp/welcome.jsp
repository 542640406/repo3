<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/8/24
  Time: 11:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <title>Title</title>
</head>
<frameset rows="20%,*">
    <frame src="${pageContext.request.contextPath}/toTop" frameborder="1">
    <frameset cols="20%,*">
        <frame src="${pageContext.request.contextPath}/toLeft" frameborder="1">
        <frame src="${pageContext.request.contextPath}/toMain" frameborder="1" name="main">
    </frameset>
</frameset>
<body>

</body>
</html>
