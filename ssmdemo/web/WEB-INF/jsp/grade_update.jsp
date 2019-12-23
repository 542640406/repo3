<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/5
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>班级修改</title>
</head>
<body>
<div align="center">
    <h3>修改</h3>
    <script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#updateButton").click(function () {
                //获取表单数据与
                var data=$("#searchForm").serialize();

                $.post("${pageContext.request.contextPath}/gender/update",
                data,function (result) {
                        if(result=="success"){
                            alert("修改成功");
                            location.href='${pageContext.request.contextPath}/gender/toList';
                        }else{
                            alert("修改失败！");
                        }
                    })
            })
        })
    </script>
    <form id="searchForm">
    <input type="hidden" name="id" value="${grade.id}">
    <p>
        班级名称:<input type="text" name="gradeName" value="${grade.gradeName}"/>
    </p>
    <p>
        创建日期: <fmt:formatDate value="${grade.createDate}"></fmt:formatDate>
    </p>
    <p>
        描述:<textarea cols="18" rows="5"  name="details">
        ${grade.details}
    </textarea>
        <input type="button" id="updateButton" value="修改">
        <input type="reset" value="重置"/>

    </p>
    </form>
</div>
</body>
</html>
