$(function () {
    $.ajax({
        url: "indexServlet",
        dataType: "json",
        type: "GET",
        success: function (pData) {
            var product;
            var typeElem; //元素
            var elem;
            for (var outIndex in pData) {
                typeElem = $('.goods_list')[outIndex];
                for (var inIndex in pData[outIndex]) {
                    product = pData[outIndex][inIndex];//每一件商品
                    elem = typeElem.children[inIndex];
                    elem.children[0].children[0].innerHTML = product["name"];
                    elem.children[1].children[0].src = product["image"];
                    elem.children[2].innerHTML = "￥" + product["price"];
                    elem.children[0].children[0].href = "detailLoad?productId="+product["id"];
                    elem.children[1].href = "detailLoad?productId="+product["id"];
                }
            }
        }

    });
});