

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
            url:"ocrcontrol?action=text",
            method:"POST", // POST无内存限制，可以提交文件
            dataType:"JSON",
            data:$formData,
            processData:false, // 关闭数据验证
            contentType:false, // 关闭类型验证
            success:function (resp) {
                console.log(resp)
                // 动态标签更新
                for (var i = 0; i < resp.words_result.length ; i++) {

                    $(".results").append("<div>"+
                        "<span>文字"+
                            i
                        +"</span>"
                        +"<p>"+
                            resp.words_result[i].words
                        +"</p>"
                        +"</div>");
                }
            },
            error:function (resp) {
                
            }
        }
        $.ajax(config);
    });
});

