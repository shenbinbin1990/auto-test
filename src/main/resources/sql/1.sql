#1.2.4
#shenbinbin
#修改字典类型表,id改为字符串类型
DROP TABLE IF EXISTS `base_dictionary_type`;
CREATE TABLE `base_dictionary_type`  (
  `id` VARCHAR(50) NOT NULL COMMENT '字典类型编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典类型名称',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `delete_flag` tinyint(3) NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医美字典类型表' ROW_FORMAT = Compact;

INSERT INTO `base_dictionary_type`(id,name)  VALUES('MEDICAL_BEAUTY_ITEM_TYPE', '医美项目类型');
INSERT INTO `base_dictionary_type`(id,name)  VALUES('MEDICAL_BEAUTY_ITEM_LEVEL', '医美项目级别');
INSERT INTO `base_dictionary_type`(id,name)  VALUES('MEDICAL_BEAUTY_KEYWORD_TYPE', '医美关键词类型');

#修改字典表,type_id改为字符串类型
DROP TABLE IF EXISTS `base_dictionary`;
CREATE TABLE `base_dictionary`  (
  `id` VARCHAR(50) NOT NULL COMMENT '字典编号',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '字典名称',
  `type_id` VARCHAR(50) NOT NULL COMMENT '字典类型id',
  `sort` int(10) NULL DEFAULT NULL COMMENT '排序号',
  `gmt_create` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_update` datetime(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `delete_flag` tinyint(3) NOT NULL DEFAULT 0 COMMENT '删除标志',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '医美字典表' ROW_FORMAT = Compact;

INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("head_and_face" , '头面部', 'MEDICAL_BEAUTY_ITEM_TYPE', 1);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("breast_and_body" , '乳房、躯干', 'MEDICAL_BEAUTY_ITEM_TYPE', 2);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("perineum" , '会阴部', 'MEDICAL_BEAUTY_ITEM_TYPE', 3);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("other_medical_beauty_item_type" , '其他', 'MEDICAL_BEAUTY_ITEM_TYPE', 4);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("tooth_cosmetic_repair_technique" , '牙齿美容修复技术', 'MEDICAL_BEAUTY_ITEM_TYPE', 5);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("periodontal_cosmetic_technique" , '牙周美容技术操作', 'MEDICAL_BEAUTY_ITEM_TYPE', 6);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("malocclusion_cosmetic_treatment" , '牙牙合畸形美容矫治', 'MEDICAL_BEAUTY_ITEM_TYPE', 7);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("noninvasive_treatment_program" , '无创治疗项目', 'MEDICAL_BEAUTY_ITEM_TYPE', 8);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("microport_treatment_project" , '微创治疗项目', 'MEDICAL_BEAUTY_ITEM_TYPE', 9);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("operation_item" , '手术项目', 'MEDICAL_BEAUTY_ITEM_TYPE', 10);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("chinese_medicine_oral_beauty_therapy" , '中药内服美容法', 'MEDICAL_BEAUTY_ITEM_TYPE', 11);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("chinese_medicine_external_cosmetic_therapy" , '中药外治美容技术', 'MEDICAL_BEAUTY_ITEM_TYPE', 12);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("acupuncture_cosmetic_technique" , '针灸美容技术', 'MEDICAL_BEAUTY_ITEM_TYPE', 13);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("chinese_massage_cosmetic_technique" , '中医推拿美容技术', 'MEDICAL_BEAUTY_ITEM_TYPE', 14);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("other_chinese_medicine_cosmetic_technique" , '其他中医美容技术', 'MEDICAL_BEAUTY_ITEM_TYPE', 15);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("first_level" , '一级', 'MEDICAL_BEAUTY_ITEM_LEVEL', 2);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("second_level" , '二级', 'MEDICAL_BEAUTY_ITEM_LEVEL', 3);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("third_level" , '三级', 'MEDICAL_BEAUTY_ITEM_LEVEL', 4);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("fourth_level" , '四级', 'MEDICAL_BEAUTY_ITEM_LEVEL', 5);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("no_grading_temporary" , '暂不分级', 'MEDICAL_BEAUTY_ITEM_LEVEL', 1);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("medical_cosmetic_service" , '医美服务', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 1);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("medical_cosmetic_service_recovery_period" , '医美服务恢复期', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 2);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("medical_cosmetic_accident" , '医美事故', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 3);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("medical_equipment" , '医美药械', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 4);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("medical_cosmetic_item" , '医美项目', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 5);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("place_keyword" , '场所关键词', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 6);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("object_keyword" , '对象关键词', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 7);
INSERT INTO `base_dictionary`(id,name,type_id,sort) VALUES ("block_keyword" , '屏蔽关键词', 'MEDICAL_BEAUTY_KEYWORD_TYPE', 8);


#修改注释,明确意义
ALTER TABLE base_item_term MODIFY second_subject_code int(10) NOT NULL COMMENT '所属二级科目编码(对应base_treatment_subject表id字段)';
ALTER TABLE base_item_term MODIFY item_level_code VARCHAR(50) NOT NULL COMMENT '项目级别编码(对应base_dictionary表id字段)';
ALTER TABLE base_item_term MODIFY item_category_code VARCHAR(50) NOT NULL COMMENT '所属项目类型编码(对应base_dictionary表id字段)';
ALTER TABLE base_service_keyword_dictionary MODIFY type_code VARCHAR(50) NOT NULL COMMENT '关键词类型编码(对应base_dictionary表id字段)';

update base_item_term set item_category_code = 'head_and_face' where item_category_code = '1';
update base_item_term set item_category_code = 'breast_and_body' where item_category_code = '2';
update base_item_term set item_category_code = 'perineum' where item_category_code = '3';
update base_item_term set item_category_code = 'other_medical_beauty_item_type' where item_category_code = '4';
update base_item_term set item_category_code = 'tooth_cosmetic_repair_technique' where item_category_code = '5';
update base_item_term set item_category_code = 'periodontal_cosmetic_technique' where item_category_code = '6';
update base_item_term set item_category_code = 'malocclusion_cosmetic_treatment' where item_category_code = '7';
update base_item_term set item_category_code = 'noninvasive_treatment_program' where item_category_code = '8';
update base_item_term set item_category_code = 'microport_treatment_project' where item_category_code = '9';
update base_item_term set item_category_code = 'operation_item' where item_category_code = '10';
update base_item_term set item_category_code = 'chinese_medicine_oral_beauty_therapy' where item_category_code = '11';
update base_item_term set item_category_code = 'chinese_medicine_external_cosmetic_therapy' where item_category_code = '12';
update base_item_term set item_category_code = 'acupuncture_cosmetic_technique' where item_category_code = '13';
update base_item_term set item_category_code = 'chinese_massage_cosmetic_technique' where item_category_code = '14';
update base_item_term set item_category_code = 'other_chinese_medicine_cosmetic_technique' where item_category_code = '15';


#修改base_item_term表相应的字典值
update base_item_term set item_level_code = 'first_level' where item_level_code = '16';
update base_item_term set item_level_code = 'second_level' where item_level_code = '17';
update base_item_term set item_level_code = 'third_level' where item_level_code = '18';
update base_item_term set item_level_code = 'fourth_level' where item_level_code = '19';
update base_item_term set item_level_code = 'no_grading_temporary' where item_level_code = '20';


#修改base_service_keyword_dictionary表相应的字典值
update base_service_keyword_dictionary set type_code = 'medical_cosmetic_service' where type_code = '21';
update base_service_keyword_dictionary set type_code = 'medical_cosmetic_service_recovery_period' where type_code = '22';
update base_service_keyword_dictionary set type_code = 'medical_cosmetic_accident' where type_code = '23';
update base_service_keyword_dictionary set type_code = 'medical_equipment' where type_code = '24';
update base_service_keyword_dictionary set type_code = 'medical_cosmetic_item' where type_code = '25';
update base_service_keyword_dictionary set type_code = 'place_keyword' where type_code = '26';
update base_service_keyword_dictionary set type_code = 'object_keyword' where type_code = '27';
update base_service_keyword_dictionary set type_code = 'block_keyword' where type_code = '28';



update base_service_keyword_dictionary set type_code = '21' where type_code = '1';
update base_service_keyword_dictionary set type_code = '22' where type_code = '2';
update base_service_keyword_dictionary set type_code = '23' where type_code = '3';
update base_service_keyword_dictionary set type_code = '24' where type_code = '4';
update base_service_keyword_dictionary set type_code = '25' where type_code = '5';
update base_service_keyword_dictionary set type_code = '26' where type_code = '6';
update base_service_keyword_dictionary set type_code = '27' where type_code = '7';
update base_service_keyword_dictionary set type_code = '28' where type_code = '8';