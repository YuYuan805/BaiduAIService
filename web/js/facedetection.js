
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
            url:"facecontrol?action=face",
            method:"POST", // POST无内存限制，可以提交文件
            dataType:"JSON",
            data:$formData,
            processData:false, // 关闭数据验证
            contentType:false, // 关闭类型验证
            success:function (resp) {
                console.log(resp)
                // 动态标签更新
                if (resp.error_msg == "SUCCESS"){
                    $("#num").text(resp.result.face_num);
                    $("#token").text(resp.result.face_list[0].face_token);
                    $("#age").text(resp.result.face_list[0].age);
                    $("#beauty").text(resp.result.face_list[0].beauty);
                    var sex = resp.result.face_list[0].gender.type;
                    if (sex == "female"){
                        sex = "女性";
                    }else {
                        sex = "男性";
                    }
                    $("#sex").text(sex);
                    $("#mood").text(resp.result.face_list[0].emotion.type);
                }else {
                    alert(resp.error_msg);
                }

            },
            error:function (resp) {

            }
        }
        $.ajax(config);
    });
});

