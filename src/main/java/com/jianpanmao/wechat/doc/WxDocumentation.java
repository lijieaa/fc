package com.jianpanmao.wechat.doc;

/**
 * @apiDefine wxMessage 微信公众号
 */

/**
 * @api {post} /message 给用户发送文本消息
 * @apiName sendTextMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,Content:消息内容
 * @apiParam {Number} wxPublicId 公众号ID
 * @apiParamExample {json} Param-Example:
 * {
 *      "ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *      "MsgType":"text",
 *      "Content":"hello world"
 * }
 *
 */

/**
 * @api {post} /message 给用户发送图片消息
 * @apiName sendImageMsg
 * @apiGroup wxMessage
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,MediaId:素材ID
 * @apiParam {Number} wxPublicId 公众号ID
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
 * @apiParam {Number} wxPublicId 公众号ID
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
 * @apiParam {Number} wxPublicId 公众号ID
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
 * @apiParam {String} json ToUserName:用户的openId,MsgType:消息类型,Title:图文标题,Description:图文描述,PicUrl:显示的图片链接
 * @apiParam {Number} wxPublicId 公众号ID
 * @apiParamExample {json} Request-Example:
 * {
 * 	"ToUserName": "o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 * 	"MsgType": "news",
 * 	"Title": "图文标题",
 * 	"Description": "图文描述",
 * 	"Url": "http://www.baidu.com",
 * 	"MediaId": "f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA"
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
 * @apiParam {Number} wxPublicId 公众号ID
 * @apiParam {String} nickname 用户名称
 * @apiExample Request-Example:
 * localhost:8080/wxUsers/page?page=1&rows=10&wxPublicId=1
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
 * @api {get} /message/user/page 获取用户消息(分页)
 * @apiName getUserMsg
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * openId:用户的OPENID  wxPublicId:公众号ID
 * localhost:8080/message/page?page=1&rows=10&openId=o2IG5wpS7Ju6FPg6LW1OIuxKUgI0&wxPublicId=1
 */

/**
 * @api {post} /wxPublic 添加公众号
 * @apiName addWxPublic
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/wxPublic
 *
 * @apiParamExample {json} Param - Example:
 *
 * {
 *   "publicName":"公众号名称",
 *	 "sourceId":"原始ID",
 *	 "appId":"appId",
 *	 "appSecret":"appSecret",
 *	 "publicEmail":"publicEmail"
 *}
 */

/**
 * @api {put} /wxPublic 编辑公众号
 * @apiName updateWxPublic
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/wxPublic
 *
 * @apiParamExample {json} Param - Example:
 *
 * {
 *   "id":"主键ID",
 *   "publicName":"公众号名称",
 *	 "sourceId":"原始ID",
 *	 "appId":"appId",
 *	 "appSecret":"appSecret",
 *	 "publicEmail":"publicEmail"
 *}
 */

/**
 * @api {delete} /wxPublic 删除公众号
 * @apiName deleteWxPublic
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/wxPublic?id=1
 */

/**
 * @api {post} /material/upload 添加图片素材
 * @apiName addImageMaterial
 * @apiGroup wxMessage
 * @apiParam media 图片文件
 * @apiParam wxPublicId 公众号ID
 * @apiParam type 素材类型，type为image，表示图片
 * @apiExample Request-Example:
 * localhost:8080/material/upload
 */

/**
 * @api {post} /material/upload 添加语音素材
 * @apiName addVoiceMaterial
 * @apiGroup wxMessage
 * @apiParam media 语音文件(mp3格式)
 * @apiParam wxPublicId 公众号ID
 * @apiParam type 素材类型，type为voice，表示语音
 * @apiExample Request-Example:
 * localhost:8080/material/upload
 */

/**
 * @api {post} /material/upload 添加视频素材
 * @apiName addVideoMaterial
 * @apiGroup wxMessage
 * @apiParam media 视频文件(mp4格式)
 * @apiParam wxPublicId 公众号ID
 * @apiParam type 素材类型，type为video，表示视频
 * @apiParam description 视频相关信息 {"title":"视频标题", "introduction":"视频介绍"}
 * @apiExample Request-Example:
 * localhost:8080/material/upload
 */

/**
 * @api {post} /material/upload/news 添加图文素材
 * @apiName addNewsMaterial
 * @apiGroup wxMessage
 * @apiExample Request-Example:
 * localhost:8080/material/upload/news
 * @apiParamExample: Param - Example:
 *{
 *	"title": "文章标题",
 *	"thumb_media_id": "f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA",    图片的media_id
 *	"author": "作者",
 *	"digest": "文章摘要",
 *	"show_cover_pic": 1,    是否显示封面0：不显示，1：显示
 *	"content": "<p>hehe</p>",
 *	"content_source_url": "",    点击原文阅读后跳转的链接
 *	"wxPublicId": 14    公众号ID
 *}
 */

/**
 * @api {get} /material/page 获取素材列表
 * @apiName getMaterialList
 * @apiGroup wxMessage
 * @apiParam type 素材类型image/voice/video/news
 * @apiParam wxPublicId 公众号ID
 * @apiExample Request-Example:
 * localhost:8080/material/page?page=1&rows=10&type=video&wxPublicId=14
 * @apiSuccessExample : Param - Example:
 *{
 *   "status": "200",
 *   "messages": "操作成功！",
 *   "list": null,
 *   "data": {
 *     "pageNum": 1,
 *     "pageSize": 10,
 *     "size": 2,
 *     "startRow": 1,
 *     "endRow": 2,
 *     "total": 2,
 *     "pages": 1,
 *     "list": [
 *       {
 *         "id": 6,
 *         "intermediary": null,
 *         "createTime": null,
 *         "updateTime": "2018-05-04 22:30:58",
 *         "wxPublicId": null,
 *         "mediaId": "f1QOuU_OT4Hrt8abnY9n2CqDJDpsZl92N9G3YqH-ReA",
 *         "name": "sd1524405694_2呵呵.MP4",
 *         "type": "video",
 *         "url": null,
 *         "title": null,
 *         "author": null,
 *         "digest": null,
 *         "content": null,
 *         "contentSourceUrl": null,
 *         "thumbMediaId": null,
 *         "showCoverPic": null,
 *         "thumbUrl": null,
 *        "needOpenComment": null,
 *         "onlyFansCanComment": null,
 *         "description": null
 *       },
 *       {
 *         "id": 7,
 *         "intermediary": null,
 *         "createTime": null,
 *         "updateTime": "2018-05-05 23:45:56",
 *         "wxPublicId": null,
 *         "mediaId": "f1QOuU_OT4Hrt8abnY9n2ERDzW2rCwiZzT7AWJzgtGc",
 *         "name": "sd1524405694_2呵呵.MP4",
 *         "type": "video",
 *         "url": null,
 *         "title": null,
 *         "author": null,
 *         "digest": null,
 *         "content": null,
 *         "contentSourceUrl": null,
 *         "thumbMediaId": null,
 *         "showCoverPic": null,
 *         "thumbUrl": null,
 *         "needOpenComment": null,
 *         "onlyFansCanComment": null,
 *         "description": null
 *       }
 *     ],
 *     "prePage": 0,
 *     "nextPage": 0,
 *     "isFirstPage": true,
 *     "isLastPage": true,
 *    "hasPreviousPage": false,
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
 * @api {get} /material/video/detail 获取单个视频素材内容
 * @apiName getMaterialVideoDetail
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiParam mediaId 素材mediaId
 * @apiParam name 素材文件名
 * @apiExample Request-Example:
 * localhost:8080/material/video/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.mp4
 */

/**
 * @api {get} /material/voice/detail 获取单个语音素材内容
 * @apiName getMaterialVoiceDetail
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiParam mediaId 素材mediaId
 *  * @apiParam name 素材文件名
 * @apiExample Request-Example:
 * localhost:8080/material/voice/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.mp3
 */

/**
 * @api {get} /material/news/detail 获取单个图文素材内容
 * @apiName getMaterialNewsDetail
 * @apiGroup wxMessage
 * @apiParam {String} wxPublicId 公众号ID
 * @apiParam {Number} materialId 素材Id
 * @apiExample Request-Example:
 * http://localhost:8080/material/news/detail?wxPublicId=14&materialId=59
 */

/**
 * @api {get} /material/news/detailByWxMediaId 获取单个图文素材内容
 * @apiName detailByWxMediaId
 * @apiGroup wxMessage
 * @apiParam {String} wxPublicId 公众号ID
 * @apiParam {String} materialId 素材Id
 * @apiExample Request-Example:
 * http://localhost:8080/material/news/detailByWxMediaId?wxPublicId=14&materialId=f1QOuU_OT4Hrt8abnY9n2JtuBkM5JTjri6XfVo3ftDY
 */

/**
 * @api {get} /material/image/detail 获取单个图片素材内容
 * @apiName getMaterialImageDetail
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiParam mediaId 素材mediaId
 * @apiParam name 素材文件名
 * @apiExample Request-Example:
 * localhost:8080/material/image/detail?mediaId=f1QOuU_OT4Hrt8abnY9n2Eurpum2VNfDPrakA2RIrVA&wxPublicId=14&name=test.jpg
 */

/**
 * @api {post} /menu 创建菜单
 * @apiName createMenu
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiParam json 菜单内容
 * @apiExample Request - Example:
 * localhost:8080/menu
 * @apiParamExample: Param - Example:
 * {
 * 	"button": [{
 * 		"type": "click",
 * 		"name": "今日歌曲",
 * 		"key": "V1001_TODAY_MUSIC"
 * 	}, {
 * 		"name": "菜单",
 * 		"sub_button": [{
 * 			"type": "view",
 * 			"name": "搜索",
 * 			"url": "http://www.soso.com/"
 * 		}, {
 * 			"type": "click",
 * 			"name": "赞一下我们",
 * 			"key": "V1001_GOOD"
 * 		}]
 * 	}]
 * }
 */

/**
 * @api {get} /menu 获取菜单
 * @apiName getMenu
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiExample Request - Example:
 * localhost:8080/menu?wxPublicId=14
 *  @apiSuccessExample {String} Response - Example:
 *{
 *  "menu": {
 *    "button": [
 *      {
 *        "type": "click",
 *        "name": "今日歌曲",
 *        "key": "V1001_TODAY_MUSIC",
 *        "sub_button": []
 *      },
 *      {
 *        "name": "菜单",
 *        "sub_button": [
 *          {
 *            "type": "view",
 *            "name": "搜索",
 *            "url": "http://www.soso.com/",
 *            "sub_button": []
 *          },
 *          {
 *            "type": "click",
 *            "name": "赞一下我们",
 *            "key": "V1001_GOOD",
 *            "sub_button": []
 *          }
 *        ]
 *      }
 *    ]
 *  }
 *}
 */

/**
 * @api {delete} /menu 删除菜单
 * @apiDescription 将删除所有自定义菜单
 * @apiName deleteMenu
 * @apiGroup wxMessage
 * @apiParam wxPublicId 公众号ID
 * @apiExample Request - Example:
 * localhost:8080/menu?wxPublicId=14
 */

/**
 * @api {get} /material/image/detail 素材图片查看
 * @apiDescription 直接使用素材链接不能正常显示，需要通过后台接口转一下
 * @apiName imageDetail
 * @apiGroup wxMessage
 * @apiParam url 素材url
 * @apiParam name 素材名称（xxx.jpg/xxx.png）
 * @apiExample Request - Example:
 * localhost:8080/material/image/detail?url=http://mmbiz.qpic.cn/mmbiz_jpg/FwRDKpzzTCMeic3kUEqYZiahRLxpa3WQ8YYpmKjmq9LiawOgb5lKGaT7FOG0ahPCMYibB6Cox3kztDQrvDsicACltSg/0?wx_fmt=jpeg&name=11.jpg
 */

/**
 * @api {get} /message/page 获取公从号消息(分页)
 * @apiName getWxPublicMsg
 * @apiGroup wxMessage
 * @apiParam {Number} wxPublicId 公众号ID
 * @apiParam {Number} page 当前页
 * @apiParam {Number} rows 一页显示的条数
 * @apiExample Request-Example:
 * localhost:8080/message/page?page=1&rows=10&wxPublicId=14
 */

/**
 * @api {get} /message/attachment 获取用户消息附件（用户发给公众号的图片、语音、视频是临时素材）
 * @apiName getMaterialTemp
 * @apiGroup wxMessage
 * @apiParam {String} msgType 消息类型image,voice,video
 * @apiParam {String} localFile 文件名
 * @apiExample Request-Example:
 * http://localhost:8080/message/attachment?msgType=voice&localFile=sdfjwefjj-23lfjk20.mp3
 */

public class WxDocumentation {
}
