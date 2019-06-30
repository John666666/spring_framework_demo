<%--
  Created by IntelliJ IDEA.
  User: john
  Date: 2019/6/26
  Time: 9:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>

    Hello World!

    <br />

    <ul>
        <li><a href="/login?age=21&nickname=三哥">测试</a></li>
    </ul>

    <hr />
    测试多DispatcherServlet, （需要启用web.xml.multi_dispatcherServlet）
    <ul>
        <li><a href="/order/query">查询所有订单</a></li>
        <li><a href="/goods/query">查询所有商品</a></li>
    </ul>

</body>
</html>
