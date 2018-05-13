package com.we.fc.deviceLog.devicelogDoc;

/**
 * Created by mayn on 2018/5/6.
 */

/**
 * @apiDefine deviceLog 设备日志
 */

/**
 * @api {post} localhost:8080/deviceLog 设备日志新增
 * @apiName addDeviceLog
 * @apiGroup deviceLog
 * @apiParam {String} json {
 *"deviceProductionNum":"3",
 *"operateCommand":"3",
 *"operateCommandDesc":"3",
 *"user":{"id":1}
 *}
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": null
 *}
 *
 */

/**
 * @api {put} localhost:8080/deviceLog 设备日志编辑
 * @apiName updateDeviceLog
 * @apiGroup deviceLog
 * @apiParam {String} json {
 *"id":1,
 *"deviceProductionNum":"3",
 *"operateCommand":"3",
 *"operateCommandDesc":"3",
 *"user":{"id":1}
 *}
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": null
 *}
 *
 */

/**
 * @api {delete} localhost:8080/deviceLog/1 设备日志删除
 * @apiName deleteDeviceLog
 * @apiGroup deviceLog
 * @apiParam {number} id 链接后直接加设备日志id值
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": null
 *}
 *
 */

/**
 * @api {get} localhost:8080/deviceLog/2 设备日志详情
 * @apiName deviceLogDetail
 * @apiGroup deviceLog
 * @apiParam {number} id 链接后直接加设备id值
 * @apiParamExample {json} Param-Example:
 *{
 *"id": 2,                                              设备日志id
 *"intermediary": null,
 *"createTime": "2018-04-25 22:26:01",
 *"updateTime": "2018-04-25 22:26:01",
 *"wxPublicId": null,
 *"deviceProductionNum": "2",                           设备生产编号
 *"operateCommand": "2",                                操作指令
 *"operateCommandDesc": "2",                            操作指令描述
 *"user": {                                             操作人对象
 *"id": 1,                                              操作人id
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",1                                     操作人名称
 *"position": null,
 *"mobile": null,
 *"tel": null,
 *"pwd": null,
 *"workplace": null,
 *"remark": null,
 *"email": null,
 *"orgemail": null,
 *"jobnumber": null,
 *"ishide": null,
 *"issenior": null,
 *"intermediaryId": null,
 *"extattr": null,
 *"menus": null,
 *"enabled": true,
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *}
 *}
 *
 */

/**
 * @api {get} localhost:8080/deviceLog/page 设备日志分页查询
 * @apiName queryPageDeviceLog
 * @apiGroup deviceLog
 * @apiParam {Number} page 页数
 * @apiParam {Number} rows 条数
 * @apiParam {Number} createTimeStr 发生日期
 * @apiExample Request-Example:
 * localhost:8080/deviceLog/page?page=1&rows=10&createTimeStr=2018-04-25
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": {
 *"pageNum": 1,
 *"pageSize": 10,
 *"size": 3,
 *"startRow": 1,
 *"endRow": 3,
 *"total": 3,
 *"pages": 1,
 *"list": [
 *{
 *"id": 2,
 *"intermediary": null,
 *"createTime": "2018-04-25 22:26:01",
 *"updateTime": "2018-04-25 22:26:01",
 *"wxPublicId": null,
 *"deviceProductionNum": "2",
 *"operateCommand": "2",
 *"operateCommandDesc": "2",
 *"user": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",
 *"position": null,
 *"mobile": null,
 *"tel": null,
 *"pwd": null,
 *"workplace": null,
 *"remark": null,
 *"email": null,
 *"orgemail": null,
 *"jobnumber": null,
 *"ishide": null,
 *"issenior": null,
 *"intermediaryId": null,
 *"extattr": null,
 *"menus": null,
 *"enabled": true,
 *"username": null,
 *"password": null,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"accountNonExpired": true
 *},
 *"createTimeStr": null
 *},
 *{
 *"id": 3,
 *"intermediary": null,
 *"createTime": "2018-04-25 22:40:20",
 *"updateTime": "2018-04-25 22:40:20",
 *"wxPublicId": null,
 *"deviceProductionNum": "3",
 *"operateCommand": "3",
 *"operateCommandDesc": "3",
 *"user": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",
 *"position": null,
 *"mobile": null,
 *"tel": null,
 *"pwd": null,
 *"workplace": null,
 *"remark": null,
 *"email": null,
 *"orgemail": null,
 *"jobnumber": null,
 *"ishide": null,
 *"issenior": null,
 *"intermediaryId": null,
 *"extattr": null,
 *"menus": null,
 *"enabled": true,
 *"username": null,
 *"password": null,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"accountNonExpired": true
 *},
 *"createTimeStr": null
 *},
 *{
 *"id": 4,
 *"intermediary": null,
 *"createTime": "2018-04-25 22:40:26",
 *"updateTime": "2018-04-25 22:40:26",
 *"wxPublicId": null,
 *"deviceProductionNum": "3",
 *"operateCommand": "3",
 *"operateCommandDesc": "3",
 *"user": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",
 *"position": null,
 *"mobile": null,
 *"tel": null,
 *"pwd": null,
 *"workplace": null,
 *"remark": null,
 *"email": null,
 *"orgemail": null,
 *"jobnumber": null,
 *"ishide": null,
 *"issenior": null,
 *"intermediaryId": null,
 *"extattr": null,
 *"menus": null,
 *"enabled": true,
 *"username": null,
 *"password": null,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"accountNonExpired": true
 *},
 *"createTimeStr": null
 *}
 *],
 *"prePage": 0,
 *"nextPage": 0,
 *"isFirstPage": true,
 *"isLastPage": true,
 *"hasPreviousPage": false,
 *"hasNextPage": false,
 *"navigatePages": 8,
 *"navigatepageNums": [
 *1
 *],
 *"navigateFirstPage": 1,
 *"navigateLastPage": 1,
 *"lastPage": 1,
 *"firstPage": 1
 *}
 *}
 *
 */


/**
 * @api {get} localhost:8080/deviceLog 设备日志各字段验证条件
 * @apiName deviceLogExist
 * @apiGroup deviceLog
 * @apiParam {String} deviceProductionNum 设备生产编号不能为空\生成编号在1-20个字符
 * @apiParam {String} operateCommand 操作指令不能为空\操作指令在1-20个字符
 * @apiParam {String} operateCommandDesc 操作指令描述不能为空\操作指令描述在1-20个字符
 * @apiParam {String} user 操作人不能为空
 */

public class DeviceLogDoc {
}
