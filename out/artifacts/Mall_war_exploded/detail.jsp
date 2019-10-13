<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="fun" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>1号店-商品详情</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/detail.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/detail.js"></script>
    <script type="text/javascript" src="js/cart.js"></script>
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到1号店!</div>
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
<!--空白填充-->
<div class="block_div">
    <div class="block_div_bottom"></div>
    <div></div>
</div>
<div class="goods_detail_con priority">
    <div class="goods_detail_pic fl"><img alt="image" src=${requestScope.product["image"]}></div>
    <div class="goods_detail_wrap fr">
        <ul class="goods_detail_tab priority">
            <li class="active">购&nbsp;&nbsp;&nbsp;&nbsp;买</li>
            <li>商品详情</li>
            <li>商品评价</li>
        </ul>
        <!-- 导航底部内容-->
        <div class="tab_content checked"><!--购买-->
            <div class="tab_content_buy">
                <h3>${requestScope.product["name"]}</h3>
                <div class="goods_num priority">
                    <div class="num_name fl">数量:</div>
                    <div class="num_add fl">
                        <label>
                            <input class="fl num_show" type="text" value="1">
                        </label>
                        <a href="javascript:" class="add fr">+</a>
                        <a href="javascript:" class="minus fr">-</a>
                    </div>
                </div>
                <div class="total_price">
                    总价：
                    <em>￥${requestScope.product["price"]}</em>
                </div>
                <div class="operate_btn">
                    <a href="javascript:" class="buy_btn">立即购买</a>
                    <c:if test="${sessionScope.loginId == null}">
                        <a href="javascript:" class="add_cart_btn" onclick="addToCart('',${requestScope.product['id']})">加入购物车</a>
                    </c:if>
                    <c:if test="${sessionScope.loginId != null}">
                        <a href="javascript:" class="add_cart_btn" onclick="addToCart('${sessionScope.loginId}',${requestScope.product['id']})">加入购物车</a>
                    </c:if>
                </div>
            </div>
        </div>

        <div class="tab_content"><!--商品详情-->
            <dl>
                <dt>商品详情</dt>
                <dd>${requestScope.product['description']}</dd>
            </dl>
        </div>

        <div class="tab_content"><!--商品评价-->
            <ul class="judge_list_con">
                <li>
                    <b class="user_name">罗汝</b>
                    <div class="judge_detail">
                        "派送非常快，第二天上午就收到。2天使用初步总结，前一部手机也是华为P9plus.MATE10pro包装原封未拆精致大气。拆开后第一眼就看到宝石蓝的手机，非常惊艳；然后就是配件一应俱全。开机各方面设置，把通讯录、短信等同步好，同品牌手机同步很快。和P9plus一样的后置指纹识别很方便。录制指纹容易，解锁非常快，秒开！屏幕完好，默认分辨率显示效果很好。"
                    </div>
                </li>
                <li>
                    <b class="user_name">罗汝</b>
                    <div class="judge_detail">
                        "派送非常快，第二天上午就收到。2天使用初步总结，前一部手机也是华为P9plus.MATE10pro包装原封未拆精致大气。拆开后第一眼就看到宝石蓝的手机，非常惊艳；然后就是配件一应俱全。开机各方面设置，把通讯录、短信等同步好，同品牌手机同步很快。和P9plus一样的后置指纹识别很方便。录制指纹容易，解锁非常快，秒开！屏幕完好，默认分辨率显示效果很好。"
                    </div>
                </li>
                <li>
                    <b class="user_name">罗汝</b>
                    <div class="judge_detail">
                        "派送非常快，第二天上午就收到。2天使用初步总结，前一部手机也是华为P9plus.MATE10pro包装原封未拆精致大气。拆开后第一眼就看到宝石蓝的手机，非常惊艳；然后就是配件一应俱全。开机各方面设置，把通讯录、短信等同步好，同品牌手机同步很快。和P9plus一样的后置指纹识别很方便。录制指纹容易，解锁非常快，秒开！屏幕完好，默认分辨率显示效果很好。"
                    </div>
                </li>
            </ul>
        </div>
    </div>
</div>
<div class="footer priority">
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
