<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/8/27
  Time: 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>学生管理</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js" type="text/javascript"></script>
<script>
    $(function () {
        //获取到查询条件
    //select赋值

    $("select[name='gender']").val(${gender});

    $("button[no]").click(function () {
        //要跳转的页面
        var no = $(this).attr("no");
        var data = $("form").serialize();
        location.href = "${pageContext.request.contextPath}/student/queryStudent?" + data + "&pageNum=" + no;

    })
    })
</script>
<body>
<center>
<div style="width: 500px">
    <h2>学生管理</h2>
    <form action="${pageContext.request.contextPath}/student/queryStudent" method="post">
        性别:<select name="gender">
        <option value="-1">请选择</option>
        <option value="0">男</option>
        <option value="1">女</option>
    </select>
        <input type="submit" value="查询">
    </form>
    <table border="1">
        <tr>
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
        </tr>
        <c:forEach var="page" items="${pageInfo.list}">
            <tr>
                <td>${page.id}</td>
                <td>${page.studentName}</td>
                <td>
                    <c:if test="${page.gender==0}">男</c:if>
                    <c:if test="${page.gender==1}">女</c:if>
                </td>
            </tr>

        </c:forEach>
    </table
</div>
<div align="left">
    [
    ${pageInfo.pageNum}
    /
    ${pageInfo.pages}]
</div>
<div align="right">
    <button no="1">首页</button>
    <button no="${pageInfo.prePage}">上一页</button>
    <button no="${pageInfo.nextPage}">下一页</button>
    <button no="${pageInfo.pages}">末页</button>
</div>
</center>
</body>
</html>
