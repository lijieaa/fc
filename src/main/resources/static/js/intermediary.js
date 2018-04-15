//中间商管理

$(document).ready(function() {
    Vue.component('option-item', {
        props: ['todo'],
        template: '<option>{{todo.name}}</option>'
    });
    new Vue({
        el:"#myMediary",
        data:{
            companyName:"新增中间商",
            selected:"3",
            projectList:[
                {val:1,name:"成都华西"},
                {val:2,name:"成都龙泉"},
                {val:3,name:"项目二"}
            ],
            facList:[],
            treeIsShow:false
        },
        methods:{
            redirectMediary:function(){
                var _this = this;
                $("#mediaryList").hide();
                $("#mediaryAddEdit").show();
                _this.companyName = "新增中间商";
            },
            backMediary:function(){
                $("#mediaryList").show();
                $("#mediaryAddEdit").hide();
            },
            closePop:function(){
                $("#modal-default").removeClass("in").css("display","none")
            },
            editorFun:function(){
                CKEDITOR.replace( 'editor1', {
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
            },
            uploaderFun:function(){
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
                    var $li = $(
                        '<div id="' + file.id + '" class="file-item thumbnail">' +
                        '<img></div>'
                    );
                    $("#fileList").html($li);
                    uploader.makeThumb(file, function (error, src) {
                        $("img").attr("src",src);
                        $("#fileList").addClass("active");
                    });
                });


            },
            treeShow:function(e){
                // e.stopPropagation()
                var _this = this;
                _this.treeIsShow = true;
            },
            treeHide:function(){
                var _this = this;
                // _this.treeIsShow = false;
            },
            zTreeInit:function(){
                var _this = this;
                return {
                    useTree : function(ele,zNodes,inputEle){
                    var setting = {
                        async: {
                            enable: true,
                            url: getUrl,
                            type: "get"
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        },
                        callback: {
                            // beforeClick: zTreeBeforeClick,
                            onClick:zTreeOnclick,
                            beforeExpand: beforeExpand
                            // onAsyncSuccess:onAsyncSuccess
                        },
                        view: {
                            fontCss: getFontCss,
                            showLine: false,
                            showIcon:false
                        }
                    };
                    function getFontCss(treeId, treeNode) {
                        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
                    }
                    function zTreeOnclick(event, treeId, treeNode) {
                        // $(inputEle).val(treeNode.name).attr("data-id",treeNode.id);
                        // _this.treeIsShow = false;
                        // console.log(treeNode);
                        // $.axspost("/area/condition?level="+parseInt(treeNode.level+2)+"&parent="+parseInt(treeNode.id),"get","",function(data){
                            // _this.facList = data.data;
                            // _this.zTreeInit().useTree($("#treeDemo"),_this.facList,"#address");
                        // });
                    }
                    function getUrl(treeId, treeNode){

                        return "/area/condition?level="+parseInt(treeNode.level+2)+"&parent="+parseInt(treeNode.id);
                    }
                    function beforeExpand(treeId, treeNode) {
                        console.log(treeNode);

                        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                        // var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                        // var nodes = treeObj.getNodes();
                        // console.log(nodes[0]);
                        treeObj.updateNode(nodes[0]);
                        treeObj.reAsyncChildNodes(nodes[0], "refresh");
                        // zTree.reAsyncChildNodes(treeNode, reloadType, true);


                        // if (!treeNode.isAjaxing) {
                        // } else {
                        //
                        // }
                    }
                    $.fn.zTree.init(ele, setting, zNodes);
                }
                }

            }
        },
        mounted:function(){
            var _this = this;
            $(document).on("click","#editDevice",function(){
                _this.companyName = "编辑中间商";
                $("#mediaryList").hide();
                $("#mediaryAddEdit").show();
            });

            $(document).on("click","#detail",function(){
                window.location.href = "detail?menuId=4";
            });
            $(document).bind("click",function(){
                // _this.treeIsShow = false;
                // console.log( _this.treeIsShow);
            });

            _this.editorFun(); //初始化生成编辑器
            _this.uploaderFun();  //上传图片
            $.axspost("/area/condition?level=1","get","",function(data){
                _this.facList = data.data;
                _this.zTreeInit().useTree($("#treeDemo"),_this.facList,"#address");
            },function (data) {

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