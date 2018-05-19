    //
    // // 图片上传
    // function imgupload() {
    //     var uploader = WebUploader.create({
    //         auto: true,//是否自动上传
    //         swf: '../js/dist/Uploader.swf',
    //         pick: '#filePicker1',
    //         server: contextPath + 'material/upload',//传到服务器的链接
    //         formData: {
    //             wxPublicId: 14,
    //             //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
    //             wxtype:'image'
    //         },
    //         accept: {
    //             title: 'Images',
    //             extensions: 'gif,jpg,jpeg,bmp,png',
    //             mimeTypes: 'image/*'
    //         },
    //         fileVal:"media"
    //     });
    //     uploader.on('uploadBeforeSend',function(obj,file,head) {
    //         delete file['id'];
    //         delete file['name'];
    //         delete file['lastModifiedDate'];
    //         delete file['type'];
    //         // console.log(file);
    //     });
    //     uploader.on('fileQueued',function(file) {
    //         // console.log(file);
    //     });
    //     uploader.on( 'uploadSuccess', function( file ) {
    //         ajaxData(1);
    //     });
    //     uploader.onError = function( code ) {
    //         alert( 'Eroor: ' + code );
    //     };
    // }
    // imgupload();
    // function  ajaxData(pageNo) {
    //     $.ajax({
    //         url:contextPath +"material/page",
    //         type: "get",
    //         data: {
    //             wxtype:'image',
    //             wxPublicId:14,
    //             total:0,
    //             records:0,
    //             rows:10,
    //             page:pageNo
    //         },
    //         success:function(data){
    //             var dataList = data.data.list;
    //             $("#imgShow").html("");
    //             for(var i=0;i<dataList.length;i++){
    //                 var error="error";
    //                 var url=data.data.list[i].url;
    //                 var name=data.data.list[i].name;
    //                 var urlLink = ''+contextPath+'material/image/detail?url='+url+"&name="+name;
    //                 urlLink = encodeURI(urlLink);
    //                 // var li = "<li>"+dataList[i].id+"</li>";
    //                 // $("#imgShow").append(li);
    //                 $("#imgShow").append("<li id=''="+data.data.list[i].id+" alt=''="+data.data.list[i].name+"><img src='"+urlLink+"' title='"+data.data.list[i].name+"' alt='"+error+"'></li>");
    //             }
    //             $("#pagingTest").paging1({
    //                 pageNo:pageNo,
    //                 totalPage:data.data.pages
    //             })
    //         }
    //     });
    // }
    // $(document).on("click","a",function () {
    //     var val = $("#page").val();
    //     ajaxData(val);
    // });
    // ajaxData(1);
    //
    // //语音上传
    // function yyupload() {
    //     var allMaxSize = 10;
    //     var uploader = WebUploader.create({
    //         auto: true,//是否自动上传
    //         swf: '../js/dist/Uploader.swf',
    //         pick: '#filePicker2',
    //         server: contextPath + 'material/upload',//传到服务器的链接
    //         timeout: 0,
    //         formData: {
    //             wxPublicId: 14,
    //             //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
    //             wxtype:'voice'
    //         },
    //         accept: {
    //             title: 'mp3',
    //             extensions: 'mp3,ogg',
    //             mimeTypes: 'audio/*'
    //         },
    //         fileVal:"media",
    //         duplicate:true,
    //         fileSizeLimit: allMaxSize*1024*1024  //限制大小10M，所有被选文件，超出选择不上
    //     });
    //     uploader.on('uploadBeforeSend',function(obj,file,head) {
    //         delete file['id'];
    //         delete file['name'];
    //         delete file['lastModifiedDate'];
    //         delete file['type'];
    //         // console.log(file);
    //     });
    //     uploader.on('fileQueued',function(file) {
    //         // console.log(file);
    //     });
    //     uploader.on( 'uploadSuccess', function( file ) {
    //         alert('success');
    //     });
    //     uploader.onError = function( code ) {
    //         alert( 'Eroor: ' + code );
    //     };
    // }
    // yyupload();
    // function  ajaxMp(pageNo) {
    //     $.ajax({
    //         url:contextPath +"material/page",
    //         type: "get",
    //         data: {
    //             wxtype:'voice',
    //             wxPublicId:14,
    //             total:0,
    //             records:0,
    //             rows:10,
    //             page:1
    //         },
    //         success:function(data){
    //             var dataList = data.data.list;
    //             $("#mpShow").html("");
    //             for(var i=0;i<dataList.length;i++){
    //                 var error="error";
    //                 var url=data.data.list[i].url;
    //                 var name=data.data.list[i].name;
    //                 // var urlLink = ''+contextPath+'material/image/detail?url='+url+"&name="+name;
    //                 // urlLink = encodeURI(urlLink);
    //                 // var li = "<li>"+dataList[i].id+"</li>";
    //                 // $("#imgShow").append(li);
    //                 $("#mpShow").append("<li id=''="+data.data.list[i].id+"><audio src='"+url+"' title='"+data.data.list[i].name+"'></audio></li>");
    //             }
    //             $("#pagingTest").paging1({
    //                 pageNo:pageNo,
    //                 totalPage:data.data.pages
    //             })
    //         }
    //     });
    // }
    // $(document).on("click","a",function () {
    //     var val = $("#page").val();
    //     ajaxMp(val);
    // });
    // ajaxMp(1);
    //
    //
    // function videoupload() {
    //     var allMaxSize = 20;
    //     var uploader = WebUploader.create({
    //         auto: true,//是否自动上传
    //         swf: '../js/dist/Uploader.swf',
    //         pick: '#filePicker3',
    //         server: contextPath + 'material/upload',//传到服务器的链接
    //         formData: {
    //             wxPublicId: 14,
    //             //media:'u=177485426,2064801038&fm=27&gp=0.jpg',
    //             wxtype:'video',
    //             description:{
    //                 "title":"111",
    //                 "introduction":"2222"
    //             }
    //         },
    //         accept: {
    //             title: '视频上传',
    //             extensions: 'mp4,3gp,mp4,rmvb,mov,avi,m4v',
    //             mimeTypes: 'video/*,application/*'
    //         },
    //         fileVal:"media",
    //         duplicate:true,
    //         fileNumLimit: 1,
    //         fileSizeLimit: allMaxSize*1024*1024  //限制大小10M，所有被选文件，超出选择不上
    //     });
    //     uploader.on('uploadBeforeSend',function(obj,file,head) {
    //         delete file['id'];
    //         delete file['name'];
    //         delete file['lastModifiedDate'];
    //         delete file['type'];
    //          console.log(obj);
    //     });
    //     uploader.on('fileQueued',function(file) {
    //         // console.log(file);
    //     });
    //     uploader.on( 'uploadSuccess', function( file ) {
    //         alert('success');
    //     });
    //     uploader.onError = function( code ) {
    //         alert( 'Eroor: ' + code );
    //     };
    // }
    // videoupload();
    //
