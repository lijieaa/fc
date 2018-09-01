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
Vue.component('option-item', {
    props: ['todo'],
    template: '<option>{{todo.name}}</option>'
});
var responseUrl;
new Vue({
    el:"#myClues",
    data:{
        deviceName:"添加线索",
        inputLimit:"",
        searchVal:"",
        selected:"3",
        editorId:"",
        delErrorMsg:"",
        projectList:[
            {val:1,name:"成都华西"},
            {val:2,name:"成都龙泉"},
            {val:3,name:"项目二"}
        ],
        editList:{
            area:{
                name:"",
                id:""
            },
            projectName: "",
            projectContactUser:{
                id:"",
                name:1
            },
            projectOwnerContact: "",
            projectOwnerContactTel: "",
            projectLogo: "",
            projectStatus:0,
            projectTopicStatus:0
        }
    },
    methods:{
        addDevice:function(){
            this.deviceName = "添加线索";
            $("#modal-default").addClass("in").css("display","block")
        },
        closePop:function(){
            $("#modal-default").removeClass("in").css("display","none")
        },
        closeDelPop:function(){
            $(".modalAll").removeClass("in").css("display","none");
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
                "rows":10,
                "projectStatus":0
            };
            switch (val){
                case 1 :{
                    postData.projectName = _this.inputLimit;//线索名称
                    break;
                }
                case 2:{
                    postData["projectContactUser.id"]= _this.inputLimit;//负责人
                    break;
                }
                case 3:{
                    postData.projectOwnerContact = _this.inputLimit; //业主名
                    break;
                }
                case 4:{
                    postData.projectOwnerContactTel= _this.inputLimit; //业务联系电话
                    break;
                }
            }
            $('#deviceForm').DataTable({
                "ajax":{
                    // url:"../dist/data/device.json",
                    url: contextPath +"project/page",
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
                    { "data": "id"},
                    { "data": "projectName"},
                    { "data": "projectContactUser.name"},
                    { "data": "projectOwnerContact"},
                    { "data": "projectOwnerContactTel"},
                    // { "data": "intermediary.intermediaryName" },
                    { "data": "", "render": function(data, type, row, meta){
                            var html = "<button type='button' class='Normal margin-right-4 btn btn-primary' data-id='"+row.id+"' id='editClubs'>编辑</button>" +
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
                            $(".search-list").append(li).show();
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
        uploaderFun:function(){
            //    创建上传图片
            uploader = WebUploader.create({
                // 选完文件后，是否自动上传。
                auto: true,
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
                console.log(responseUrl);
            });
        },
        sureSubmit:function(){
            var _this = this;
            var postData = {
                projectLogo:responseUrl,
                area:{
                    id:_this.editList.area.id
                },
                projectName:_this.editList.projectName,
                projectContactUser:{
                    id:1
                },
                projectOwnerContact:_this.editList.projectOwnerContact,
                projectOwnerContactTel:_this.editList.projectOwnerContactTel,
                projectTopicStatus:_this.editList.projectTopicStatus,
                projectStatus:0
            };
            var type;
            if(_this.editorId.length !=0 ){
                type = "put";
                postData.id = _this.editorId;
            }else{
                type = "post"
            }
            $.axspost(contextPath + "project",type,JSON.stringify(postData),function(data){
                if(data.status == "200"){
                    location.reload();
                }else{
                    $("#errorMsg").addClass("in").css("display","block");
                    _this.delErrorMsg = data.messages;
                }
            },function(data){

            })
        }
    },
    mounted:function(){
        var _this = this;
        _this.uploaderFun();  //上传图片

        $(document).on("click","#editClubs",function(){
            _this.editorId = $(this).attr("data-id");
            _this.deviceName = "编辑线索";
            $("#modal-default").addClass("in").css("display","block");
            var postData = {
                id:$(this).attr("data-id"),
                statusId:0
            };
            $.axspost(contextPath + "project/byIdStatus","get",postData,function(data){
                _this.editList = data;
                $("#imgInter").attr("src",data.projectLogo);
                responseUrl = data.projectLogo;
            },function(data){})
        });
        setTimeout(function(){
            $(".webuploader-pick").next().css({
                position: "absolute",
                top: "0px",
                left:"0px",
                width: "72px",
                height: "24px",
                overflow: "hidden",
                opacity: 0
            });
        }, 1000);
        $(document).on("click","#detail",function(){
            window.location.href = "detail?menuId=30";
        });
        $.axspost(contextPath + "area/condition?level=1","get","",function(data){
            _this.facList = data.data;
            _this.zTreeInit().useTree($("#treeDemo"),_this.facList,"#address");//初始化生成树
        },function (data) {});
        _this.tableInit(false); //创建表格

        //
        $("#deviceSubmit").html5Validate(function() {
            _this.sureSubmit();
        },{
            validate:function () {
                if(responseUrl == undefined){
                    $(".webuploader-pick").testRemind("请选择图片");
                    return false;
                }
                return true;
            }
        })
    }
});

