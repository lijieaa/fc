 $(document).ready(function() {
        $('#deviceForm').DataTable( {
            "ajax": "../dist/data/gzh.json",
            "info":false,
            "searching": false,
            "lengthChange": false,
            "ordering": false,
            // "pagingType": "full_numbers",
            "language": {
                "paginate": {
                    "next": "下一页",
                    "previous": "上一页"
                }
            },
            "columns": [
                { "data": "name" },
                { "data": "position" },
                { "data": "office" },
                { "data": "Extn" },
                { "data": "Start" },
                { "data": "", "render": function(data, type, row, meta){
                        var html = "<button type='button' class='Normal margin-right-4 btn btn-primary'>编辑</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary'>删除</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary table-manage'>管理</button>"
                        return html;
                    }}

            ],
            "fnInitComplete": function() {//初始化完毕事件
                $(".table-manage").click(function () {
                    $("#gzh-index").hide();
                    $("#gzh-manage").show();
                });
            }
        } );
        // 添加公众号
        $("#add-gzh").click(function () {
            $('#myModal').modal();
        });
     //聊天点击点击跳转不同弹窗
        $(".chat-type>span").click(function () {
            var data_id=$(this).attr("data-id");
            if(data_id==2){
                $("#textInput").focus();
            }else{
                $('#sourceRoom').modal();
                if(data_id==1){
                    $("#mySource").text("选择素材");
                    $(".new-source").text("新建图文消息").attr("data-id","1");
                }else if(data_id==3){
                    $("#mySource").text("选择图片");
                    $(".new-source").text("上传图片").attr("data-id","2");
                }else if(data_id==4){
                    $("#mySource").text("选择语音");
                    $(".new-source").text("上传语音").attr("data-id","3");
                }else if(data_id==5){
                    $("#mySource").text("选择视频");
                    $(".new-source").text("上传视频").attr("data-id","4");
                }
            }
        })
     $(".new-source").click(function () {
         var cliText=$(this).attr("data-id");
         $("#gzh-index").hide();
         $("#gzh-manage").hide();
         $("#source-bulid").show();
         $("#sourceRoom").modal("hide");
         if(cliText=="1"){
             $(".gzh-source-type a:eq(0)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("图文消息");
             $(".btn-new-check").text("新建图文素材");
         }
         if(cliText=="2"){
             $(".gzh-source-type a:eq(1)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("图片");
             $(".btn-new-check").text("上传");
         }
         if(cliText=="3"){
             $(".gzh-source-type a:eq(2)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("语音");
             $(".btn-new-check").text("添加");
         }
         if(cliText=="4"){
             $(".gzh-source-type a:eq(3)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("视频");
             $(".btn-new-check").text("添加");
         }
     })
    } );
