// 语音合成
// 2024年4月20日10点07分：功能正常

$(document).ready(function () {

    // 1.完成输入框的状态监听，同步输入长度
    // bind("click",funciton(){});
    // property 输入原型：input.value
    // change 发生变化
    $("#text").bind("input propertychange",function () {

        // 获取输入的长度
        var length = $("#text").val().length;
        // 计算剩余长度
        length = 300 - length;
        // 修改内容
        $("#length").text(length);
        // 修改样式
        $("#length").css({"color":"red"});

    });

    // 2 提交File异步请求
    $("#submit").bind("click",function () {

        //  获取name属性的input并判断checked状态
        var $per_value = $("input[name='per']:checked").val();
        var $spd_value = $("input[name='spd']:checked").val();
        var $pit_value = $("input[name='pit']:checked").val();
        var $inp_value = $("#text").val(); // 获取输入内容
        console.log($per_value);
        console.log($spd_value);
        console.log($pit_value);
        console.log($inp_value);

        var par = "&text="+$inp_value+"&per="+$per_value + "&spd="+$spd_value + "&pit="+$pit_value;
        var config = {
            // 协议://本地IP:服务器端口/自定义URL?name=value&name=value
            url:"speechcontrol?action=synthesis"+par,
            method:"GET", // GET|POST|DELETE｜PUT｜OPTIONS
            dataType:"text", // 响应的数据类型：服务器返回数据类型 html\xml\file\json\text
            data:{}, // 提交数据 POST
            async:true, // async true 异步 false 同步
            success:function (resp) { // 成功：200
                // resp 返回数据
                // console.log(resp);

                var player = $("#audio")[0];

                $(player).attr({"src":'data:audio/wav;base64,' + resp});

                // load 加载 src
                player.load();

                if (player.paused){ /*如果已经暂停*/
                    player.play(); /*播放*/
                }else {
                    player.pause();/*暂停*/
                }

            },
            error:function (resp) { // 失败：403，400，500
                console.log(resp);
            }
        }
        $.ajax(config);
    });
});

