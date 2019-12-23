<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/23
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户详情</title>
</head>
<body>
<center>
    <div>
        <h3>用户详情</h3>
        <table>
            <tr>
                <td>id</td>
                <td>${user.id}</td>
            </tr>
            <tr>
                <td>用户名</td>
                <td>${user.userName}</td>
            </tr>
            <tr>
                <td>用户昵称</td>
                <td>${user.nickName}</td>
            </tr>
            <tr>
                <td>Email</td>
                <td>${user.mail}</td>
            </tr>
            <tr>
                <td>用户照片</td>
                <td>
                    <img src="${pageContext.request.contextPath}/statics/uploadfiles/${user.pic1Path}" style="width: 50px;height: 50px" alt="">
                </td>
            </tr>
            <tr>
                <td>证件照片</td>
                <td>
                    <img src="${pageContext.request.contextPath}/statics/uploadfiles/${user.pic2Path}" style="width: 50px;height: 50px" alt="">
                </td>
            </tr>
        </table>
    </div>
</center>
</body>
</html>
