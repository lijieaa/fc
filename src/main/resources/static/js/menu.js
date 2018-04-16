//菜单管理

$(document).ready(function() {
    var setting = {
        check: {
            enable: true
        },
        async: {
            enable: true,
            url:contextPath+"ding_talk_menu/all",
            //autoParam:["id", "name=n", "level=lv"],
            //otherParam:{"otherParam":"zTreeAsyncTest"},
            type: "get",
            //dataFilter: filter
            dataFilter: ajaxDataFilter
        },
        data: {
            key: {
                //children: "children",
                name: "menuName",
               // title: "",
                //url: "url"
            },
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "menuParentId",
                rootPId: 0
            }
        },
        callback: {
            //onClick:zTreeOnclick,
            //beforeExpand: beforeExpand,
            //onAsyncSuccess:onAsyncSuccess
        },
    };
    //异步加载返回的数据
    function ajaxDataFilter(treeId, parentNode, responseData) {
        return responseData.data;
    }

    $.fn.zTree.init($("#treeDemo"), setting);
} );