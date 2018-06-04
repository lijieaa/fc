
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
        //$("#sourceRoom").modal("hide");
        // if(cliText=="1"){
        //     $(".gzh-source-type a:eq(0)").addClass("cli-color").siblings().removeClass("cli-color");
        //     $(".new-type-name").text("图文消息");
        //     $("#filePicker").show().siblings().hide();
        //     $("#photo-tx").show().siblings().hide();
        // } else if(cliText=="2"){
        //     $(".gzh-source-type a:eq(1)").addClass("cli-color").siblings().removeClass("cli-color");
        //     $(".new-type-name").text("图片");
        //     $("#filePicker1").show().siblings().hide();
        //     $("#photo-show").show().siblings().hide();
        // } else if(cliText=="3"){
        //     $(".gzh-source-type a:eq(2)").addClass("cli-color").siblings().removeClass("cli-color");
        //     $(".new-type-name").text("语音");
        //     $("#filePicker2").show().siblings().hide();
        //     $("#source").show().siblings().hide();
        // } else if(cliText=="4"){
        //     $(".gzh-source-type a:eq(3)").addClass("cli-color").siblings().removeClass("cli-color");
        //     $(".new-type-name").text("视频");
        //     $("#filePicker3").show().siblings().hide();
        //     $("#vid").show().siblings().hide();
        // }
    })

})