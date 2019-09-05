<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>Mall-首页</title>
    <link rel="stylesheet" type="text/css" href="css/reset.css">
    <link rel="stylesheet" type="text/css" href="css/main.css">
    <link rel="stylesheet" type="text/css" href="css/index.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>

</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到1号店！</div>
        <div class="fr">
            <div class="login_info fl">
                欢迎您：<em>张 山</em>
            </div>
            <div class="login_btn fl">
                <a href="login.jsp">登录</a>
                <span>|</span>
                <a href="register.jsp">注册</a>
            </div>
            <div class="user_link fl">
                <span>|</span>
                <a href="">用户中心</a>
                <span>|</span>
                <a href="cart.jsp">我的购物车</a>
                <span>|</span>
                <a href="">我的订单</a>
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
        <a href="cart.jsp" class="cart_name fl">我的购物车</a>
        <div class="goods_count fl" id="show_count">2</div>
    </div>
</div>
<div class="navbar_con">
    <div class="navbar">
        <h1 class="fl">全部商品分类</h1>
    </div>
</div>
<div class="center_con priority">
    <ul class="subnav fl">
        <li><a href="#model01" class="phone">手机数码</a></li>
        <li><a href="#model02" class="computer">电脑办公</a></li>
        <li><a href="#model03" class="makeup">美妆护理</a></li>
        <li><a href="#model04" class="clothes">家居家装</a></li>
        <li><a href="#model05" class="electric">生活电器</a></li>
        <li><a href="#model06" class="food">食品零食</a></li>
    </ul>
    <div class="slide fl">
        <ul class="slide_pics">
            <li><img src="images/slide01.jpg" alt="幻灯片"></li>
            <li><img src="images/slide02.jpg" alt="幻灯片"></li>
            <li><img src="images/slide03.jpg" alt="幻灯片"></li>
            <li><img src="images/slide04.jpg" alt="幻灯片"></li>
        </ul>
        <div class="prev"></div>
        <div class="next"></div>
        <ul class="points"></ul>
    </div>
    <div class="adv fl">
        <a href="#"><img src="images/adv01.jpg" alt="image"></a>
        <a href="#"><img src="images/adv02.jpg" alt="image"></a>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model01">手机数码</h3>
        <div class="subtitle fl"></div>
        <a href="#" class="goods_more fr" id="fruit_more">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner01.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">华为P30 Pro</a></h4>
                <a href="#"><img src="images/goods/phone01.jpg" alt="image"></a>
                <div class="prize">¥4988</div>
            </li>
            <li>
                <h4><a href="#">Redmi Note7 Pro</a></h4>
                <a href="#"><img src="images/goods/phone02.png" alt="image"></a>
                <div class="prize">¥1399</div>
            </li>
            <li>
                <h4><a href="#">vivo iQOO Neo</a></h4>
                <a href="#"><img src="images/goods/phone03.jpg" alt="image"></a>
                <div class="prize">¥1798</div>
            </li>
            <li>
                <h4><a href="#">honor/荣耀 荣耀9x</a></h4>
                <a href="#"><img src="images/goods/phone04.jpg" alt="image"></a>
                <div class="prize">¥1599.00</div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model02">电脑办公</h3>
        <div class="subtitle fl">
        </div>
        <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner02.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">Lenovo/联想 拯救者 Y7000</a></h4>
                <a href="#"><img src="images/goods/computer01.jpg" alt="image"></a>
                <div class="prize">¥ 5099.00</div>
            </li>
            <li>
                <h4><a href="#">Asus/华硕灵耀S2代S5300FN</a></h4>
                <a href="#"><img src="images/goods/computer02.jpg" alt="image"></a>
                <div class="prize">¥ 7999.00</div>
            </li>
            <li>
                <h4><a href="#">HP/惠普 暗影精灵</a></h4>
                <a href="#"><img src="images/goods/computer03.jpg" alt="image"></a>
                <div class="prize">¥ 7599.00</div>
            </li>
            <li>
                <h4><a href="#">联想小新Air13</a></h4>
                <a href="#"><img src="images/goods/computer04.jpg" alt="image"></a>
                <div class="prize">¥ 5499.00</div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model03">美妆护理</h3>
        <div class="subtitle fl"></div>
        <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner03.png" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">兰蔻粉水清滢柔肤水</a></h4>
                <a href="#"><img src="images/goods/makeup01.jpg" alt="image"></a>
                <div class="prize">¥ 420.00</div>
            </li>
            <li>
                <h4><a href="#">CHANEL 香奈儿炫亮魅力唇膏丝绒系列 哑光口红</a></h4>
                <a href="#"><img src="images/goods/makeup02.jpg" alt="image"></a>
                <div class="prize">¥ 320.00</div>
            </li>
            <li>
                <h4><a href="#">NYX定妆喷雾SETTING SPRAY雾面光面哑光女持久定妆水</a></h4>
                <a href="#"><img src="images/goods/makeup03.jpg" alt="image"></a>
                <div class="prize">¥ 98.00</div>
            </li>
            <li>
                <h4><a href="#">雅诗兰黛小棕瓶抗蓝光眼霜15ml 淡化细纹黑眼圈 补水保湿</a></h4>
                <a href="#"><img src="images/goods/makeup04.jpg" alt="image"></a>
                <div class="prize">¥ 510.00</div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model04">家居家装</h3>
        <div class="subtitle fl"></div>
        <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner04.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">花花公子青少年衣服男士短袖t恤</a></h4>
                <a href="#"><img src="images/goods/clothes01.jpg" alt="image"></a>
                <div class="prize">¥ 258.00</div>
            </li>
            <li>
                <h4><a href="#">乐町可爱连帽短外套</a></h4>
                <a href="#"><img src="images/goods/clothes02.jpg" alt="image"></a>
                <div class="prize">¥ 489.00</div>
            </li>
            <li>
                <h4><a href="#">北极绒纯棉四件套全棉床品夏季床上用品宿舍被套床单三件套北欧风</a></h4>
                <a href="#"><img src="images/goods/clothes03.jpg" alt="image"></a>
                <div class="prize">¥ 530.00</div>
            </li>
            <li>
                <h4><a href="#">Daphne/达芙妮新款白色小背包韩版大铆钉休闲双肩包</a></h4>
                <a href="#"><img src="images/goods/clothes04.jpg" alt="image"></a>
                <div class="prize">¥ 399.00</div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model05">生活电器</h3>
        <div class="subtitle fl"></div>
        <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner05.jpg" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">Skyworth/创维 55M1</a></h4>
                <a href="#"><img src="images/goods/electric01.jpg" alt="image"></a>
                <div class="prize">¥ 2199.00</div>
            </li>
            <li>
                <h4><a href="#">Haier/海尔 BCD-160TMPQ双开门两门小型家用冰箱</a></h4>
                <a href="#"><img src="images/goods/electric02.jpg" alt="image"></a>
                <div class="prize">¥ 1399.00</div>
            </li>
            <li>
                <h4><a href="#">Gree/格力KFR-35GW/NhBaD3大1.5匹空调</a></h4>
                <a href="#"><img src="images/goods/electric03.jpg" alt="image"></a>
                <div class="prize">¥ 3149.00</div>
            </li>
            <li>
                <h4><a href="#">小米无线吸尘器家用小型吸尘器</a></h4>
                <a href="#"><img src="images/goods/electric04.png" alt="image"></a>
                <div class="prize">¥ 1299.00</div>
            </li>
        </ul>
    </div>
</div>

<div class="list_model">
    <div class="list_title priority">
        <h3 class="fl" id="model06">食品零食</h3>
        <div class="subtitle fl"></div>
        <a href="#" class="goods_more fr">查看更多 ></a>
    </div>

    <div class="goods_con priority">
        <div class="goods_banner fl"><img src="images/banner06.png" alt="image"></div>
        <ul class="goods_list fl">
            <li>
                <h4><a href="#">良品铺子-去骨鸭爪零食小吃卤味休闲食品</a></h4>
                <a href="#"><img src="images/goods/food01.jpg" alt="image"></a>
                <div class="prize">¥ 32.00</div>
            </li>
            <li>
                <h4><a href="#">燕之坊黑芝麻粉黑芝麻糊速食营养早餐</a></h4>
                <a href="#"><img src="images/goods/food02.jpg" alt="image"></a>
                <div class="prize">¥ 98.00</div>
            </li>
            <li>
                <h4><a href="#">三只松鼠_麻辣肉食大礼包</a></h4>
                <a href="#"><img src="images/goods/food03.jpg" alt="image"></a>
                <div class="prize">¥ 80.00</div>
            </li>
            <li>
                <h4><a href="#">稻香村糕点礼盒传统小吃</a></h4>
                <a href="#"><img src="images/goods/food04.jpg" alt="image"></a>
                <div class="prize">¥ 198.00</div>
            </li>
        </ul>
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