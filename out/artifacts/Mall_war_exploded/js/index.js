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
                    elem.children[0].children[0].href = "detailLoad?productId=" + product["id"];
                    elem.children[1].href = "detailLoad?productId=" + product["id"];
                }
            }
        }

    });
});

$(function () {
    $.ajax({
        url: "typeList",
        type: "GET",
        dataType: "JSON",
        success: function (typeList) {
            var $menu = $(".sub_menu");
            console.log(typeList);
            for(var Index in typeList){

                var $menu_item = $("<li></li>");
                var $level1 = $("<div class='level1'></div>");
                var $level2 = $("<div class='level2'></div>");
                var $list_group = $("<div class='list_group'></div>");
                var firstType = typeList[Index];

                var $level1_a = $("<a href='#'>"+firstType['name']+"</a>");
                $level1_a.appendTo($level1);
                var secondTypes = typeList[Index]['cTypes'];
                for(var index in  secondTypes){
                    var secondType = secondTypes[index];
                    var thirdTypes = secondType['cTypes'];

                    var $group_name = $("<div class='group_name fl'>"+secondType['name']+"&nbsp;&gt</div>");
                    var $group_detail = $("<div class='group_detail fl'></div>");
                    for(var inn in thirdTypes){
                        var thirdType = thirdTypes[inn];
                        var $a_item = $("<a href='#' typeid="+thirdType['id']+">"+thirdType['name']+"</a>");
                        $a_item.appendTo($group_detail);
                    }
                    $group_name.appendTo($list_group);
                    $group_detail.appendTo($list_group);
                }
                $list_group.appendTo($level2);
                $level1.appendTo($menu_item);
                $level2.appendTo($menu_item);
                $menu_item.appendTo($menu);
            }
        }
    })
});
function searchProduct() {
    var keyword = $("#search_keyword").val();
    window.location.href = "searchProduct?keyword="+keyword;
}