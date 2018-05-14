package com.we.fc.intermediary.apidoc;

/**
 * @apiDefine intermediary 中间商
 */

/**
 * @api {post} localhost:8080/intermediary/exist 中间商名称验证
 * @apiName exist
 * @apiGroup intermediary
 * @apiParam {String} name 需要验证的字段名（intermediary_name）
 * @apiParam {String} value 内容
 * @apiExample Request-Example:
 * localhost:8080/intermediary/exist?name=intermediary_name&value=中间商4
 * @apiParamExample {json} Param-Example:
 * {
 * "status": "500",
 * "messages": "参数被占用",
 * "list": null,
 * "data": null
 * }
 */

/**
 * @api {get} localhost:8080/intermediary/idNameList 中间商id，name list列表
 * @apiName idNameList
 * @apiGroup intermediary
 */

/**
 * @api {get} localhost:8080/intermediary 中间商各字段验证条件
 * @apiName intermediaryExist
 * @apiGroup intermediary
 * @apiParam {String} isPlat 中间商所属不能为空
 * @apiParam {String} intermediaryName 名称不能为空\名称字数在1-64之间
 * @apiParam {String} intermediaryContact 联系人不能为空\联系人字数在1-16之间
 * @apiParam {String} intermediaryContactTel 中间商联系方式不能为空\电话号码格式验证
 * @apiParam {String} area 所属地区不能为空
 * @apiParam {String} user 平台对接人不能为空
 * @apiParam {String} intermediaryLogoUrl logo不能为空\logo在1-256之间
 * @apiParam {String} intermediaryIntroduction 图文简介不能为空
 */


/**
 * @api {get} 各字段验证条件 中间商跟进各字段验证条件
 * @apiName topicExist
 * @apiGroup intermediary
 * @apiParam {String} all 全部非空验证
 */


/**
 * @api {get} 各字段验证条件 中间商跟进评论各字段验证条件
 * @apiName topicComments
 * @apiGroup intermediary
 * @apiParam {String} all 全部非空验证
 */

public class ApiDoc {
}
