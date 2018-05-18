package com.we.fc.project.doc;

/**
 * Created by mayn on 2018/5/16.
 */


/**
 * @apiDefine project 线索、项目
 */


/**
 * @api {get} localhost:8080/project 项目线索各字段验证条件
 * @apiName exist
 * @apiGroup project
 * @apiParam {String} projectName 线索或项目名称不能为空\线索或项目名称在1
 * @apiParam {String} area 地区不能为空
 * @apiParam {String} projectContactUser 负责人不能为空
 * @apiParam {String} projectOwnerContact 业主联系人不能为空
 * @apiParam {String} projectOwnerContactTel 电话号码不能为空\请输入正确电话号码
 * @apiParam {String} projectLogo logo不能为空
 * @apiParam {String} projectStatus 状态不能为空
 * @apiParam {String} projectTopicStatus 线索处理状态不能为空
 */


/**
 * @api {get} localhost:8080/project/byIdStatus 查询线索、项目详情
 * @apiName projectDetail
 * @apiGroup project
 * @apiParam {number} id 主键
 * @apiParam {number} statusId 线索、项目区分字段（0线索，1项目）
 * @apiParamExample {json} Param-Example:
 *{
 *"id": 1,                                       主键
 *"intermediary": null,
 *"createTime": "2018-04-24 22:09:31",
 *"updateTime": "2018-05-16 22:18:54",
 *"wxPublicId": null,
 *"projectName": "项目1",                         项目名称
 *"area": {                                         地区
 *"id": 110100,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"isParent": false,
 *"parentId": null,
 *"name": "北京市",                                    地区名称
 *"shortName": null,
 *"longitude": null,
 *"latitude": null,
 *"level": null,
 *"sort": null,
 *"status": null
 *},
 *"projectContactUser": {                              项目联系人
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",                                        项目联系人名称
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
 *"accountNonExpired": true,
 *"credentialsNonExpired": true,
 *"accountNonLocked": true,
 *"password": null
 *},
 *"projectCreateUser": {                                项目创建人
 *"id": 1,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"name": "欧群飞",                                    项目创建人名称
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
 *"accountNonExpired": true,
 *"credentialsNonExpired": true,
 *"accountNonLocked": true,
 *"password": null
 *},
 *"projectOwnerContact": "1",                    业主名
 *"projectOwnerContactTel": "1",                  业主联系电话
 *"projectLogo": "",                                logo
 *"projectStatus": 1,                               项目线索区分字段（0线索，1项目）
 *"projectTopicStatus": 1                           线索状态（0已处理，1正在处理）
 *}
 */

/**
 * @api {post} localhost:8080/project 添加线索、项目
 * @apiName addProject
 * @apiGroup project
 * @apiParam {String} json json对象字符串
 * @apiExample Request-Example:
 *{
 *	"projectName":"下项目12321",
 *	"area":{"id":10010},
 *	"projectContactUser":{"id":1},
 *	"projectOwnerContact":"联系人11",
 *	"projectOwnerContactTel":"13548656547",
 *	"projectLogo":"3214dsd",
 *	"projectStatus":0,
 *	"projectTopicStatus":1
 *}
 *
 * @apiParamExample {json} Param-Example:
 *{
"status": "200",
"messages": "操作成功！",
"list": null,
"data": null
}
 */

/**
 * @api {put} localhost:8080/device 编辑项目、线索
 * @apiName updateProject
 * @apiGroup project
 * @apiParam {String} json json对象字符串
 * @apiExample Request-Example:
 * {
 *"id":3,
 *"projectName":"下项目12321211",
 *"area":{"id":110100},
 *"projectContactUser":{"id":1},
 *"projectOwnerContact":"联系人11",
 *"projectOwnerContactTel":"13548656547",
 *"projectLogo":"3214dsd",
 *"projectStatus":0,
 *"projectTopicStatus":1
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
 * @api {delete} localhost:8080/project/3 删除项目、线索
 * @apiName deleteProject
 * @apiGroup project
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
 * @api {get} localhost:8080/project/page 项目、线索分页查询
 * @apiName queryPageProject
 * @apiGroup project
 * @apiParam {Number} page 页数
 * @apiParam {Number} rows 条数
 * @apiParam {Number} projectStatus 线索项目区分字段（0线索，1项目）
 * @apiParam {String} projectName 线索项目名称
 * @apiParam {Object} projectContactUser 项目负责人
 * @apiParam {Number} name 项目负责人id
 * @apiParam {String} projectOwnerContact 业主名
 * @apiParam {String} projectOwnerContactTel 业主联系电话
 * @apiExample Request-Example:
 * localhost:8080/project/page?page=1&rows=10&projectStatus=1&projectName=项目&projectContactUser.id=1&projectOwnerContact=1&projectOwnerContactTel=1
 * @apiParamExample {json} Param-Example:
 *{
 *"status": "200",
 *"messages": "操作成功！",
 *"list": null,
 *"data": {
 *"pageNum": 1,
 *"pageSize": 10,
 *"size": 2,
 *"startRow": 1,
 *"endRow": 2,
 *"total": 2,
 *"pages": 1,
 *"list": [
 *{
 *"id": 1,
 *"intermediary": null,
 *"createTime": "2018-04-24 22:09:31",
 *"updateTime": "2018-05-16 22:18:54",
 *"wxPublicId": null,
 *"projectName": "项目1",
 *"area": {
 *"id": 110100,
 *"intermediary": null,
 *"createTime": null,
 *"updateTime": null,
 *"wxPublicId": null,
 *"isParent": false,
 *"parentId": null,
 *"name": "北京市",
 *"shortName": null,
 *"longitude": null,
 *"latitude": null,
 *"level": null,
 *"sort": null,
 *"status": null
 *},
 *"projectContactUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true
 *},
 *"projectCreateUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true
 *},
 *"projectOwnerContact": "1",
 *"projectOwnerContactTel": "1",
 *"projectLogo": "",
 *"projectStatus": 1,
 *"projectTopicStatus": 1
 *},
 *{
 *"id": 4,
 *"intermediary": null,
 *"createTime": "2018-05-16 23:01:39",
 *"updateTime": "2018-05-16 23:21:56",
 *"wxPublicId": null,
 *"projectName": "下项目12321",
 *"area": null,
 *"projectContactUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true
 *},
 *"projectCreateUser": {
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
 *"accountNonExpired": true,
 *"accountNonLocked": true,
 *"credentialsNonExpired": true
 *},
 *"projectOwnerContact": "联系人11",
 *"projectOwnerContactTel": "13548656547",
 *"projectLogo": "3214dsd",
 *"projectStatus": 1,
 *"projectTopicStatus": 1
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
 */



public class ProjectDoc {
}
