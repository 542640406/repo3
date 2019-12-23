<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/4
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>班级管理</title>
</head>
<script src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js" type="text/javascript"></script>
<script>
    $(function () {
        $("button[no]").click(function () {
            //获取no值

            var no = $(this).attr("no");
            var url = location.href;
            // localhost:8080/grade/toList?pageNum=1&pageName=003
            var urlArray = url.split("?");
            var url1 = urlArray[0];
            //序列化查询表单
            var data = $("#searchForm").serialize();
            location.href = url1 + "?pageNum=" + no + "&" + data;
        });
        $("button[name='query']").click(function () {
            var id = $(this).attr("queryId");
            location.href = '${pageContext.request.contextPath}/gender/queryGradeById?id=' + id + '&open=query';
        })
        $("button[name='update']").click(function () {
            var id = $(this).attr("queryId");
            location.href = '${pageContext.request.contextPath}/gender/queryGradeById?id=' + id + '&open=update';
        })
        //删除
        $("button[name='delete']").click(function () {
            var id = $(this).attr("queryId");
            $.post("${pageContext.request.contextPath}/gender/delete", "id=" + id, function (result) {
                if (result == "success") {
                    alert("删除成功");
                    location.href = '${pageContext.request.contextPath}/gender/toList';
                } else {
                    alert("删除失败！");
                }
            });
        })
        //添加班级
        $("#saveButton").click(function () {
            location.href = '${pageContext.request.contextPath}/gender/toSave';
        })
    })
</script>
<body>
<div align="center">
    <h3>班级管理</h3>
    <form action="${pageContext.request.contextPath}/gender/toList" method="post" id="searchForm">
        班级名称：<input type="text" name="gradeName" value="${gradeName}"/>
        <input type="submit" value="查询"/>
    </form>
    <div>
        <p>
            <button id="saveButton">添加</button>
        </p>
    </div>
    <table border="1" cellspacing="0" width="100%">
        <tr>
            <td>id</td>
            <td>班级名称</td>
            <td>创建时间</td>
            <td>操作</td>
        </tr>
        <c:forEach items="${pageInfo.list}" var="grade">
            <tr>
                <td>${grade.id}</td>
                <td>${grade.gradeName}</td>
                <td>
                        <%--使用fmt标签的formatData转换日期类型--%>
                    <fmt:formatDate value="${grade.createDate}" pattern="yyyy-MM-dd"></fmt:formatDate>
                </td>
                <td>
                    <button name="query" queryId="${grade.id}">详情</button>
                    <button name="update" queryId="${grade.id}">修改</button>
                    <button name="delete" queryId="${grade.id}">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
    <%--显示当前页码和总页数--%>
    <div align="left">
        [
        ${pageInfo.pageNum}/${pageInfo.pages}
        ]
    </div>
</div>
<%--页面控制--%>
<div align="right">
    <button no="1">首页</button>
    <button no="${pageInfo.prePage}">上一页</button>
    <button no="${pageInfo.nextPage}">下一页</button>
    <button no="${pageInfo.pages}">末页</button>
</div>
</body>
</html>
