//页面切换
$(function () {
    var $menu = $("#menu li");
    var $content = $(".right_content");
    $menu.click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $content.eq($(this).index()).addClass('con_active').siblings().removeClass('con_active');
    })
});

//添加商品请求
function addProduct() {

    var dom = $("#confirmAddBtm");
    dom.attr("disable", true);
    var tips = [];
    var datas = new FormData();
    var pName = $('#pName').val();  //商品名称
    var pDescription = $('#pDescription').val();    //商品描述
    var pPrice = $('#pPrice').val();    //商品价格
    var pImage = $('#pImage')[0].files[0];     //商品图片
    var pImageAddress = null;
    var pType = $('option:selected', '#pType').index(); //商品分类

    var tr = $('#add_tips_table tbody').children('tr');  //规格表格
    tr.each(function () {
        var tip = [];
        var name = $(this).find("[name = 'tip_name']").val();
        var value1 = $(this).find("[name = 'tip_value1']").val();
        var value2 = $(this).find("[name = 'tip_value2']").val();
        var value3 = $(this).find("[name = 'tip_value3']").val();
        var value4 = $(this).find("[name = 'tip_value4']").val();
        var value5 = $(this).find("[name = 'tip_value5']").val();
        if (name !== "" && ((value1 !== "") || value2 !== "" || value3 !== "" || value4 !== "" || value5 !== "")) {
            tip.push(name);
            if (value1 !== "") {
                tip.push(value1);
            }
            if (value2 !== "") {
                tip.push(value2);
            }
            if (value3 !== "") {
                tip.push(value3);
            }
            if (value4 !== "") {
                tip.push(value4);
            }
            if (value5 !== "") {
                tip.push(value5);
            }
            tips.push(tip);
        }
    });
    datas.append("pImage", pImage);

    $.ajax({
        url: 'addProduct',
        type: 'POST',
        async: false,
        data: datas,
        processData: false,
        contentType: false,
        success: function (data) {
            pImageAddress = data;//返回的图片地址
        }
    });
    $.ajax({
        url: 'addProduct',
        type: 'GET',
        async: false,
        dataType: 'json',
        data: {
            'pName': pName,
            'pDescription': pDescription,
            'pPrice': pPrice,
            'pImage': pImageAddress,
            'pType': pType,
            'tips': JSON.stringify(tips)
        }
    });
    alert("添加成功");
    $("input").val("");
    $("textarea").val("");
    $("select").find("option:first").prop("selected", true);
    $("#pImageShow").src = "";
    dom.attr("disable", true);
}

/*选择图片后预览*/
function showImg() {
    $("#pImageShow").attr("src", URL.createObjectURL($("#pImage")[0].files[0]));
}

$(function () {
    var $operation = $(".operation");
    $operation.click(function () {
        var $operation_div = $(this).parents("ul").next();
        $operation_div.toggle(function () {
            $operation_div.addClass("con_active");
            $operation_div.removeClass("con_active");
        })
    });
});

/*选择图片后预览*/
function showImage() {
    $("#p_img_show").attr("src", URL.createObjectURL($("#p_image")[0].files[0]));
}

/**
 * 商品管理
 */
$(function () {
    var $saveChange = $(".save_change");  //修改商品
    var $delateProduct = $(".delate_product");  //删除商品

    $saveChange.click(function () {
        var $productInfo = $(this).parents(".product_information");
        var $productImg = $productInfo.next();
        var $imageInput = $productImg.children(".p_image").children(".productImage_input");

        var productId = $productInfo.children(".con_input").eq(0).children(".productId_input").val();
        var productName = $productInfo.children(".con_input").eq(1).children(".productName_input").val();
        var productDescription = $productInfo.children(".con_area").children(".productDescription_input").text();
        var productPrice = $productInfo.children(".con_input").eq(2).children(".productPrice_input").val();
        var productImage = $productImg.children(".productImage_show").attr("src");

        if ($imageInput.val()) {
            var fileData = new FormData();
            var productImageFile = $imageInput[0].files[0];
            fileData.append("pImage", productImageFile);
            $.ajax({
                url: 'updateProduct',
                type: 'POST',
                data: fileData,
                processData: false,
                contentType: false,
                success: function (data) {
                    productImage = data;//返回的图片地址
                    $.ajax({
                        url: "updateProduct",
                        type: "GET",
                        dataType: "JSON",
                        data: {
                            "productId": productId,
                            "productName": productName,
                            "productDescription": productDescription,
                            "productPrice": productPrice,
                            "productImage": productImage
                        },
                        success: function (success) {
                            if (success) {
                                alert("修改成功！");
                            } else {
                                alert("系统繁忙，请稍后重试");
                            }
                        }
                    })
                }
            })
        } else {
            $.ajax({
                url: "updateProduct",
                type: "GET",
                dataType: "JSON",
                data: {
                    "productId": productId,
                    "productName": productName,
                    "productDescription": productDescription,
                    "productPrice": productPrice,
                    "productImage": productImage
                },
                success: function (success) {
                    if (success) {
                        alert("修改成功！");
                    } else {
                        alert("系统繁忙，请稍后重试");
                    }
                }
            })
        }
    });

    /**
     * 删除商品
     */
    $delateProduct.click(function () {
        var conFirm = window.confirm("确认删除该商品？");
        if (conFirm) {
            var $child_one = $(this).parents(".operation_con");
            var $child_two = $child_one.prev();
            var pId = $child_one.children(".product_information").children(".con_input").children(".productId_input").val();
            $.ajax({
                url: "deleteProduct",
                type: "GET",
                dataType: "JSON",
                data: {
                    "productId": pId
                },
                success: function (success) {
                    if (success) {
                        $child_one.remove();
                        $child_two.remove();
                        alert("删除成功！");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            });
        }
    })
});

/**
 * 用户管理
 */
$(function () {
    var $delete_btn = $(".user_operation_a");
    $delete_btn.click(function () {
        var $father = $(this).parent();
        var userId = $(this).parent().siblings(".user_id_show").text();
        var confirmDelete = confirm("确认删除该用户：\n账号：" + userId);
        if (confirmDelete) {
            $.ajax({
                url: "deleteUser",
                type: "GET",
                dataType: "JSON",
                data: {
                    "userId": userId
                },
                success: function (success) {
                    if (success) {
                        alert("删除成功！");
                        $father.remove();
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    })
});

/**
 * 订单管理
 */
$(function () {
    var $deteleOrderBtn = $(".delete_order_btn");
    $deteleOrderBtn.click(function () {
        var $father = $(this).parents(".content_con");
        var orderId = $(this).parent().siblings(".col01").text().slice(4);
        var confirmDeleteOrder = confirm("确定删除该订单：\n订单编号:" + orderId);
        if (confirmDeleteOrder) {
            $.ajax({
                url: "deleteOrder",
                type: "GET",
                dataType: "JSON",
                data: {
                    "orderId": orderId
                },
                success: function (success) {
                    if (success) {
                        alert("已删除！");
                        $father.remove();
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    })
});