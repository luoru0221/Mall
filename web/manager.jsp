<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <div class="welcome fl">1号店管理员后台</div>
        <div class="fr">
            <div class="user_link fl">
                <a href="exitLogin">退出管理系统</a>
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
            <li><a href="javascript:" class="menu_a">分类管理</a></li>
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
                <li class="order_operation fr"><a class="operation" href="javascript:">发货</a></li>
            </ul>
        </div>
        <div class="operation_con">

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
            <c:forEach var="user" items="${requestScope.users}">
                <ul class="user_list_td priority">
                    <li class="user_id_show">${user['id']}</li>
                    <li class="user_name_show">${user['name']}</li>
                    <li class="user_email_show">${user['email']}</li>
                    <li class="user_operation_show"><a class="operation" href="javascript:">删除</a></li>
                </ul>
            </c:forEach>
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
            <c:forEach var="product" items="${requestScope.products}">
                <ul class="product_list_td priority">
                    <li class="product_id_show">${product['id']}</li>
                    <li class="product_name_show">${product['name']}</li>
                    <li class="product_price_show">${product['price']}</li>
                    <li class="product_operation_show"><a class="operation" href="javascript:">编辑</a></li>
                </ul>
                <div class="operation_con priority">
                    <div class="product_information fl">
                        <div class="con_input"><label for="p_id">ID：</label><input type="text" id="p_id" value="123"
                                                                                   readonly='true'></div>
                        <div class="con_input"><label for="p_name">名称：</label><input type="text" id="p_name"></div>
                        <div class="con_area"><label for="p_description">详情：</label><textarea id="p_description"></textarea>
                        </div>
                        <div class="con_input"><label for="p_price">单价：</label><input type="text" id="p_price"></div>
                        <div class="con_input"><label for="p_stock">库存：</label><input type="text" id="p_stock"></div>
                        <div class="con_btn priority">
                            <button class="fl">保存修改</button>
                            <button class="fr">删除商品</button>
                        </div>
                    </div>
                    <div class="product_img fr">
                        <div class="p_image"><label>上传商品图片</label><input type="file" id="p_image"
                                                                         accept=".png,.jpg,.jpeg,image/png,image/jpg,image/jpeg"
                                                                         onchange="showImage()"></div>
                        <img src="" id="p_img_show" alt="暂未上传图片">
                    </div>
                </div>
            </c:forEach>
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