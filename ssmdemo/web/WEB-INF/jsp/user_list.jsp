<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/19
  Time: 10:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户管理</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function () {
        $("button[no]").click(function () {
            //获取当前页码
            var no=$(this).attr("no");
            location.href="${pageContext.request.contextPath}/user/queryAll?pageNum="+no;
        })
    })
</script>
<body>
<div align="center">
    <h3>用户管理</h3>
    <a href="${pageContext.request.contextPath}/user/toSave">添加用户</a>
    <table  border="1" cellspacing="0" width="100%">
        <tr>
            <td>id</td>
            <td>用户名</td>
            <td>用户昵称</td>
            <td>Email</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="user">
            <tr>
                <td>${user.id}</td>
                <td>${user.userName}</td>
                <td>${user.nickName}</td>
                <td>${user.mail}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/user/queryById?id=${user.id}">详情</a>
                </td>
            </tr>
        </c:forEach>

    </table>
    <div align="left">
        [
        ${pageInfo.pageNum}
        /
        ${pageInfo.pages}
        ]
    </div>
    <div align="right">
        <button no="1">首页</button>
        <button no="${pageInfo.prePage}">上一页</button>
        <button no="${pageInfo.nextPage}">下一页</button>
        <button no="${pageInfo.pages}">末页</button>
    </div>
</div>
</body>
</html>
