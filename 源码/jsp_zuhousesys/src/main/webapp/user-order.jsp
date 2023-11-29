<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>民宿屋预约</title>
    <link rel="stylesheet" href="css/order.css">
</head>
<body>
<%-- header --%>
<div class="header">
    <div class="headbox">
        <img src="img/logo.png" alt="logo">
    </div>
</div>
<%-- header --%>

<%-- content --%>
<div class="content">
    <%-- order-info --%>
    <div class="order-info-box clearfix">
        <div class="house clearfix">

            <div class="house-img">
                <img src="${requestScope.house.cimg}" alt="">
            </div>

            <div class="house-info">
                <p>${requestScope.house.cname}</p>
                <p>${requestScope.house.cinfo}</p>
            </div>
        </div>

        <div class="store-info">
            <ul class="clearfix">
                <li>
                    <p class="line1"><span class="take"></span>看房</p>
                    <p class="line2"><span class="time"></span>${requestScope.takeTime}</p>
                    <p class="line3"><span class="place"></span>台州 椒江市府大道店</p>
                </li>
                <li>
                    <p class="line1"><span class="get"></span>退订</p>
                    <p class="line2"><span class="time"></span>${requestScope.getTime}</p>
                    <p class="line3"><span class="place"></span>台州 椒江市府大道店</p>
                </li>
            </ul>
        </div>
    </div>
    <%-- order-info --%>

    <%-- check --%>
    <div class="check clearfix">
        <div class="clearfix">
        <dl>
            <dt>费用明细</dt>
            <dd>
                <ul>
                    <li>
                        <span>民宿屋租赁及服务费</span>
                        <span>${requestScope.house.crent*3}</span>
                        <span>${requestScope.house.crent}x3</span>
                    </li>

                    <li>
                        <span>基础服务费</span>
                        <span>100</span>
                        <span>50x2</span>
                    </li>

                    <li>
                        <span>其他费</span>
                        <span>20</span>
                        <span>合计</span>
                    </li>
                </ul>
            </dd>
        </dl>
        </div>
        <div class="total">
            <a href="PutOrderServlet?cid=${house.cid}&crent=${house.crent*3+100+20}&takeTime=${requestScope.takeTime}&getTime=${requestScope.getTime}&cname=${house.cname}">提交订单</a>
            <p>订单总价 <span>￥${requestScope.house.crent*3+100+20}</span></p>
        </div>
    </div>
    <%-- check --%>

</div>
<%-- content --%>

</body>
</html>
