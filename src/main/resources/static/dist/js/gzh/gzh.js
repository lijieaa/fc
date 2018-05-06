 $(document).ready(function() {
     //公众号列表
        $('#deviceForm').DataTable( {
            // "ajax": "../dist/data/gzh.json",
            "ajax":{
                url: contextPath +"wxPublic/page",
                dataSrc:"data.list",
                "data":{
                    "page":1,
                    "rows":10
                }
            },
            "info":false,
            "searching": false,
            "lengthChange": false,
            "ordering": false,
            "language": {
                "paginate": {
                    "next": "下一页",
                    "previous": "上一页"
                }
            },
            "columns": [
                { "data": "publicName"},
                { "data": "sourceId" },
                { "data": "appId" },
                { "data": "appSecret" },
                { "data": "publicEmail" },
                { "data": "", "render": function(data, type, row, meta){
                        var html = "<button type='button' class='Normal margin-right-4 btn btn-primary'>编辑</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary'>删除</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary table-manage'>管理</button>"
                        return html;
                    }}

            ],
            "pageLength": 10,
            "fnInitComplete": function() {//初始化完毕事件
                $(".table-manage").click(function () {
                    $("#gzh-manage").show().siblings().hide();
                });
            }
        } );
        //用户管理列表
     $('#gzh-ul-manage').DataTable( {
         "autoWidth":false,
         "ajax":{
             url: contextPath +"wxUsers/page",
             dataSrc:"data.list",
             "data":{
                 "page":1,
                 "rows":10
             }
         },
         "info":false,
         "searching": false,
         "lengthChange": false,
         "ordering": false,
         "language": {
             "paginate": {
                 "next": "下一页",
                 "previous": "上一页"
             }
         },
         "columns": [
             { "width": "20%","data": "headimgurl",render:function (data, type, row, meta) {
                     var html="<img src="+data+" class='chatOne' />";
                     return html;
                 }},
             { "data": "nickname", "width":'75%'}

         ],
         "pageLength": 3,
         "fnInitComplete": function() {//初始化完毕事件
             $(".chatOne").click(function () {
                 //点击公众号列表
                 $("#chating-per").show().siblings().hide();
             });
         }
        } );
        // 添加公众号
        $("#add-gzh").click(function () {
            $('#myModal').modal();
        });
        // 返回公众号管理列表
       $("#backUl").click(function () {
           $("#gzh-index").show().siblings().hide();
       })
     //返回公众号列表
     $("#backUlManage").click(function () {
         $("#gzh-manage").show().siblings().hide();
     })
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
     // 点击弹窗新建跳转到不同的页面
     $(".new-source").click(function () {
         var cliText=$(this).attr("data-id");
         $("#source-bulid").show().siblings().hide();
         $("#sourceRoom").modal("hide");
         if(cliText=="1"){
             $(".gzh-source-type a:eq(0)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("图文消息");
             $(".btn-new-check").text("新建图文素材");
             $("#photo-tx").show().siblings().hide();
         } else if(cliText=="2"){
             $(".gzh-source-type a:eq(1)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("图片");
             $(".btn-new-check").text("上传");
             $("#photo-show").show().siblings().hide();
         } else if(cliText=="3"){
             $(".gzh-source-type a:eq(2)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("语音");
             $(".btn-new-check").text("添加");
             $("#source").show().siblings().hide();
         } else if(cliText=="4"){
             $(".gzh-source-type a:eq(3)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("视频");
             $(".btn-new-check").text("添加");
             $("#vid").show().siblings().hide();
         }
     })
     //在素材页面操作按钮
     $(".gzh-source-type a").click(function () {
         var cliID=$(this).attr("data-id");
         $(this).addClass("cli-color").siblings().removeClass("cli-color");
         if(cliID=="1"){
             $(".new-type-name").text("图文消息");
             $(".btn-new-check").text("新建图文素材");
             $("#photo-tx").show().siblings().hide();
         } else if(cliID=="2"){
             $(".new-type-name").text("图片");
             $(".btn-new-check").text("上传");
             $("#photo-show").show().siblings().hide();
         } else if(cliID=="3"){
             $(".new-type-name").text("语音");
             $(".btn-new-check").text("添加");
             $("#source").show().siblings().hide();
         } else if(cliID=="4"){
             $(".new-type-name").text("视频");
             $(".btn-new-check").text("添加");
             $("#vid").show().siblings().hide();
         }
     })
     // 新建选择素材操作
     $("#newAdd").click(function () {
         var newText=$(this).text();
         if(newText=="新建图文素材"){
             $("#new-photo-text").show().siblings().hide();
         }else {
             return false;
         }
     })

    } );
