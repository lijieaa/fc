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
function pShow(thisPhtID) {
    $.ajax({
        url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+thisPhtID,
        type: "get",
        processData:true,
        success:function (data) {
            var id=data.content.thumbMediaId;
            var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
             $(".showTime").text(data.content.updateTime);
             $(".showTitle").text(data.content.title);
             $(".showImg img").attr("src",urlLink);
        }
    })
}

new Vue({
    el:"#app",
    data:{
        selectedMenuIndex:'',//当前选中菜单索引
        selectedSubMenuIndex:'',//当前选中子菜单索引
        picShow: true,
        menu:{
            button:[
                {
                    "name":"菜单1",
                    "sub_button":[
                        {
                            "key":"/material msg",
                            "type":"click",
                            "name":"一级目录",
                            "url":""
                        },
                        {
                            "key":"/material/voice voice",
                            "type":"click",
                            "name":"二级目录",
                            "url":""
                        },
                        {
                            "key":"http://203.205.158.72 video",
                            "type":"click",
                            "name":"三级目录",
                            "url":""
                        },
                        {
                            "key":"58 msg",
                            "type":"click",
                            "name":"四级目录",
                            "url":""
                        }
                    ],
                    "type":"click",
                    "key":"555",
                    "url":""
                },
                {
                    "name":"菜单2",
                    "sub_button":[
                        {
                            "type":"view",
                            "name":"一级目录",
                            "url":"http://www.baidu.com",
                            "key":""
                        }
                    ],
                    "type":"click",
                    "key":"/material/image/detail",
                    "url":""
                },
                {
                    "name":"菜单3",
                    "sub_button":[
                        // {
                        //     "key":"/material/voice/detail?wxPublicId=14&mediaId=f1QOuU_OT4Hrt8abnY9n2JtuBkM5JTjri6XfVo3ftDY&name=wx.mp3",
                        //     "type":"click",
                        //     "name":"二级目录",
                        //     "url":""
                        // },
                    ],
                    "type":"click",
                    "key":"/material/detail photo",
                    "url":""
                }
            ]
        }
    },
    methods:{
        addMenu:function(level){
            if(level == 1 && this.menu.button.length<3){
                this.menu.button.push({
                    "name":"菜单名称",
                    "type":"click",
                    "key":"msg",
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
                    "key":"msg",
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
            if(checkType=="msg"){
                if(checkContent!=""){
                    this.picShow = true;
                    // $.ajax({
                    //     url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+thisPhtID,
                    //     type: "get",
                    //     processData:true,
                    //     success:function (data) {
                    //         var id=data.content.thumbMediaId;
                    //         var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                    //         $(".showTime").text(data.content.updateTime);
                    //         $(".showTitle").text(data.content.title);
                    //         $(".showImg img").attr("src",urlLink);
                    //     }
                    // });
                }else {
                    this.picShow = false;
                }
            }else if(checkType=="video"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
                }

            }else if(checkType=="photo"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
                }

            }else if(checkType=="voice"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
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
            if(checkType=="msg"){
                if(checkContent!=""){
                    this.picShow = true;
                    // $.ajax({
                    //     url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+thisPhtID,
                    //     type: "get",
                    //     processData:true,
                    //     success:function (data) {
                    //         var id=data.content.thumbMediaId;
                    //         var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                    //         $(".showTime").text(data.content.updateTime);
                    //         $(".showTitle").text(data.content.title);
                    //         $(".showImg img").attr("src",urlLink);
                    //     }
                    // });
                }else{
                    this.picShow = false;
                }
            }else if(checkType=="video"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
                }

            }else if(checkType=="photo"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
                }

            }else if(checkType=="voice"){
                if(checkContent!=""){
                    this.picShow = true;
                }else{
                    this.picShow = false;
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
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'msg';
                }else if(this.currentSelect() == 2){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'video';
                }else if(this.currentSelect() == 3){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'photo';
                }else if(this.currentSelect() == 4){
                    this.menu.button[this.selectedMenuIndex].key = value+' '+'voice';
                }
            }else if(this.selectedMenuLevel() == 2){
                this.picShow = true;
                if(this.currentSubSelect() == 1){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'msg';
                }else if(this.currentSubSelect() == 2){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'video';
                }else if(this.currentSubSelect() == 3){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'photo';
                }else if(this.currentSubSelect() == 4){
                    this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = value+' '+'voice';
                }
            }


        },
        submitData:function(){
            // for(var i = 0; i < this.menu.button.length; i++) {
            //     let type = this.menu.button[i].type;
            //     let value = this.menu.button[i][type];
            //     this.menu.button[i].video = '';
            //     this.menu.button[i].msg = '';
            //     this.menu.button[i].photo = '';
            //     this.menu.button[i].voice = '';
            //     if(this.menu.button[i].sub_button.length == 0) {
            //         this.menu.button[i][type] = value;
            //     }
            //     if(this.menu.button[i].sub_button && this.menu.button[i].sub_button.length){
            //         for(var j = 0; j < this.menu.button[i].sub_button.length; j++) {
            //             let subType = this.menu.button[i].sub_button[j].type;
            //             let subValue = this.menu.button[i].sub_button[j][subType];
            //             this.menu.button[i].sub_button[j].video = '';
            //             this.menu.button[i].sub_button[j].msg = '';
            //             this.menu.button[i].sub_button[j].photo = '';
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
                    console.log(data);
                },
                error:function (data) {
                    console.log(data.status);
                }

            });
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
        subMenu:function(level,msg){
            if(level == 1){
                var parType = this.menu.button[this.selectedMenuIndex].key;
                var kgIndex=parType.indexOf(" ");
                var checkType=parType.substr(kgIndex+1);//获得type
                var checkContent=parType.substr(0,kgIndex);//获得内容
                switch (msg){
                    case 'msg' :
                        this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'msg';
                        // if(checkContent!=""){
                        //     this.picShow = true;
                        //     // $.ajax({
                        //     //     url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+parType.msg,
                        //     //     type: "get",
                        //     //     processData:true,
                        //     //     success:function (data) {
                        //     //         var id=data.content.thumbMediaId;
                        //     //         var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                        //     //         $(".showTime").text(data.content.updateTime);
                        //     //         $(".showTitle").text(data.content.title);
                        //     //         $(".showImg img").attr("src",urlLink);
                        //     //     }
                        //     // });
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'video' :
                        this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'video';
                        // if(this.menu.button[this.selectedMenuIndex].key==""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'photo' :
                        this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'photo';
                        // if(checkContent!=""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'voice' :
                        this.menu.button[this.selectedMenuIndex].key = checkContent+' '+'voice';
                        // if(checkContent!=""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                }
            }else{
                var sonType=this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key;
                var kgIndex=sonType.indexOf(" ");
                var checkType=sonType.substr(kgIndex+1);//获得type
                var checkContent=sonType.substr(0,kgIndex);//获得内容
                switch (msg){
                    case 'msg' :
                        // if(checkType=='msg'){
                        //     this.picShow = true;
                        // }else{
                        //     this.picShow = false;
                        // }
                        this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'msg';
                        // if(sonType.msg!=""){
                        //     this.picShow = true;
                        //     // $.ajax({
                        //     //     url: contextPath +"material/news/detail?wxPublicId="+wxPublicId+"&materialId="+sonType.msg,
                        //     //     type: "get",
                        //     //     processData:true,
                        //     //     success:function (data) {
                        //     //         var id=data.content.thumbMediaId;
                        //     //         var urlLink = ''+contextPath+'material/image/detail?mediaId='+id+"&name="+name+"&wxPublicId="+wxID;
                        //     //         $(".showTime").text(data.content.updateTime);
                        //     //         $(".showTitle").text(data.content.title);
                        //     //         $(".showImg img").attr("src",urlLink);
                        //     //     }
                        //     // });
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'video' :
                        this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'video';
                        // if(sonType.video!=""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'photo' :
                        this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'photo';
                        // if(sonType.photo!=""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                    case 'voice' :
                        this.menu.button[this.selectedMenuIndex].sub_button[this.selectedSubMenuIndex].key = checkContent+' '+'voice';
                        // if(sonType.voice!=""){
                        //     this.picShow = true;
                        // }else {
                        //     this.picShow = false;
                        // }
                        break;
                }
            }

        },
        //主菜单选中哪一个type
        currentSelect:function(){
            var menuIndex = this.menu.button[this.selectedMenuIndex].key;
            var kgIndex=menuIndex.indexOf(" ");
            var checkType=menuIndex.substr(kgIndex+1);
            if(checkType == 'msg'){
                return 1
            }else if(checkType == 'video'){
                return 2
            }
            else if(checkType == 'photo'){
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
            if(checkType == 'msg'){
                return 1
            }else if(checkType == 'video'){
                return 2
            }
            else if(checkType == 'photo'){
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
            if(this.selectedMenuIndex===0){
                this.menu.button.splice(this.selectedMenuIndex, 1);
                this.selectedMenuIndex = 0;
            }
            if(this.menu.button.length==0){
                this.selectedMenuIndex = ''
            }
        },
        delSubMenu:function(){
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
        }
    },
    mounted:function () {
        var _this =  this;
        // _this.selectTab(1);
    }

});