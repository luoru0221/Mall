<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/orderlist.css">
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到1号店！</div>
        <div class="fr">
            <div class="login_btn fl">
                <c:if test="${sessionScope.loginId == null}">
                    <a href="login.jsp">登录</a>
                </c:if>
                <c:if test="${sessionScope.loginId != null}">
                    <a href="usercenter.jsp">欢迎${sessionScope.loginId}</a>
                </c:if>
                <span>|</span>
                <a href="register.jsp">注册</a>
            </div>
            <div class="user_link fl">
                <c:if test="${sessionScope.loginId != null}">
                    <span>|</span>
                    <a href="usercenter.jsp">用户中心</a>
                    <span>|</span>
                    <a href="cartLoad?userId=${sessionScope.loginId}">我的购物车</a>
                    <span>|</span>
                    <a href="orderList">我的订单</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="search_bar priority">
    <a href="index.jsp" class="logo fl"><img src="images/logo03.png" alt="logo"></a>
    <div class="sub_page_name fl">|&nbsp;&nbsp;&nbsp;我的订单</div>
    <div class="search_con fr">
        <label>
            <input type="text" class="input_text fl" name="" placeholder="搜索商品">
        </label>
        <input type="button" class="input_btn fr" name="" value="搜索">
    </div>
</div>

<div class="main_con">
    <div class="total_count">全部订单</div>
    <c:forEach var="order" items="${requestScope.orders}">
        <div class="order_list">
            <ul class="cart_list_th priority">
                <li class="col01">订单编号：${order.key}</li>
                <li class="col02">总价：</li>
            </ul>
            <c:forEach var="orderItem" items="${order.value}">
                <ul class="order_list_td priority">
                    <li class="order_image fl"><img alt="image" src=${orderItem.product.image}></li>
                    <li class="order_name fl">${orderItem.product.name}</li>
                    <li class="order_price fl">￥${orderItem.product.price}</li>
                    <li class="order_number fl">${orderItem.number}</li>
                    <li class="order_total_price fl">￥${orderItem.product.price*orderItem.number}</li>
                    <li class="order_operation fr"><a class="operation" href="javascript:">发货</a></li>
                </ul>
            </c:forEach>
        </div>
    </c:forEach>
</div>

<div class="footer">
    <div class="foot_link">
        <a href="#">关于我们</a>
        <span>|</span>
        <a href="#">联系我们</a>
        <span>|</span>
        <a href="#">招聘人才</a>
        <span>|</span>
        <a href="#">友情链接</a>
    </div>
    <p>CopyRight © 2019 吉首大学CCW</p>
    <p>电话：0730-****888 湘ICP备*******8号</p>
</div>

</body>
</html>