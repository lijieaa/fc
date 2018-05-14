Vue.component('option-item', {
    props: ['todo'],
    template: '<option>{{todo.name}}</option>'
});
new Vue({
    el:"#myClues",
    data:{
        deviceName:"添加线索",
        inputLimit:"",
        selected:"3",
        projectList:[
            {val:1,name:"成都华西"},
            {val:2,name:"成都龙泉"},
            {val:3,name:"项目二"}
        ]
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
        }
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

        //
        _this.tableInit(false); //创建表格

        //
        $("#intermediaryName").html5Validate(function() {

        })
    }
});

