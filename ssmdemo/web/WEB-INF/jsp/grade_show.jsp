<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/5
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>详情信息</title>
</head>
<body>
    <div align="center">
        <table>
            <tr>
                <td>班级名称</td>
                <td>创建日期</td>
                <td>描述</td>
            </tr>
            <tr>
                <td>${grade.gradeName}</td>
                <td>
                    <fmt:formatDate value="${grade.createDate}"></fmt:formatDate>
                </td>
                <td>${grade.details}</td>
            </tr>
        </table>
    </div>
</body>
</html>
