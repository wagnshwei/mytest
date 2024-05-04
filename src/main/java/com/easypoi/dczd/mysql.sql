DROP TABLE IF EXISTS `dczd_business_apply`;
CREATE TABLE `dczd_business_apply` (
	`id` BIGINT(20) NOT NULL AUTO_INCREMENT COMMENT '主键id',
	`introducer_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '介绍人姓名' COLLATE 'utf8mb4_0900_as_ci',
	`host_account_id` BIGINT(20) NULL DEFAULT NULL COMMENT '业务主办人',
	`assist_account_id` BIGINT(20) NULL DEFAULT NULL COMMENT '业务辅办人',
	`company_name` VARCHAR(100) NULL DEFAULT NULL COMMENT '企业名称' COLLATE 'utf8mb4_0900_as_ci',
	`company_uscc` VARCHAR(64) NULL DEFAULT NULL COMMENT '企业营业执照编码' COLLATE 'utf8mb4_0900_as_ci',
	`company_address` VARCHAR(200) NULL DEFAULT NULL COMMENT '经营地址' COLLATE 'utf8mb4_0900_as_ci',
	`legal_person` VARCHAR(64) NULL DEFAULT NULL COMMENT '法人' COLLATE 'utf8mb4_0900_as_ci',
	`company_contract` VARCHAR(64) NULL DEFAULT NULL COMMENT '企业联系人' COLLATE 'utf8mb4_0900_as_ci',
	`company_mobile` VARCHAR(32) NULL DEFAULT NULL COMMENT '企业联系电话' COLLATE 'utf8mb4_0900_as_ci',
	`company_city` VARCHAR(32) NULL DEFAULT NULL COMMENT '公司所在城市' COLLATE 'utf8mb4_0900_as_ci',
	`company_industry_type` VARCHAR(32) NULL DEFAULT NULL COMMENT '企业行业分类' COLLATE 'utf8mb4_0900_as_ci',
	`company_type` VARCHAR(32) NULL DEFAULT NULL COMMENT '企业分类' COLLATE 'utf8mb4_0900_as_ci',
	`bank_name` VARCHAR(32) NULL DEFAULT NULL COMMENT '经办银行' COLLATE 'utf8mb4_0900_as_ci',
	`bank_web` VARCHAR(32) NULL DEFAULT NULL COMMENT '经办银行网点' COLLATE 'utf8mb4_0900_as_ci',
	`bank_lease_info` VARCHAR(1000) NULL DEFAULT NULL COMMENT '租赁信息 [{"leaseAmount": 1000, "expire_date": "2024-12-31"},{"leaseAmount": 500, "expire_date": "2025-12-31"} ]' COLLATE 'utf8mb4_0900_as_ci',
	`renewal_amount` DECIMAL(15,2) NULL DEFAULT NULL COMMENT '续贷金额',
	`surety_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '保证人或抵押物名称' COLLATE 'utf8mb4_0900_as_ci',
	`loan_bank_account_name` VARCHAR(255) NULL DEFAULT NULL COMMENT '贷款账户名称' COLLATE 'utf8mb4_0900_as_ci',
	`loan_bank_account_no` VARCHAR(255) NULL DEFAULT NULL COMMENT '贷款账号' COLLATE 'utf8mb4_0900_as_ci',
	`company_offer_amount` DECIMAL(15,2) NOT NULL COMMENT '公司自筹金额',
	`apply_loan_amount` DECIMAL(15,2) NULL DEFAULT NULL COMMENT '申请放款金额',
	`apply_loan_start_time` DATE NULL DEFAULT NULL COMMENT '申请借款开始时间',
	`apply_loan_end_time` DATE NULL DEFAULT NULL COMMENT '申请借款结束时间',
	`apply_loan_contract_no` VARCHAR(50) NULL DEFAULT NULL COMMENT '申请借款合同号' COLLATE 'utf8mb4_0900_as_ci',
	`apply_company_meas` VARCHAR(255) NULL DEFAULT NULL COMMENT '企业担保措施' COLLATE 'utf8mb4_0900_as_ci',
	`if_offer_relend_contact` CHAR(1) NULL DEFAULT NULL COMMENT '是否出具银行转贷联系单，0 否，1 是' COLLATE 'utf8mb4_0900_as_ci',
	`company_info_file_id` BIGINT(20) NULL DEFAULT NULL COMMENT '公司简介文件id',
	`loan_apply_file_id` BIGINT(20) NULL DEFAULT NULL COMMENT '转贷申请表文件id',
	`base_material_file_id` BIGINT(20) NULL DEFAULT NULL COMMENT '基础材料文件id',
	`survey_report_file_id` BIGINT(20) NULL DEFAULT NULL COMMENT '尽调报告文件id',
	`approval_status` VARCHAR(4) NULL DEFAULT '0' COMMENT '审批状态 0、审批中， 1、审批通过 2、审批拒绝 3、已结清 4、已终止 -1、其他' COLLATE 'utf8mb4_0900_as_ci',
	`comment` VARCHAR(255) NULL DEFAULT NULL COMMENT '审批意见，冗余字段。低代码审批时候填写意见用' COLLATE 'utf8mb4_0900_as_ci',
	`approval_end_time` DATETIME NULL DEFAULT NULL COMMENT '审批完成时间',
	`abort_reason` VARCHAR(255) NULL DEFAULT NULL COMMENT '中止原因' COLLATE 'utf8mb4_0900_as_ci',
	`if_settle` CHAR(1) NULL DEFAULT NULL COMMENT '是否结清 0: 未结清 1: 已结清' COLLATE 'utf8mb4_0900_as_ci',
	`settle_time` DATETIME NULL DEFAULT NULL COMMENT '结清时间',
	`abort_time` DATETIME NULL DEFAULT NULL COMMENT '中止时间',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT(20) NULL DEFAULT NULL COMMENT '创建人',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
	`update_user_id` BIGINT(20) NULL DEFAULT NULL COMMENT '修改人',
	`delete_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '是否删除 未删除存0' COLLATE 'utf8mb4_0900_as_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='业务申请表'
COLLATE='utf8mb4_0900_as_ci'
ENGINE=InnoDB
AUTO_INCREMENT=1000000
;

DROP TABLE IF EXISTS `dczd_business_repay_detail`;
CREATE TABLE `dczd_business_repay_detail` (
	`id` BIGINT(19) NOT NULL AUTO_INCREMENT COMMENT '客户主键id',
	`business_apply_id` BIGINT(19) NULL DEFAULT NULL COMMENT '业务申请id',
	`enlending_balance` DECIMAL(15,2) NULL DEFAULT NULL COMMENT '转贷余额',
	`interest_balance` VARCHAR(255) NULL DEFAULT NULL COMMENT '利息余额' COLLATE 'utf8mb4_0900_as_ci',
	`if_loan` CHAR(1) NULL DEFAULT NULL COMMENT '是否是放款' COLLATE 'utf8mb4_0900_as_ci',
	`start_time` DATE NULL DEFAULT NULL COMMENT '起始日期',
	`end_time` DATE NULL DEFAULT NULL COMMENT '结束日期',
	`create_time` DATETIME NULL DEFAULT NULL COMMENT '创建时间',
	`create_user_id` BIGINT(19) NULL DEFAULT NULL COMMENT '创建人',
	`update_time` DATETIME NULL DEFAULT NULL COMMENT '修改时间',
	`update_user_id` BIGINT(19) NULL DEFAULT NULL COMMENT '修改人',
	`delete_flag` CHAR(1) NOT NULL DEFAULT '0' COMMENT '是否删除 未删除存0, 已删除存主键id' COLLATE 'utf8mb4_0900_as_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COMMENT='还款明细表'
COLLATE='utf8mb4_0900_as_ci'
ENGINE=InnoDB
AUTO_INCREMENT=100000000
;

ALTER TABLE dczd_business_apply AUTO_INCREMENT = 1000000;
ALTER TABLE dczd_business_repay_detail AUTO_INCREMENT = 100000000;