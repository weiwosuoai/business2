-- 用户表
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户 id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `phone` varchar(20) DEFAULT NULL COMMENT '手机号',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  `role_id` INT NOT NULL COMMENT '角色 id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 系统初始化添加一个超级管理员
INSERT INTO t_user(username, password, create_time, update_time, role_id) VALUES ('admin', '123456', NOW(), NOW(), 1);

-- 角色表
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE t_role (
  `role_id` INT AUTO_INCREMENT COMMENT '角色 id',
  `role_name` VARCHAR (500) NOT NULL COMMENT '角色名',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  `remark` VARCHAR (500) COMMENT '备注',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO t_role(role_name, create_time, update_time) VALUES ('超级管理员', NOW(), NOW());

-- 菜单表
DROP TABLE IF EXISTS `t_menu`;
CREATE TABLE t_menu (
  `menu_id` INT AUTO_INCREMENT COMMENT '菜单 id',
  `name` VARCHAR (50) NOT NULL COMMENT '菜单名称',
  `url` VARCHAR(500) NOT NULL COMMENT '菜单url',
  `parent_id` INT NOT NULL DEFAULT 0 COMMENT '父菜单id,若为0，则为顶级菜单',
  `type` INT NOT NULL DEFAULT 1 COMMENT '菜单级别，1表示一级菜单，2表示二级菜单',
  `icon` VARCHAR(50) COMMENT '菜单图标',
  `sort` INT NOT NULL DEFAULT 0 COMMENT '菜单排序, 0表示排第一',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  `remark` VARCHAR (500) COMMENT '备注',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 企业管理
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (1, '企业管理', '/sys/business/manage/list', 0, 1, 0, 'fa fa-bank',NOW(), NOW());

-- 客户管理
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (2, '客户管理', '/sys/customer/manage/list', 0, 1, 1, 'fa fa-user',NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (3, '在线留言', '/sys/messageol/manage/list', 2, 2, 0, NOW(), NOW());
-- 订单管理菜单
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (4, '订单管理', '/sys/order/manage/list', 0, 1, 2, 'fa fa-credit-card',NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (5, '订单信息', '/sys/order/manage/list', 4, 2, 0, NOW(), NOW());
-- 业务管理菜单
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (11, '业务管理', '/sys/business/list', 0, 1, 3, 'fa fa-credit-card',NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (12, '企业设立', '/sys/business/list', 11, 2, 0, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (13, '企业变更', '/sys/business/list/change', 11, 2, 1, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (14, '企业注销', '/sys/business/list/destroy', 11, 2, 2, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (15, '代理记账', '/sys/business/list/bookkeep', 11, 2, 3, NOW(), NOW());
-- 证照交易
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (16, '证照交易', '/sys/trans/list', 0, 1, 4, 'fa fa-credit-card',NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (17, '公司出售', '/sys/trans/list/sell', 16, 2, 0, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (18, '公司求购', '/sys/trans/list/buy', 16, 2, 1, NOW(), NOW());
-- 系统管理菜单
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, icon, create_time, update_time) VALUES (6, '系统管理', '/sys/user/manage/list', 0, 1, 5, 'fa fa-table', NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (7, '用户管理', '/sys/user/manage/list', 6, 2, 0, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (8, '角色管理', '/sys/role/manage/list', 6, 2, 1, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (9, '产品管理', '/sys/product/list', 6, 2, 2, NOW(), NOW());
INSERT INTO t_menu(menu_id, name, url, parent_id, type, sort, create_time, update_time) VALUES (10, '服务管理', '/sys/product/desc/list', 6, 2, 3, NOW(), NOW());

-- 角色菜单关系表
DROP TABLE IF EXISTS `t_role_menu_rel`;
CREATE TABLE t_role_menu_rel (
  `id` INT AUTO_INCREMENT COMMENT 'id',
  `role_id` INT NOT NULL COMMENT '角色id',
  `menu_id` INT NOT NULL COMMENT '菜单id',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- 产品表
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `product_id` int(11) auto_increment COMMENT '产品id',
  `product_name` varchar(100) default NULL COMMENT '产品名称',
  `product_title` varchar(500) default NULL COMMENT '产品标题',
  `com_type` int(2) default NULL COMMENT '企业类型 1、内资  2、外资   n>2、特殊类企业',
  `sub_com_type` int(2) default NULL COMMENT '规模 0、不限 1、小规模 2、一般纳税人',
  `month_size` int(2) default NULL COMMENT '月份数  0、不限 1、6个月  2、12个月',
  `price` decimal(20, 2) default NULL COMMENT '价格',
  `create_time` DATETIME default NULL COMMENT '创建时间',
  `update_time` DATETIME default NULL COMMENT '更新时间',
  `remark` text COMMENT '备注',
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
INSERT INTO `t_product` VALUES ('1', '企业设立-内资企业设立全国-统一价', '', '1', '0', '0', '3000.00', '2017-09-21 01:40:49', '2017-09-21 01:40:54', null);
INSERT INTO `t_product` VALUES ('2', '代理记帐内资公司小规模<25张凭证500元/月全国-统一价', '代理记账是指将本企业的会计核算、记账、报税等一系列的工作全部委托给专业记账公司完成，本企业只设立出纳人员，负责日常货币收支业务和财产保管等工作。', '1', '1', '2', '6000.00', '2017-09-21 02:16:58', '2017-09-21 02:16:58', '系统开始报税和开票之前的工作： 1、 税种核定（税务局）；  2、 发票申购（税务局）；  3、 开票硬软件培训、购买、安装（税务局指定的软件公司）；  4、 法人一证通申购（在数字中心申购）；  5、 一般纳税人资格申请。 月度代理记账服务： 标准化服务 1、 标准会计科目表；  2、 月度代理记账(收取原始资料，根据流水帐和发票内容做帐)；  3、 编制月底财务报表（资产负债表和利润表）。  个性化定制 1、 个性化会计科目表 ； 2、 月度代理记账(收取原始资料，根据个性化定制的要求，根据客户的具体商业模式和运营模式做帐)；  3、 编制月底财务报表（资产负债表和利润表）。 月度税务申报： 1、 增值税；  2、 合伙人经营个税；  3、 薪资个人所得税；  4、 企业所得税  5、 其他地方税种。 发票服务： 1、 进项增值税认证；  2、 开票服务； 3、 一般增值税纳税人发票升版。 年度税务代理服务： 1、 企业所得税汇算清缴 ； 2、 年度超过12万收入的，个人所得税申报；  3、 企业信息公告 ； 4、 联合年检。');


-- 订单表
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL auto_increment COMMENT '订单id',
  `order_no` VARCHAR(100) DEFAULT NULL UNIQUE COMMENT '订单号',
  `user_id` int(11) default NULL COMMENT '用户id',
  `product_id` int(11) default NULL COMMENT '商品id',
  `price` decimal(20, 2) default NULL COMMENT '实际付款金额，单位元，保留两位小数',
  `status` int(2) default NULL COMMENT '订单状态：0：获取二维码，等待支付 1：已付款',
  `create_time` DATETIME default NULL COMMENT '创建时间',
  `update_time` DATETIME default NULL COMMENT '更新时间',
  `pay_platform` INT(2) default NULL COMMENT '支付平台：1：支付宝 2：微信支付',
  `pay_time` DATETIME default NULL COMMENT '订单支付时间',
  `refund_time` DATETIME default NULL COMMENT '退款时间',
  `platform_trade_no` varchar(50) default NULL COMMENT '平台的交易号',
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--  20170922
DROP TABLE IF EXISTS `t_product_description`;
CREATE TABLE `t_product_description` (
  `desc_Id` int(11) NOT NULL auto_increment,
  `product_Id` int(11) default NULL,
  `desc_name` varchar(100) default NULL,
  `need_Papers` text,
  `product_Desc` text,
  `flow_Image` varchar(100) default NULL,
  `remark` varchar(500) default NULL,
  PRIMARY KEY  (`desc_Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

INSERT INTO `t_product_description` VALUES ('1', '1', '企业登记', '1. 公司股东、法定代表人、监事、财务及联络人的身份证复印件；（股东、监事、法定代表人需提供原件核对）\r\n2.拟设立公司基本信息；（公司名称、注册资本、股东出资比例、经营范围）\r\n3.股东是企业的提供公司营业执照原件及加盖公章的复印件；\r\n4. 政府表格及签字材料由创业伞提供。', '1、免费电话咨询\r\n2、免费起草公司设立的全部法律文书\r\n3、协助提供公司注册地址\r\n4、名称登记\r\n5、营业执照', '1', '1');


DROP TABLE IF EXISTS `t_business_request`;
CREATE TABLE `t_business_request` (
  `request_id` int(11) auto_increment,
  `desc_id` int(11) default NULL,
  `product_id` int(11) default NULL,
  `order_no` VARCHAR(100) DEFAULT NULL COMMENT '订单号',
  `request_type` int(2) default NULL,
  `status` int(2) default NULL,
  `accept_user_id` int(11) default NULL,
  `accept_user_name` varchar(50) default NULL,
  `customer_name` varchar(100) default NULL,
  `email` varchar(100) default NULL,
  `mobile` varchar(50) default NULL,
  `fax` varchar(50) default NULL,
  `need_invoice` int(2) default NULL,
  `invoice_title` varchar(100) default NULL,
  `create_time` DATETIME default NULL,
  `accept_time` DATETIME default NULL,
  PRIMARY KEY  (`request_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_company_transaction`;
CREATE TABLE `t_company_transaction` (
  `trans_id` int(11) NOT NULL auto_increment,
  `trans_type` int(2) default NULL,
  `city` varchar(40) default NULL,
  `license_image` varchar(50) default NULL,
  `debt` int(2) default NULL,
  `finance_status` int(2) default NULL,
  `permit` int(2) default NULL,
  `permit_image` varchar(50) default NULL,
  `industry` varchar(40) default NULL,
  `bargain` int(2) default NULL,
  `reg_duration` int(2) default NULL,
  `price` decimal(20, 2) default NULL,
  `valid_code` varchar(10) default NULL,
  `valid_date_end` date default NULL,
  `industry_require` text,
  `address_require` text,
  `reg_capital_require` text,
  `status` int(2) default NULL,
  `accept_user_id` int(11) default NULL,
  `accept_user_name` varchar(20) default NULL,
  `create_time` DATETIME NULL default NULL,
  `accept_time` DATETIME NULL default NULL,
  PRIMARY KEY  (`trans_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;


