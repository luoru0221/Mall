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
/*选择图片后预览*/
function showImage() {
    $("#p_img_show").attr("src", URL.createObjectURL($("#p_image")[0].files[0]));
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