package com.we.fc.wechat.doc;

/**
 * @apiDefine wxMessage 微信公众号
 */

/**
 * @api {post} /message 给用户发送文本消息
 * @apiName sendTextMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,Content:消息内容
 * @apiParamExample {json} Request-Example:
 * {
 *      "ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *      "MsgType":"text",
 *      "Content":"hello world"
 * }
 */

/**
 * @api {post} /message 给用户发送图片消息
 * @apiName sendImageMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID
 * @apiParamExample {json} Request-Example:
 * {
 *      "ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *      "MsgType":"image",
 *      "MediaId":"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0"
 * }
 */

/**
 * @api {post} /message 给用户发送语音消息
 * @apiName sendVoiceMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID
 * @apiParamExample {json} Request-Example:
 * {
 *      "ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *      "MsgType":"voice",
 *      "MediaId":"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0"
 * }
 */

/**
 * @api {post} /message 给用户发送视频消息
 * @apiName sendVideoMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID
 * @apiParamExample {json} Request-Example:
 * {
 *      "ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *      "MsgType":"video",
 *      "MediaId":"f1QOuU_OT4Hrt8abnY9n2F8ssl_ni6Y1HbRbR4HRkU0"
 * }
 */

/**
 * @api {post} /message 给用户发送图文消息
 * @apiName sendImageTextMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,Title:图文标题,Description:图文描述,Url:跳转链接,PicUrl:显示的图片链接
 * @apiParamExample {json} Request-Example:
 * {
 * 	"ToUserName": "o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 * 	"MsgType": "news",
 * 	"Title": "图文标题",
 * 	"Description": "图文描述",
 * 	"Url": "http://www.baidu.com",
 * 	"PicUrl": "http://mmbiz.qpic.cn/mmbiz_jpg/FwRDKpzzTCMo4Aqfw3kQwq3Dn8Sq1amp3RhaHjaSZIb1qus6RibUP8gyF8DvqgL6VkEfSnMCtdB3e6c9BG6SACQ/0?wx_fmt=jpeg"
 * }
 */

/**
 * @api {get} /wxPublic/page 公众号列表(分页)
 * @apiName getWxPublic
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/wxPublic/page?page=1&rows=10
 *
 * @apiSuccessExample Result-Example:
 * {
 *   "status": "200",
 *   "messages": "操作成功！",
 *   "list": null,
 *   "data": {
 *     "pageNum": 1,
 *     "pageSize": 10,
 *     "size": 1,
 *     "startRow": 1,
 *     "endRow": 1,
 *     "total": 1,
 *     "pages": 1,
 *     "list": [
 *       {
 *         "id": 14,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": "2018-04-14 19:38:56",
 *         "updateTime": "2018-04-14 19:38:56",
 *         "publicName": "键猫盘",
 *         "sourceId": "gh_f5a46974c0f6",
 *         "appId": "wx8be44989f5440994",
 *         "appSecret": "978bc882348ededa7027fb98e5f816ca",
 *         "publicEmail": "451914442@qq.com"
 *       }
 *     ],
 *     "prePage": 0,
 *     "nextPage": 0,
 *     "isFirstPage": true,
 *     "isLastPage": true,
 *     "hasPreviousPage": false,
 *     "hasNextPage": false,
 *     "navigatePages": 8,
 *     "navigatepageNums": [
 *       1
 *     ],
 *     "navigateFirstPage": 1,
 *     "navigateLastPage": 1,
 *     "firstPage": 1,
 *     "lastPage": 1
 *   }
 * }
 */

/**
 * @api {get} /wxUsers/page 用户列表(分页)
 * @apiName getWxUsers
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/wxUsers/page?page=1&rows=10
 *
 * @apiSuccessExample Result-Example:
 * {
 *   "status": "200",
 *   "messages": "操作成功！",
 *   "list": null,
 *   "data": {
 *     "pageNum": 1,
 *     "pageSize": 10,
 *     "size": 5,
 *     "startRow": 1,
 *     "endRow": 5,
 *     "total": 5,
 *     "pages": 1,
 *     "list": [
 *       {
 *         "id": 1,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": null,
 *         "updateTime": null,
 *         "subscribe": 1,
 *         "openid": "o2IG5wmk7mrmbijC7cdNCV8IU5z4",
 *         "nickname": "⊙",
 *         "sex": 1,
 *         "city": "成都",
 *         "country": "中国",
 *         "province": "四川",
 *         "language": "zh_CN",
 *         "headimgurl": "http://thirdwx.qlogo.cn/mmopen/ajNVdqHZLLC6WfvwBdzib24MhiaX10PeRm4xGFxUwHyWQP2wGJcFsHtIhxp6rUUicnJFZJ0E2Uhia2lH3icyibib2W2Kw/132",
 *         "subscribe_time": 1523692332,
 *         "unionid": null,
 *         "remark": "",
 *         "groupid": 0,
 *         "subscribe_scene": "ADD_SCENE_OTHERS",
 *         "wxPublic": {
 *           "id": 14,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "publicName": null,
 *           "sourceId": null,
 *           "appId": null,
 *           "appSecret": null,
 *           "publicEmail": null
 *         }
 *       },
 *       {
 *         "id": 3,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": null,
 *         "updateTime": null,
 *         "subscribe": 1,
 *         "openid": "o2IG5wkVvAP_3TpVM1Ny4SsysO2w",
 *         "nickname": "456",
 *         "sex": 0,
 *         "city": "",
 *         "country": "",
 *         "province": "",
 *         "language": "zh_CN",
 *         "headimgurl": "http://thirdwx.qlogo.cn/mmopen/sJqic27LwEIsxBeKyBZsV3oc0rickqXW9ucNrHCeiaLBbW43kSXDaacnzvngKYDeghdnBgVNrE7srFzmB6zWFTOtdcJorEDKmRo/132",
 *         "subscribe_time": 1512722588,
 *         "unionid": null,
 *         "remark": "",
 *         "groupid": 0,
 *         "subscribe_scene": "ADD_SCENE_SEARCH",
 *         "wxPublic": {
 *           "id": 14,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "publicName": null,
 *           "sourceId": null,
 *           "appId": null,
 *           "appSecret": null,
 *           "publicEmail": null
 *         }
 *       },
 *       {
 *         "id": 4,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": null,
 *         "updateTime": null,
 *         "subscribe": 1,
 *         "openid": "o2IG5wtA0EhlkfTx3ya7-IrYVwVc",
 *         "nickname": "柠檬的酸ヾ",
 *         "sex": 1,
 *         "city": "",
 *         "country": "安哥拉",
 *         "province": "莫希科",
 *         "language": "zh_CN",
 *         "headimgurl": "http://thirdwx.qlogo.cn/mmopen/ChCs6YSVOGVaaial3Q0O1iaSIuibo9e5qFhJ4YdDt2ice2NKqY83oCGRgwARYtjEfmeqa4MylgKPACDkIhIriaCFmX28Kgar8RlJW/132",
 *         "subscribe_time": 1509525070,
 *         "unionid": null,
 *         "remark": "",
 *         "groupid": 0,
 *         "subscribe_scene": "ADD_SCENE_PROFILE_CARD",
 *         "wxPublic": {
 *           "id": 14,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "publicName": null,
 *           "sourceId": null,
 *           "appId": null,
 *           "appSecret": null,
 *           "publicEmail": null
 *         }
 *       },
 *       {
 *         "id": 5,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": null,
 *         "updateTime": null,
 *         "subscribe": 1,
 *         "openid": "o2IG5wtibBZkEWY5fqfvwLkFA4dY",
 *         "nickname": "吴先生",
 *         "sex": 1,
 *         "city": "成都",
 *         "country": "中国",
 *         "province": "四川",
 *         "language": "zh_CN",
 *         "headimgurl": "http://thirdwx.qlogo.cn/mmopen/oP2gYibP60TEnvzqW1z6FrF6mibHnuR69pcex2KrH5rSljbzmtb9TyOofn6T3ia1P0MXDt7Z0OZ4oocEQbP0YpFrwiaXWjmfsxCF/132",
 *         "subscribe_time": 1509557353,
 *         "unionid": null,
 *         "remark": "",
 *         "groupid": 0,
 *         "subscribe_scene": "ADD_SCENE_SEARCH",
 *         "wxPublic": {
 *           "id": 14,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "publicName": null,
 *           "sourceId": null,
 *           "appId": null,
 *           "appSecret": null,
 *           "publicEmail": null
 *         }
 *       },
 *       {
 *         "id": 6,
 *         "intermediary": {
 *           "id": 1,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "isPlat": 0,
 *           "intermediaryName": null,
 *           "intermediaryContact": null,
 *           "intermediaryContactTel": null,
 *           "area": null,
 *           "user": null,
 *           "intermediaryLogoUrl": null,
 *           "intermediaryIntroduction": null
 *         },
 *         "createTime": null,
 *         "updateTime": null,
 *         "subscribe": 1,
 *         "openid": "o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *         "nickname": "♬上弦月♂",
 *         "sex": 1,
 *         "city": "成都",
 *         "country": "中国",
 *         "province": "四川",
 *         "language": "zh_CN",
 *         "headimgurl": "http://thirdwx.qlogo.cn/mmopen/oP2gYibP60TEWDFM0URPns2VRbYJfxGSSUX5NdwtSI8ianWC12cR07MOKbiaQGUAVckXYxTU7GXVNzNH2bpfvhEFs8ibs7ELbNZC/132",
 *         "subscribe_time": 1524577077,
 *         "unionid": null,
 *         "remark": "",
 *         "groupid": 0,
 *         "subscribe_scene": "ADD_SCENE_SEARCH",
 *         "wxPublic": {
 *           "id": 14,
 *           "intermediary": null,
 *           "createTime": null,
 *           "updateTime": null,
 *           "publicName": null,
 *           "sourceId": null,
 *           "appId": null,
 *           "appSecret": null,
 *           "publicEmail": null
 *         }
 *       }
 *     ],
 *     "prePage": 0,
 *     "nextPage": 0,
 *     "isFirstPage": true,
 *     "isLastPage": true,
 *     "hasPreviousPage": false,
 *     "hasNextPage": false,
 *     "navigatePages": 8,
 *     "navigatepageNums": [
 *       1
 *     ],
 *     "navigateFirstPage": 1,
 *     "navigateLastPage": 1,
 *     "firstPage": 1,
 *     "lastPage": 1
 *   }
 * }
 */

/**
 * @api {get} /message/page 获取用户消息(分页)
 * @apiName getUserMsg
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * openId:用户的OPENID
 * localhost:8080/message/page?page=1&rows=10&openId=o2IG5wpS7Ju6FPg6LW1OIuxKUgI0
 */

public class WxDocumentation {
}
