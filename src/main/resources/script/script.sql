DROP TABLE IF EXISTS `product_info`;
CREATE TABLE IF NOT EXISTS `product_info` (
  `id` varchar(32) NOT NULL,
  `name` varchar(64) NOT NULL COMMENT '商品名称',
  `price` decimal(8, 2) NOT NULL comment '单价',
  `stock` int NOT NULL comment '库存',
  `description` varchar(64) NOT NULL comment '描述',
  `icon` varchar(512) NOT NULL comment '小图片链接',
  `status` tinyint NOT NULL DEFAULT '0' comment '商品状态, 默认0-正常 1下架',
  `category_Type` int NOT NULL comment '类目编号',
  `cr_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) comment '商品表';

DROP TABLE IF EXISTS `product_category`;
CREATE TABLE IF NOT EXISTS `product_category` (
  `id` int NOT NULL auto_increment,
  `name` varchar(64) NOT NULL comment '类目名称',
  `type` int NOT NULL comment '类目编号',
  `cr_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uqe_category_type` (`type`)
) comment '商品类目表';

DROP TABLE IF EXISTS `order_master`;
CREATE TABLE IF NOT EXISTS `order_master` (
  `id` varchar(32) NOT NULL,
  `buyer_Name` varchar(32) NOT NULL comment '买家名称',
  `buyer_Phone` varchar(32) NOT NULL comment '买家电话',
  `buyer_Address` varchar(128) NOT NULL comment '买家地址',
  `buyer_OpenID` varchar(64) NOT NULL comment '买家微信OpenID',
  `order_Amount` decimal(8, 2) NOT NULL comment '订单总金额',
  `order_Status` tinyint NOT NULL DEFAULT '0' comment '订单状态, 默认0-新订单',
  `pay_Status` tinyint NOT NULL DEFAULT '0' comment '支付状态, 默认0-未支付',
  `cr_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_buyerOpenID` (`buyerOpenID`)
) comment '订单表';

DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE IF NOT EXISTS `order_detail` (
  `id` varchar(32) NOT NULL comment '订单明细ID',
  `order_Id` varchar(32) NOT NULL comment '订单ID',
  `product_Id` varchar(32) NOT NULL comment '商品ID',
  `product_Name` varchar(64) NOT NULL comment '商品名称',
  `product_Price` decimal(8, 2) NOT NULL comment '商品价格',
  `product_Quantity` int NOT NULL comment '商品数量',
  `product_ICON` varchar(512) NOT NULL comment '商品图片链接地址',
  `cr_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP comment '创建时间',
  `update_Time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP comment '修改时间',
  PRIMARY KEY (`id`),
  KEY `idx_orderId` (`orderId`)
) comment '订单详情表';
