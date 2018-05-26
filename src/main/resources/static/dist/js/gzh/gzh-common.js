
$(function () {
    //子页面返回主页面
    $(document).on("click","#backUl",function () {
        window.location.href="http://localhost:8080/wxPublic/index?mid=11";
    })
    //各页面切换
    $(".gzh-manage-menu>a").click(function () {
        var thisID=$(this).attr("data-id");
        if(thisID==1){
            window.location.href="http://localhost:8080/wxPublic/user/?wxPublicId=14";
        }else if(thisID==2){
            window.location.href="http://localhost:8080/wxPublic/menu/?wxPublicId=14";
        }else if(thisID==3){
            window.location.href="http://localhost:8080/wxPublic/msg/?wxPublicId=14";
        }else if (thisID==4){
            window.location.href="http://localhost:8080/wxPublic/material/?wxPublicId=14";
        }
    })
})