<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 3:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

    <table>
        <tr>
            <th>id</th>
            <th>房间号码</th>
            <th>状态</th>
            <th>操作</th>
        </tr>
        <c:forEach  items="${meetingrooms}" var="meeting">
            <tr>
                <td>${meeting.id}</td>
                <td>${meeting.roomnumber}</td>
                <td>${meeting.reservationStatus}</td>
                <td><a id="a1" href="javascript:add(${meeting.id})">加入订单</a></td>
            </tr>
        </c:forEach>
    </table>




</body>
<script src="/js/jquery-3.3.1.js"></script>
<script>
        function add(id) {

            location.href = "${pageContext.request.contextPath}/meeting/findById?id="+ id;
        }




</script>
</html>
