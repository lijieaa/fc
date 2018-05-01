define({ "api": [
  {
    "type": "get",
    "url": "/message/page",
    "title": "获取用户消息(分页)",
    "name": "getUserMsg",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "openId:用户的OPENID\nlocalhost:8080/message/page?page=1&rows=10&openId=o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
        "type": "json"
      }
    ],
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  },
  {
    "type": "get",
    "url": "/wxUsers/page",
    "title": "用户列表(分页)",
    "name": "getWxUsers",
    "group": "wxMessage",
    "examples": [
      {
        "title": "Request-Example:",
        "content": "localhost:8080/wxUsers/page?page=1&rows=10",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
          }
        ]
      },
      "examples": [
        {
          "title": "Request-Example:",
          "content": "{\n     \"ToUserName\":\"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0\",\n     \"MsgType\":\"text\",\n     \"Content\":\"hello world\"\n}",
          "type": "json"
        }
      ]
    },
    "version": "0.0.0",
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
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
    "filename": "D:/fc/src/main/java/com/we/fc/wechat/doc/WxDocumentation.java",
    "groupTitle": "微信公众号"
  }
] });
