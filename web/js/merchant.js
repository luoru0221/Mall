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