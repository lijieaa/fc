//菜单管理

$(document).ready(function() {
    console.log(" menu init");
    console.log(contextPath)
    var zTreeObj;
    // zTree 的参数配置，深入使用请参考 API 文档（setting 配置详解）
    var setting = {
        async: {
            enable: true,
            url: getUrl
        },
        data: {
            simpleData: {
                enable: true
            }
        },
        callback: {
            // beforeClick: zTreeBeforeClick,
            onClick:zTreeOnclick
        },
        view: {
            fontCss: getFontCss,
            showLine: false,
            showIcon:false
        }
    };
    // zTree 的数据属性，深入使用请参考 API 文档（zTreeNode 节点数据详解）
    var zNodes = [
        {name:"test1", open:true, children:[
            {name:"test1_1"}, {name:"test1_2"}]},
        {name:"test2", open:true, children:[
            {name:"test2_1"}, {name:"test2_2"}]}
    ];

    zTreeObj = $.fn.zTree.init($("#treeDemo"), setting, zNodes);
} );