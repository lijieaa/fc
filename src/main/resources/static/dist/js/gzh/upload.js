
// 图片上传
function imgupload() {
    var uploader = WebUploader.create({
        auto: true,//是否自动上传
        swf: '../js/dist/Uploader.swf',
        pick: '#filePicker1',
        server: contextPath + 'material/upload',//传到服务器的链接
        formData: {
            wxPublicId: 14,
            wxtype:'image'
        },
        accept: {
            title: 'Images',
            extensions: 'gif,jpg,jpeg,bmp,png',
            mimeTypes: 'image/*'
        },
        fileVal:"media",
        fileSizeLimit: 1*1024*1024  //限制大小1M，所有被选文件，超出选择不上
    });
    uploader.on('uploadBeforeSend',function(obj,file,head) {
        delete file['id'];
        delete file['name'];
        delete file['lastModifiedDate'];
        delete file['type'];
        // console.log(file);
    });
    uploader.on('fileQueued',function(file) {
    });
    uploader.on( 'uploadSuccess', function( file ) {
        photoShow();
    });
    uploader.onError = function( code ) {
        alert( 'Eroor: ' + code );
        if (code=="Q_TYPE_DENIED"){
            alert("请上传图片格式的文件");
        }
    };
}
imgupload();
// 图片展示
var totalPage;
    function  ajaxData(pageNo) {
        var webdata={"wxtype":'image',"wxPublicId":14,"rows":10,"page":pageNo};
        $.ajax({
            url:contextPath +"material/page",
            type: "get",
            data:$.param(webdata),
            success:function(data){
                totalPage=data.content.data.pages;
                $("#NumMater").text(data.content.data.total);
                var dataList = data.content.data.list;
                $("#imgShow").html("");
                for(var i=0;i<dataList.length;i++){
                    var error="error";
                    var url=data.content.data.list[i].mediaId;
                    var name="test.jpg";
                    var urlLink = ''+contextPath+'material/image/detail?mediaId='+url+"&name="+name+"&wxPublicId="+14;
                    urlLink = encodeURI(urlLink);
                    $("#imgShow").append("<li id=''="+data.content.data.list[i].id+" ><img src='"+urlLink+"' title='"+name+"' alt='"+error+"'></li>");
                }
                $("#pagingTest").paging1({
                    pageNo:pageNo,
                    totalPage:totalPage
                })
            }
        });

    }
$(document).on("click","a",function () {
    var val = $("#page").val();
    if(!$(this).hasClass("disable")){
        ajaxData(val);
    }else{
        $("#pagingTest").paging1({
            pageNo:val,
            totalPage:totalPage
        })
    }

});

// 弹窗图片展示
function  ajaxDataPop(pageNo) {
    var webdata={"wxtype":'image',"wxPublicId":14,"rows":10,"page":pageNo};
    $.ajax({
        url:contextPath +"material/page",
        type: "get",
        data:$.param(webdata),
        success:function(data){
            var dataList = data.content.data.list;
            $("#popImg").html("");
            for(var i=0;i<dataList.length;i++){
                var error="error";
                var url=data.content.data.list[i].mediaId;
                //var name=data.content.data.list[i].name;
                var name="test.jpg";
                var urlLink = ''+contextPath+'material/image/detail?mediaId='+url+"&name="+name+"&wxPublicId="+14;
                urlLink = encodeURI(urlLink);
                $("#popImg").append("<li id=''="+data.content.data.list[i].id+" ><img src='"+urlLink+"' title='"+url+"' alt='"+error+"'></li>");
            }
            $("#popPagingTest").paging1({
                pageNo:pageNo,
                totalPage:data.content.data.pages
            })
        }
    });
}
$(document).on("click","#popPagingTest a",function () {
    var val = $("#popPage").val();
    ajaxData(val);
});

//语音上传
function yyupload() {
    var allMaxSize = 1;
    var uploader = WebUploader.create({
        auto: true,//是否自动上传
        swf: '../js/dist/Uploader.swf',
        pick: '#filePicker2',
        server: contextPath + 'material/upload',//传到服务器的链接
        timeout: 0,
        formData: {
            wxPublicId: 14,
            //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
            wxtype:'voice'
        },
        accept: {
            title: 'mp3',
            extensions: 'mp3',
            mimeTypes: 'audio/*'
        },
        fileVal:"media",
        duplicate:true,
        fileSizeLimit: allMaxSize*1024*1024  //限制大小2M，所有被选文件，超出选择不上
    });
    uploader.on('uploadBeforeSend',function(obj,file,head) {
        delete file['id'];
        delete file['name'];
        delete file['lastModifiedDate'];
        delete file['type'];
        // console.log(file);
    });
    uploader.on('fileQueued',function(file) {
        // console.log(file);
    });
    uploader.on( 'uploadSuccess', function( file ) {
        ajaxMp(1);
    });
    uploader.onError = function( code ) {
        //alert( 'Eroor: ' + code );
        if (code=="Q_TYPE_DENIED"){
            alert("请上传MP3格式的文件");
        }else if(code=="Q_EXCEED_SIZE_LIMIT"){
            alert("文件大小超过限制");
        }
    };
}
yyupload();
//语音展示
function  ajaxMp(pageNo) {
    var webdata={"wxtype":'voice',"wxPublicId":14,"total":0,"records":0,"rows":5,"page":pageNo};
    $.ajax({
        url:contextPath +"material/page",
        type: "get",
        data: $.param(webdata),
        success:function(data){
            var dataList = data.content.data.list;
            $("#mpShow").html("");
            var mpArr=[];
            for(var i=0;i<dataList.length;i++){
                mpArr.push(data.content.data.list[i].mediaId)
            }
            for(var i=0;i<mpArr.length;i++){
                var wxPublicId=14;
                var mediaId=mpArr[i];
                var name="test.mp3";
                var urlLink = ''+contextPath+'material/voice/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId+"&name="+name;
                urlLink = encodeURI(urlLink);
                $("#mpShow").append("<li><audio controls='controls' preload='auto' ><source src='"+urlLink+"' type=\"audio/mpeg\"></audio></li>");
                // $("#mpShow").append("<li ></li>");
                // var wxAudio = new Wxaudio({
                //     ele: '#mpShow li',
                //     title: 'Jar Of Love',
                //     disc: 'Break Me Up',
                //     src: urlLink,
                //     width: '500px'
                // });
            }
            $("#pagingTest1").paging1({
                pageNo:pageNo,
                totalPage:data.content.data.pages
            })
        }
    });
}
// $(document).on("click","a",function () {
//     var val = $("#page1").val();
//     ajaxMp(val);
// });
// 语音弹窗展示
function  ajaxMpPop(pageNo) {
    var webdata={"wxtype":'voice',"wxPublicId":14,"total":0,"records":0,"rows":10,"page":pageNo};
    $.ajax({
        url:contextPath +"material/page",
        type: "get",
        data: $.param(webdata),
        success:function(data){
            var dataList = data.content.data.list;
            $("#popImg").html("");
            var mpArr=[];
            for(var i=0;i<dataList.length;i++){
                mpArr.push(data.content.data.list[i].mediaId)
            }
            for(var i=0;i<mpArr.length;i++){
                var wxPublicId=14;
                var mediaId=mpArr[i];
                var name="wx.mp3";
                var urlLink = ''+contextPath+'material/voice/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId+"&name="+name;
                urlLink = encodeURI(urlLink);
                $("#popImg").append("<li><audio controls='controls' preload='auto' data-src='"+urlLink+"' data-id='"+mediaId+"'><source src='"+urlLink+"' type=\"audio/mpeg\"></audio></li>");
            }
            $("#popPagingTest").paging1({
                pageNo:pageNo,
                totalPage:data.content.data.pages
            })
        }
    });
}
// $(document).on("click","#popPagingTest a",function () {
//     var val = $("#popPage").val();
//     ajaxMp(val);
// });


function videoupload() {
    var uploader = WebUploader.create({
        auto: true,//是否自动上传
        swf: '../js/dist/Uploader.swf',
        pick: '#filePicker3',
        server: contextPath + 'material/upload',
        formData: {
            wxPublicId: 14,
            wxtype:'video'
        },
        accept: {
            title: 'video',
            extensions: 'mp4,ogg',
            mimeTypes: 'video/*'
        },
        fileVal:"media",
        duplicate:true,
        fileSizeLimit: 10*1024*1024  //限制大小10M，所有被选文件，超出选择不上
    });
    uploader.on('uploadBeforeSend',function(obj,file,head) {
        delete file['id'];
        delete file['name'];
        delete file['lastModifiedDate'];
        delete file['type'];
        var description={"title":"标题","introduction":"视频"};
        file.description=JSON.stringify(description);
    });
    uploader.on('fileQueued',function(file) {
        console.log(file);
    });
    uploader.on( 'uploadSuccess', function( file ) {
        ajaxVid(1);
    });
    uploader.onError = function( code ) {
        alert( 'Eroor: ' + code );
    };
}
videoupload();
//视频展示
function  ajaxVid(pageNo) {
    var webdata={"wxtype":"video","wxPublicId":14,"rows":10,"page":pageNo};
    $.ajax({
        url:contextPath +"material/page",
        type: "get",
        data: $.param(webdata),
        success:function(data){
            var dataList = data.content.data.list;
            $("#vidShow").html("");
            var videoArr=[];
            for(var i=0;i<dataList.length;i++){
                videoArr.push(data.content.data.list[i].mediaId)
            }
            for(var i=0;i<videoArr.length;i++){
                var wxPublicId=14;
                var mediaId=videoArr[i];
                var name="wx.mp4";
                $.ajax({
                    url:contextPath+'material/video/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId+"&name="+name,
                    type: "get",
                    success:function (data) {
                        $("#vidShow").append("<li><video src='"+data.content.down_url+"' controls='controls'></video></li>");
                    }
                })

            }
            $("#pagingTest2").paging1({
                pageNo:pageNo,
                totalPage:data.content.data.pages
            })
        }
    });
}
// $(document).on("click","a",function () {
//     var val = $("#page2").val();
//     ajaxVid(val);
// });

// 视频弹窗展示
function  ajaxVidPop(pageNo) {
    var webdata={"wxtype":"video","wxPublicId":14,"rows":10,"page":pageNo};
    $.ajax({
        url:contextPath +"material/page",
        type: "get",
        data: $.param(webdata),
        success:function(data){
            var dataList = data.content.data.list;
            $("#popImg").html("");
            var videoArr=[];
            for(var i=0;i<dataList.length;i++){
                videoArr.push(data.content.data.list[i].mediaId)
            }
            for(var i=0;i<videoArr.length;i++){
                var wxPublicId=14;
                let mediaId=videoArr[i];
                var name="test.mp4";
                $.ajax({
                    url:contextPath+'material/video/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId+"&name="+name,
                    type: "get",
                    success:function (data) {
                        $("#popImg").append("<li><video src='"+data.content.down_url+"' controls='controls' data-id='"+mediaId+"'></video></li>");
                    }
                })

            }
            $("#popPagingTest").paging1({
                pageNo:pageNo,
                totalPage:data.content.data.pages
            })
        }
    });
}
// $(document).on("click","#popPagingTest a",function () {
//     var val = $("#popPage").val();
//     ajaxMp(val);
// });

//点击图片选中状态
$(document).on("click","#imgShow li img",function () {
    var thisSrc=$(this).attr("src");
    $(this).addClass("opactiy").parent().siblings().children().removeClass("opactiy");
    $(this).parent().append("<a class='bgimg'></a>").siblings().children("a").remove();
//            alert(thisSrc)
})

// 图文展示
function photoText() {
    $.ajax({
        url:contextPath +"material/page?page=1&rows=10&wxtype=news&wxPublicId="+wxPublicId,
        type: "get",
        success:function(data){
            var list = data.content.data.list;
            if(data.status == 200 && list.length){
                for(var i=0; i<list.length;i++){
                     var id=list[i].thumbMediaId;
                    var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxPublicId;
                    let html = `<li class="messageLi" data-id="${list[i].id}">
                                    <div style="height: 250px;overflow: hidden">
                                        <p>${list[i].title}</p>
                                        <p><img src="${urlLink}" style="width: 200px;height: 150px;"> </p>
                                        <p>${list[i].digest}</p>
                                        <p>${list[i].updateTime}</p>
                                    </div>
                                </li>`
                    $("#photo-tx ul").append(html);
                }
            }
        }
    });
}
//单个图文悬浮效果
$(document).on("mouseenter",".messageLi",function () {
    $(this).append("<a class='bgshadow'>预览文章</a>").siblings().find("a").remove();
});
//单个图文点击跳转
$(document).on("click",".messageLi",function () {
    var thistwID=$(this).attr("data-id");
    $.ajax({
        url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+thistwID,
        type: "get",
        processData:true,
        success:function (data) {
            $('#aphoto').modal();
            $("#mySourcePhoto").text(data.content.title);
            $("#photoAutor>span:eq(0)").text(data.content.author);
            $("#photoAutor>span:eq(2)").text(data.content.updateTime);
            $("#photoContent").html(data.content.content)
        }
    })


});

