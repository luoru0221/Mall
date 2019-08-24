$(function () {

    var error_name = false; //用户名是否错误
    var error_pwd = false;
    var error_cpwd = false;
    var error_phone = false;
    var error_pcode = false;
    var error_mcode = false;
    var error_check = false;

    //验证用户名
    $('#user_name').blur(function () {
        checkUserName();
    });

    //验证密码
    $('#pwd').blur(function () {
        checkPwd();
    });

    //验证确定密码
    $('#cpwd').blur(function () {
        checkCpwd();
    });

    //验证手机号码
    $('#phone').blur(function () {
        checkPhone();
    });

    //验证图形验证码
    $('#pic_code').blur(function () {
        checkPcode();
    });

    //验证短信验证码
    $('#msg_code').blur(function () {
        checkMcode();
    });

    //验证是否勾选许可协议
    $('#allow').click(function () {
        if($(this).is(':checked'))
        {
            error_check = false;
            $(this).siblings('span').hide();
        }
        else
        {
            error_check = true;
            $(this).siblings('span').show();
        }
    });

    function checkUserName() {
        var len = $('#user_name').val().length;
        if (len < 5 || len > 20) {
            $('#user_name').next().show();
            error_name = true;
        } else {
            $('#user_name').next().hide();
            error_name = false;
        }
    }

    function checkPwd() {
        var len = $('#pwd').val().length;
        if (len < 8 || len > 20) {
            $('#pwd').next().show();
            error_pwd = true;
        } else {
            $('#pwd').next().hide();
            error_pwd = false;
        }
    }

    function checkCpwd() {
        var pwd = $('#pwd').val();
        var cpwd = $('#cpwd').val();
        if (pwd !== cpwd) {
            $('#cpwd').next().show();
            error_cpwd = true;
        } else {
            $('#cpwd').next().hide();
            error_cpwd = false;
        }
    }

    function checkPhone() {
        var reg = /^1([38]\d|5[0-35-9]|7[3678])\d{8}$/;
        if (reg.test($('#phone').val())) {
            $('#phone').next().hide();
            error_phone = false;
        } else {
            $('#phone').next().show();
            error_phone = true;
        }
    }

    function checkPcode() {
        var len = $('#pic_code').val().length;
        if (len === 4) {
            $('#pic_code').next().next().hide();
            error_pcode = false;
        } else {
            $('#pic_code').next().next().hide();
            error_pcode = true;
        }
    }

    function checkMcode() {
        var len = $('#msg_code').val().length;
        if(len === 4){
            $('#msg_code').next().hide();
            error_mcode = false;
        }else{
            $('#msg_code').next().show();
            error_mcode = true;
        }
    }

    
    $('#reg_from').submit(function () {
        checkUserName();
        checkPwd();
        checkCpwd();
        checkPhone();
        checkPcode();
        checkMcode();
        return error_name === false && error_pwd === false && error_cpwd === false && error_pcode === false && error_mcode === false && error_phone === false && error_check === false;

    })


});