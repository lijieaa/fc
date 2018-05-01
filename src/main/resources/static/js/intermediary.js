//中间商管理
function changeImg() {
    alert(1);
    var reads = new FileReader();
    var file = document.getElementById("file").files[0];
    reads.readAsDataURL(file);

    reads.onload = function(e){
        console.log(this.result);
        document.getElementById("imgInter").src = this.result;
    }
}
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
            address:"",
            addRessId:"",
            inputLimit:"", //搜索框
            projectList:[
                {val:1,name:"成都华西"},
                {val:2,name:"成都龙泉"},
                {val:3,name:"项目二"}
            ],
            facList:[],
            treeIsShow:false,
            intermediaryName:"",
            intermediaryContact:"",
            intermediaryContactTel:"",
            broker:"",
            brokerPhone:"",
            editor:"" ,//文本编辑器
            editorId:"",
            delId:"",
            delErrorMsg:"是否删除当前信息?"
        },
        methods:{
            redirectMediary:function(){
                var _this = this;
                $("#mediaryList").hide();
                $("#mediaryAddEdit").show();
                _this.companyName = "新增中间商";
            },
            backMediary:function(){
                // $("#mediaryList").show();
                // $("#mediaryAddEdit").hide();
                location.reload();
            },
            closePop:function(){
                $("#modal-default").removeClass("in").css("display","none")
            },
            editorFun:function(){ //文本框编辑
                this.editor = CKEDITOR.replace( 'editor1', {
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
            // changeImg:function(){
            //
            // },
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
                            type: "get",
                            dataFilter: ajaxDataFilter
                        },
                        data: {
                            simpleData: {
                                enable: true
                            }
                        },
                        callback: {
                            onClick:zTreeOnclick,
                            beforeExpand: beforeExpand,
                            onAsyncSuccess:onAsyncSuccess
                        },
                        view: {
                            fontCss: getFontCss,
                            showLine: false
                            // showIcon:false
                        }
                    };
                    function getFontCss(treeId, treeNode) {
                        return (!!treeNode.highlight) ? {color:"#A60000", "font-weight":"bold"} : {color:"#333", "font-weight":"normal"};
                    }
                    //异步加载返回的数据
                    function ajaxDataFilter(treeId, parentNode, responseData) {
                        return responseData.data;
                    }
                    function zTreeOnclick(event, treeId, treeNode) {
                        _this.address = treeNode.name;
                        _this.addRessId = treeNode.id;
                        _this.treeIsShow = false;
                    }
                    function getUrl(treeId, treeNode){
                        return contextPath +"area/condition?level="+parseInt(treeNode.level+2)+"&parent="+parseInt(treeNode.id);
                    }
                    function beforeExpand(treeId, treeNode) {
                        if (!treeNode.isAjaxing) {
                            return true;
                        } else {
                            alert("zTree 正在下载数据中，请稍后展开节点。。。");
                            return false;
                        }
                    }
                    function onAsyncSuccess(event, treeId, treeNode, msg) {
                        var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
                        treeObj.updateNode(treeNode);
                    }
                    $.fn.zTree.init(ele, setting, zNodes);
                }
                }

            },
            closeDelPop:function(){
                $("#canDelate").removeClass("in").css("display","none")
            },
            sureSubmit:function(){ //添加中间商
                var _this = this;
                var postData = {
                    intermediaryName:_this.intermediaryName, //中间商名称
                    intermediaryContact:_this.intermediaryContact,//中间商联系人
                    intermediaryContactTel:_this.intermediaryContactTel, //中间商联系方式
                    area:{
                        id:_this.addRessId
                    },
                    broker:_this.broker,
                    brokerPhone:_this.brokerPhone,
                    intermediaryLogoUrl:"",
                    intermediaryIntroduction: CKEDITOR.instances.editor1.getData()
                };
                var type;
                if(_this.editorId.length !=0 ){
                    type = "put";
                    postData.id = _this.editorId;
                }else{
                    type = "post"
                }
                $.axspost(contextPath + "intermediary",type,postData,function(data){

                },function(data){})
            },
            sureDel:function(){
                $.axspost(contextPath + "intermediary/"+this.delId+"","delete","",function(data){
                },function(data){})
            },
            searchLimit:function(){ //按条件进行搜索
                var _this = this;
                var val = parseInt($("#limitSelect").val());
                console.log(val);
                var postData = {
                    "page":1,
                    "rows":10
                };
                switch (val){
                    case 1 :{
                        postData.intermediaryName = _this.inputLimit;
                        break;
                    }
                    case 2:{
                        postData.area.name = _this.inputLimit;
                        break;
                    }
                    case 3:{
                        postData.intermediaryContact = _this.inputLimit;
                        break;
                    }
                    case 4:{
                        postData.intermediaryContactTel = _this.inputLimit;
                        break;
                    }
                }
                _this.tableInit(postData,true);
            },
            tableInit : function(data,flag){
                $('#deviceForm').DataTable({
                    "ajax":{
                        // url:"../dist/data/device.json",
                        url: contextPath +"intermediary/page",
                        dataSrc:"data.list",
                        "data":data
                    },
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
                    "destroy":flag,
                    "columns": [
                        { "data": "intermediaryName" },
                        { "data": "area.name" },
                        { "data": "intermediaryContact" },
                        { "data": "intermediaryContactTel" },
                        { "data": "user.name" },
                        { "data": "user.mobile"},
                        { "data": "", "render": function(data, type, row, meta){
                                var html = "<button type='button' class='Normal margin-right-4 btn btn-primary' data-id='"+row.id+"' id='editInter'>编辑</button>" +
                                    "<button type='button' class='Normal margin-right-4 btn btn-primary' data-id='"+row.id+"' id='delete'>删除</button>" +
                                    "<button type='button' class='Normal margin-right-4 btn btn-primary' data-id='"+row.id+"' id='detail'>详情</button>";
                                return html;
                            }}

                    ],
                    "pageLength": 10,
                    "stateLoadParams": function (settings, data) {
                        alert(1);
                    }
                });
            }
        },
        mounted:function(){
            var _this = this;
            _this.editorFun(); //初始化生成编辑器
            _this.uploaderFun();  //上传图片
            $.axspost(contextPath + "area/condition?level=1","get","",function(data){
                _this.facList = data.data;
                _this.zTreeInit().useTree($("#treeDemo"),_this.facList,"#address");//初始化生成树
            },function (data) {});
            var data =  {
                "page":1,
                "rows":10
            };
           _this.tableInit(data,false);

            $(document).on("click","#editInter",function(){
                _this.editorId = $(this).attr("data-id");
                // console.log(_this.editorId);
                _this.companyName = "编辑中间商";
                $("#mediaryList").hide();
                $("#mediaryAddEdit").show();
            });

            //删除
            $(document).on("click","#delete",function(){
                var id = $(this).attr("data-id");
                _this.delId = id;
                $("#canDelate").show();
                $("#canDelate").addClass("in").css("display","block")

            });
            $(document).on("click","#detail",function(){
                window.location.href = "detail?menuId=4&"+$(this).attr("data-id");
            });


        }
    });



} );