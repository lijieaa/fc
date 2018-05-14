//中间商管理
function showMenu() {
    $(".tree-div-contain").show();
    $("body").unbind("mousedown", onBodyDown);
}
function hideMenu() {
    $(".tree-div-contain").hide();
    $("body").unbind("mousedown", onBodyDown);
}
function onBodyDown(event) {
    if (!(event.target.id == "address"  || event.target.className == "tree-div-contain" || $(event.target).parents(".tree-div-contain").length>0)) {
        hideMenu();
    }
}
$(document).bind("click",function(e){
    onBodyDown(e) ;
});

$(document).ready(function(){

});

$(document).on("click",".search-list >li",function(){
    $(".tree-div-contain").hide();
    $("#address").val($(this).text());
    $("#treeDemo").show();
    $(".search-list").hide();
    var text = $(this).text();
    var treeObj = $.fn.zTree.getZTreeObj("treeDemo");
    var nodes = treeObj.transformToArray(treeObj.getNodes());
    $(".limit-style").val("");
    nodes.forEach(function(item,i){
        if(nodes[i].name == text){
            treeObj.selectNode(nodes[i]);
        }
    });

});
var uploader;
Vue.component('option-item', {
    props: ['todo'],
    template: '<option>{{todo.name}}</option>'
});
var responseUrl;
new Vue({
    el:"#myMediary",
    data:{
        companyName:"新增中间商",
        searchVal:"",
        selected:"3",
        // address:"",
        // addRessId:"",
        inputLimit:"", //搜索框
        projectList:[
            {val:1,name:"成都华西"},
            {val:2,name:"成都龙泉"},
            {val:3,name:"项目二"}
        ],
        facList:[],
        treeIsShow:false,
        broker:"",
        brokerPhone:"",
        editor:"" ,//文本编辑器
        editorId:"",
        delId:"",
        delErrorMsg:"",
        // responseUrl:"",
        editList:{
            area:{
                name:"",
                id:""
            },
            company: null,
            createTime: "",
            id: 1,
            intermediaryContact: "",
            intermediaryContactTel: "",
            intermediaryIntroduction: "",
            intermediaryLogoUrl: "",
            intermediaryName: "",
            isPlat: 1,
            updateTime: "",
            user:{
                id: 1,
                name: "",
                mobile: ""
            }
        }
    },
    methods:{
        redirectMediary:function(){
            var _this = this;
            $("#mediaryList").hide();
            $("#mediaryAddEdit").show();
            _this.companyName = "新增中间商";
        },
        backMediary:function(){
            location.reload();
        },
        closePop:function(){
            $("#modal-default").removeClass("in").css("display","none")
        },
        editorFun:function(){ //文本框编辑
            this.editor = CKEDITOR.replace( 'editor1', {
                customConfig: '',
                filebrowserImageUploadUrl:contextPath + 'intermediary/upload',
                removeDialogTabs:"image:advanced;image:Link",
                toolbarGroups: [
                    {"name":"basicstyles","groups":["basicstyles"]},
                    {"name":"links","groups":["links"]},
                    {"name":"paragraph","groups":["list","blocks"]},
                    // {"name":"document","groups":["mode"]},
                    {"name":"insert","groups":["insert"]},
                    {"name":"styles","groups":["styles"]},
                    {"name":"about","groups":["about"]}
                ],
                removePlugins:"elementspath"
//            removeButtons: 'Underline,Strike,Subscript,Superscript,Anchor,Styles,Specialchar'
            });
        }
        ,
        uploaderFun:function(){
            //    创建上传图片
            uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: false,
                // swf文件路径
                swf: '../js/dist/Uploader.swf',
                server: contextPath + 'intermediary/upload',
                pick: '#picker',
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
                var size = parseInt(file.size)/1024;
                var sizeSub = size.toString().substr(0,5);
                $("#size").text(sizeSub+"kb");
                uploader.makeThumb(file, function (error, src) {
                    $("#imgInter").attr("src",src);
                    $("#fileList").addClass("active");
                });
            });
            uploader.on( 'uploadSuccess', function( file ,response) {
                var _this = this;
                responseUrl = JSON.parse(response._raw).data;
            });
        },
        searchZtree:function(){
            var searchVal = this.searchVal;
            if(searchVal.length != 0){
                $.axspost(contextPath + "area/?shortName="+searchVal,"get","",function (data) {
                    var getData = data.data;
                    $(".search-list").html("");
                    if(getData.length != 0){
                        getData.forEach(function(item,i){
                            var li = "<li data-id="+getData[i].id+">"+getData[i].name+"</li>";
                            $(".search-list").append(li);
                            $("#treeDemo").hide();
                        })
                    }
                },function (data) {

                });
            }else{
                $("#treeDemo").show();
                $(".search-list").hide();
            }

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
                        _this.editList.area.name = treeNode.name;
                        _this.editList.area.id = treeNode.id;
                        // _this.treeIsShow = false;
                        $(".tree-div-contain").hide();
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
            $(".modalAll").removeClass("in").css("display","none");
        },
        sureSubmit:function(){ //添加中间商
        },
        sureDel:function(){
            var _this = this;
            $.axspost(contextPath + "intermediary/"+_this.delId+"","delete","",function(data){
                if(data.status == "200"){
                    $("#canDelate").removeClass("in").css("display","none");
                    _this.tableInit(true);
                }else{
                    $("#canDelate").removeClass("in").css("display","none");
                    $("#errorMsg").addClass("in").css("display","block");
                    _this.delErrorMsg = data.messages;
                    // console.log( _this.delErrorMsg);
                }
            },function(data){})
        },
        searchLimit:function(){ //按条件进行搜索
            var _this = this;
            _this.tableInit(true);
        },
        tableInit : function(flag){
            var _this = this;
            var val = parseInt($("#limitSelect").val());
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
            $('#deviceForm').DataTable({
                "ajax":{
                    // url:"../dist/data/device.json",
                    url: contextPath +"intermediary/page",
                    dataSrc:"data.list",
                    "data":postData
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

                }
            });
        },

        postImg:function(){
            uploader.upload();
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
        _this.tableInit(false);
        $(document).on("click","#editInter",function(){
            _this.editorId = $(this).attr("data-id");
            _this.companyName = "编辑中间商";
            $("#mediaryList").hide();
            $("#mediaryAddEdit").show();
            $.axspost(contextPath + "intermediary/"+$(this).attr("data-id")+"","get","",function(data){
                _this.editList = data;
                $("#imgInter").attr("src",data.intermediaryLogoUrl);
                responseUrl = data.intermediaryLogoUrl;
                CKEDITOR.instances.editor1.setData(data.intermediaryIntroduction);
            },function(data){})
        });
        setTimeout(function(){
            $(".webuploader-pick").next().css({
                position: "absolute",
                top: "0px",
                left: "15px",
                width: "85px",
                height: "40px",
                overflow: "hidden",

                opacity: 0
            });
        }, 1000);
        _this.$nextTick(function() {

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
        $("#sureSubmit").html5Validate(function() {
        // 全部验证通过，该干嘛干嘛~~
            var _this = this;
            var postData = {
                intermediaryName:_this.editList.intermediaryName, //中间商名称
                intermediaryContact:_this.editList.intermediaryContact,//中间商联系人
                intermediaryContactTel:_this.editList.intermediaryContactTel, //中间商联系方式
                intermediaryLogoUrl:  responseUrl,
                intermediaryIntroduction: CKEDITOR.instances.editor1.getData(),
                user:{
                    name:_this.editList.user.name,
                    mobile:_this.editList.user.mobile,
                    id:1
                },
                area:{
                    id:_this.editList.area.id
                }
            };
            var type;
            if(_this.editorId.length !=0 ){
                type = "put";
                postData.id = _this.editorId;
            }else{
                type = "post"
            }
            $.axspost(contextPath + "intermediary",type,JSON.stringify(postData),function(data){
                if(data.status == "200"){
                    // $("#errorMsg").addClass("in").css("display","block");
                    // _this.delErrorMsg = data.messages;
                    location.reload();
                }else{
                    $("#errorMsg").addClass("in").css("display","block");
                    _this.delErrorMsg = data.messages;
                }
            },function(data){})
        },{
            validate:function () {
                if(responseUrl == undefined){
                    $("#isSc").testRemind("请上传图片");
                    return false;
                }
                return true;
            }
        });


    }
});