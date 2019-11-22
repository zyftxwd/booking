<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/22 0022
  Time: 上午 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<style>
    td{
        text-align: center;
    }
</style>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table>
    <tr><th>id</th>
        <th width="150px">下单时间</th>
        <th width="150px">会议室id</th>
        <th width="150px">预定时间</th>
        <th width="150px">结束时间</th>
        <th width="150px">付款状态</th>
    </tr>
    <c:forEach var="page" items="${orderforms}">

        <tr><td>${page.id}</td>
            <td> <fmt:formatDate value="${page.ordertime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td>${page.mid}</td>
            <td><fmt:formatDate value="${page.starttime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td><fmt:formatDate value="${page.endtime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
            <td>${page.payment}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
