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