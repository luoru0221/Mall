$(function () {
    /*导航栏切换效果*/
    var $nav = $("#menu li");
    var $content = $(".content");
    $nav.click(function () {
        $(this).addClass('active').siblings().removeClass('active');
        $content.eq($(this).index()).addClass('con_active').siblings().removeClass('con_active');
    });
});
$(function () {
    var userId = $("#userId").text();
    var $name = $("#name");
    var $email = $("#email");
    //填充数据
    $.ajax({
        url: "userCenter",
        dataType: "json",
        type: "POST",
        data: {loginId: userId},
        success: function (user) {
            $name.val(user['name']);
            $email.val(user['email']);
        }
    })
});
$(function () {
    var emailTrue = true;  //邮箱地址是否正确
    var emailCodeTrue = false;  //邮箱验证码是否正确
    var pwdTrue = false;  //原始密码是否正确
    var $email = $("#email");  //邮箱输入框
    var $code = $("#code");  //验证码输入框
    var $getCode = $("#get_msg_code");  //获取验证码按钮
    var $submit = $("#submit");  //提交按钮
    var $oldPwd = $("#old_password"); //原始密码框
    var $newPwd = $("#new_password");  //新密码框
    var $conPwd = $("#con_password");  //确认密码框

    var userId = $("#userId").text();
    var userName = $("#name").val();
    var email = $email.val();
    var code = $code.val();
    var oldPwd = $oldPwd.val(); //原始密码
    var newPwd = $newPwd.val(); //新密码
    var conPwd = $conPwd.val(); //确认密码


    //正则判断邮箱是否合法
    $email.change(function () {
        var reg = /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/;
        emailTrue = reg.test($(this).val());
    });

    //获取验证码
    $getCode.click(function () {
        email = $email.val();
        if (!emailTrue) {
            alert("请输入正确的邮箱地址！");
        } else {
            $.ajax({
                url: "sendEmailCode",
                dataType: "json",
                type: "POST",
                data: {address: email}
            });

            $getCode.attr("disabled", true); //使按钮失效
            $getCode.css("background-color", "#eadcc0"); //改变按钮颜色
            var count = 60;
            countTimes();

            function countTimes() {
                $getCode.html("重新发送(" + count + "s)");
                count--;
                if (count > 0) {
                    setTimeout(countTimes, 1000);
                } else if (count === 0) {
                    $getCode.html("获取验证码");
                    $getCode.attr("disabled", false); //重新激活按钮
                    $getCode.css("background-color", "#ff0000");
                }
            }
        }
    });

    //判断验证码是否正确
    $code.change(function () {
        code = $code.val();
        $.ajax({
            url: "judgeCode",
            type: "POST",
            dataType: "json",
            data: {
                emailCode: code
            },
            success: function (isTrue) {
                emailCodeTrue = isTrue;
            }
        })
    });

    //判断原始密码是否正确
    $oldPwd.change(function () {
        userId = $("#userId").text();
        oldPwd = $oldPwd.val();
        $.ajax({
            url: "judgePwd",
            type: "POST",
            dataType: "json",
            data: {
                userId: userId,
                oldPwd: oldPwd
            },
            success: function (isTrue) {
                pwdTrue = isTrue;
            }
        })
    });

    //异步提交
    $submit.click(function () {
        userName = $("#name").val();
        email = $email.val();
        newPwd = $newPwd.val();
        conPwd = $conPwd.val();
        if (newPwd !== conPwd) {
            alert("两次输入的密码不一致！");
        } else if (!emailCodeTrue) {
            alert("验证码错误！")
        } else if (!pwdTrue) {
            alert("原始密码错误");
        } else if (newPwd === "") {
            //不修改密码
            userId = $("#userId").text();
            alert("修改成功");
            $.ajax({
                url: "updateUser",
                type: "POST",
                dataType: "json",
                data: {
                    id: userId,
                    name: userName,
                    email: email
                }
            })
        } else if (newPwd !== "") {
            if (newPwd.length < 8 || newPwd.length > 20) {
                alert("密码必须为8-20位之间！");
            } else {
                //修改密码
                userId = $("#userId").text();
                alert("修改成功！");
                $.ajax({
                    url: "updateUser",
                    type: "POST",
                    dataType: "json",
                    data: {
                        id: userId,
                        name: userName,
                        email: email,
                        password: newPwd
                    }
                })
            }
        }
    })
});

