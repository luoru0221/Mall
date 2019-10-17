$(function () {

    $(".prePage").click(function () {
        if ($(".pageCode.active").prev().text() !== "<上一页") {
            $(".pageCode.active").removeClass("active").prev().addClass("active");
        }
    });
    $(".nextPage").click(function () {
        if ($(".pageCode.active").next().text() !== "下一页>") {
            $(".pageCode.active").removeClass("active").next().addClass("active");
        }
    })
});

$(function () {
    var keyword = $("#keyword_input").attr("keyword");  //搜索关键字
    var pageCode = $(".pageCode.active").text();  //当前页码
    $.ajax({
        url:"searchProductPage",
        type:"GET",
        dataType:"JSON",
        data:{
            "keyword":keyword,
            "pageCode":pageCode
        },
        success:function (pageProducts) {
            var $list = $(".goods_list li");
            for(var index in pageProducts){
                var product = pageProducts[index];
                $list.eq(index).children("a").attr("href","detailLoad?productId="+product['id']);
                $list.eq(index).children("a").children("img").attr("src",product['image']);
                $list.eq(index).children("h4").children("a").text(product['name']);
                $list.eq(index).children("h4").children("a").attr("href","detailLoad?productId="+product['id']);
                $list.eq(index).children("div").text("￥"+product['price']);
            }
        }
    })
});