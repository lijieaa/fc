
    // 图片上传
    function imgupload() {
        var uploader = WebUploader.create({
            auto: true,//是否自动上传
            swf: '../js/dist/Uploader.swf',
            pick: '#filePicker1',
            server: contextPath + 'material/upload',//传到服务器的链接
            formData: {
                wxPublicId: 14,
                //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
                wxtype:'image'
            },
            accept: {
                title: 'Images',
                extensions: 'gif,jpg,jpeg,bmp,png',
                mimeTypes: 'image/*'
            },
            fileVal:"media"
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
            ajaxData(1);
        });
        uploader.onError = function( code ) {
            alert( 'Eroor: ' + code );
        };
    }
    imgupload();
// 图片展示
    function  ajaxData(pageNo) {
        $.ajax({
            url:contextPath +"material/page",
            type: "get",
            data: {
                wxtype:'image',
                wxPublicId:14,
                total:0,
                records:0,
                rows:10,
                page:pageNo
            },
            success:function(data){
                var dataList = data.data.list;
                $("#imgShow").html("");
                for(var i=0;i<dataList.length;i++){
                    var error="error";
                    var url=data.data.list[i].url;
                    var name=data.data.list[i].name;
                    var urlLink = ''+contextPath+'material/image/detail?url='+url+"&name="+name;
                    urlLink = encodeURI(urlLink);
                    $("#imgShow").append("<li id=''="+data.data.list[i].id+" alt=''="+data.data.list[i].name+"><img src='"+urlLink+"' title='"+data.data.list[i].name+"' alt='"+error+"'></li>");
                }
                $("#pagingTest").paging1({
                    pageNo:pageNo,
                    totalPage:data.data.pages
                })
            }
        });
    }
    $(document).on("click","a",function () {
        var val = $("#page").val();
        ajaxData(val);
    });

    // 弹窗图片展示
    function  ajaxDataPop(pageNo) {
        $.ajax({
            url:contextPath +"material/page",
            type: "get",
            data: {
                wxtype:'image',
                wxPublicId:14,
                total:0,
                records:0,
                rows:10,
                page:pageNo
            },
            success:function(data){
                var dataList = data.data.list;
                $("#popImg").html("");
                for(var i=0;i<dataList.length;i++){
                    var error="error";
                    var url=data.data.list[i].url;
                    var name=data.data.list[i].name;
                    var urlLink = ''+contextPath+'material/image/detail?url='+url+"&name="+name;
                    urlLink = encodeURI(urlLink);
                    $("#popImg").append("<li id=''="+data.data.list[i].id+" alt=''="+data.data.list[i].name+"><img src='"+urlLink+"' title='"+data.data.list[i].name+"' alt='"+error+"'></li>");
                }
                $("#popPagingTest").paging1({
                    pageNo:pageNo,
                    totalPage:data.data.pages
                })
            }
        });
    }
    $(document).on("click","a",function () {
        var val = $("#popPage").val();
        ajaxDataPop(val);
    });

    //语音上传
    function yyupload() {
        var allMaxSize = 10;
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
                extensions: 'mp3,ogg',
                mimeTypes: 'audio/*'
            },
            fileVal:"media",
            duplicate:true,
            fileSizeLimit: allMaxSize*1024*1024  //限制大小10M，所有被选文件，超出选择不上
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
            alert('success');
        });
        uploader.onError = function( code ) {
            alert( 'Eroor: ' + code );
        };
    }
    yyupload();
    function  ajaxMp(pageNo) {
        $.ajax({
            url:contextPath +"material/page",
            type: "get",
            data: {
                wxtype:'voice',
                wxPublicId:14,
                total:0,
                records:0,
                rows:10,
                page:1
            },
            success:function(data){
                //console.log(data.data.list.length)
                //data.data.list[0].mediaId
                var dataList = data.data.list;
                $("#mpShow").html("");
                var mpArr=[];
                for(var i=0;i<dataList.length;i++){
                    mpArr.push(data.data.list[i].mediaId)
                }
                for(var i=0;i<mpArr.length;i++){
                    var error="error";
                    var wxPublicId=14;
                    var mediaId=mpArr[i];
                    var urlLink = ''+contextPath+'material/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId;
                    urlLink = encodeURI(urlLink);
                    $("#mpShow").append("<li><audio controls=\"controls\" ><source src='\"+urlLink+\"' type=\"audio/mpeg\"><source src='"+urlLink+"' type=\"audio/ogg\"><embed  src='"+urlLink+"'></audio></li>");
                }
                $("#pagingTest1").paging1({
                    pageNo:pageNo,
                    totalPage:data.data.pages
                })
            }
        });
    }
    // $(document).on("click","a",function () {
    //     var val = $("#page1").val();
    //     ajaxMp(val);
    // });


    function videoupload() {
        var uploader = WebUploader.create({
            auto: true,//是否自动上传
            swf: '../js/dist/Uploader.swf',
            pick: '#filePicker3',
            server: contextPath + 'material/upload',//传到服务器的链接
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
            fileSizeLimit: 20*1024*1024  //限制大小10M，所有被选文件，超出选择不上
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
            alert('success');
        });
        uploader.onError = function( code ) {
            alert( 'Eroor: ' + code );
        };
    }
    videoupload();
    function  ajaxVid(pageNo) {
        $.ajax({
            url:contextPath +"material/page",
            type: "get",
            data: {
                wxtype:'video',
                wxPublicId:14,
                total:0,
                records:0,
                rows:10,
                page:1
            },
            success:function(data){
                //console.log(data.data.list.length)
                //data.data.list[0].mediaId
                var dataList = data.data.list;
                $("#vidShow").html("");
                var videoArr=[];
                for(var i=0;i<dataList.length;i++){
                    videoArr.push(data.data.list[i].mediaId)
                }
                for(var i=0;i<videoArr.length;i++){
                    var error="error";
                    var wxPublicId=14;
                    var mediaId=videoArr[i];
                    $.ajax({
                        url:contextPath+'material/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId,
                        type: "get",
                        success:function (data) {
                            var obj = eval( "(" + data + ")" );
                             $("#vidShow").append("<li><video src='"+obj.down_url+"' controls='controls'></video></li>");
                        }
                    })
                    // var urlLink = ''+contextPath+'material/detail?wxPublicId='+wxPublicId+"&mediaId="+mediaId;
                    // urlLink = encodeURI(urlLink);

                }
                $("#pagingTest2").paging1({
                    pageNo:pageNo,
                    totalPage:data.data.pages
                })
            }
        });
    }
    // $(document).on("click","a",function () {
    //     var val = $("#page2").val();
    //     ajaxVid(val);
    // });

