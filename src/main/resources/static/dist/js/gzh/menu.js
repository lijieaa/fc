/**
 * Created by Administrator on 2018/5/18 0018.
 */
// Vue.component('right-list',{
//   props:['right'],
//   template:" <input type='text'>",
// })


new Vue({
  el:"#app",
  data:{
    selectedMenuIndex:'',//当前选中菜单索引
    selectedSubMenuIndex:'',//当前选中子菜单索引
    menu:{
        button:[
            {
                "name":"菜单1",
                "childMenu":[
                    {
                        "type":"photo",
                        "video":"",
                        "msg":"",
                        "photo":"/material/image/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2ENCGrWj7MLYoUT62QJ2Kn0&name=upload.jpg&wxPublicId=14",
                        "voice":"",
                        "isSelect":"postMsg",
                        "name":"一级目录",
                        "url":""
                    },
                    {
                        "type":"voice",
                        "video":"",
                        "msg":"",
                        "photo":"",
                        "voice":"/material/voice/detail?wxPublicId=14&mediaId=f1QOuU_OT4Hrt8abnY9n2JtuBkM5JTjri6XfVo3ftDY&name=wx.mp3",
                        "isSelect":"postMsg",
                        "name":"二级目录",
                        "url":""
                    },
                    {
                        "type":"video",
                        "video":"http://203.205.158.79/vweixinp.tc.qq.com/1007_8fd7c0df34794d22954303f614199302.f10.mp4?vkey=D0362E3B4CF64B3A2139439544F0ED9FD2690A4BABEB87C78A379EB4896330950B37654B5A435D3B23F99CD30F1AE849DE4DFDF3CE537716CCF2D759E65D7E75416D59D196D229C9B194C98BD573BC43F500EC2F37E3C81D&sha=0&save=1",
                        "msg":"",
                        "photo":"",
                        "voice":"",
                        "isSelect":"postMsg",
                        "name":"三级目录",
                        "url":""
                    }
                ],
                "video":"444",
                "isSelect":"postMsg",
                "msg":"555",
                "photo":"",
                "type":"video",
                "url":"",
                "voice":""
            },
            {"name":"菜单2","childMenu":[],"video":"","isSelect":"postMsg","msg":"","photo":"/material/image/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2MaPsF21OaR7mIruFhnbID4&name=upload.jpg&wxPublicId=14","type":"photo","url":"","voice":""},
            {"name":"菜单3","childMenu":[],"video":"","isSelect":"postMsg","msg":"","photo":"/material/image/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Oh0sj8PyIlnrmepRkD4-WM&name=upload.jpg&wxPublicId=14","type":"photo","url":"","voice":""}
        ]
    }
  },
  methods:{
    addMenu:function(level){
      if(level == 1 && this.menu.button.length<3){
        this.menu.button.push({
            "name":"菜单名称",
            "isSelect":"postMsg",
            "type":"msg",
            "url":"",
            "msg":"",
            "video":"",
            "photo":"",
            "voice":"",
            "childMenu":[]
        });
        this.selectedMenuIndex = this.menu.button.length-1;
        this.selectedSubMenuIndex=''
      }
      if(level == 2 && this.menu.button[this.selectedMenuIndex].childMenu.length<5){
        this.menu.button[this.selectedMenuIndex].childMenu.push({
            "name":"子菜单名称",
            "isSelect":"postMsg", //选中哪一个菜单
            "type":"msg",
            "url":"",
            "msg":"",
            "video":"",
            "photo":"",
            "voice":""
        });
        this.selectedSubMenuIndex= this.menu.button[this.selectedMenuIndex].childMenu.length-1;

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
    },
    selectedSubMenu:function(i,event){//选择子菜单
      this.selectedSubMenuIndex = i;
        this.selectTab();
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
            if(this.currentSelect() == 1){
                this.menu.button[this.selectedMenuIndex].msg = value;
            }else if(this.currentSelect() == 2){
                this.menu.button[this.selectedMenuIndex].video = value;
            }else if(this.currentSelect() == 3){
                this.menu.button[this.selectedMenuIndex].photo = value;
            }else if(this.currentSelect() == 4){
                this.menu.button[this.selectedMenuIndex].voice = value;
            }
        }else if(this.selectedMenuLevel() == 2){
            if(this.currentSubSelect() == 1){
                this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].msg = value;
            }else if(this.currentSubSelect() == 2){
                this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].video = value;
            }else if(this.currentSubSelect() == 3){
                this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].photo = value;
            }else if(this.currentSubSelect() == 4){
                this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].voice = value;
            }
        }


    },
    submitData:function(){
        for(var i = 0; i < this.menu.button.length; i++) {
            let type = this.menu.button[i].type;
            let value = this.menu.button[i][type];
            this.menu.button[i].video = '';
            this.menu.button[i].msg = '';
            this.menu.button[i].photo = '';
            this.menu.button[i].voice = '';
            if(this.menu.button[i].childMenu.length == 0) {
                this.menu.button[i][type] = value;
            }
            if(this.menu.button[i].childMenu && this.menu.button[i].childMenu.length){
                for(var j = 0; j < this.menu.button[i].childMenu.length; j++) {
                    let subType = this.menu.button[i].childMenu[j].type;
                    let subValue = this.menu.button[i].childMenu[j][subType];
                    this.menu.button[i].childMenu[j].video = '';
                    this.menu.button[i].childMenu[j].msg = '';
                    this.menu.button[i].childMenu[j].photo = '';
                    this.menu.button[i].childMenu[j].voice = '';
                    this.menu.button[i].childMenu[j][subType] = subValue;
                }
            }
        }
      console.log(this.menu);
    },
    selectTab:function(){ //选中发送消息还是发送网页
      if(this.selectedMenuLevel() == 1) {
          switch (this.menu.button[this.selectedMenuIndex].isSelect) {
              case 'postMsg':
                  this.menu.button[this.selectedMenuIndex].url = "";
                  return 1;
                  break;
              case 'view':
                  this.menu.button[this.selectedMenuIndex].msg = "";
                  this.menu.button[this.selectedMenuIndex].video = "";
                  this.menu.button[this.selectedMenuIndex].photo = "";
                  this.menu.button[this.selectedMenuIndex].voice = "";
                  return 2;
                  break;
          }
      }else{
          switch (this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].isSelect) {
              case 'postMsg':
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].url = "";
                  return 1;
                  break;
              case 'view':
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].msg = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].video = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].photo = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].voice = "";
                  return 2;
                  break;
          }
      }

    },
    subMenu:function(level,msg){
      if(level == 1){
          switch (msg){
              case 'msg' :
                  this.menu.button[this.selectedMenuIndex].type = 'msg';
                  break;
              case 'video' :
                  this.menu.button[this.selectedMenuIndex].type = 'video';
                  break;
              case 'photo' :
                  this.menu.button[this.selectedMenuIndex].type = 'photo';
                  break;
              case 'voice' :
                  this.menu.button[this.selectedMenuIndex].type = 'voice';
                  break;
          }
      }else{
          switch (msg){
              case 'msg' :
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type = 'msg';
                  break;
              case 'video' :
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type = 'video';
                  break;
              case 'photo' :
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type = 'photo';
                  break;
              case 'voice' :
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type = 'voice';
                  break;
          }
      }

    },
      //主菜单选中哪一个type
    currentSelect:function(){
      var menuIndex = this.menu.button[this.selectedMenuIndex].type;
      if(menuIndex == 'msg'){
        return 1
      }else if(menuIndex == 'video'){
        return 2
      }
      else if(menuIndex == 'photo'){
        return 3
      }
      else{
        return 4
      }
    },

  //右边子菜单选中哪一个type
    currentSubSelect:function(){
        var submenuIndex = this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type;
        if(submenuIndex == 'msg'){
            return 1
        }else if(submenuIndex == 'video'){
            return 2
        }
        else if(submenuIndex == 'photo'){
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
            this.menu.button[this.selectedMenuIndex].childMenu.splice(this.selectedSubMenuIndex, 1);
            this.selectedSubMenuIndex = 0;
        }else{
            this.menu.button[this.selectedMenuIndex].childMenu.splice(this.selectedSubMenuIndex, 1);
            this.selectedSubMenuIndex -= 1;
        }
        if(this.menu.button[this.selectedMenuIndex].childMenu.length==0){
            this.selectedSubMenuIndex = ''
        }
    }
  },
  mounted:function () {
    var _this =  this;
    // _this.selectTab(1);
  }

});