<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/usercenter.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/usercenter.js"></script>
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
                    <a href="">我的订单</a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<div class="user_header">
    <div class="wrap">
        <a href="" class="wrap_logo">
            <img src="images/logo04.png" alt="">
        </a>
    </div>
</div>
<div class="main_con priority">
    <div class="left_menu priority">
        <h3>个人中心</h3>
        <ul id="menu">
            <li class="nav_item active">个人信息</li>
            <li class="nav_item">地址管理</li>
            <li class="nav_item">我的订单</li>
        </ul>
    </div>

    <div class="right_content priority con_active">
        <!--用户个人信息-->
        <div class="content user_information priority con_active">
            <h3 class="content_title">个人信息</h3>
            <div class="basic_information fl">
                <div class="information_item">
                    <label for="userId">ID：</label>
                    <label id="userId">${sessionScope.loginId}</label><br>
                </div>
                <div class="information_item">
                    <label for="name">用户名：</label>
                    <input type="text" id="name"><br>
                </div>
                <div class="information_item">
                    <label for="email">邮箱：</label>
                    <input type="text" id="email"><br>
                </div>
                <div class="information_item">
                    <label for="code">验证码：</label>
                    <input type="text" id="code">
                    <button id="get_msg_code">获取验证码</button>
                </div>
            </div>
            <div class="other_information fr">
                <div class="information_item">
                    <label for="old_password">原始密码：</label>
                    <input type="password" id="old_password" placeholder="若需修改信息，请填写密码"><br>
                </div>
                <div class="information_item">
                    <label for="new_password">新密码：</label>
                    <input type="password" id="new_password" placeholder="需要修改密码时才填写"><br>
                </div>
                <div class="information_item">
                    <label for="con_password">确认密码：</label>
                    <input type="password" id="con_password" placeholder="需要修改密码时才填写"><br>
                </div>
                <div class="information_item">
                    <button id="submit" class="fr">提交</button>
                    <br>
                </div>
            </div>
        </div>

        <!--地址管理-->
        <div class="content address_manager priority">
            <h3 class="content_title">地址管理</h3>
            <ul class="address">
                <!--已经存在的地址-->
            </ul>
            <div class="add_address"><!--添加新地址-->
                <a href="">+添加新地址</a>
            </div>
            <div class="add_address_operation">

            </div>
        </div>

        <!--我的订单-->
        <div class="content my_order priority">
            <h3 class="content_title">我的订单</h3>

        </div>
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



