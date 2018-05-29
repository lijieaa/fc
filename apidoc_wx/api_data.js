define({ "api": [
  {
    "type": "post",
    "url": "/material/upload",
    "title": "添加图片素材",
    "name": "addImageMaterial",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "media",
            "description": "<p>图片文件</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "type",
            "description": "<p>素材类型，type为image，表示图片</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/upload",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/material/upload/news",
    "title": "添加图文素材",
    "name": "addNewsMaterial",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/upload/news",
        "type": "json"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": ": Param - Example:",
          "content": "{\n\t\"title\": \"文章标题\",\n\t\"thumb_media_id\": \"f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA\",    图片的media_id\n\t\"author\": \"作者\",\n\t\"digest\": \"文章摘要\",\n\t\"show_cover_pic\": 1,    是否显示封面0：不显示，1：显示\n\t\"content\": \"<p>hehe</p>\",\n\t\"content_source_url\": \"\",    点击原文阅读后跳转的链接\n\t\"wxPublicId\": 14    公众号ID\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/material/upload",
    "title": "添加视频素材",
    "name": "addVideoMaterial",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "media",
            "description": "<p>视频文件(mp4格式)</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "type",
            "description": "<p>素材类型，type为video，表示视频</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "description",
            "description": "<p>视频相关信息 {&quot;title&quot;:&quot;视频标题&quot;, &quot;introduction&quot;:&quot;视频介绍&quot;}</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/upload",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/material/upload",
    "title": "添加语音素材",
    "name": "addVoiceMaterial",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "media",
            "description": "<p>语音文件(mp3格式)</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "type",
            "description": "<p>素材类型，type为voice，表示语音</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/upload",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/wxPublic",
    "title": "添加公众号",
    "name": "addWxPublic",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxPublic",
        "type": "json"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Param - Example:",
          "content": "\n{\n  \"publicName\":\"公众号名称\",\n\t \"sourceId\":\"原始ID\",\n\t \"appId\":\"appId\",\n\t \"appSecret\":\"appSecret\",\n\t \"publicEmail\":\"publicEmail\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/menu",
    "title": "创建菜单",
    "name": "createMenu",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "json",
            "description": "<p>菜单内容</p>"
          }
        ]
      },
      "examples": [
        {
          "title": ": Param - Example:",
          "content": "{\n\t\"button\": [{\n\t\t\"type\": \"click\",\n\t\t\"name\": \"今日歌曲\",\n\t\t\"key\": \"V1001_TODAY_MUSIC\"\n\t}, {\n\t\t\"name\": \"菜单\",\n\t\t\"sub_button\": [{\n\t\t\t\"type\": \"view\",\n\t\t\t\"name\": \"搜索\",\n\t\t\t\"url\": \"http://www.soso.com/\"\n\t\t}, {\n\t\t\t\"type\": \"click\",\n\t\t\t\"name\": \"赞一下我们\",\n\t\t\t\"key\": \"V1001_GOOD\"\n\t\t}]\n\t}]\n}",
          "type": "json"
        }
      ]
    },
    "examples": [
      {
        "title": "Request - Example:",
        "content": "localhost:8080/menu",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "delete",
    "url": "/menu",
    "title": "删除菜单",
    "description": "<p>将删除所有自定义菜单</p>",
    "name": "deleteMenu",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request - Example:",
        "content": "localhost:8080/menu?wxPublicId=14",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "delete",
    "url": "/wxPublic",
    "title": "删除公众号",
    "name": "deleteWxPublic",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxPublic?id=1",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/image/detail",
    "title": "获取单个图片素材内容",
    "name": "getMaterialImageDetail",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "mediaId",
            "description": "<p>素材mediaId</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "name",
            "description": "<p>素材文件名</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/video/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.jpg",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/page",
    "title": "获取素材列表",
    "name": "getMaterialList",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "type",
            "description": "<p>素材类型image/voice/video/news</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/page?page=1&rows=10&type=video&wxPublicId=14",
        "type": "json"
      }
    ],
    "success": {
      "examples": [
        {
          "title": ": Param - Example:",
          "content": "{\n  \"status\": \"200\",\n  \"messages\": \"操作成功！\",\n  \"list\": null,\n  \"data\": {\n    \"pageNum\": 1,\n    \"pageSize\": 10,\n    \"size\": 2,\n    \"startRow\": 1,\n    \"endRow\": 2,\n    \"total\": 2,\n    \"pages\": 1,\n    \"list\": [\n      {\n        \"id\": 6,\n        \"intermediary\": null,\n        \"createTime\": null,\n        \"updateTime\": \"2018-05-04 22:30:58\",\n        \"wxPublicId\": null,\n        \"mediaId\": \"f1QOuU_OT4Hrt8abnY9n2CqDJDpsZl92N9G3YqH-ReA\",\n        \"name\": \"sd1524405694_2呵呵.MP4\",\n        \"type\": \"video\",\n        \"url\": null,\n        \"title\": null,\n        \"author\": null,\n        \"digest\": null,\n        \"content\": null,\n        \"contentSourceUrl\": null,\n        \"thumbMediaId\": null,\n        \"showCoverPic\": null,\n        \"thumbUrl\": null,\n       \"needOpenComment\": null,\n        \"onlyFansCanComment\": null,\n        \"description\": null\n      },\n      {\n        \"id\": 7,\n        \"intermediary\": null,\n        \"createTime\": null,\n        \"updateTime\": \"2018-05-05 23:45:56\",\n        \"wxPublicId\": null,\n        \"mediaId\": \"f1QOuU_OT4Hrt8abnY9n2ERDzW2rCwiZzT7AWJzgtGc\",\n        \"name\": \"sd1524405694_2呵呵.MP4\",\n        \"type\": \"video\",\n        \"url\": null,\n        \"title\": null,\n        \"author\": null,\n        \"digest\": null,\n        \"content\": null,\n        \"contentSourceUrl\": null,\n        \"thumbMediaId\": null,\n        \"showCoverPic\": null,\n        \"thumbUrl\": null,\n        \"needOpenComment\": null,\n        \"onlyFansCanComment\": null,\n        \"description\": null\n      }\n    ],\n    \"prePage\": 0,\n    \"nextPage\": 0,\n    \"isFirstPage\": true,\n    \"isLastPage\": true,\n   \"hasPreviousPage\": false,\n    \"hasNextPage\": false,\n    \"navigatePages\": 8,\n    \"navigatepageNums\": [\n      1\n    ],\n    \"navigateFirstPage\": 1,\n    \"navigateLastPage\": 1,\n    \"firstPage\": 1,\n    \"lastPage\": 1\n  }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/news/detail",
    "title": "获取单个图文素材内容",
    "name": "getMaterialNewsDetail",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "mediaId",
            "description": "<p>素材mediaId</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/video/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/video/detail",
    "title": "获取单个视频素材内容",
    "name": "getMaterialVideoDetail",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "mediaId",
            "description": "<p>素材mediaId</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "name",
            "description": "<p>素材文件名</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/video/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.mp4",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/voice/detail",
    "title": "获取单个语音素材内容",
    "name": "getMaterialVoiceDetail",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "mediaId",
            "description": "<p>素材mediaId</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "name",
            "description": "<p>素材文件名</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/material/video/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.mp3",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/menu",
    "title": "获取菜单",
    "name": "getMenu",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request - Example:",
        "content": "localhost:8080/menu?wxPublicId=14",
        "type": "json"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Response - Example:",
          "content": "{\n \"menu\": {\n   \"button\": [\n     {\n       \"type\": \"click\",\n       \"name\": \"今日歌曲\",\n       \"key\": \"V1001_TODAY_MUSIC\",\n       \"sub_button\": []\n     },\n     {\n       \"name\": \"菜单\",\n       \"sub_button\": [\n         {\n           \"type\": \"view\",\n           \"name\": \"搜索\",\n           \"url\": \"http://www.soso.com/\",\n           \"sub_button\": []\n         },\n         {\n           \"type\": \"click\",\n           \"name\": \"赞一下我们\",\n           \"key\": \"V1001_GOOD\",\n           \"sub_button\": []\n         }\n       ]\n     }\n   ]\n }\n}",
          "type": "String"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/message/page",
    "title": "获取用户消息(分页)",
    "name": "getUserMsg",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "openId:用户的OPENID  wxPublicId:公众号ID\nlocalhost:8080/message/page?page=1&rows=10&openId=o2IG5wpS7Ju6FPg6LW1OIuxKUgI0&wxPublicId=1",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/wxPublic/page",
    "title": "公众号列表(分页)",
    "name": "getWxPublic",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxPublic/page?page=1&rows=10",
        "type": "json"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Result-Example:",
          "content": "{\n  \"status\": \"200\",\n  \"messages\": \"操作成功！\",\n  \"list\": null,\n  \"data\": {\n    \"pageNum\": 1,\n    \"pageSize\": 10,\n    \"size\": 1,\n    \"startRow\": 1,\n    \"endRow\": 1,\n    \"total\": 1,\n    \"pages\": 1,\n    \"list\": [\n      {\n        \"id\": 14,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": \"2018-04-14 19:38:56\",\n        \"updateTime\": \"2018-04-14 19:38:56\",\n        \"publicName\": \"键猫盘\",\n        \"sourceId\": \"gh_f5a46974c0f6\",\n        \"appId\": \"wx8be44989f5440994\",\n        \"appSecret\": \"978bc882348ededa7027fb98e5f816ca\",\n        \"publicEmail\": \"451914442@qq.com\"\n      }\n    ],\n    \"prePage\": 0,\n    \"nextPage\": 0,\n    \"isFirstPage\": true,\n    \"isLastPage\": true,\n    \"hasPreviousPage\": false,\n    \"hasNextPage\": false,\n    \"navigatePages\": 8,\n    \"navigatepageNums\": [\n      1\n    ],\n    \"navigateFirstPage\": 1,\n    \"navigateLastPage\": 1,\n    \"firstPage\": 1,\n    \"lastPage\": 1\n  }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/wxUsers/page",
    "title": "用户列表(分页)",
    "name": "getWxUsers",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxUsers/page?page=1&rows=10&wxPublicId=1",
        "type": "json"
      }
    ],
    "success": {
      "examples": [
        {
          "title": "Result-Example:",
          "content": "{\n  \"status\": \"200\",\n  \"messages\": \"操作成功！\",\n  \"list\": null,\n  \"data\": {\n    \"pageNum\": 1,\n    \"pageSize\": 10,\n    \"size\": 5,\n    \"startRow\": 1,\n    \"endRow\": 5,\n    \"total\": 5,\n    \"pages\": 1,\n    \"list\": [\n      {\n        \"id\": 1,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": null,\n        \"updateTime\": null,\n        \"subscribe\": 1,\n        \"openid\": \"o2IG5wmk7mrmbijC7cdNCV8IU5z4\",\n        \"nickname\": \"⊙\",\n        \"sex\": 1,\n        \"city\": \"成都\",\n        \"country\": \"中国\",\n        \"province\": \"四川\",\n        \"language\": \"zh_CN\",\n        \"headimgurl\": \"http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLC6WfvwBdzib24MhiaX10PeRm4xGFxUwHyWQP2wGJcFsHtIhxp6rUUicnJFZJ0E2Uhia2lH3icyibib2W2Kw/132\",\n        \"subscribe_time\": 1523692332,\n        \"unionid\": null,\n        \"remark\": \"\",\n        \"groupid\": 0,\n        \"subscribe_scene\": \"ADD_SCENE_OTHERS\",\n        \"wxPublic\": {\n          \"id\": 14,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"publicName\": null,\n          \"sourceId\": null,\n          \"appId\": null,\n          \"appSecret\": null,\n          \"publicEmail\": null\n        }\n      },\n      {\n        \"id\": 3,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": null,\n        \"updateTime\": null,\n        \"subscribe\": 1,\n        \"openid\": \"o2IG5wkVvAP_3TpVM1Ny4SsysO2w\",\n        \"nickname\": \"456\",\n        \"sex\": 0,\n        \"city\": \"\",\n        \"country\": \"\",\n        \"province\": \"\",\n        \"language\": \"zh_CN\",\n        \"headimgurl\": \"http://thirdwx.qlogo.cn/mmopen/sJqic27LwEIsxBeKyBZsV3oc0rickqXW9ucNrHCeiaLBbW43kSXDaacnzvngKYDeghdnBgVNrE7srFzmB6zWFTOtdcJorEDKmRo/132\",\n        \"subscribe_time\": 1512722588,\n        \"unionid\": null,\n        \"remark\": \"\",\n        \"groupid\": 0,\n        \"subscribe_scene\": \"ADD_SCENE_SEARCH\",\n        \"wxPublic\": {\n          \"id\": 14,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"publicName\": null,\n          \"sourceId\": null,\n          \"appId\": null,\n          \"appSecret\": null,\n          \"publicEmail\": null\n        }\n      },\n      {\n        \"id\": 4,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": null,\n        \"updateTime\": null,\n        \"subscribe\": 1,\n        \"openid\": \"o2IG5wtA0EhlkfTx3ya7-IrYVwVc\",\n        \"nickname\": \"柠檬的酸ヾ\",\n        \"sex\": 1,\n        \"city\": \"\",\n        \"country\": \"安哥拉\",\n        \"province\": \"莫希科\",\n        \"language\": \"zh_CN\",\n        \"headimgurl\": \"http://thirdwx.qlogo.cn/mmopen/ChCs6YSVOGVaaial3Q0O1iaSIuibo9e5qFhJ4YdDt2ice2NKqY83oCGRgwARYtjEfmeqa4MylgKPACDkIhIriaCFmX28Kgar8RlJW/132\",\n        \"subscribe_time\": 1509525070,\n        \"unionid\": null,\n        \"remark\": \"\",\n        \"groupid\": 0,\n        \"subscribe_scene\": \"ADD_SCENE_PROFILE_CARD\",\n        \"wxPublic\": {\n          \"id\": 14,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"publicName\": null,\n          \"sourceId\": null,\n          \"appId\": null,\n          \"appSecret\": null,\n          \"publicEmail\": null\n        }\n      },\n      {\n        \"id\": 5,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": null,\n        \"updateTime\": null,\n        \"subscribe\": 1,\n        \"openid\": \"o2IG5wtibBZkEWY5fqfvwLkFA4dY\",\n        \"nickname\": \"吴先生\",\n        \"sex\": 1,\n        \"city\": \"成都\",\n        \"country\": \"中国\",\n        \"province\": \"四川\",\n        \"language\": \"zh_CN\",\n        \"headimgurl\": \"http://thirdwx.qlogo.cn/mmopen/oP2gYibP60TEnvzqW1z6FrF6mibHnuR69pcex2KrH5rSljbzmtb9TyOofn6T3ia1P0MXDt7Z0OZ4oocEQbP0YpFrwiaXWjmfsxCF/132\",\n        \"subscribe_time\": 1509557353,\n        \"unionid\": null,\n        \"remark\": \"\",\n        \"groupid\": 0,\n        \"subscribe_scene\": \"ADD_SCENE_SEARCH\",\n        \"wxPublic\": {\n          \"id\": 14,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"publicName\": null,\n          \"sourceId\": null,\n          \"appId\": null,\n          \"appSecret\": null,\n          \"publicEmail\": null\n        }\n      },\n      {\n        \"id\": 6,\n        \"intermediary\": {\n          \"id\": 1,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"isPlat\": 0,\n          \"intermediaryName\": null,\n          \"intermediaryContact\": null,\n          \"intermediaryContactTel\": null,\n          \"area\": null,\n          \"user\": null,\n          \"intermediaryLogoUrl\": null,\n          \"intermediaryIntroduction\": null\n        },\n        \"createTime\": null,\n        \"updateTime\": null,\n        \"subscribe\": 1,\n        \"openid\": \"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n        \"nickname\": \"♬上弦月♂\",\n        \"sex\": 1,\n        \"city\": \"成都\",\n        \"country\": \"中国\",\n        \"province\": \"四川\",\n        \"language\": \"zh_CN\",\n        \"headimgurl\": \"http://thirdwx.qlogo.cn/mmopen/oP2gYibP60TEWDFM0URPns2VRbYJfxGSSUX5NdwtSI8ianWC12cR07MOKbiaQGUAVckXYxTU7GXVNzNH2bpfvhEFs8ibs7ELbNZC/132\",\n        \"subscribe_time\": 1524577077,\n        \"unionid\": null,\n        \"remark\": \"\",\n        \"groupid\": 0,\n        \"subscribe_scene\": \"ADD_SCENE_SEARCH\",\n        \"wxPublic\": {\n          \"id\": 14,\n          \"intermediary\": null,\n          \"createTime\": null,\n          \"updateTime\": null,\n          \"publicName\": null,\n          \"sourceId\": null,\n          \"appId\": null,\n          \"appSecret\": null,\n          \"publicEmail\": null\n        }\n      }\n    ],\n    \"prePage\": 0,\n    \"nextPage\": 0,\n    \"isFirstPage\": true,\n    \"isLastPage\": true,\n    \"hasPreviousPage\": false,\n    \"hasNextPage\": false,\n    \"navigatePages\": 8,\n    \"navigatepageNums\": [\n      1\n    ],\n    \"navigateFirstPage\": 1,\n    \"navigateLastPage\": 1,\n    \"firstPage\": 1,\n    \"lastPage\": 1\n  }\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/material/image/detail",
    "title": "素材图片查看",
    "description": "<p>直接使用素材链接不能正常显示，需要通过后台接口转一下</p>",
    "name": "imageDetail",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "optional": false,
            "field": "url",
            "description": "<p>素材url</p>"
          },
          {
            "group": "Parameter",
            "optional": false,
            "field": "name",
            "description": "<p>素材名称（xxx.jpg/xxx.png）</p>"
          }
        ]
      }
    },
    "examples": [
      {
        "title": "Request - Example:",
        "content": "localhost:8080/material/image/detail?url=http://mmbiz.qpic.cn/mmbiz_jpg/FwRDKpzzTCMeic3kUEqYZiahRLxpa3WQ8YYpmKjmq9LiawOgb5lKGaT7FOG0ahPCMYibB6Cox3kztDQrvDsicACltSg/0?wx_fmt=jpeg&name=11.jpg",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/message",
    "title": "给用户发送图片消息",
    "name": "sendImageMsg",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "json",
            "description": "<p>ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n     \"ToUserName\":\"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n     \"MsgType\":\"image\",\n     \"MediaId\":\"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/message",
    "title": "给用户发送图文消息",
    "name": "sendImageTextMsg",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "json",
            "description": "<p>ToUserName:用户的openId,MsgType:消息类型,Title:图文标题,Description:图文描述,Url:跳转链接,PicUrl:显示的图片链接</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n\t\"ToUserName\": \"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n\t\"MsgType\": \"news\",\n\t\"Title\": \"图文标题\",\n\t\"Description\": \"图文描述\",\n\t\"Url\": \"http://www.baidu.com\",\n\t\"PicUrl\": \"http://mmbiz.qpic.cn/mmbiz_jpg/FwRDKpzzTCMo4Aqfw3kQwq3Dn8Sq1amp3RhaHjaSZIb1qus6RibUP8gyF8DvqgL6VkEfSnMCtdB3e6c9BG6SACQ/0?wx_fmt=jpeg\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/message",
    "title": "给用户发送文本消息",
    "name": "sendTextMsg",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "json",
            "description": "<p>ToUserName:用户的openId,MsgType:消息类型,Content:消息内容</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Param-Example:",
          "content": "{\n     \"ToUserName\":\"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n     \"MsgType\":\"text\",\n     \"Content\":\"hello world\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/message",
    "title": "给用户发送视频消息",
    "name": "sendVideoMsg",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "json",
            "description": "<p>ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n     \"ToUserName\":\"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n     \"MsgType\":\"video\",\n     \"MediaId\":\"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "post",
    "url": "/message",
    "title": "给用户发送语音消息",
    "name": "sendVoiceMsg",
    "group": "wxMessage",
    "parameter": {
      "fields": {
        "Parameter": [
          {
            "group": "Parameter",
            "type": "String",
            "optional": false,
            "field": "json",
            "description": "<p>ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID</p>"
          },
          {
            "group": "Parameter",
            "type": "Number",
            "optional": false,
            "field": "wxPublicId",
            "description": "<p>公众号ID</p>"
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n     \"ToUserName\":\"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n     \"MsgType\":\"voice\",\n     \"MediaId\":\"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "put",
    "url": "/wxPublic",
    "title": "编辑公众号",
    "name": "updateWxPublic",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxPublic",
        "type": "json"
      }
    ],
    "parameter": {
      "examples": [
        {
          "title": "Param - Example:",
          "content": "\n{\n  \"id\":\"主键ID\",\n  \"publicName\":\"公众号名称\",\n\t \"sourceId\":\"原始ID\",\n\t \"appId\":\"appId\",\n\t \"appSecret\":\"appSecret\",\n\t \"publicEmail\":\"publicEmail\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/jianpanmao/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  }
] });
