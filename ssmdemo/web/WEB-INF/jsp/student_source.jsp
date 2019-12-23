<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/11
  Time: 19:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩管理</title>
</head>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function () {
        $("button[no]").click(function () {
            //获取button的值想controller传入页码
            var no=$(this).attr("no");
            //要跳转的页面
            location.href="${pageContext.request.contextPath}/student/querySource?pageNum="+no;
        })
        $("button[name='update']").click(function () {
            var id = $(this).attr("queryId");
            location.href = '${pageContext.request.contextPath}/student/queryById?sid='+ id;
        })
        $("button[name='delete']").click(function () {
            var id=$(this).attr("queryId");
            $.post("${pageContext.request.contextPath}/student/delSource?id="+id,function (result) {
                if(result=="success"){
                    alert("删除成功！");
                    location.href="${pageContext.request.contextPath}/student/querySource";
                }else{
                    alert("删除失败");
                }
            })
        })
    })
</script>
<body>
<center>
    <div style="width: 500px">
        <h2>成绩管理</h2>
        <table border="1">
            <tr>
                <td>id</td>
                <td>学生姓名</td>
                <td>课程名称</td>
                <td>成绩</td>
                <td>操作</td>
            </tr>
            <c:forEach var="page" items="${pageInfo.list}">
                <tr>
                    <td>${page.id}</td>
                    <td>${page.studentName}</td>
                    <td>${page.courseName}</td>
                    <td>${page.score}</td>
                    <td>
                        <button name="update" queryId="${page.id}">修改</button>
                        <button name="delete" queryId="${page.id}">删除</button>
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
