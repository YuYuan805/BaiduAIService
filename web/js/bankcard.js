// 身份证识别
// 2024年4月20日10点43分：功能异常
// 2024年4月20日10点44分：功能正常

$(document).ready(function () {

    // 1 图片同步
    $("#file").bind("change",function () {
        // $(this)[0] 获取多文件提交的第一个文件
        // files[0] 文件属性集合
        var file = $(this)[0].files[0];
        // http://id:port/file.jpg createObjectURL 创建URL地址
        // src: path、url、base64
        $("#show_img").attr({"src":URL.createObjectURL(file)});
    });

    // 2 提交File异步请求
    $("#submit").bind("click",function () {

        // [0] 获取表单第一个组件
        let $form = $("#uploadForm")[0];

        // FormData 可以把表单及表单的组件进行序列化（数组、字典）
        var $formData = new FormData($form);
        // $formData.append(key,value);

        let config = {
            url:"ocrcontrol?action=bankcard",
            method:"POST", // POST无内存限制，可以提交文件
            dataType:"JSON",
            data:$formData,
            processData:false, // 关闭数据验证
            contentType:false, // 关闭类型验证
            success:function (resp) {
                console.log(resp)
                // 动态标签更新
                $("#bankcard_number").text(resp.result.bank_card_number);
                $("#bankcard_name").text(resp.result.bank_name);

                if(resp.result.bank_card_type == 0){
                    $("#bankcard_type").text("不能识别");
                }
                else if(resp.result.bank_card_type == 1){
                    $("#bankcard_type").text("借记卡");
                }
                else{
                    $("#bankcard_type").text("信用卡");
                }

            },
            error:function (resp) {

            }
        }
        $.ajax(config);
    });
});

