/**
 * 加载分类信息
 */
$(function () {

    var $first_select = $("#first_select");
    var $second_select = $("#second_select");
    var $third_select = $("#third_select");

    $.ajax({
        url: "selectInitTypes",
        type: "GET",
        typeData: "JSON",
        success: function (jsonString) {
            var jsonArray = JSON.parse(jsonString);
            for (var index in jsonArray[0]) {
                var type = jsonArray[0][index];
                $first_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                $second_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
            }
            for (var Index in jsonArray[1]) {
                var Type = jsonArray[1][Index];
                $third_select.append("<option value=" + Type['id'] + ">" + Type['name'] + "</option>");
            }
        }
    });

    $second_select.change(function () {
        var fId = $(this).val();
        $.ajax({
            url: "selectType",
            type: "GET",
            dataType: "JSON",
            data: {
                "fId": fId
            },
            success: function (jsonString) {
                $third_select.empty();
                for (var index in jsonString) {
                    var type = jsonString[index];
                    $third_select.append("<option value=" + type['id'] + ">" + type['name'] + "</option>");
                }
            }
        })
    });
});

$(function () {
    //添加一级分类
    $("#first_add_btn").click(function () {
        var $firstInput = $(this).prev();  //一级分类输入框
        var firstTypeName = $firstInput.val();
        if (firstTypeName.length === 0) {
            alert("分类名称不能为空");
        } else {
            $.ajax({
                url: "addFirstType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "name": firstTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功！");
                        $firstInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });

    //添加二级分类
    $("#second_add_btn").click(function () {
        var $secondInput = $(this).prev();  //二级分类输入框
        var firstTypeId = $(this).siblings("select").val();  //一级分类选择框
        var secondTypeName = $secondInput.val();   //二级分类
        if (secondTypeName.length === 0) {
            alert("分类名称不能为空！");
        } else {
            $.ajax({
                url: "addType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "fid": firstTypeId,
                    "name": secondTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功!");
                        $secondInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });

    //添加三级分类
    $("#third_add_btn").click(function () {
        var $thirdInput = $(this).prev();  //三级分类输入框
        var secondTypeId = $thirdInput.prev().val();
        var thirdTypeName = $thirdInput.val();
        if (thirdTypeName.length === 0) {
            alert("分类名不能为空！");
        } else {
            $.ajax({
                url: "addType",
                type: "GET",
                dataType: "JSON",
                data: {
                    "fid": secondTypeId,
                    "name": thirdTypeName
                },
                success: function (success) {
                    if (success) {
                        alert("添加成功！");
                        $thirdInput.val("");
                    } else {
                        alert("系统繁忙，请稍后重试！");
                    }
                }
            })
        }
    });
});