/**
 * 购物车图标的数量填充
 */
$(function () {
    $.ajax({
        url: 'cartNumber',
        type: 'GET',
        DataType: 'json',
        success: function (number) {
            if ($('#show_count')[0] !== undefined)
                $('#show_count')[0].innerHTML = number;
        }
    })
});

/**
 * 购物车商品数量调节
 */
$(function () {
    var $add = $('.add'); //数量增加按钮
    var $minus = $('.minus');  //数量减小按钮

    var totalPrice = 0;  //总价
    var totalNumber = 0;  //选中的总数量
    var $checkbox = $("input[name = 'item_box']"); //每一项的选择框
    var $allChecked = $("input[name = 'all_checked']"); //全部选择选择框
    var $totalPrice = $("#total_price"); //总价显示框
    var $totalNumber = $("#total_number");  //总数量显示框

    /**
     * 数量增加
     */
    $add.click(function () {
        var $num_show = $(this).next().children('input'); //显示商品数量的元素
        var now = parseInt($num_show.val());
        $num_show.val(now + 1);
        var price = parseFloat($(this).parents('.col05').prev().text().slice(1)); //商品单价
        var $price_show = $(this).parents('.col05').next(); //显示当前商品总价格的元素
        $price_show.text('￥' + price * (now + 1));
        var $thisCheckBox = $(this).parents("li").siblings(".col01").children("label").children("input");
        if ($thisCheckBox.prop("checked")) {
            totalPrice += price;  //当前项被选中，总价加上当前项单价
            $totalPrice.text(totalPrice);
        }
    });

    /**
     * 数量减小
     */
    $minus.click(function () {
        var $num_show = $(this).prev().children('input');
        var now = parseInt($num_show.val());
        if (now > 1) {
            $num_show.val(now - 1);
            var price = parseFloat($(this).parents('.col05').prev().text().slice(1)); //商品单价
            var $price_show = $(this).parents('.col05').next(); //显示当前商品总价格的元素
            $price_show.text('￥' + price * (now - 1));
            var $thisCheckBox = $(this).parents("li").siblings(".col01").children("label").children("input");
            if ($thisCheckBox.prop("checked")) {
                totalPrice -= price;  //当前项被选中，总价减去当前项单价
                $totalPrice.text(totalPrice);
            }
        }
    });

    /**
     *手动填入商品数量重新计算价格
     */
    var $num = $('.num_show');
    $num.change(function () {
        var price = parseFloat($(this).parents('.col05').prev().text().slice(1)); //商品单价
        var nowNum = parseInt($(this).val()); //改变后的商品的数量
        var $price_show = $(this).parents('.col05').next(); //显示当前商品的总价格
        $price_show.text('￥' + price * nowNum);
        totalPrice = 0; //总价归零重新计算
        $checkbox.each(function () {
            if($(this).prop("checked")){   //当前项为选中状态
                totalPrice+=parseFloat($(this).parents("li").siblings(".col06").text().slice(1));
            }
        });
        $totalPrice.text(totalPrice);  //重新填入总价
    });

    /**
     * 全部选中按钮被改变
     */
    $allChecked.click(function () {
        if ($allChecked.prop("checked")) {
            //全部选中状态
            $checkbox.each(function () {
                if (!$(this).prop("checked")) { //当该项没有选中时，改为选中
                    $(this).prop("checked", true);
                    totalPrice += parseFloat($(this).parents("li").siblings(".col06").text().slice(1));
                    totalNumber += 1;
                }
            });
        } else {
            //取消全部选中状态
            $checkbox.each(function () {
                if ($(this).prop("checked")) { //当该选项为选中状态时，取消选中
                    $(this).prop("checked", false);
                    totalPrice -= parseFloat($(this).parents("li").siblings(".col06").text().slice(1));
                    totalNumber -= 1;
                }
            });
        }
        $totalPrice.text(totalPrice);
        $totalNumber.text(totalNumber);
    });

    /**
     * 某一项选择状态被改变
     */
    $checkbox.click(function () {
        if ($(this).prop("checked")) {
            //某一项被选中
            totalPrice += parseFloat($(this).parents("li").siblings(".col06").text().slice(1));
            totalNumber += 1;
            var isAllChecked = true;
            $checkbox.each(function () {
                if (!$(this).prop("checked")) {
                    isAllChecked = false;
                }
            });
            if (isAllChecked) {
                //全部选中
                $allChecked.prop("checked", true);
            }
        } else {
            //某一项被取消选中
            totalPrice -= parseFloat($(this).parents("li").siblings(".col06").text().slice(1));
            totalNumber -= 1;
            $allChecked.prop("checked", false);//取消全部选中
        }
        $totalPrice.text(totalPrice);
        $totalNumber.text(totalNumber);
    });
});

