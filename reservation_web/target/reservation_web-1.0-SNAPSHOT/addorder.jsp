<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/21 0021
  Time: 下午 3:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>
    <title>Title</title>
</head>
<style></style>
<body>
<form action="/orderform/addredis">
   <input type="text" value="" hidden><br>
      会议室id<input type="text" value="${meetingroom.id}" name="mid"><br>
    已经预定的时间段有

        <table>
            <tr>
                <td width="160px">开始时间</td>
                <td width="160px">结束时间</td>
                <td width="160px">下单时间</td>
                <td width="160px">付款状态</td>
            </tr>
            <c:forEach  var="order" items="${list}"  >
            <tr>
                <td><fmt:formatDate value="${order.starttime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${order.endtime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                <td><fmt:formatDate value="${order.ordertime}" pattern="yyyy/MM/dd HH:mm:ss"/></td>
                <c:if test="${order.payment.equals('N')}">
                <td>未付款，若15分钟之内还未付款您即可预定此时间段</td>
                </c:if>
                <c:if test="${order.payment.equals('y')}">
                    <td>已付款</td>
                </c:if>
            </tr>

    </c:forEach>
        </table>
      会议室号<input type="text" value="${meetingroom.roomnumber}" disabled="true"><br>
     开始时间<input type="text" value="" name="starttime"><br>
     结束时间<input type="text" value="" name="endtime"><br>
    <input type="submit"value="生成订单">


</form>


</body>
</html>
