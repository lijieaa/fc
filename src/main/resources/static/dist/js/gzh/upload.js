
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
            console.log(file);
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
    imgupload();
    function yyupload() {
        var uploader = WebUploader.create({
            auto: true,//是否自动上传
            swf: '../js/dist/Uploader.swf',
            pick: '#filePicker2',
            server: contextPath + 'material/upload',//传到服务器的链接
            formData: {
                wxPublicId: 14,
                //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
                wxtype:'voice'
            },
            accept: {
                title: 'mp3',
                extensions: 'mp3',
                mimeTypes: 'mp3/*'
            },
            fileVal:"media"
        });
        uploader.on('uploadBeforeSend',function(obj,file,head) {
            delete file['id'];
            delete file['name'];
            delete file['lastModifiedDate'];
            delete file['type'];
            console.log(file);
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
    function videoupload() {
        var uploader = WebUploader.create({
            auto: true,//是否自动上传
            swf: '../js/dist/Uploader.swf',
            pick: '#filePicker3',
            server: contextPath + 'material/upload',//传到服务器的链接
            formData: {
                wxPublicId: 14,
                //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
                wxtype:'video'
            },
            accept: {
                title: 'video',
                extensions: 'mp4',
                mimeTypes: 'video/*'
            },
            fileVal:"media"
        });
        uploader.on('uploadBeforeSend',function(obj,file,head) {
            delete file['id'];
            delete file['name'];
            delete file['lastModifiedDate'];
            delete file['type'];
            console.log(file);
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
    videoupload();
    // function  ajaxData(pageNo) {
    //     $.ajax({
    //         url:contextPath +"material/page",
    //         success:function(data){
    //             var dataList = data.list;
    //             $("#imgShow").html("");
    //             dataList.map(function(v){
    //                 var li = "<li>"+v.name+"</li>";
    //                 $("#imgShow").append(li);
    //             });
    //             $("#pagingTest").paging1({
    //                 pageNo:pageNo,
    //                 totalPage:data.totalPage
    //             })
    //         }
    //     });
    // }
    // $(document).on("click","a",function () {
    //     var val = $("#page").val();
    //     ajaxData(val);
    // });
    // ajaxData(1);
