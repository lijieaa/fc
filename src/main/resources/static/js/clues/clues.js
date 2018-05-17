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
new Vue({
    el:"#myClues",
    data:{
        deviceName:"添加线索",
        inputLimit:"",
        searchVal:"",
        selected:"3",
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
        addDevice:function(){
            this.deviceName = "添加线索";
            $("#modal-default").addClass("in").css("display","block")
        },
        closePop:function(){
            $("#modal-default").removeClass("in").css("display","none")
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
                    postData.deviceProductionNum = _this.inputLimit;//生产编号
                    break;
                }
                case 2:{
                    postData["project.projectName"]= _this.inputLimit;//项目名称
                    break;
                }
                case 3:{
                    postData["operateUser.name"] = _this.inputLimit; //操作员名称
                    break;
                }
                case 4:{
                    postData["transcribeUser.name"] = _this.inputLimit; //抄表员名称
                    break;
                }
            }
            $('#deviceForm').DataTable({
                "ajax":{
                    // url:"../dist/data/device.json",
                    url: contextPath +"device/page",
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
                    { "data": "deviceProductionNum"},
                    { "data": "position"},
                    { "data": "project.projectName"},
                    { "data": "operateUser.name"},
                    { "data": "transcribeUser.name"},
                    { "data": "deivceStatus","render": function(data, type, row, meta){
                            var status;
                            if(data == 0){
                                status = "在线"
                            }else{
                                status = "不在线"
                            }
                            return status;
                        }},
                    // { "data": "intermediary.intermediaryName" },
                    { "data": "", "render": function(data, type, row, meta){
                            var html = "<button type='button' class='Normal margin-right-4 btn btn-primary' id='editClubs'>编辑</button>" +
                                "<button type='button' class='Normal margin-right-4 btn btn-primary' id='delete'>删除</button>" +
                                "<button type='button' class='Normal margin-right-4 btn btn-primary' id='detail'>详情</button>";
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
    },
    mounted:function(){
        var _this = this;
        $(document).on("click","#editClubs",function(){
            _this.deviceName = "编辑线索";
            $("#modal-default").addClass("in").css("display","block")
        });

        $(document).on("click","#detail",function(){
            window.location.href = "detail?menuId=30";
        });
        $.axspost(contextPath + "area/condition?level=1","get","",function(data){
            _this.facList = data.data;
            _this.zTreeInit().useTree($("#treeDemo"),_this.facList,"#address");//初始化生成树
        },function (data) {});
        _this.tableInit(false); //创建表格

        //
        $("#intermediaryName").html5Validate(function() {

        })
    }
});

