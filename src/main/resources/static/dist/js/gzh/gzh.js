 $(document).ready(function() {
        $('#deviceForm').DataTable( {
            "ajax": "../dist/data/gzh.json",
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
                { "data": "", "render": function(data, type, row, meta){
                        var html = "<button type='button' class='Normal margin-right-4 btn btn-primary'>编辑</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary'>删除</button>" +
                            "<button type='button' class='Normal margin-right-4 btn btn-primary table-manage'>管理</button>"
                        return html;
                    }}

            ],
            "fnInitComplete": function() {//初始化完毕事件
                $(".table-manage").click(function () {
                    $("#gzh-index").hide();
                    $("#gzh-manage").show();
                });
            }
        } );
        // 添加公众号
        $("#add-gzh").click(function () {
            $('#myModal').modal();
        });
        $(".chat-type span").click(function () {
            var data_id=$(this).attr("data-id");
            if(data_id==2){
                $("#textInput").focus();
            }else{
                $('#sourceRoom').modal();
                if(data_id==1){
                    $("#mySource").text("选择素材");
                    $("#new-source").text("新建图文消息");
                }else if(data_id==3){
                    $("#mySource").text("选择图片");
                    $("#new-source").text("上传图片");
                }else if(data_id==4){
                    $("#mySource").text("选择语音");
                    $("#new-source").text("上传语音");
                }else if(data_id==5){
                    $("#mySource").text("选择视频");
                    $("#new-source").text("上传视频");
                }
            }
        })
    } );
