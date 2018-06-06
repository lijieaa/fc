
$(function () {
    //子页面返回主页面
    // $(document).on("click","#backUlOther",function () {
    //     window.location.href="/wxPublic/index?mid=11";
    // })
    $(document).on("click","#backUl",function () {
        window.location.href="/wxPublic/index?mid=11";
    })
    //各页面切换
    $(".gzh-manage-menu>a").click(function () {
        var thisID=$(this).attr("data-id");
        if(thisID==1){
            window.location.href="/wxPublic/user?wxPublicId="+wxPublicId;
        }else if(thisID==2){
            window.location.href="/wxPublic/menu?wxPublicId="+wxPublicId;
        }else if(thisID==3){
            window.location.href="/wxPublic/msg?wxPublicId="+wxPublicId;
        }else if (thisID==4){
            window.location.href="/wxPublic/material?wxPublicId="+wxPublicId;
        }
    })
    //聊天点击点击跳转不同弹窗
    $(".chat-type>span").click(function () {
        var data_id=$(this).attr("data-id");
        $(this).addClass("txt-green").siblings().removeClass("txt-green");
        if(data_id==2){
            $("#textInput").show();
            $("#mediaDiv").hide();
            $("#textInput").focus();
            $("#sender").attr("data-id",2);
        }else{
            $('#sourceRoom').modal();
            if(data_id==1){
                $("#textInput").hide();
                $("#mediaDiv").show();
                $("#mySource").text("选择素材");
                $(".new-source").text("新建图文消息").attr("data-id","1");
                $("#sender").attr("data-id",1);
            }else if(data_id==3){
                $("#textInput").hide();
                $("#mediaDiv").show();
                $("#mySource").text("选择图片");
                $(".new-source").text("上传图片").attr("data-id","2");
                $("#sender").attr("data-id",3);
                ajaxDataPop(1);
            }else if(data_id==4){
                $("#textInput").hide();
                $("#mediaDiv").show();
                $("#mySource").text("选择语音");
                $(".new-source").text("上传语音").attr("data-id","3");
                $("#sender").attr("data-id",4);
            }else if(data_id==5){
                $("#textInput").hide();
                $("#mediaDiv").show();
                $("#mySource").text("选择视频");
                $(".new-source").text("上传视频").attr("data-id","4");
                $("#sender").attr("data-id",5);
            }
        }
    })
    //文本区域改变
    $(document).on('keyup', '#textInput', function() {
        var limitNum=100;
        var remain = $(this).val().length;
        $("#limNum").text(remain)
        if(remain > limitNum){
            alert("字数超过限制")
        }else{
            var result = limitNum - remain;
            $("#limNum").text(result)
        }
    });

    //将lone型数据转换为datetime型
    function datetimeFormat(longTypeDate){
        var date = new Date();
        date.setTime(longTypeDate);
        var mouth =  parseInt(date.getMonth()+1);
        var dateDay = date.getDate();
        var hours = date.getHours();
        var minutes = date.getMinutes();
        var showMonth = mouth<10 ? "0"+mouth :mouth;
        var showDay = dateDay<10 ? "0"+dateDay :dateDay;
        var showHour = hours<10 ? "0"+hours :hours;
        var showMinutes = minutes<10 ? "0"+minutes :minutes;
        var datetimeType = date.getFullYear()+"-"+showMonth+"-"+showDay+
            "&nbsp;"+showHour+":"+showMinutes;//yyyy-MM-dd 00:00:00格式日期
        return datetimeType;
    }
    // 点击弹窗新建跳转到不同的页面
    $(".new-source").click(function () {
        var cliText=$(this).attr("data-id");
        window.location.href="/wxPublic/material?wxPublicId="+wxPublicId+"&id="+cliText;

    })
    //图片选中
    var thisSrc;
    var thisphotoId;
    $(document).on("click","#popImg li img",function () {
        thisSrc=$(this).attr("src");
        thisphotoId=$(this).attr("title");
        $(this).addClass("opactiy").parent().siblings().children().removeClass("opactiy");
        $(this).parent().append("<a class='bgimg'></a>").siblings().children("a").remove();
    });
    $(document).on("click","#btn-sure-source",function () {
        $('#sourceRoom').modal("hide");
        var title1 = '<img class="content-img" src='+thisSrc+'>';
        $("#mediaDiv").append(title1);
    })
//发送消息
    $(document).on("click","#sender",function () {
          var thisName=$(this).attr("data-name");
          var thisID=$(this).attr("data-id");
          if(thisID==2){
              var content=$("#textInput").val();
              var webdata={"ToUserName":thisName,"wxPublicId":14,"MsgType":"text","Content":content};
              $.ajax({
                  url:contextPath +"message",
                  type: "POST",
                  data: $.param(webdata),
                  success:function(data){
                      alert(data.status)
                  },
                  error:function (data) {
                      alert(data.status)
                  }

              });
          }
        if(thisID==3){
            var content=$("#textInput").val();
            var webdata={"ToUserName":thisName,"wxPublicId":14,"MsgType":"image","MediaId":thisphotoId};
            $.ajax({
                url:contextPath +"message",
                type: "POST",
                data: $.param(webdata),
                success:function(data){
                    alert(data.status)
                },
                error:function (data) {
                    alert(data.status)
                }

            });
        }
    })


})