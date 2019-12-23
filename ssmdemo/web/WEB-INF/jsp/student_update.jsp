<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/11
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩修改</title>
</head>
<body>
<center>
    <div style="width: 500px">
        <h2>成绩修改</h2>
        <form action="${pageContext.request.contextPath}/student/updateSource" method="post">
            <input type="hidden" value="${vo.id}" name="id">
            <p>学生姓名:${vo.studentName}</p>
            <p>课程名称:${vo.courseName}</p>
            <p>成绩:<input type="text" name="score" value="${vo.score}"></p>
            <p><input type="submit" value="保存"></p>
        </form>
    </div>
    </center>
</body>
</html>
