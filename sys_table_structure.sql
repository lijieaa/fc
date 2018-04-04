/*
SQLyog 
MySQL - 5.7.21 : Database - fc
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
/*Table structure for table `sys_company` */

CREATE TABLE `sys_company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(40) NOT NULL COMMENT '公司名称',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_company` */

insert  into `sys_company`(`id`,`name`,`create_time`,`update_time`) values (1,'成都飞创科技有限公司','2018-03-31 14:20:47','2018-03-31 14:20:47');
insert  into `sys_company`(`id`,`name`,`create_time`,`update_time`) values (2,'成都赚他一个科技有限公司','2018-03-31 14:21:10','2018-03-31 14:21:10');

/*Table structure for table `sys_dept` */

CREATE TABLE `sys_dept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '部门名称',
  `parent_id` int(11) NOT NULL COMMENT '上级部门ID',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `sortd` int(11) DEFAULT NULL COMMENT '排序',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `sys_dept` */

insert  into `sys_dept`(`id`,`name`,`parent_id`,`company_id`,`sortd`,`create_time`,`update_time`) values (1,'销售部',0,1,NULL,'2018-03-31 14:24:21','2018-03-31 14:24:21');
insert  into `sys_dept`(`id`,`name`,`parent_id`,`company_id`,`sortd`,`create_time`,`update_time`) values (2,'管理部',0,1,NULL,'2018-03-31 14:24:49','2018-03-31 14:24:49');

/*Table structure for table `sys_menu` */

CREATE TABLE `sys_menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '菜单名称',
  `parent_id` int(11) NOT NULL DEFAULT '0' COMMENT '父级菜单',
  `url` varchar(64) DEFAULT NULL COMMENT 'url',
  `prmission` varchar(64) DEFAULT NULL COMMENT '权限码',
  `sortd` int(11) DEFAULT NULL COMMENT '排序',
  `display` tinyint(4) NOT NULL DEFAULT '1' COMMENT '是否显示1:显示，0不显示',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `sys_menu` */

insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (1,'设备管理',0,NULL,NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (2,'设备列表',1,'/device/list','device:list',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (3,'新建设备',1,'/device/create','device:create',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (4,'中间商管理',0,'',NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (5,'中间商列表',4,'/intermediary/list','intermediary:list',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (6,'新建中间商',4,'/intermediary/create','intermediary:create',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (7,'项目管理',0,NULL,NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (8,'项目列表',7,'/project/list','project:list',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (9,'新建项目',8,'/project/create','project:create',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (10,'添加设备',7,'/project/device/add','project:device:add',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (11,'微信公众号管理',0,NULL,NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (12,'基本设置',11,'/wechat/basic','wechat:basic',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (13,'菜单管理',11,'/wechat/menu','wechat:menu',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (14,'订阅管理',11,'/wechat/subscribe','wechat:subscribe',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (15,'消息管理',11,'/wechat/message','wechat:message',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (16,'系统设置',0,NULL,NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (17,'组织管理',16,'/company/index','company:index',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (18,'编辑公司名称',17,'','company:editname',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (19,'部门[添加/删除/修改]',17,'','company:deptmanage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (20,'成员[添加/删除/修改]',17,'','company:personmanage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (21,'角色管理',0,'/role/index','role:index',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (22,'角色组[添加/删除/修改]',21,NULL,'role:groupmanage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (23,'角色[添加/删除/修改]',21,NULL,'role:manage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (24,'角色成员[添加/移除]',21,NULL,'role:personmanage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (25,'人员管理',0,'/person/index','person:index',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (26,'人员[添加/删除/修改]',25,NULL,'person:manage',NULL,0);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (27,'数据备份',0,'/backup','backup',NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (28,'统计',0,NULL,NULL,NULL,1);
insert  into `sys_menu`(`id`,`name`,`parent_id`,`url`,`prmission`,`sortd`,`display`) values (29,'数据统计',28,'/statistics','statistics',NULL,1);

/*Table structure for table `sys_role` */

CREATE TABLE `sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '角色代码',
  `description` varchar(50) NOT NULL COMMENT '角色名称',
  `group_id` int(11) NOT NULL COMMENT '所属角色组',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role` */

insert  into `sys_role`(`id`,`name`,`description`,`group_id`,`company_id`,`update_time`,`create_time`) values (1,'ADMIN','系统管理员',1,1,'2018-03-31 14:23:35','2018-03-31 14:23:35');

/*Table structure for table `sys_role_group` */

CREATE TABLE `sys_role_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL COMMENT '组名称',
  `company_id` int(11) NOT NULL COMMENT '所属公司',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_group` */

insert  into `sys_role_group`(`id`,`name`,`company_id`,`create_time`,`update_time`) values (1,'管理层',1,'2018-03-31 14:21:25','2018-03-31 14:21:25');
insert  into `sys_role_group`(`id`,`name`,`company_id`,`create_time`,`update_time`) values (2,'销售层',1,'2018-03-31 14:21:34','2018-03-31 14:21:34');
insert  into `sys_role_group`(`id`,`name`,`company_id`,`create_time`,`update_time`) values (3,'其它',1,'2018-03-31 14:21:57','2018-03-31 14:21:57');
insert  into `sys_role_group`(`id`,`name`,`company_id`,`create_time`,`update_time`) values (4,'管理层',2,'2018-03-31 14:22:06','2018-03-31 14:22:06');
insert  into `sys_role_group`(`id`,`name`,`company_id`,`create_time`,`update_time`) values (5,'销售层',2,'2018-03-31 14:22:13','2018-03-31 14:22:13');

/*Table structure for table `sys_role_menu` */

CREATE TABLE `sys_role_menu` (
  `role_id` int(11) NOT NULL,
  `menu_id` int(11) NOT NULL,
  PRIMARY KEY (`role_id`,`menu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_role_menu` */

/*Table structure for table `sys_user` */

CREATE TABLE `sys_user` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL COMMENT '登录名',
  `password` varchar(128) NOT NULL COMMENT '登录密码',
  `is_admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否管理员0：否，1：是',
  `is_platform_admin` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否是平台管理员0否，1是',
  `real_name` varchar(20) NOT NULL COMMENT '真实姓名',
  `company_id` int(11) NOT NULL COMMENT '公司ID',
  `dept_id` int(11) NOT NULL COMMENT '所属部门',
  `telephone` varchar(11) NOT NULL COMMENT '联系电话',
  `position` varchar(20) DEFAULT NULL COMMENT '职位',
  `job_number` varchar(10) DEFAULT NULL COMMENT '工号',
  `email` varchar(30) DEFAULT NULL COMMENT '邮箱',
  `work_address` varchar(50) DEFAULT NULL COMMENT '办公地点',
  `entry_time` datetime DEFAULT NULL COMMENT '入职时间',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `sys_user` */

insert  into `sys_user`(`id`,`username`,`password`,`is_admin`,`is_platform_admin`,`real_name`,`company_id`,`dept_id`,`telephone`,`position`,`job_number`,`email`,`work_address`,`entry_time`,`create_time`,`update_time`) values (1,'zdc','$2a$10$ICPn3Ar/NmzQFSJjBRbSZe5r.F/y9UZfe8fwUAknUD2Bc8e31Bjpm',0,0,'zdc',1,1,'1592517460',NULL,NULL,NULL,NULL,NULL,'2018-03-27 23:10:35','2018-03-31 14:43:44');

/*Table structure for table `sys_user_role` */

CREATE TABLE `sys_user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`user_id`,`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sys_user_role` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
