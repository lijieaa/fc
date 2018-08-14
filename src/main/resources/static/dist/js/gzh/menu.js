/**
 * Created by Administrator on 2018/5/18 0018.
 */
// Vue.component('right-list',{
//   props:['right'],
//   template:" <input type='text'>",
// })
$(document).on("click","#backUl",function () {
    window.location.href="/wxPublic/index?mid=11";
})
function getUrlParms(name){
    var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if(r!=null)
        return unescape(r[2]);
    return null;
}
var wxID=getUrlParms("wxPublicId");
//各页面切换
$(".gzh-manage-menu>a").click(function () {
    var thisID=$(this).attr("data-id");
    if(thisID==1){
        window.location.href="/wxPublic/user?wxPublicId="+wxPublicId;
    }else if(thisID==2){
        window.location.href="/wxPublic/menu?wxPublicId="+wxPublicId;
    }else if(thisID==3){
        window.location.href="/wxPublic/msg?wxPublicId="+wxPublicId;
    }else if (thisID==4){
        window.location.href="/wxPublic/material?wxPublicId="+wxPublicId;
    }
});
// function pShow(thisPhtID) {
//     $.ajax({
//         url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+thisPhtID,
//         type: "get",
//         processData:true,
//         success:function (data) {
//             var id=data.content.thumbMediaId;
//             var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
//              $(".showTime").text(data.content.updateTime);
//              $(".showTitle").text(data.content.title);
//              $(".showImg img").attr("src",urlLink);
//         }
//     })
// }


new Vue({
    el:"#app",
    data:{
        selectedMenuIndex:'',//当前选中菜单索引
        selectedSubMenuIndex:'',//当前选中子菜单索引
        picShow: true,
        initFlagStatus: '',
        menu:{
            // button:[
            //     {
            //         "name":"菜单1",
            //         "sub_button":[
            //             {
            //                 "key":"f1QOuU_OT4Hrt8abnY9n2Oh0sj8PyIlnrmepRkD4-WM image",
            //                 "type":"click",
            //                 "name":"一级目录",
            //                 "url":""
            //             },
            //             {
            //                 "key":"f1QOuU_OT4Hrt8abnY9n2OU1AxEimiViibqgnVyyPjA voice",
            //                 "type":"click",
            //                 "name":"二级目录",
            //                 "url":""
            //             },
            //             {
            //                 "key":"f1QOuU_OT4Hrt8abnY9n2Bgl8PvwCft-Isk4Fo4S_EU video",
            //                 "type":"click",
            //                 "name":"三级目录",
            //                 "url":""
            //             },
            //             {
            //                 "key":"58 news",
            //                 "type":"click",
            //                 "name":"四级目录",
            //                 "url":""
            //             }
            //         ],
            //         "type":"click",
            //         "key":"",
            //         "url":""
            //     },
            //     {
            //         "name":"菜单2",
            //         "sub_button":[
            //             {
            //                 "type":"view",
            //                 "name":"一级目录",
            //                 "url":"http://www.baidu.com",
            //                 "key":""
            //             }
            //         ],
            //         "type":"click",
            //         "key":"",
            //         "url":""
            //     },
            //     {
            //         "name":"菜单3",
            //         "sub_button":[
            //             // {
            //             //     "key":"/material/voice/detail?wxPublicId=14&mediaId=f1QOuU_OT4Hrt8abnY9n2JtuBkM5JTjri6XfVo3ftDY&name=wx.mp3",
            //             //     "type":"click",
            //             //     "name":"二级目录",
            //             //     "url":""
            //             // },
            //         ],
            //         "type":"click",
            //         "key":"f1QOuU_OT4Hrt8abnY9n2Oh0sj8PyIlnrmepRkD4-WM image",
            //         "url":""
            //     }
            // ]
        },
        arr:''
    },
    created: function() {
        var _this = this;
        $.ajax({
            url: contextPath +"menu?wxPublicId="+wxID,
            type: "get",
            processData:true,
            success:function (data) {
                _this.menu=data.menu;
                if(_this.menu.button && _this.menu.button.length){
                    _this.selectedMenuIndex = 0;
                }
            }
        })
    },
    methods:{
        addMenu:function(level){
            if(level == 1 && this.menu.button.length<3){
                this.menu.button.push({
                    "name":"菜单名称",
                    "type":"click",
                    "key":"mpnews",
                    "url":"",
                    "sub_button":[]
                });
                let selectedMenuIndex = this.menu.button.length-1;
                this.selectedMenu(selectedMenuIndex);
                this.selectedSubMenuIndex='';
            }
            if(level == 2 && this.menu.button[this.selectedMenuIndex].sub_button.length<5){
                this.menu.button[this.selectedMenuIndex].sub_button.push({
                    "name":"子菜单名称",
                    "type":"click",
                    "key":"mpnews",
                    "url":""
                });
                let selectedSubMenuIndex= this.menu.button[this.selectedMenuIndex].sub_button.length-1;

                this.selectedSubMenu(selectedSubMenuIndex);


                // this.selectedMenuIndex = '';
                // console.log(this.selectedSubMenuIndex);
                // console.log(this.selectedMenuIndex);
            }
        },
        selectedMenu:function(i,event){ //选择主菜单
            this.selectedSubMenuIndex='';
            this.selectedMenuIndex=i;
            // var selectedMenu = this.menu.button[this.selectedMenuIndex];
            if(this.selectedMenuLevel() == 1){
                this.selectTab();
            }
            var parType=this.menu.button[this.selectedMenuIndex].key;
            var kgIndex=parType.indexOf(" ");
            var checkType=parType.substr(kgIndex+1);//获得type
            var checkContent=parType.substr(0,kgIndex);//获得内容
            this.initFlagStatus = checkType;
            if(checkType=="mpnews"){
                if(checkContent==""){
                    this.picShow = false;
                }else {
                    this.picShow = true;
                    this.arr=checkContent;
                    $.ajax({
                        url: contextPath +"material/news/detailByWxMediaId?wxPublicId="+wxPublicId+"&materialId="+this.arr,
                        type: "get",
                        processData:true,
                        success:function (data) {
                            var id=data.content.thumbMediaId;
                            var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                            $(".showTime").text(data.content.updateTime);
                            $(".showTitle").text(data.content.title);
                            $(".showImg img").attr("src",urlLink);
                        }
                    });
                }
            }else if(checkType=="video"){
                if(checkContent==""){
                    this.picShow = false;
                }else{
                    this.picShow = true;
                    var name="wx.mp4";
                    var urlLink=contextPath+'material/video/detail?wxPublicId='+wxID+"&mediaId="+checkContent+"&name="+name;
                    this.arr=urlLink;
                }
            }else if(checkType=="image"){
                if(checkContent==""){
                    this.picShow = false;
                }else{
                    this.picShow = true;
                    var name="upload.jpg";
                    var urlLink =contextPath+'material/image/detail?mediaId='+checkContent+"&name="+name+"&wxPublicId="+wxID;
                    this.arr=urlLink;
                }
            }else if(checkType=="voice"){
                if(checkContent==""){
                    this.picShow = false;
                }else{
                    this.picShow = true;
                    var name="upload.mp3";
                    var urlLink =contextPath+'material/voice/detail?wxPublicId='+wxID+"&mediaId="+checkContent+"&name="+name;
                    this.arr=urlLink;
                }
            }
        },
        selectedSubMenu:function(i,event){//选择子菜单
            this.selectedSubMenuIndex = i;
            this.selectTab();
            var sonType=this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex];
            var sonKey=sonType.key;
            var kgIndex=sonKey.indexOf(" ");
            var checkType=sonKey.substr(kgIndex+1);//获得type
            var checkContent=sonKey.substr(0,kgIndex);//获得内容
            if(checkType=="mpnews"){
                if(checkContent==""){
                    this.picShow = false;
                }else {
                    this.picShow = true;
                    this.arr=checkContent;
                    $.ajax({
                        url: contextPath +"material/news/detailByWxMediaId?wxPublicId="+wxPublicId+"&materialId="+this.arr,
                        type: "get",
                        processData:true,
                        success:function (data) {
                            var id=data.content.thumbMediaId;
                            var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                            $(".showTime").text(data.content.updateTime);
                            $(".showTitle").text(data.content.title);
                            $(".showImg img").attr("src",urlLink);
                        }
                    });
                }
            }else if(checkType=="video"){
                if(checkContent==""){
                    this.picShow = false;
                }else {
                    this.picShow = true;
                    var name="wx.mp4";
                    var urlLink=contextPath+'material/video/detail?wxPublicId='+wxID+"&mediaId="+checkContent+"&name="+name;
                    this.arr=urlLink;
                }
            }else if(checkType=="image"){
                if(checkContent==""){
                    this.picShow = false;
                }else {
                    this.picShow = true;
                    var name="upload.jpg";
                    var urlLink =contextPath+'material/image/detail?mediaId='+checkContent+"&name="+name+"&wxPublicId="+wxID;
                    this.arr=urlLink;
                }
            }else if(checkType=="voice"){
                if(checkContent==""){
                    this.picShow = false;
                }else {
                    this.picShow = true;
                    var name="upload.mp3";
                    var urlLink =contextPath+'material/voice/detail?wxPublicId='+wxID+"&mediaId="+checkContent+"&name="+name;
                    this.arr=urlLink;
                }
            }
        },
        //选中菜单级别
        selectedMenuLevel: function () {
            if (this.selectedMenuIndex !== '' && this.selectedSubMenuIndex === '') {
                //主菜单
                return 1;
            }else if (this.selectedMenuIndex !== '' && this.selectedSubMenuIndex !== '') {
                //子菜单
                return 2;
            }else {
                //未选中任何菜单
                return 0;
            }
        },
        testFun(v){
            var value = v.target.value;
            if(this.selectedMenuLevel() == 1) {
                this.picShow = true;
                if(this.currentSelect() == 1){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'mpnews';
                    this.arr=value;
                    $.ajax({
                        url: contextPath +"material/news/detailByWxMediaId?wxPublicId="+wxPublicId+"&materialId="+this.arr,
                        type: "get",
                        processData:true,
                        success:function (data) {
                            var id=data.content.thumbMediaId;
                            var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                            $(".showTime").text(data.content.updateTime);
                            $(".showTitle").text(data.content.title);
                            $(".showImg img").attr("src",urlLink);
                        }
                    });
                }else if(this.currentSelect() == 2){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'video';
                    var name="wx.mp4";
                    var urlLink=contextPath+'material/video/detail?wxPublicId='+wxID+"&mediaId="+value+"&name="+name;
                    this.arr=urlLink;
                }else if(this.currentSelect() == 3){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'image';
                    var name="upload.jpg";
                    var urlLink = ''+contextPath+'material/image/detail?mediaId='+value+"&name="+name+"&wxPublicId="+wxID;
                    this.arr=urlLink;
                }else if(this.currentSelect() == 4){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'voice';
                    var name="upload.mp3";
                    var urlLink =contextPath+'material/voice/detail?wxPublicId='+wxID+"&mediaId="+value+"&name="+name;
                    this.arr=urlLink;
                }
            }else if(this.selectedMenuLevel() == 2){
                this.picShow = true;
                if(this.currentSubSelect() == 1){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'mpnews';
                    this.arr=value;
                    $.ajax({
                        url: contextPath +"material/news/detailByWxMediaId?wxPublicId="+wxPublicId+"&materialId="+this.arr,
                        type: "get",
                        processData:true,
                        success:function (data) {
                            var id=data.content.thumbMediaId;
                            var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                            $(".showTime").text(data.content.updateTime);
                            $(".showTitle").text(data.content.title);
                            $(".showImg img").attr("src",urlLink);
                        }
                    });
                }else if(this.currentSubSelect() == 2){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'video';
                    var name="wx.mp4";
                    var urlLink=contextPath+'material/video/detail?wxPublicId='+wxID+"&mediaId="+value+"&name="+name;
                    this.arr=urlLink;
                }else if(this.currentSubSelect() == 3){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'image';
                    var name="upload.jpg";
                    var urlLink = ''+contextPath+'material/image/detail?mediaId='+value+"&name="+name+"&wxPublicId="+wxID;
                    this.arr=urlLink;
                }else if(this.currentSubSelect() == 4){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'voice';
                    var name="upload.mp3";
                    var urlLink =contextPath+'material/voice/detail?wxPublicId='+wxID+"&mediaId="+value+"&name="+name;
                    this.arr=urlLink;
                }
            }


        },
        submitData:function(){
            // for(var i = 0; i < this.menu.button.length; i++) {
            //     let type = this.menu.button[i].type;
            //     let value = this.menu.button[i][type];
            //     this.menu.button[i].video = '';
            //     this.menu.button[i].news = '';
            //     this.menu.button[i].image = '';
            //     this.menu.button[i].voice = '';
            //     if(this.menu.button[i].sub_button.length == 0) {
            //         this.menu.button[i][type] = value;
            //     }
            //     if(this.menu.button[i].sub_button && this.menu.button[i].sub_button.length){
            //         for(var j = 0; j < this.menu.button[i].sub_button.length; j++) {
            //             let subType = this.menu.button[i].sub_button[j].type;
            //             let subValue = this.menu.button[i].sub_button[j][subType];
            //             this.menu.button[i].sub_button[j].video = '';
            //             this.menu.button[i].sub_button[j].news = '';
            //             this.menu.button[i].sub_button[j].image = '';
            //             this.menu.button[i].sub_button[j].voice = '';
            //             this.menu.button[i].sub_button[j][subType] = subValue;
            //         }
            //     }
            // }
            $.ajax({
                url:contextPath +"menu",
                type: "POST",
                dataType:"json",
                processData:true,
                data:{
                    wxPublicId:wxPublicId,
                    json:JSON.stringify(this.menu)
                },
                success:function(data){
                    if(data.errmsg=="ok"){
                        alert("保存成功！")
                    }
                },
                error:function (data) {
                    console.log(data.status);
                }

            });
            // console.log(this.menu)
        },
        selectTab:function(){ //选中发送消息还是发送网页
            if(this.selectedMenuLevel() == 1) {
                switch (this.menu.button[this.selectedMenuIndex].type) {
                    case 'click':
                        this.menu.button[this.selectedMenuIndex].url = "";
                        return 1;
                        break;
                    case 'view':
                        var parMenu=this.menu.button[this.selectedMenuIndex];
                        parMenu.key = "";
                        return 2;
                        break;
                }
            }
            else{
                switch (this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].type) {
                    case 'click':
                        this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].url = "";
                        return 1;
                        break;
                    case 'view':
                        var sonMenu=this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex];
                        sonMenu.key = "";
                        return 2;
                        break;
                }
            }

        },
        subMenu:function(level,news){
            if(level == 1){
                var parType = this.menu.button[this.selectedMenuIndex].key;
                var kgIndex=parType.indexOf(" ");
                var checkType=parType.substr(kgIndex+1);//获得type
                var checkContent=parType.substr(0,kgIndex);//获得内容
                switch (news){
                    case 'mpnews' :
                        //this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'news';
                        if(this.initFlagStatus != 'mpnews' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'mpnews';
                                this.initFlagStatus='mpnews';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'mpnews';
                        }
                        break;
                    case 'video' :
                        //this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'video';
                        if(this.initFlagStatus != 'video' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'video';
                                this.initFlagStatus='video';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'video';
                        }
                        break;
                    case 'image' :
                        //this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'image';
                        if(this.initFlagStatus != 'image' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'image';
                                this.initFlagStatus='image';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'image';
                        }
                        break;
                    case 'voice' :
                        //this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'voice';
                        if(this.initFlagStatus != 'voice' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'voice';
                                this.initFlagStatus='voice';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'voice';
                        }
                        break;
                }
            }else{
                var sonType=this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key;
                var kgIndex=sonType.indexOf(" ");
                var checkType=sonType.substr(kgIndex+1);//获得type
                var checkContent=sonType.substr(0,kgIndex);//获得内容
                switch (news){
                    case 'mpnews' :
                        if(this.initFlagStatus != 'mpnews' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'mpnews';
                                this.initFlagStatus='mpnews';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'mpnews';
                        }
                        break;
                    case 'video' :
                        if(this.initFlagStatus != 'video' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'video';
                                this.initFlagStatus='video';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'video';
                        }
                        break;
                    case 'image' :
                        if(this.initFlagStatus != 'image' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'image';
                                this.initFlagStatus='image';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'image';
                        }
                        break;
                    case 'voice' :
                        if(this.initFlagStatus != 'voice' && checkContent!=""){
                            var r=confirm('操作会清空当前状态');
                            if(r==true){
                                checkContent='';
                                this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'voice';
                                this.initFlagStatus='voice';
                                this.picShow = false;
                            }else{
                                return false;
                            }
                        }else{
                            this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'voice';
                        }
                        break;
                }
            }

        },
        //主菜单选中哪一个type
        currentSelect:function(){
            var menuIndex = this.menu.button[this.selectedMenuIndex].key;
            var kgIndex=menuIndex.indexOf(" ");
            var checkType=menuIndex.substr(kgIndex+1);
            if(checkType == 'mpnews'){
                return 1
            }else if(checkType == 'video'){
                return 2
            }
            else if(checkType == 'image'){
                return 3
            }
            else{
                return 4
            }
        },

        //右边子菜单选中哪一个type
        currentSubSelect:function(){
            var submenuIndex = this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key;
            var kgIndex=submenuIndex.indexOf(" ");
            var checkType=submenuIndex.substr(kgIndex+1);
            if(checkType == 'mpnews'){
                return 1
            }else if(checkType == 'video'){
                return 2
            }
            else if(checkType == 'image'){
                return 3
            }
            else{
                return 4
            }
        },
        fromSelect:function() {
            layer.open({
                type: 2,
                area: ['360px', '500px'],
                skin: 'layui-layer-rim', //加上边框
                id: 'materialList', //防止重复弹出
                content: '<div style="padding: 20px 100px;">66666</div>'
            });
        },
        //删除主菜单菜单
        delMenu:function () {
            var r=confirm("确定要删除主菜单么？删除会清空子菜单");
            if(r==true){

                if(this.selectedMenuIndex===0){
                    this.menu.button.splice(this.selectedMenuIndex, 1);
                    this.selectedMenuIndex = 0;
                }
                else{
                    this.menu.button.splice(this.selectedMenuIndex, 1);
                    this.selectedMenuIndex -= 1;
                }
                if(this.menu.button.length==0){
                    this.selectedMenuIndex = ''
                }
            }else {
                return false;
            }
        },
        delSubMenu:function(){
            var r=confirm("确定要删除此菜单？");
            if(r==true){
                if(this.selectedSubMenuIndex===0){
                    this.menu.button[this.selectedMenuIndex].sub_button.splice(this.selectedSubMenuIndex, 1);
                    this.selectedSubMenuIndex = 0;
                }else{
                    this.menu.button[this.selectedMenuIndex].sub_button.splice(this.selectedSubMenuIndex, 1);
                    this.selectedSubMenuIndex -= 1;
                }
                if(this.menu.button[this.selectedMenuIndex].sub_button.length==0){
                    this.selectedSubMenuIndex = ''
                }
            }else {
                return false;
            }
        }
    },
    mounted:function () {
        var _this =  this;
        // _this.selectTab(1);
    }

});