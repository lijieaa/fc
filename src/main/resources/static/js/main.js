/**
 * Created by Administrator on 2018/4/11 0011.
 */

//封装ajax
jQuery.axspost=function(url,type, data, successfn, errorfn) {
    $.ajax({
        // contentType:"multipart/form-data",
        url: url,
        type: type,
        data: data,
        dataType: "json",
        success: function(d){
            successfn(d);
        },
        error: function(e){
            errorfn(e);
        }
    });
};

//树状菜单
/**
 * ele 当前dom的元素
 * zNodes: 树状菜单的数据
 * zTreeBeforeClick :点击事件
 * */
;
