/**
 * Created by Administrator on 2018/5/18 0018.
 */
// Vue.component('right-list',{
//   props:['right'],
//   template:" <input type='text'>",
// })


new Vue({
  el:"#menu",
  data:{
    selectedMenuIndex:'',//当前选中菜单索引
    selectedSubMenuIndex:'',//当前选中子菜单索引
    // postMsg:true,
    // view:false,
    // currentSelect:'',
    menu:{
      button:[

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
          "childMenu":[]
        })
        this.selectedMenuIndex = this.menu.button.length-1;
        this.selectedSubMenuIndex=''
      }
      if(level == 2 && this.menu.button[this.selectedMenuIndex].childMenu.length<5){
        this.menu.button[this.selectedMenuIndex].childMenu.push({
          name:"子菜单名称",
          "isSelect":true
        })
        this.selectedSubMenuIndex= this.menu.button[this.selectedMenuIndex].childMenu.length-1;

        // this.selectedMenuIndex = '';
        // console.log(this.selectedSubMenuIndex);
        // console.log(this.selectedMenuIndex);
      }
    },
    selectedMenu:function(i,event){ //选择主菜单
      this.selectedSubMenuIndex=''
      this.selectedMenuIndex=i
      var selectedMenu = this.menu.button[this.selectedMenuIndex];
      if(this.selectedMenuLevel() == 1){
        // this.selectTab();
      }
    },
    selectedSubMenu:function(i,event){//选择子菜单
      this.selectedSubMenuIndex = i;

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
    selectTab:function(){
      switch (this.menu.button[this.selectedMenuIndex].isSelect){
        case 'postMsg':
          return 1;
          break;
        case 'view':
          return 2;
          break;
      }
    },
    subMenu:function(msg){
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
    },
    currentSelect:function(){
      if(this.menu.button[this.selectedMenuIndex].type == 'msg'){
        return 1
      }else if(this.menu.button[this.selectedMenuIndex].type == 'font'){
        return 2
      }
      else if(this.menu.button[this.selectedMenuIndex].type == 'photo'){
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
    }
  },
  mounted:function () {
    var _this =  this;
    // _this.selectTab(1);
  }
})