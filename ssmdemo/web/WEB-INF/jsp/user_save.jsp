<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/21
  Time: 8:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
    $(function () {
        var errorInfo=$("#errorInfo").val();
        if(errorInfo!=null||errorInfo!=""){
            $("input[name='pic']").next().html(errorInfo);
        }
    })
</script>
<body>
<center>
    <form action="${pageContext.request.contextPath}/user/saveUser" method="post" enctype="multipart/form-data">
        <table>
            <tr>
                <td>用户名：</td>
                <td><input type="text" name="userName"></td>
            </tr>
            <tr>
                <td>用户密码：</td>
                <td><input type="password" name="password"></td>
            </tr>
            <tr>
                <td>用户昵称：</td>
                <td><input type="text" name="nickName"></td>
            </tr>
            <tr>
                <td>用户邮箱：</td>
                <td><input type="text" name="mail"></td>
            </tr>
            <tr>
                <td>用户照片：</td>
                <td>
                    <input type="file" name="pic">
                    <font color="red">
                        * 上传文件大小不能超过500B
                        * 上传文件类型必须为：.jpg、jpeg、png
                    </font>
                    <input type="hidden" id="errorInfo" value="${errorInfo}">
                </td>
            </tr>

            <tr>
                <td><input type="submit" value="保存"></td>
                <td><input type="reset" value="重置"></td>
            </tr>
        </table>
    </form>
</center>
</body>
</html>
