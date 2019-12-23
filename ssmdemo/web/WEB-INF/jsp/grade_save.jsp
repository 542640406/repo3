<%--
  Created by IntelliJ IDEA.
  User: zxy
  Date: 2019/9/7
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加班级</title>
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/statics/js/jquery-1.12.4.js"></script>

<body>
<div align="center">
    <h3>添加班级</h3>
    <script type="text/javascript">
        $(function () {
            //保存的单机事件
            $("input[type='button']").click(function () {
                //获取数据
                var data=$("#saveForm").serialize();
                //发起请求
                $.post("${pageContext.request.contextPath}/gender/save",
                    data,function (result) {
                        if(result=="success"){
                            alert("添加成功");
                            location.href='${pageContext.request.contextPath}/gender/toList';
                        }else{
                            alert("添加失败！");
                        }
                    })
            })
        })
    </script>
</div>
<div align="center">
    <form id="saveForm">
        <p>
            班级名称：<input type="text" name="gradeName">
        </p>
        <p>
            班级描述：
            <textarea rows="3" cols="15" name="details"></textarea>
        </p>
        <p>
            <input type="reset" value="重置"/><input type="button" value="保存">
        </p>
    </form>
</div>
</body>
</html>
