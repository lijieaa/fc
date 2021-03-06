
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
                        var html = "<button type='button' class='Normal margin-right-4 btn btn-primary table-edit'>编辑</button>" +
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
                //编辑公众号
                $(".table-edit").click(function () {
                    $('#myModal').modal();
                    $("#myModalLabel").text("编辑公众号");
                    $("#btn_sure").addClass("edit-gzh").removeClass("add-gzh");
                    $.ajax({
                        contentType:'application/json; charset=utf-8',
                        url: contextPath +"wxPublic/14",
                        type: "get",
                        data: "",
                        dataType: "json",
                        success: function(d){
                            $("#txt_name").val(d.publicName);
                            $("#txt_firstID").val(d.sourceId);
                            $("#txt_departmentlevel").val(d.appId);
                            $("#txt_psd").val(d.appSecret);
                            $("#txt_email").val(d.publicEmail);
                        }
                    })
                })
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
                 "rows":10,
                 "wxPublicId":14
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
         "pageLength": 4,
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
            $("#myModalLabel").text("添加公众号");
            $("#btn_sure").addClass("add-gzh").removeClass("edit-gzh");
            $("#txt_name").val("");
            $("#txt_firstID").val("");
            $("#txt_departmentlevel").val("");
            $("#txt_psd").val("");
            $("#txt_email").val("");
        });
     $(document).on("click",".add-gzh",function () {
         var gName=$("#txt_name").val();
         var gSourceID=$("#txt_firstID").val();//原始id
         var ID=$("#txt_departmentlevel").val();//开发者id
         var psd=$("#txt_psd").val();//密码
         var email=$("#txt_email").val();//邮箱
         var webdata= {"id":"14","publicName":gName,"sourceId":gSourceID,"appId":ID,"appSecret":psd,"publicEmail":email};
         var data=JSON.stringify(webdata);
         $.ajax({
             contentType:'application/json; charset=utf-8',
             url: contextPath +"wxPublic",
             type: "post",
             data: data,
             dataType: "json",
             success: function(d){
                 alert(d.messages)
             }
         })
     });
     $(document).on("click",".edit-gzh",function () {
             var gName=$("#txt_name").val();
             var gSourceID=$("#txt_firstID").val();//原始id
             var ID=$("#txt_departmentlevel").val();//开发者id
             var psd=$("#txt_psd").val();//密码
             var email=$("#txt_email").val();//邮箱
             var webdata= {"id":"14","publicName":gName,"sourceId":gSourceID,"appId":ID,"appSecret":psd,"publicEmail":email};
             var data=JSON.stringify(webdata);
             $.ajax({
               contentType:'application/json; charset=utf-8',
               url: contextPath +"wxPublic",
               type: "put",
               data: data,
               dataType: "json",
               success: function(d){
                 alert(d.messages)
              }
           })
     });
        // 返回公众号管理列表
       $("#backUl").click(function () {
           $("#gzh-index").show().siblings().hide();
       })
     //返回公众号列表
     $("#backUlManage").click(function () {
         $("#gzh-manage").show().siblings().hide();
     })
     // 点击跳转不同菜单
     $(".gzh-manage-menu a").click(function () {
         var cName=$(this).text();
         if(cName=="素材管理"){
             $("#source-bulid").show().siblings().hide();
             $("#photo-tx").show().siblings().hide();
         }
         if(cName=="菜单管理"){
             // window.location.href="http://localhost:8080/wxPublic/menu";
         }
         if(cName=="消息管理"){
             // window.location.href="http://localhost:8080/`/msg";
         }
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
                    ajaxDataPop(1);
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
             $("#filePicker").show().siblings().hide();
             $("#photo-tx").show().siblings().hide();
         } else if(cliText=="2"){
             $(".gzh-source-type a:eq(1)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("图片");
             $("#filePicker1").show().siblings().hide();
             $("#photo-show").show().siblings().hide();
         } else if(cliText=="3"){
             $(".gzh-source-type a:eq(2)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("语音");
             $("#filePicker2").show().siblings().hide();
             $("#source").show().siblings().hide();
         } else if(cliText=="4"){
             $(".gzh-source-type a:eq(3)").addClass("cli-color").siblings().removeClass("cli-color");
             $(".new-type-name").text("视频");
             $("#filePicker3").show().siblings().hide();
             $("#vid").show().siblings().hide();
         }
     })
     //在素材页面操作按钮
     $(".gzh-source-type a").click(function () {
         var cliID=$(this).attr("data-id");
         $(this).addClass("cli-color").siblings().removeClass("cli-color");
         if(cliID=="1"){
             $(".new-type-name").text("图文消息");
             $("#filePicker").show().siblings().hide();
             $("#photo-tx").show().siblings().hide();
         } else if(cliID=="2"){
             $(".new-type-name").text("图片");
             $("#filePicker1").show().siblings().hide();
             $("#photo-show").show().siblings().hide();
             ajaxData(1);
         } else if(cliID=="3"){
             $(".new-type-name").text("语音");
             $("#filePicker2").show().siblings().hide();
             $("#source").show().siblings().hide();
             ajaxMp(1);
         } else if(cliID=="4"){
             $(".new-type-name").text("视频");
             $("#filePicker3").show().siblings().hide();
             $("#vid").show().siblings().hide();
             ajaxVid(1);
         }
     })
     // 新建选择素材操作
     $("#filePicker").click(function () {
         $("#new-photo-text").show().siblings().hide();

     });
       $("#backStore").click(function () {
           $("#source-bulid").show().siblings().hide();
       })
$("#backUlGzh").click(function () {
    $("#gzh-manage").show().siblings().hide();
})
//文本编辑器
     function textEdior(){
         CKEDITOR.replace( 'editor1', {
             height:500,
             customConfig: '',
             filebrowserImageUploadUrl:"skins",
             removeDialogTabs:"image:advanced;image:Link",
             toolbarGroups: [
                 {"name":"basicstyles","groups":["basicstyles"]},
                 {"name":"links","groups":["links"]},
                 {"name":"paragraph","groups":["list","blocks"]},
                 // {"name":"document","groups":["mode"]},
                 {"name":"insert","groups":["insert"]},
//                {"name":"styles","groups":["styles"]},
                 {"name":"about","groups":["about"]}
             ],
             removePlugins:"elementspath"
//            removeButtons: 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
         });
     }
     textEdior();
       //新建图文消息
     $(".newPhotoText>a").click(function () {
         $('#sourceRoom').modal();
         $("#mySource").text("选择图片");
         $(".new-source").text("上传图片").attr("data-id","2");
         ajaxDataPop(1);
     });
         $(document).on("click","#savapt",function () {
             var title=$("#ptTitle").html();
             var autor=$("#ptAutor").text();//原始id
             var digest=$("#ptdigest").text();//摘要
             var content=$("#ptcontent").text();//正文
             var webdata= {"wxPublicId": 14,"title":title,"author":autor,"digest":digest,"content":content,"show_cover_pic":1,"content_source_url":'',"thumb_media_id":''};
             var data=JSON.stringify(webdata);
             console.log(title)
             $.ajax({
                 contentType:'application/json; charset=utf-8',
                 url: contextPath +"material/upload/news",
                 type: "post",
                 data: data,
                 dataType: "json",
                 success: function(d){
                     alert(d.message)
                 }
             })
         })


