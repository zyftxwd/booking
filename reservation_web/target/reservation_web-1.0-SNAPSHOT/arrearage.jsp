<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 3:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<style>
    th,td{
        width: 200px;
        text-align: center;
        text-align: center;
    }
</style>

<body>
<script src="/js/jquery-2.1.1.min.js"></script>
<table>
    <tr><th>订单号</th>
        <th>下单时间</th>
        <th>会议室id</th>
        <th>预定时间</th>
        <th>结束时间</th>
        <th>付款状态</th>
        <th>操作</th>
    </tr>
    <c:forEach var="page" items="${page}">

        <tr><td>${page.uuid}</td>
        <td>${page.orderform.mid}</td>
        <td><fmt:formatDate value="${page.orderform.ordertime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
        <td><fmt:formatDate value="${page.orderform.starttime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
        <td><fmt:formatDate value="${page.orderform.endtime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
        <td>${page.orderform.payment}</td>
        <td><a id="a1" href="${pageContext.request.contextPath}/orderform/findorder?uuid=${page.uuid}">付款</a></td>
    </tr>
    </c:forEach>
</table>
</body>

<script>

</script>
</html>
