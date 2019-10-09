<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/reset.css">
    <link rel="stylesheet" href="css/main.css">
    <link rel="stylesheet" href="css/manager.css">
    <script type="text/javascript" src="js/jquery-3.4.1.min.js"></script>
    <script type="text/javascript" src="js/manager.js"></script>
</head>
<body>
<div class="header_con">
    <div class="header">
        <div class="welcome fl">欢迎来到1号店！</div>
        <div class="fr">
            <div class="login_btn fl">
                <a href="login.jsp">登录</a>
                <span>|</span>
                <a href="register.jsp">注册</a>
            </div>
            <div class="user_link fl">
                <span>|</span>
                <a href="usercenter.jsp">用户中心</a>
                <span>|</span>
                <a href="cartLoad?userId=${sessionScope.loginId}">我的购物车</a>
                <span>|</span>
                <a href="">我的订单</a>
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
        <h3>商家中心</h3>
        <ul id="menu">
            <li class="active"><a href="javascript:" class="menu_a">订单管理</a></li>
            <li><a href="javascript:" class="menu_a">用户管理</a></li>
            <li><a href="javascript:" class="menu_a">商品管理</a></li>
            <li><a href="javascript:" class="menu_a">添加商品</a></li>
        </ul>
    </div>

    <!--    订单管理页-->
    <div class="right_content priority con_active">
        <h3 class="content_title">订单管理</h3>
        <div class="content_con">
            <ul class="order_list_th priority">
                <li class="col01">订单号：<h4></h4></li>
                <li class="col02">用户：<h4></h4></li>
                <li class="col03">状态：<h4></h4></li>
            </ul>
            <ul class="order_list_td priority">
                <li class="order_image fl"><img src="images/goods/1569673849484.jpg" alt="image"></li>
                <li class="order_name fl">华为P30</li>
                <li class="order_price fl">￥3366.00</li>
                <li class="order_number fl">1</li>
                <li class="order_total_price fl">￥3366.00</li>
                <li class="order_operation fr"><a href="javascript:">发货</a></li>
            </ul>
        </div>
    </div>

    <!--    用户管理页-->
    <div class="right_content priority">
        <h3 class="content_title">用户管理</h3>
        <div class="content_con">
            <ul class="user_list_th priority">
                <li class="user_id">ID</li>
                <li class="user_name">昵称</li>
                <li class="user_email">Email</li>
                <li class="user_operation">操作</li>
            </ul>
            <ul class="user_list_td priority">
                <li class="user_id_show">12345</li>
                <li class="user_name_show">luoru</li>
                <li class="user_email_show">331980169@qq.com</li>
                <li class="user_operation_show"><a href="javascript:">删除</a></li>
            </ul>
        </div>
    </div>
    <!--    商品管理页-->
    <div class="right_content priority">
        <h3 class="content_title">商品管理</h3>
        <div class="content_con">
            <ul class="product_list_th priority">
                <li class="product_id">商品ID</li>
                <li class="product_name">名称</li>
                <li class="product_price">单价</li>
                <li class="product_operation">操作</li>
            </ul>
            <ul class="product_list_td priority">
                <li class="product_id_show">商品ID</li>
                <li class="product_name_show">名称</li>
                <li class="product_price_show">单价</li>
                <li class="product_operation_show"><a href="javascript:">编辑</a></li>
            </ul>
        </div>
    </div>
    <!--    添加商品-->
    <div class="right_content priority">
        <h3 class="content_title">添加商品</h3>
        <div class="add_information fl">
            <label for="pName">商品名称：</label>
            <input type="text" id="pName"><br>
            <label for="pDescription">商品描述：</label>
            <textarea rows="10" cols="30" id="pDescription"></textarea><br>
            <label for="pPrice">商品价格：</label>
            <input type="text" id="pPrice"><br>
            <label for="pType">商品分类：</label>
            <select name="pType" id="pType">
                <option>手机数码</option>
                <option>电脑办公</option>
                <option>美妆护理</option>
                <option>家居家装</option>
                <option>生活电器</option>
                <option>食品零食</option>
            </select>
        </div>
        <div class="pImageDiv fr priority">
            <label for="pImage">商品图片：</label>
            <input type="file" id="pImage" accept=".png,.jpg,.jpeg,image/png,image/jpg,image/jpeg" onchange="showImg()"><br>
            <img src="" id="pImageShow" alt="暂未上传图片">
        </div>
        <div class="fl priority" id="add_tips">
            <h4>添加规格：</h4>
            <table id="add_tips_table">
                <thead>
                <tr>
                    <th>规格名称</th>
                    <th>规格1</th>
                    <th>规格2</th>
                    <th>规格3</th>
                    <th>规格4</th>
                    <th>规格5</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td class="tip_name"><label>
                        <input type="text" name="tip_name">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value1">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value2">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value3">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value4">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value5">
                    </label></td>
                </tr>
                <tr>
                    <td class="tip_name"><label>
                        <input type="text" name="tip_name">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value1">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value2">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value3">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value4">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value5">
                    </label></td>
                </tr>
                <tr>
                    <td class="tip_name"><label>
                        <input type="text" name="tip_name">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value1">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value2">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value3">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value4">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value5">
                    </label></td>
                </tr>
                <tr>
                    <td class="tip_name"><label>
                        <input type="text" name="tip_name">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value1">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value2">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value3">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value4">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value5">
                    </label></td>
                </tr>
                <tr>
                    <td class="tip_name"><label>
                        <input type="text" name="tip_name">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value1">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value2">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value3">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value4">
                    </label></td>
                    <td class="tip_value"><label>
                        <input type="text" name="tip_value5">
                    </label></td>
                </tr>
                </tbody>
            </table>
            <button class="fr" onclick="addProduct()">确认添加</button>
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