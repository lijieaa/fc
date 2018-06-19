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
      button:[]
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
            "msgValue":"",
            "fontValue":"",
            "photoValue":"",
            "voiceValue":"",
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
            "msgValue":"",
            "fontValue":"",
            "photoValue":"",
            "voiceValue":""
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
    submitData:function(){
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
                  this.menu.button[this.selectedMenuIndex].msgValue = "";
                  this.menu.button[this.selectedMenuIndex].fontValue = "";
                  this.menu.button[this.selectedMenuIndex].photoValue = "";
                  this.menu.button[this.selectedMenuIndex].voiceValue = "";
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
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].msgValue = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].fontValue = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].photoValue = "";
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].voiceValue = "";
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
              case 'font' :
                  this.menu.button[this.selectedMenuIndex].type = 'font';
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
              case 'font' :
                  this.menu.button[this.selectedMenuIndex].childMenu[this.selectedSubMenuIndex].type = 'font';
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
      }else if(menuIndex == 'font'){
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
        }else if(submenuIndex == 'font'){
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