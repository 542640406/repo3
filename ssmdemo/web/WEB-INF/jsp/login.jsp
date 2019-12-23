<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/8/24
  Time: 11:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div align="center">
    <div>登录</div>
    <div>
        <form action="${pageContext.request.contextPath}/user/loginUser" method="post">
            <table>
                <tr>
                    <td>用户名：</td>
                    <td><input type="text" name="userName"></td>
                </tr>
                <tr>
                    <td>
                        密码：
                    </td>
                    <td>
                        <input type="password" name="password"/>

                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="登录"/></td>
                    <td></td>
                </tr>
            </table>
        </form>
    </div>
    <div>${message}</div>
</div>
</body>
</html>
