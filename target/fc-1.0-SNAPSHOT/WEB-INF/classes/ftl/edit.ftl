<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout" layout:decorate="~{layout}">
<body layout:fragment="content">
<div class="row">
    <div class="col-xs-12">
        <div class="row">
            <form class="form-horizontal" id="form" method="post">
<#list cols?keys as key>

    <#if (key?index_of('primaryKey'))!=-1>
        <#assign index=key?index_of('primaryKey')>
    <input type="hidden" name="${key?substring(0,index-1)}"  id="${key?substring(0,index-1)}">

    <#else>
        <div class="form-group">
            <label class="control-label col-xs-12 col-sm-3 no-padding-right" for="${key}">${key}:</label>
            <div class="col-xs-12 col-sm-9">
                <div class="clearfix">
                    <input type="text" name="${key}" id="${key}" class="col-xs-12 col-sm-6" />
                </div>
            </div>
        </div>
    </#if>

</#list>
                <div class="space-4"></div>
                <div class="clearfix form-actions">
                    <div class="col-md-offset-3 col-md-9">
                        <button class="btn btn-info" type="submit" id="submit">
                            <i class="ace-icon fa fa-check bigger-110"></i>
                            提交
                        </button>

                        &nbsp; &nbsp; &nbsp;
                        <button class="btn" type="reset">
                            <i class="ace-icon fa fa-undo bigger-110"></i>
                            重置
                        </button>
                    </div>
                </div>
            </form>
        </div>
        <!-- PAGE CONTENT ENDS -->
    </div>
    <!-- /.col -->
</div>
<script type="text/javascript" th:inline="javascript">

    jQuery(function($) {
        var id=[[${r"${id}"}]];
        $.ajax({
            url: contextPath+"api/${modelName?lower_case}?id="+id,
            method: "get",
            success: function (data) {
                $('#form').autofill(data.content);
            },
            error: function (data) {
                console.log("查询数据出错！");
            }
        })




        var $form = $('#form').validate({
            errorElement: 'div',
            errorClass: 'help-block',
            focusInvalid: false,
            ignore: "",
            rules: {
<#list cols?keys as key>
    <#if (key?index_of('primaryKey'))==-1>
                ${key}: {
                    required: true
                },
    </#if>
</#list>       
            },
            
            highlight: function (e) {
                $(e).closest('.form-group').removeClass('has-info').addClass('has-error');
            },

            success: function (e) {
                $(e).closest('.form-group').removeClass('has-error');
                $(e).remove();
            },

            errorPlacement: function (error, element) {
                 error.insertAfter(element.parent());
            },

            submitHandler: function (form) {

                var data = $(form).serializeObject();

                $.ajax({
                    url: contextPath+"api/${modelName?lower_case}/",
                    method: "put",
                    data : JSON.stringify(data),
                    contentType: "application/json",
                    dataType : "json",
                    success: function (data) {
                        location.href=contextPath+"${modelName?lower_case}/list";
                    },
                    error: function (data) {
                        console.log(data);
                    }
                })


            },
            invalidHandler: function (form) {

            }
        });
    })
</script>
</body>
</html>