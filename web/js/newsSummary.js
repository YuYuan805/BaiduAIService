// 文本纠错
// 2024年4月20日15:00:04  lx新添

// JQuery框架
// 轻量化，简单易使用，替代原生JS
// 语法：$(select,create).action();
// 查询语法：$("tag,.class,#id,tag #id").action();
// 创建语法：$("<a>");
// 修改属性：$("#submit").attr({"class|id|value|href|src":value});
// 修改样式：$("#submit").css({"style":value});
// 修改内容：$("#submit").html("<a>xxxx</a>"); $("#submit").text("xxxx");
// 修改表单input.value：$("#input").val("xxxxxx");
// 添加事件：$(tag).cilik(function(){});

// 延迟加载JS
// 异步、同步、getScript()、导包在body之后、setTimeInterval()

$(document).ready(function(){

    // 1.完成输入框的状态监听，同步输入长度
    // bind("click",funciton(){});
    // property 输入原型：input.value
    // change 发生变化
    $("#text").bind("input propertychange",function () {

        // 获取输入的长度
        var length = $("#text").val().length;
        // 计算剩余长度
        length = 1000 - length;
        // 修改内容
        $("#length").text(length);
        // 修改样式
        $("#length").css({"color":"red"});

    });

    // 2.点击发送异步请求
    $("#submit").bind("click",function () {

        var $value = $("#text").val(); // 获取输入内容
        var config = {
            // 协议://本地IP:服务器端口/自定义URL?name=value&name=value
            url:"nlpcontrol?action=newsSummary&text="+$value,
            method:"GET", // GET|POST|DELETE｜PUT｜OPTIONS
            dataType:"JSON", // 响应的数据类型：服务器返回数据类型 html\xml\file\json\text
            data:{}, // 提交数据 POST
            async:true, // async true 异步 false 同步
            success:function (resp) { // 成功：200
                // resp 返回数据
                console.log(resp);

                $("#newsSummary").text(resp.summary);

            },
            error:function (resp) { // 失败：403，400，500
                console.log(resp);
            }
        }

        // ajax 异步请求，同步，在不刷新网页的时候发起请求
        $.ajax(config);

    });

});








