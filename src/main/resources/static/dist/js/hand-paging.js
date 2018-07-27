/**
 * 试着做分页
 */
(function ($) {
    function Paging(elem,options){
        this.$paging = elem;
        this.$options = {
            pageNo:options.pageNo || 1,
            totalSize:options.totalSize,
            totalPage:options.totalPage,
            data:options.data
        }
    }
    Paging.prototype = {
        renderDom:function(){
            var _self = this;
            _self.$paging.html("");
            var current = _self.$options.pageNo;
            var totalSize = _self.$options.totalSize;
            var totalPage = _self.$options.totalPage;
            var content = "";
            content += "<a id='prevPage'>上一页</a>";
            if(totalPage>4){
                if(current < 3){
                    for(var i = 1;i < 4;i++){
                        if(current == i){
                            content+= "<a class='current'>"+i+"</a>"
                        }else{
                            content += "<a>"+i+"</a>"
                        }
                    }
                    content += ". . .";
                    content += "<a>"+totalPage+"</a>";
                }else{
                    if(current<totalPage - 3){
                        // alert(0);
                        console.log(current);
                        for(var i = current;i<parseInt(current)+3;i++){
                            if(current == i){
                                content+= "<a class='current'>"+i+"</a>"
                            }else{
                                content += "<a>"+i+"</a>"
                            }
                        }
                        content += ". . .";
                        content += "<a>"+totalPage+"</a>";
                    }else{
                        // alert(1);
                        content += "<a>1</a>";
                        content += "...";
                        for(var i= totalPage-3;i<totalPage+1;i++){
                            if(current == i){
                                content+= "<a class='current'>"+i+"</a>"
                            }else{
                                content += "<a>"+i+"</a>"
                            }
                        }
                    }
                }
            }else {
                for(var i = 1; i < totalPage + 1; i++) {
                    if(current == i) {
                        content += "<a class='current'>" + i + "</a>";
                    } else {
                        content += "<a>" + i + "</a>";
                    }
                }
            }
            content += "<a id='nextPage'>下一页</a>";
            _self.$paging.append(content);
        },
        inital:function(){
            var _self = this;
            _self.$paging.on('click', 'a', function() {
                var id = $(this).attr("id");
                if($(this).attr("class") == 'disable'){
                    return false
                }
                if(id == "prevPage"){
                    if(_self.$options.pageNo == 1){
                        $("#prevPage").addClass("disable");
                        _self.$options.pageNo = 1;
                    }else{
                        _self.$options.pageNo =  _self.$options.pageNo - 1;
                    }
                }else if(id == "nextPage"){
                   if(_self.$options.pageNo  == _self.$options.totalPage){
                       _self.$options.pageNo = _self.$options.totalPage;
                       $("#nextPage").addClass("disable");
                   }else{
                       _self.$options.pageNo = parseInt(_self.$options.pageNo)+1;
                   }
                }else{
                    _self.$options.pageNo = parseInt($(this).text())
                }
                $("#page").val( _self.$options.pageNo);
                _self.renderDom();
            });
            if(_self.$options.pageNo == 1){
                $("#prevPage").addClass("disable");
            }
            if(_self.$options.pageNo  == _self.$options.totalPage){
                $("#nextPage").addClass("disable");
            }

        }
    };
    $.fn.extend({
        paging1:function(options){
            var paging = new Paging(this,options);
            paging.renderDom();
            paging.inital();
        }
    })
})(jQuery);
