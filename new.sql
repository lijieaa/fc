/*
SQLyog 
MySQL - 5.7.20-log : Database - fc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `device` */

CREATE TABLE `device` (
  `device_id` int(11) NOT NULL AUTO_INCREMENT,
  `operate_user_id` int(11) DEFAULT NULL COMMENT '操作员ID',
  `transcribe_user_id` int(11) DEFAULT NULL COMMENT '抄表员ID',
  `project_id` int(11) DEFAULT NULL COMMENT '项目ID',
  `intermediary_id` int(11) NOT NULL COMMENT '中间商ID',
  `device_production_num` varchar(20) NOT NULL COMMENT '生产编号',
  `deivce_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '设备状态：0在线，1不在线',
  `device_location_x` varchar(20) DEFAULT NULL COMMENT '设备X坐标',
  `device_location_y` varchar(20) DEFAULT NULL COMMENT '设备Y坐标',
  `device_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `device_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`device_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device` */

/*Table structure for table `device_log` */

CREATE TABLE `device_log` (
  `device_log_id` int(11) NOT NULL AUTO_INCREMENT,
  `device_production_num` varchar(20) NOT NULL COMMENT '设备生产编号',
  `operate_command` varchar(20) NOT NULL COMMENT '操作指令',
  `operate_command_desc` varchar(10) NOT NULL COMMENT '操作指令描述',
  `user_id` int(11) NOT NULL COMMENT '操作人',
  `device_log_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `device_log_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`device_log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `device_log` */

/*Table structure for table `intermediary` */

CREATE TABLE `intermediary` (
  `intermediary_id` int(11) NOT NULL AUTO_INCREMENT,
  `intermediary_name` varchar(64) NOT NULL COMMENT '中间商名称',
  `intermediary_contact` varchar(16) NOT NULL COMMENT '中间商联系人',
  `intermediary_contact_tel` varchar(16) NOT NULL COMMENT '中间商联系方式',
  `area_id` int(11) NOT NULL COMMENT '所属地区',
  `user_id` int(11) NOT NULL COMMENT '平台对接人',
  `intermediary_logo_url` varchar(256) NOT NULL COMMENT '平台LOGO',
  `intermediary_introduction` text NOT NULL COMMENT '图文简介',
  `intermediary_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `intermediary_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`intermediary_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `intermediary` */

/*Table structure for table `project` */

CREATE TABLE `project` (
  `project_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_name` varchar(50) NOT NULL COMMENT '项目名称',
  `area_id` int(11) NOT NULL COMMENT '所属区域',
  `project_contact_user_id` int(11) NOT NULL COMMENT '项目联系人',
  `project_create_user_id` int(11) NOT NULL COMMENT '线索创建人',
  `project_owner_contact` varchar(20) NOT NULL COMMENT '业主联系人',
  `project_owner_contact_tel` varchar(15) NOT NULL COMMENT '业主电话',
  `project_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '状态：0线索，1项目',
  `project_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `project_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`project_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project` */

/*Table structure for table `project_comments` */

CREATE TABLE `project_comments` (
  `project_comments_id` int(11) NOT NULL AUTO_INCREMENT,
  `project_comments_content` text NOT NULL COMMENT '评论内容',
  `project_comments_parent` int(11) NOT NULL DEFAULT '0' COMMENT '上级评论',
  `project_comments_nickname` varchar(50) NOT NULL COMMENT '评论人',
  `project_comments_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '评论类型：0内部评论，1外部评论',
  `project_comments_status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '评论状态：0线索，1项目',
  `project_id` int(11) NOT NULL COMMENT '项目ID',
  `project_comments_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `project_comments_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`project_comments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_comments` */

/*Table structure for table `sys_company` */

CREATE TABLE `sys_company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(40) NOT NULL COMMENT '公司名称',
  `company_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `company_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_company` */

insert  into `sys_company`(`company_id`,`company_name`,`company_create_time`,`company_update_time`) values (1,'成都飞创科技有限公司','2018-03-31 14:20:47','2018-03-31 14:20:47');
insert  into `sys_company`(`company_id`,`company_name`,`company_create_time`,`company_update_time`) values (2,'成都赚他一个科技有限公司','2018-03-31 14:21:10','2018-03-31 14:21:10');

/*Table structure for table `sys_dept` */

CREATE TABLE `sys_dept` (
  `dept_id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(20) NOT NULL COMMENT '部门名称',
  `dept_parent_id` int(11) NOT NULL COMMENT '上级部门ID',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `dept_sortd` int(11) DEFAULT NULL COMMENT '排序',
  `dept_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `dept_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`dept_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`dept_id`,`dept_name`,`dept_parent_id`,`company_id`,`dept_sortd`,`dept_create_time`,`dept_update_time`) values (1,'销售部',0,1,NULL,'2018-03-31 14:24:21','2018-03-31 14:24:21');
insert  into `sys_dept`(`dept_id`,`dept_name`,`dept_parent_id`,`company_id`,`dept_sortd`,`dept_create_time`,`dept_update_time`) values (2,'管理部',0,1,NULL,'2018-03-31 14:24:49','2018-03-31 14:24:49');
insert  into `sys_dept`(`dept_id`,`dept_name`,`dept_parent_id`,`company_id`,`dept_sortd`,`dept_create_time`,`dept_update_time`) values (3,'管理子部1',2,1,NULL,'2018-04-01 16:44:16','2018-04-01 16:44:16');
insert  into `sys_dept`(`dept_id`,`dept_name`,`dept_parent_id`,`company_id`,`dept_sortd`,`dept_create_time`,`dept_update_time`) values (4,'管理子部的子部1',3,1,NULL,'2018-04-01 16:44:42','2018-04-01 16:44:42');

/*Table structure for table `sys_menu` */

CREATE TABLE `sys_menu` (
  `menu_id` int(11) NOT NULL AUTO_INCREMENT,
  `menu_name` varchar(20) NOT NULL COMMENT '菜单名称',
  `menu_parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级菜单',
  `menu_url` varchar(64) DEFAULT NULL COMMENT 'url',
  `menu_prmission` varchar(64) DEFAULT NULL COMMENT '权限码',
  `menu_sortd` int(11) DEFAULT NULL COMMENT '排序',
  `menu_display` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示1:显示，0不显示',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (1,'设备管理',0,'/device/index',NULL,0,1,'fa fa-steam');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (2,'查看',1,'','device:list',100,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (3,'管理',1,'','device:create',200,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (4,'中间商管理',0,'/intermediary/index',NULL,300,1,'fa fa-street-view');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (5,'查看',4,'','intermediary:list',400,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (6,'管理',4,'','intermediary:create',500,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (7,'项目管理',0,'/project/index','',600,1,'fa fa-th-list');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (8,'查看',7,'','project:list',700,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (9,'管理',7,'','project:create',800,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (10,'添加设备',7,'','project:device:add',900,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (11,'微信公众号管理',0,'/wechat/index','',1000,1,'fa fa-wechat');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (12,'基本设置',11,'','wechat:basic',1100,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (13,'自定义菜单',11,'','wechat:menu',1200,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (14,'用户管理',11,'','wechat:user',1300,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (15,'消息管理',11,'','wechat:message',1400,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (16,'系统设置',0,'',NULL,1500,1,'fa fa-gear ');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (17,'组织管理',16,'/company/index','company:index',1600,1,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (18,'编辑公司名称',17,'','company:editname',1700,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (19,'部门[添加/删除/修改]',17,'','company:deptmanage',1800,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (20,'成员[添加/删除/修改]',17,'','company:personmanage',1900,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (21,'角色管理',16,'/role/index','role:index',2000,1,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (22,'角色组[添加/删除/修改]',21,NULL,'role:groupmanage',2100,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (23,'角色[添加/删除/修改]',21,NULL,'role:manage',2200,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (24,'角色成员[添加/移除]',21,NULL,'role:personmanage',2300,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (25,'人员管理',16,'/user/index','person:index',2400,1,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (26,'人员[添加/删除/修改]',25,NULL,'person:manage',2500,0,NULL);
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (27,'数据备份',16,'/backup/index','backup',2600,1,'fa fa-database');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (28,'数据统计',0,'/statistics/index','statistics',2700,1,'fa fa-bar-chart');
insert  into `sys_menu`(`menu_id`,`menu_name`,`menu_parent_id`,`menu_url`,`menu_prmission`,`menu_sortd`,`menu_display`,`icon`) values (30,'线索管理',0,'/clues/index','clues',2800,1,'fa fa-stumbleupon');

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(20) NOT NULL COMMENT '角色代码',
  `role_description` varchar(50) NOT NULL COMMENT '角色名称',
  `role_group_id` int(11) NOT NULL COMMENT '所属角色组',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `role_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `role_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`role_id`,`role_name`,`role_description`,`role_group_id`,`company_id`,`role_update_time`,`role_create_time`) values (1,'ADMIN','系统管理员',1,1,'2018-03-31 14:23:35','2018-03-31 14:23:35');

/*Table structure for table `sys_role_group` */

CREATE TABLE `sys_role_group` (
  `role_group_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_group_name` varchar(20) NOT NULL COMMENT '组名称',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `role_group_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `role_group_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`role_group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_group` */

insert  into `sys_role_group`(`role_group_id`,`role_group_name`,`company_id`,`role_group_create_time`,`role_group_update_time`) values (1,'管理层',1,'2018-03-31 14:21:25','2018-03-31 14:21:25');
insert  into `sys_role_group`(`role_group_id`,`role_group_name`,`company_id`,`role_group_create_time`,`role_group_update_time`) values (2,'销售层',1,'2018-03-31 14:21:34','2018-03-31 14:21:34');
insert  into `sys_role_group`(`role_group_id`,`role_group_name`,`company_id`,`role_group_create_time`,`role_group_update_time`) values (3,'其它',1,'2018-03-31 14:21:57','2018-03-31 14:21:57');
insert  into `sys_role_group`(`role_group_id`,`role_group_name`,`company_id`,`role_group_create_time`,`role_group_update_time`) values (4,'管理层',2,'2018-03-31 14:22:06','2018-03-31 14:22:06');
insert  into `sys_role_group`(`role_group_id`,`role_group_name`,`company_id`,`role_group_create_time`,`role_group_update_time`) values (5,'销售层',2,'2018-03-31 14:22:13','2018-03-31 14:22:13');

/*Table structure for table `sys_role_menu` */

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '登录名',
  `password` varchar(128) NOT NULL COMMENT '登录密码',
  `is_admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否管理员0：否，1：是',
  `is_platform_admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是平台管理员0否，1是',
  `user_real_name` varchar(20) NOT NULL COMMENT '真实姓名',
  `company_id` int(11) NOT NULL COMMENT '公司ID',
  `dept_id` int(11) NOT NULL COMMENT '所属部门',
  `user_telephone` varchar(11) NOT NULL COMMENT '联系电话',
  `user_position` varchar(20) DEFAULT NULL COMMENT '职位',
  `user_job_number` varchar(10) DEFAULT NULL COMMENT '工号',
  `user_email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `user_work_address` varchar(50) DEFAULT NULL COMMENT '办公地点',
  `user_entry_time` datetime DEFAULT NULL COMMENT '入职时间',
  `user_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `user_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`user_id`,`username`,`password`,`is_admin`,`is_platform_admin`,`user_real_name`,`company_id`,`dept_id`,`user_telephone`,`user_position`,`user_job_number`,`user_email`,`user_work_address`,`user_entry_time`,`user_create_time`,`user_update_time`) values (1,'zdc','$2a$10$ICPn3Ar/NmzQFSJjBRbSZe5r.F/y9UZfe8fwUAknUD2Bc8e31Bjpm',1,1,'zdc',1,1,'1592517460',NULL,NULL,NULL,NULL,NULL,'2018-03-27 23:10:35','2018-03-31 22:16:02');

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

/*Table structure for table `topic` */

CREATE TABLE `topic` (
  `topic_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '跟进人',
  `topic_content` text NOT NULL COMMENT '跟进内容',
  `intermediary_id` int(11) NOT NULL COMMENT '中间商ID',
  `topic_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `topic_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`topic_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `topic` */

/*Table structure for table `topic_comments` */

CREATE TABLE `topic_comments` (
  `topic_comments_id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_comments_content` text NOT NULL COMMENT '评论内容',
  `user_id` int(11) NOT NULL COMMENT '评论人',
  `topic_comments_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `topic_comments_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`topic_comments_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `topic_comments` */

/*Table structure for table `wx_message` */

CREATE TABLE `wx_message` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `from_user` varchar(32) NOT NULL COMMENT '发送者open_id',
  `create_time` int(11) NOT NULL COMMENT '消息发送时间（整型）',
  `msg_type` varchar(10) NOT NULL COMMENT '消息类型',
  `content` varchar(16384) DEFAULT NULL COMMENT '消息内容(文本)',
  `pic_url` varchar(256) DEFAULT NULL COMMENT '图片地址',
  `media_id` varchar(128) DEFAULT NULL COMMENT '消息媒体ID',
  `format_` varchar(10) DEFAULT NULL COMMENT '语音格式(amr,speex等)',
  `thumbMedia_id` varchar(128) DEFAULT NULL COMMENT '视频缩略图媒体ID',
  `location_x` varchar(20) DEFAULT NULL COMMENT '地理位置X',
  `location_y` varchar(20) DEFAULT NULL COMMENT '地理位置Y',
  `scale` int(11) DEFAULT NULL COMMENT '地图缩放大小',
  `label` varchar(256) DEFAULT NULL COMMENT '地理位置信息',
  `title` varchar(128) DEFAULT NULL COMMENT '消息标题',
  `description` varchar(128) DEFAULT NULL COMMENT '消息描述',
  `url` varchar(256) DEFAULT NULL COMMENT '消息链接',
  `msg_id` bigint(64) DEFAULT NULL COMMENT '消息ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_message` */

/*Table structure for table `wx_token` */

CREATE TABLE `wx_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `app_id` varchar(32) NOT NULL COMMENT 'app_id',
  `app_secret` varchar(32) NOT NULL COMMENT 'app_secret',
  `access_token` varchar(512) NOT NULL COMMENT 'access_token',
  `account` varchar(128) NOT NULL COMMENT '微信号',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `wx_token_create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `wx_token_update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `wx_token` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
