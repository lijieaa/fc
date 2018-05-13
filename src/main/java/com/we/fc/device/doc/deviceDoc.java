package com.we.fc.device.doc;

/**
 * Created by mayn on 2018/5/6.
 */
/**
 * @apiDefine device 设备管理
 */

/**
 * @api {get} localhost:8080/device/2 设备详情
 * @apiName detail
 * @apiGroup device
 * @apiParam {number} id 链接后直接加设备id值
 * @apiParamExample {json} Param-Example:
 * {
 * "id": 2,                                           设备id
 * "intermediary": {                                  中间商对象
 *   "id": 1,                                         中间商id
 *   "intermediary": null,
 *   "createTime": null,
 *   "updateTime": null,
 *   "wxPublicId": null,
 *   "isPlat": 0,
 *   "intermediaryName": null,                        中间商名称
 *   "intermediaryContact": null,
 *   "intermediaryContactTel": null,
 *   "area": null,
 *   "user": null,
 *   "intermediaryLogoUrl": null,
 *   "intermediaryIntroduction": null
 * },
 * "createTime": "2018-04-24 21:52:11",
 * "updateTime": "2018-04-24 22:10:45",
 *   "wxPublicId": null,
 * "operateUser": {                                    操作员对象
 *   "id": 1,                                           操作员id
 *   "intermediary": null,
 *   "createTime": null,
 *   "updateTime": null,
 *   "wxPublicId": null,
 *   "name": "欧群飞",                                  操作员名称
 *   "position": null,
 *   "mobile": null,
 *   "tel": null,
 *   "pwd": null,
 *   "workplace": null,
 *   "remark": null,
 *   "email": null,
 *   "orgemail": null,
 *   "jobnumber": null,
 *   "ishide": null,
 *   "issenior": null,ToUserName":"o2IG5wpS7Ju6FPg6LW1OIuxKUgI0",
 *     "intermediaryId": null,
 *   "extattr": null,
 *   "menus": null,
 *   "enabled": true,
 *   "accountNonExpired": true,
 *   "accountNonLocked": true,
 *   "credentialsNonExpired": true,
 *   "password": null,
 *   "username": null
 * },
 * "transcribeUser": {                             抄表员对象
 *   "id": 1,                                       抄表员id
 *   "intermediary": null,
 *   "createTime": null,
 *   "updateTime": null,
 *   "wxPublicId": null,
 *   "name": "欧群飞",                              抄表员名称
 *   "position": null,
 *   "mobile": null,MsgType":"text",
 *     "tel": null,
 *   "pwd": null,
 *   "workplace": null,
 *   "remark": null,
 *   "email": null,
 *   "orgemail": null,
 *   "jobnumber": null,
 *   "ishide": null,
 *   "issenior": null,
 *   "intermediaryId": null,
 *   "extattr": null,
 *   "menus": null,
 *   "enabled": true,
 *   "accountNonExpired": true,
 *   "accountNonLocked": true,
 *   "credentialsNonExpired": true,
 *   "password": null,
 *   "username": null
 * },Content":"hello world"
 *   "project": {                               项目对象
 *   "id": 2,                                    项目id
 *   "intermediary": null,
 *   "createTime": null,
 *   "updateTime": null,
 *   "wxPublicId": null,
 *   "projectName": null,                        项目名称
 *   "areaId": null,
 *   "projectContactUserId": null,
 *   "projectCreateUserId": null,
 *   "projectOwnerContact": null,
 *   "projectOwnerContactTel": null,
 *   "projectStatus": null
 * },
 * "deviceProductionNum": "00012",                     生产编号
 * "deviceStatus": 1,                                  设备状态：0在线，1不在线
 * "deviceLocationX": "31",                            设备X坐标
 * "deviceLocationY": "33",                             设备Y坐标
 * "device_type":"FGGD-1"                               设备型号
 *}
 */

/**
 * @api {post} localhost:8080/device 添加设备
 * @apiName addDevice
 * @apiGroup device
 * @apiParam {String} json json对象字符串
 * @apiExample Request-Example:
 * {
 *"operateUser":{"id":1},
 *"transcribeUser":{"id":"2"},
 *"project":{"id":3},
 *"intermediary":{"id":1},
 *"deviceProductionNum":"00012",
 *"deivceStatus":1,
 *"deviceLocationX":"31",
 *"deviceLocationY":"33"
 *}
 * @apiParamExample {json} Param-Example:
 *{
"status": "200",
"messages": "操作成功！",
"list": null,
"data": null
}
 */

/**
 * @api {put} localhost:8080/device 编辑设备
 * @apiName updateDevice
 * @apiGroup device
 * @apiParam {String} json json对象字符串
 * @apiExample Request-Example:
 * {
 *"id":1,
 *"operateUser":{"id":1},
 *"transcribeUser":{"id":"1"},
 *"project":{"id":1},
 *"intermediary":{"id":1},
 *"deviceProductionNum":"00011",
 *"deviceStatus":1,
 *"deviceLocationX":"31",
 *"deviceLocationY":"33"
 *}
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": null
 *}
 */

/**
 * @api {delete} localhost:8080/device/1 删除设备
 * @apiName deleteDevice
 * @apiGroup device
 * @apiParam {Number} id 链接后直接加设备id值
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": null
 *}
 */

/**
 * @api {get} localhost:8080/device/page 设备分页查询
 * @apiName queryPageDevice
 * @apiGroup device
 * @apiParam {Number} page 页数
 * @apiParam {Number} rows 条数
 * @apiParam {Number} deviceProductionNum 生产编号
 * @apiParam {Object} project
 * @apiParam {String} project.projectName 项目名称
 * @apiParam {Object} operateUser
 * @apiParam {String} operateUser.name 操作员名称
 * @apiParam {Object} transcribeUser
 * @apiParam {String} transcribeUser.name 抄表员名称
 * @apiExample Request-Example:
 * localhost:8080/device/page?page=1&rows=1&deviceProductionNum=1&project.projectName=1&operateUser.name=z&transcribeUser.name=z
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": {
 *"pageNum": 1,
 *"pageSize": 1,
 *"size": 1,
 *"startRow": 1,
 *"endRow": 1,
 *"total": 4,
 *"pages": 4,
 *"list": [
 *{
 *"id": 2,
 *"intermediary": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"isPlat": 0,
 *"intermediaryName": null,
 *"intermediaryContact": null,
 *"intermediaryContactTel": null,
 *"area": null,
 *"user": null,
 *"intermediaryLogoUrl": null,
 *"intermediaryIntroduction": null
 *},
 *"createTime": "2018-04-24 21:52:11",
 *"updateTime": "2018-04-24 22:10:45",
 *"wxPublicId": null,
 *"operateUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"transcribeUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"project": {
 *"id": 2,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"projectName": null,
 *"areaId": null,
 *"projectContactUserId": null,
 *"projectCreateUserId": null,
 *"projectOwnerContact": null,
 *"projectOwnerContactTel": null,
 *"projectStatus": null
 *},
 *"deviceProductionNum": "00012",
 *"deivceStatus": 1,
 *"deviceLocationX": "31",
 *"deviceLocationY": "33"
 *}
 *],
 *"prePage": 0,
 *"nextPage": 2,
 *"isFirstPage": true,
 *"isLastPage": false,
 *"hasPreviousPage": false,
 *"hasNextPage": true,
 *"navigatePages": 8,
 *"navigatepageNums": [
 *1,
 *2,
 *3,
 *4
 *],
 *"navigateFirstPage": 1,
 *"navigateLastPage": 4,
 *"lastPage": 4,
 *"firstPage": 1
 *}
 *}
 */

/**
 * @api {get} localhost:8080/device/byProjectId 项目下设备
 * @apiName projectDevice
 * @apiGroup device
 * @apiParam {number} projectId 项目id
 * @apiExample Request-Example:
 * localhost:8080/device/byProjectId?projectId=2
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": [
 *{
 *"id": 2,
 *"intermediary": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"isPlat": 0,
 *"intermediaryName": null,
 *"intermediaryContact": null,
 *"intermediaryContactTel": null,
 *"area": null,
 *"user": null,
 *"intermediaryLogoUrl": null,
 *"intermediaryIntroduction": null
 *},
 *"createTime": "2018-04-24 21:52:11",
 *"updateTime": "2018-04-24 22:10:45",
 *"wxPublicId": null,
 *"operateUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"transcribeUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"project": {
 *"id": 2,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"projectName": null,
 *"areaId": null,
 *"projectContactUserId": null,
 *"projectCreateUserId": null,
 *"projectOwnerContact": null,
 *"projectOwnerContactTel": null,
 *"projectStatus": null
 *},
 *"deviceProductionNum": "00012",
 *"deivceStatus": 1,
 *"deviceLocationX": "31",
 *"deviceLocationY": "33"
 *},
 *{
 *"id": 3,
 *"intermediary": {
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"isPlat": 0,
 *"intermediaryName": null,
 *"intermediaryContact": null,
 *"intermediaryContactTel": null,
 *"area": null,
 *"user": null,
 *"intermediaryLogoUrl": null,
 *"intermediaryIntroduction": null
 *},
 *"createTime": "2018-04-24 21:52:25",
 *"updateTime": "2018-04-24 22:10:46",
 *"wxPublicId": null,
 *"operateUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"transcribeUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true,
 *"password": null,
 *"username": null
 *},
 *"project": {
 *"id": 2,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"projectName": null,
 *"areaId": null,
 *"projectContactUserId": null,
 *"projectCreateUserId": null,
 *"projectOwnerContact": null,
 *"projectOwnerContactTel": null,
 *"projectStatus": null
 *},
 *"deviceProductionNum": "000123",
 *"deivceStatus": 1,
 *"deviceLocationX": "31",
 *"deviceLocationY": "33"
 *}
 *],
 *"data": null
 *}
 */

/**
 * @api {post} localhost:8080/device/exist 设备生产编号重复验证
 * @apiName deviceExist
 * @apiGroup device
 * @apiParam {String} name 需要验证的字段名（device_production_num）
 * @apiParam {String} value 内容
 * @apiExample Request-Example:
 * localhost:8080/device/exist?name=device_production_num&value=00012
 * @apiParamExample {json} Param-Example:
 * {
 * "status": "500",
 * "messages": "参数被占用",
 * "list": null,
 * "data": null
 * }
 *
 * {
 *"status": "200",
 *"messages": "参数未被占用",
 *"list": null,
 *"data": null
}
 */

/**
 * @api {get} localhost:8080/intermediary 设备各字段验证条件
 * @apiName exist
 * @apiGroup device
 * @apiParam {String} intermediary 中间商不能为空
 * @apiParam {String} deviceProductionNum 生成编号不能为空\生成编号在1-20个字符
 * @apiParam {String} deviceStatus 设备状态不能为空
 * @apiParam {String} deviceLocationX x坐标在1-20个字符
 * @apiParam {String} deviceLocationY y坐标在1-20个字符
 */





public class deviceDoc {
}
