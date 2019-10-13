<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/list.css">
    <script type="text/javascript" src="js/cart.js"></script>
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
    <div class="search_con fl">
        <label>
            <input type="text" class="input_text fl" name="" placeholder="搜索商品">
        </label>
        <input type="button" class="input_btn fr" name="" value="搜索">
    </div>
    <div class="guest_cart fr">
        <c:if test="${sessionScope.loginId != null}">
            <a class="cart_name fl" href="cartLoad?userId=${sessionScope.loginId}">我的购物车</a>
            <div class="goods_count fl" id="show_count"></div>
        </c:if>
    </div>
</div>
<div class="navbar_con">
    <div class="navbar">
        <h1 class="fl">全部商品分类</h1>
    </div>
</div>
<div class="center_con priority">
    <ul class="subnav fl">
        <li><a href="" class="phone">手机数码</a></li>
        <li><a href="" class="computer">电脑办公</a></li>
        <li><a href="" class="makeup">美妆护理</a></li>
        <li><a href="" class="clothes">家居家装</a></li>
        <li><a href="" class="electric">生活电器</a></li>
        <li><a href="" class="food">食品零食</a></li>
    </ul>
    <div class="warp fr">
        <ul class="goods_list">
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
            <li>
                <a href=""><img src="" alt="img"></a>
                <h4><a href="">什么东西</a></h4>
                <div class="price">价格</div>
            </li>
        </ul>
    </div>
    <div class="pagenation fr">
        <a href="#">&lt上一页</a>
        <a href="#" class="active">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
        <a href="#">4</a>
        <a href="#">5</a>
        <a href="#">下一页&gt</a>
    </div>
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