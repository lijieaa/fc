//中间商管理

$(document).ready(function() {
    Vue.component('option-item', {
        props: ['todo'],
        template: '<option>{{todo.name}}</option>'
    });
    new Vue({
        el:"#myMediary",
        data:{
            deviceName:"添加设备",
            selected:"3",
            projectList:[
                {val:1,name:"成都华西"},
                {val:2,name:"成都龙泉"},
                {val:3,name:"项目二"}
            ]
        },
        methods:{
            redirectMediary:function(){
                $("#mediaryList").hide();
                $("#mediaryAddEdit").show();
            },
            closePop:function(){
                $("#modal-default").removeClass("in").css("display","none")
            }
        },
        mounted:function(){
            var _this = this;
            $(document).on("click","#editDevice",function(){
                _this.deviceName = "编辑设备";
            });

            $(document).on("click","#log",function(){
                window.location.href = "log?menuId=1";
            });

            //
            $(document).on("click","#control",function(){
                window.location.href = "control?menuId=1";
            });

        //    创建上传图片
            var uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: false,
                // swf文件路径
                swf: '../js/dist/Uploader.swf',
                pick: '#filePicker',
                // 只允许选择图片文件。
                accept: {
                    title: 'Images',
                    extensions: 'gif,jpg,jpeg,bmp,png',
                    mimeTypes: 'image/*'
                }
            });
            // 当有文件添加进来的时候
            uploader.on( 'fileQueued', function( file ) {
                console.log(file);
                var $li = $(
                    '<div id="' + file.id + '" class="file-item thumbnail">' +
                    '<img>' +
                    '<div class="info">' + file.name + '</div>' +
                    '</div>'
                    );
                $("#fileList").html($li);
                uploader.makeThumb(file, function (error, src) {
                    console.log(src);
                    $("img").attr("src",src);
                    $("#fileList").addClass("active");
                });
            });
            var editor = new wysihtml5.Editor(
                "id-page-editor-a794381c",{
                    name: "page-editor-a794381c",
                    style: true,
                    toolbar:  "page-toolbar-a794381c",
                    parserRules:  ToolBarRules,
                    useLineBreaks: false,
                    stylesheets: href
                });

        }
    });
    $('#deviceForm').DataTable( {
        "ajax": "../dist/data/device.json",
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
            { "data": "status" },
            // { "data": "Salary" },
            { "data": "", "render": function(data, type, row, meta){
                    var html = "<button type='button' class='Normal margin-right-4 btn btn-primary' id='editDevice'>编辑</button>" +
                        "<button type='button' class='Normal margin-right-4 btn btn-primary' id='delete'>删除</button>" +
                        "<button type='button' class='Normal margin-right-4 btn btn-primary' id='detail'>详情</button>";

                    return html;
                }}

        ],
        "pageLength": 50,
        "stateLoadParams": function (settings, data) {
            alert(1);
        }
    } );
    $("#deviceForm").on( 'init.dt', function ( e, settings ) {
        //在此给变量赋值
        // console.log(1);
        $(".content-list").removeClass("display-none")
    });
    $("#deviceForm").on( 'draw', function () {
        alert( 'Table redrawn' );
    } );


} );