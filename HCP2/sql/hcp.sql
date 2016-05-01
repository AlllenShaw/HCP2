/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50624
Source Host           : localhost:3306
Source Database       : ehealth

Target Server Type    : MYSQL
Target Server Version : 50624
File Encoding         : 65001

Date: 2016-03-28 16:25:12
*/
DROP Database IF EXISTS hcp;
CREATE Database hcp;
USE hcp;

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for patient
-- ----------------------------
DROP TABLE IF EXISTS `patient`;
CREATE TABLE `patient` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `realname` varchar(45) DEFAULT NULL,
  `id_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `token` varchar(50) DEFAULT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `hin` varchar(45) DEFAULT NULL,
  `tele` varchar(45) DEFAULT NULL,
  `famlily1` int(11) ,
  `famlily2` int(11) ,
  `gender` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `education` varchar(45) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `bir_address` varchar(200) DEFAULT NULL,
  `nation` varchar(45) DEFAULT NULL,
  `hospital` varchar(45) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `marriage` tinyint(1) DEFAULT '0',
  `register_time` datetime DEFAULT NULL,
  `glu_state` tinyint(1) DEFAULT '0',
  `hpl_state` tinyint(1) DEFAULT '0',
  `htn_state` tinyint(1) DEFAULT '0',
  `hd_state` tinyint(1) DEFAULT '0',
  `illness_his` varchar(200) DEFAULT NULL,
  `allergic_his` varchar(200) DEFAULT NULL,
  `family_his` varchar(200) DEFAULT NULL,
  `security1` int(11) ,
  `security2` int(11) ,
  `security3` int(11) ,
  `answer1` varchar(45) DEFAULT NULL,
  `answer2` varchar(45) DEFAULT NULL,
  `answer3` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `Id_number` (`Id_number`),
  UNIQUE KEY `mail` (`mail`),
  FOREIGN KEY (`famlily1`) REFERENCES `family` (`id`),
  FOREIGN KEY (`famlily2`) REFERENCES `family` (`id`),
  FOREIGN KEY (`security1`) REFERENCES `security` (`id`),
  FOREIGN KEY (`security2`) REFERENCES `security` (`id`),
  FOREIGN KEY (`security3`) REFERENCES `security` (`id`)
); 

  

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `relation` varchar(45) DEFAULT NULL,
  `tele` varchar(45) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ----------------------------
-- Table structure for security
-- ----------------------------
DROP TABLE IF EXISTS `security`;
CREATE TABLE `security` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `question` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for glu_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `glu_patient_info`;
CREATE TABLE `glu_patient_info` (
  `patient_id` int(11) NOT NULL,
  `blood_glucose_max` float DEFAULT NULL,
  `blood_glucose_min` float DEFAULT NULL,
  `upgrade_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `FK3318F5578E89BA61` (`patient_id`),
  CONSTRAINT `FK3318F5578E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);

-- ----------------------------
-- Table structure for glu_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `glu_patient_record`;
CREATE TABLE `glu_patient_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `blood_glucose` float NOT NULL,
  `measure_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKDF8C76BA8E89BA61` (`patient_id`),
  CONSTRAINT `FKDF8C76BA8E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);

-- ----------------------------
-- Table structure for glu_patient_medicine_record
-- ----------------------------
DROP TABLE IF EXISTS `glu_patient_medicine_record`;
CREATE TABLE `glu_patient_medicine_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `taking_medicine_way_id` int(11) NOT NULL,
  `taking_medicine_number_eachtime` int(11) NOT NULL,
  `medicine_unit_id` int(11) NOT NULL,
  `taking_medicine_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK5B8219ADE105D528` (`medicine_unit_id`),
  KEY `FK5B8219AD8E89BA61` (`patient_id`),
  KEY `FK5B8219AD1EDE8593` (`medicine_id`),
  KEY `FK5B8219ADE7F8E98D` (`taking_medicine_way_id`),
  CONSTRAINT `FK5B8219AD1EDE8593` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `FK5B8219AD8E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK5B8219ADE105D528` FOREIGN KEY (`medicine_unit_id`) REFERENCES `medicine_unit` (`id`),
  CONSTRAINT `FK5B8219ADE7F8E98D` FOREIGN KEY (`taking_medicine_way_id`) REFERENCES `taking_medicine_way` (`id`)
);


-- ----------------------------
-- Table structure for hpl_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `hpl_patient_info`;
CREATE TABLE `hpl_patient_info` (
  `patient_id` int(11) NOT NULL,
  `tc_max` float DEFAULT NULL,
  `tc_min` float DEFAULT NULL,
  `tg_max` float DEFAULT NULL,
  `tg_min` float DEFAULT NULL,
  `hdl_max` float DEFAULT NULL,
  `hdl_min` float DEFAULT NULL,
  `ldl_max` float DEFAULT NULL,
  `ldl_min` float DEFAULT NULL,
  `upgrade_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `FK8B4C65A38E89BA61` (`patient_id`),
  CONSTRAINT `FK8B4C65A38E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);


-- ----------------------------
-- Table structure for hpl_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `hpl_patient_record`;
CREATE TABLE `hpl_patient_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `tc` float NOT NULL,
  `tg` float NOT NULL,
  `hdl` float NOT NULL,
  `ldl` float NOT NULL,
  `measure_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF8A504068E89BA61` (`patient_id`),
  CONSTRAINT `FKF8A504068E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);

-- ----------------------------
-- Table structure for hpl_patient_medicine_record
-- ----------------------------
DROP TABLE IF EXISTS `hpl_patient_medicine_record`;
CREATE TABLE `hpl_patient_medicine_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `taking_medicine_way_id` int(11) NOT NULL,
  `taking_medicine_number_eachtime` int(11) NOT NULL,
  `medicine_unit_id` int(11) NOT NULL,
  `taking_medicine_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKF685C1E1E105D528` (`medicine_unit_id`),
  KEY `FKF685C1E18E89BA61` (`patient_id`),
  KEY `FKF685C1E11EDE8593` (`medicine_id`),
  KEY `FKF685C1E1E7F8E98D` (`taking_medicine_way_id`),
  CONSTRAINT `FKF685C1E11EDE8593` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `FKF685C1E18E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FKF685C1E1E105D528` FOREIGN KEY (`medicine_unit_id`) REFERENCES `medicine_unit` (`id`),
  CONSTRAINT `FKF685C1E1E7F8E98D` FOREIGN KEY (`taking_medicine_way_id`) REFERENCES `taking_medicine_way` (`id`)
);


-- ----------------------------
-- Table structure for htn_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `htn_patient_info`;
CREATE TABLE `htn_patient_info` (
  `patient_id` int(11) NOT NULL,
  `diastolic_pressure_max` float DEFAULT NULL,
  `diastolic_pressure_min` float DEFAULT NULL,
  `systolic_pressure_max` float DEFAULT NULL,
  `systolic_pressure_min` float DEFAULT NULL,
  `heart_rate_max` float DEFAULT NULL,
  `heart_rate_min` float DEFAULT NULL,
  `upgrade_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  KEY `FKB675A1E58E89BA61` (`patient_id`),
  CONSTRAINT `FKB675A1E58E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);


-- ----------------------------
-- Table structure for htn_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `htn_patient_record`;
CREATE TABLE `htn_patient_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `diastolic_pressure` float NOT NULL,
  `systolic_pressure` float NOT NULL,
  `heart_rate` float NOT NULL,
  `measure_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKFE7037C88E89BA61` (`patient_id`),
  CONSTRAINT `FKFE7037C88E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
); 

-- ----------------------------
-- Table structure for htn_patient_medicine_record
-- ----------------------------
DROP TABLE IF EXISTS `htn_patient_medicine_record`;
CREATE TABLE `htn_patient_medicine_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `taking_medicine_way_id` int(11) NOT NULL,
  `taking_medicine_number_eachtime` int(11) NOT NULL,
  `medicine_unit_id` int(11) NOT NULL,
  `taking_medicine_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK64BA85FE105D528` (`medicine_unit_id`),
  KEY `FK64BA85F8E89BA61` (`patient_id`),
  KEY `FK64BA85F1EDE8593` (`medicine_id`),
  KEY `FK64BA85FE7F8E98D` (`taking_medicine_way_id`),
  CONSTRAINT `FK64BA85F1EDE8593` FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  CONSTRAINT `FK64BA85F8E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK64BA85FE105D528` FOREIGN KEY (`medicine_unit_id`) REFERENCES `medicine_unit` (`id`),
  CONSTRAINT `FK64BA85FE7F8E98D` FOREIGN KEY (`taking_medicine_way_id`) REFERENCES `taking_medicine_way` (`id`)
);

-- ----------------------------
-- Table structure for hd_patient_info
-- ----------------------------
DROP TABLE IF EXISTS `hd_patient_info`;
CREATE TABLE `hd_patient_info` (
  `patient_id` int(11) NOT NULL,
  `heart_rate_max` float DEFAULT NULL,
  `heart_rate_min` float DEFAULT NULL,
  `upgrade_time` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`),
  FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);


-- ----------------------------
-- Table structure for hd_patient_record
-- ----------------------------
DROP TABLE IF EXISTS `hd_patient_record`;
CREATE TABLE `hd_patient_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `heart_rate` float NOT NULL,
  `ecg` varchar(400) NOT NULL,
  `measure_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
); 

-- ----------------------------
-- Table structure for hd_patient_medicine_record
-- ----------------------------
DROP TABLE IF EXISTS `hd_patient_medicine_record`;
CREATE TABLE `hd_patient_medicine_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `patient_id` int(11) NOT NULL,
  `medicine_id` int(11) NOT NULL,
  `taking_medicine_way_id` int(11) NOT NULL,
  `taking_medicine_number_eachtime` int(11) NOT NULL,
  `medicine_unit_id` int(11) NOT NULL,
  `taking_medicine_time` datetime NOT NULL,
  `upload_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  FOREIGN KEY (`medicine_unit_id`) REFERENCES `medicine_unit` (`id`),
  FOREIGN KEY (`taking_medicine_way_id`) REFERENCES `taking_medicine_way` (`id`)
);




-- ----------------------------
-- Table structure for doctor
-- ----------------------------
DROP TABLE IF EXISTS `doctor`;
CREATE TABLE `doctor` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `id_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `hospital_id` int(11) NOT NULL,
  `doctor_license` varchar(20) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tele` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `age` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `height` varchar(45) DEFAULT NULL,
  `weight` varchar(45) DEFAULT NULL,
  `nation` varchar(45) DEFAULT NULL,
  `profession` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `register_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `id_number` (`id_number`),
  KEY `FKB0EF911FBB7D8593` (`hospital_id`),
  CONSTRAINT `FKB0EF911FBB7D8593` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
);


-- ----------------------------
-- Table structure for patient_has_doctor
-- ----------------------------
DROP TABLE IF EXISTS `patient_has_doctor`;
CREATE TABLE `patient_has_doctor` (
  `patient_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `last_treat` datetime DEFAULT NULL,
  PRIMARY KEY (`patient_id`,`doctor_id`),
  KEY `FK5FBC7FDE8E89BA61` (`patient_id`),
  KEY `FK5FBC7FDEE96D11B3` (`doctor_id`),
  CONSTRAINT `FK5FBC7FDE8E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK5FBC7FDEE96D11B3` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
);

-- ----------------------------
-- Table structure for hospital_administrator
-- ----------------------------
DROP TABLE IF EXISTS `hospital_administrator`;
CREATE TABLE `hospital_administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `id_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `hospital_id` int(11) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tele` varchar(45) DEFAULT NULL,
  `register_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `id_number` (`id_number`),
  KEY `FK5CF62588BB7D8593` (`hospital_id`),
  CONSTRAINT `FK5CF62588BB7D8593` FOREIGN KEY (`hospital_id`) REFERENCES `hospital` (`id`)
);

-- ----------------------------
-- Table structure for super_administrator
-- ----------------------------
DROP TABLE IF EXISTS `super_administrator`;
CREATE TABLE `super_administrator` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `realname` varchar(45) NOT NULL,
  `id_number` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `mail` varchar(45) DEFAULT NULL,
  `tele` varchar(45) DEFAULT NULL,
  `register_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `id_number` (`id_number`)
);


-- ----------------------------
-- Table structure for hospital
-- ----------------------------
DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `address` varchar(45) NOT NULL,
  `level` varchar(45) NOT NULL,
  `introduction` varchar(400) DEFAULT NULL,
  `register_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
);


-- ----------------------------
-- Table structure for emr
-- ----------------------------
DROP TABLE IF EXISTS `emr`;
CREATE TABLE `emr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `doctor_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  `illness_state_desc` varchar(200) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK188CA8E89BA61` (`patient_id`),
  KEY `FK188CAE96D11B3` (`doctor_id`),
  CONSTRAINT `FK188CA8E89BA61` FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
  CONSTRAINT `FK188CAE96D11B3` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
);


-- ----------------------------
-- Table structure for examination_type
-- ----------------------------
DROP TABLE IF EXISTS `examination_type`;
CREATE TABLE `examination_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `value` varchar(45) NOT NULL,
  `detail` varchar(200),
  PRIMARY KEY (`id`)
);



-- ----------------------------
-- Table structure for examination_emr
-- ----------------------------
DROP TABLE IF EXISTS `examination_emr`;
CREATE TABLE `examination_emr` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `emr_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `examination_emr_type_id` int(11) NOT NULL,
  `accessory` varchar(45) NOT NULL,
  `result` varchar(200) NOT NULL,
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKB935AB7C112A190F` (`examination_emr_type_id`),
  KEY `FKB935AB7CFE98A3C1` (`emr_id`),
  KEY `FKB935AB7CE96D11B3` (`doctor_id`),
  CONSTRAINT `FKB935AB7C112A190F` FOREIGN KEY (`examination_emr_type_id`) REFERENCES `examination_type` (`id`),
  CONSTRAINT `FKB935AB7CE96D11B3` FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`),
  CONSTRAINT `FKB935AB7CFE98A3C1` FOREIGN KEY (`emr_id`) REFERENCES `emr` (`id`)
);



----------------------------------------------------------------------------------------
-- ----------------------------
-- Table structure for prescription
-- ----------------------------
DROP TABLE IF EXISTS `prescription`;
CREATE TABLE `prescription` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_id` int(11) NOT NULL,
  `taking_medicine_way_id` int(11) NOT NULL,
  `taking_medicine_number_eachtime` int(11) NOT NULL,
  `medicine_unit_id` int(11) NOT NULL,
  `taking_medicine_times_eachday` int(11) NOT NULL,
  `note` varchar(200) DEFAULT NULL,
  `emr_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  `meal_time` int(11),
  `create_time` datetime NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`medicine_id`) REFERENCES `medicine` (`id`),
  FOREIGN KEY (`taking_medicine_way_id`) REFERENCES `taking_medicine_way` (`id`),
  FOREIGN KEY (`medicine_unit_id`) REFERENCES `medicine_unit` (`id`),
  FOREIGN KEY (`emr_id`) REFERENCES `emr` (`id`),
  FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
);



-- ----------------------------
-- Table structure for medicine
-- ----------------------------
DROP TABLE IF EXISTS `medicine`;
CREATE TABLE `medicine` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `constituent` varchar(45) DEFAULT NULL,
  `adaptation_disease` varchar(200) DEFAULT NULL,
  `usage` varchar(200) DEFAULT NULL,
  `dosage` float DEFAULT NULL,
  `adverse_reaction` varchar(200) DEFAULT NULL,
  `taboo` varchar(200) DEFAULT NULL,
  `attentions` varchar(200) DEFAULT NULL,
  `direction` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);

-- ----------------------------
-- Table structure for medicine_unit
-- ----------------------------
DROP TABLE IF EXISTS `medicine_unit`;
CREATE TABLE `medicine_unit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `medicine_unit` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `medicine_unit` (`medicine_unit`)
);

-- ----------------------------
-- Table structure for taking_medicine_way
-- ----------------------------
DROP TABLE IF EXISTS `taking_medicine_way`;
CREATE TABLE `taking_medicine_way` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `taking_medicine_way` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `taking_medicine_way` (`taking_medicine_way`)
);


----------------------------------------------------------
-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ----------------------------
-- Table structure for user_group
-- ----------------------------
DROP TABLE IF EXISTS `user_group`;
CREATE TABLE `user_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
);


-- ----------------------------
-- Table structure for doctor_group
-- ----------------------------
DROP TABLE IF EXISTS `doctor_group`;
CREATE TABLE `doctor_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `doctor_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`),
  FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
);

-- ----------------------------
-- Table structure for patient_group
-- ----------------------------
DROP TABLE IF EXISTS `patient_group`;
CREATE TABLE `patient_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group_id` int(11) NOT NULL,
  `patient_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_group_id`) REFERENCES `user_group` (`id`),
  FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
);

-- ----------------------------
-- Table structure for user_group_permission
-- ----------------------------
DROP TABLE IF EXISTS `user_group_permission`;
CREATE TABLE `user_group_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_group1_id` int(11) NOT NULL,
  `user_group2_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  `feasible` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  FOREIGN KEY (`user_group1_id`) REFERENCES `user_group` (`id`),
  FOREIGN KEY (`user_group2_id`) REFERENCES `user_group` (`id`),
  FOREIGN KEY (`permission_id`) REFERENCES `permission` (`id`)
);