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

public class WxDocumentation {
}
