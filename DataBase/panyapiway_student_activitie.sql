-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 24, 2018 at 07:38 AM
-- Server version: 10.1.26-MariaDB
-- PHP Version: 7.1.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `panyapiway_student_activitie`
--

-- --------------------------------------------------------

--
-- Table structure for table `account`
--

CREATE TABLE `account` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์',
  `person_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'เจ้าของแอคเคาท์',
  `account_type_id` int(3) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสชนิดแอคเคาท์',
  `username` varchar(24) NOT NULL COMMENT 'ชื่อแอคเคาท์',
  `password` varchar(30) NOT NULL COMMENT 'รหัสผ่านแอคเคาท์',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันที่สมัครแอคเคาท์'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลแอคเคาท์';

--
-- Dumping data for table `account`
--

INSERT INTO `account` (`id`, `person_id`, `account_type_id`, `username`, `password`, `create_date`) VALUES
(00000000000000000001, 1249900399923, 001, 'sirisaknav', 'd21022539', '2018-01-24 03:59:54'),
(00000000000000000002, 1111111111111, 002, 'teacher', 'teacher', '2018-01-24 04:00:23'),
(00000000000000000003, 2222222222222, 003, 'adminpim', 'adminpim', '2018-01-24 04:00:54');

-- --------------------------------------------------------

--
-- Table structure for table `account_type`
--

CREATE TABLE `account_type` (
  `id` int(3) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสชนิดแอคเคาท์',
  `name` varchar(30) NOT NULL COMMENT 'ชื่อชนิดแอคเคาท์'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บชนิดแอคเคาท์';

--
-- Dumping data for table `account_type`
--

INSERT INTO `account_type` (`id`, `name`) VALUES
(001, 'นักเรียน'),
(002, 'อาจารย์'),
(003, 'เจ้าหน้าที่ทุนปัญญาภิวัฒน์'),
(004, 'เจ้าหน้าที่ กรอ.'),
(005, 'เจ้าหน้าที่ กยศ.'),
(006, 'เจ้าหน้าที่ Brand Ambassador');

-- --------------------------------------------------------

--
-- Table structure for table `activitie`
--

CREATE TABLE `activitie` (
  `id` bigint(18) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสกิจกรรมที่บันทึก',
  `student_have_duty_by_year_class_quarter_id` bigint(15) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นเทอมของแต่ละปี',
  `activitie_type_id` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสชนิดกิจกรรม',
  `status` varchar(20) DEFAULT 'รอการตรวจสอบ' COMMENT 'สถานะกิจกรรม ตรวจสอบแล้ว/ยังไม่ตรวจสอบ',
  `verify_by_account_id` bigint(20) UNSIGNED ZEROFILL DEFAULT NULL COMMENT 'รหัสแอคเคาท์ผู้ตรวจสอบข้อมูลกิจกรรม',
  `date_time` datetime NOT NULL COMMENT 'วันเวลาที่ทำกิจกรรม',
  `duration` int(2) UNSIGNED NOT NULL COMMENT 'ชั่วโมงที่ได้รับ',
  `location` varchar(300) DEFAULT NULL COMMENT 'สถานที่กิจกรรม (เก็บเฉพาะ กรอ กยศ)',
  `hearder` varchar(150) DEFAULT NULL COMMENT 'ชื่อโครงการ/กิจกรรม (เก็บเฉพาะ กรอ กยศ)',
  `detail` varchar(200) NOT NULL COMMENT 'รายละเอียดงาน/กิจกรรม',
  `allowance` int(10) UNSIGNED DEFAULT NULL COMMENT 'เงินตอบแทน (เก็บเฉพาะ Brand Ambassador กิจกรรม)',
  `responsible_agency` varchar(60) DEFAULT NULL COMMENT 'หน่วยงานที่รับผิดชอบ (เก็บเฉพาะ ทุนpim กรอ กยศ)',
  `holder_activitie_name` varchar(150) DEFAULT NULL COMMENT 'ผู้มอบหมายงาน',
  `holder_activitie_phone` varchar(13) DEFAULT NULL COMMENT 'หมายเลขติดต่อผู้มอบหมายงานหรือหน่วยงาน',
  `holder_activitie_email` varchar(100) DEFAULT NULL COMMENT 'อีเมลผู้มอบหมายงานหรือหน่วยงาน',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันที่บันทึกกิจกรรม'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บกิจกรรมนักศึกษา';

-- --------------------------------------------------------

--
-- Table structure for table `activitie_type`
--

CREATE TABLE `activitie_type` (
  `id` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสชนิดกิจกรรม',
  `name` varchar(60) DEFAULT NULL COMMENT 'ชื่อชนิดกิจกรรม'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บชนิดกิจกรรมภายในและภายนอก';

--
-- Dumping data for table `activitie_type`
--

INSERT INTO `activitie_type` (`id`, `name`) VALUES
(1, 'กิจกรรมภายในสภาบัน'),
(2, 'กิจกรรมภายนอกสภาบัน');

-- --------------------------------------------------------

--
-- Table structure for table `address`
--

CREATE TABLE `address` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสที่อยู่',
  `person_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสบุคคลเจ้าของที่อยู่',
  `house_no` varchar(10) DEFAULT NULL COMMENT 'บ้านเลขที่',
  `village_no` varchar(10) DEFAULT NULL COMMENT 'หมู่ที่',
  `alley` varchar(10) DEFAULT NULL COMMENT 'ตรอก',
  `lane` varchar(30) DEFAULT NULL COMMENT 'ซอย',
  `road` varchar(30) DEFAULT NULL COMMENT 'ถนน',
  `sub_district` varchar(50) DEFAULT NULL COMMENT 'ตำบล / แขวง',
  `district` varchar(50) DEFAULT NULL COMMENT 'อำเภอ / เขต',
  `province` varchar(50) NOT NULL COMMENT 'จังหวัด',
  `postal_code` int(5) NOT NULL COMMENT 'รหัสไปรษณีย์'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลที่อยู่';

--
-- Dumping data for table `address`
--

INSERT INTO `address` (`id`, `person_id`, `house_no`, `village_no`, `alley`, `lane`, `road`, `sub_district`, `district`, `province`, `postal_code`) VALUES
(00000000000000000001, 1249900399923, '12/14', NULL, NULL, NULL, 'ราษฏรอุทิศ', 'บางคล้า', 'บางคล้า', 'ฉะเชิงเทรา', 24110);

-- --------------------------------------------------------

--
-- Table structure for table `duty`
--

CREATE TABLE `duty` (
  `id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสภาระหน้าที่',
  `name` varchar(100) NOT NULL COMMENT 'ชื่อภาระหน้าที่'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลภาระหน้าที่';

--
-- Dumping data for table `duty`
--

INSERT INTO `duty` (`id`, `name`) VALUES
(01, 'ทุนปัญญาภิวัฒน์'),
(02, 'ทุน กรอ.'),
(03, 'ทุน กยศ.'),
(04, 'Brand Ambassador อาสา'),
(05, 'Brand Ambassador กิจกรรม'),
(06, 'Brand Ambassador อบรม');

-- --------------------------------------------------------

--
-- Table structure for table `email`
--

CREATE TABLE `email` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสอีเมล',
  `person_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสบุคคลเจ้าของอีเมล',
  `name` varchar(100) DEFAULT NULL COMMENT 'ชื่ออีเมล'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลอีเมล';

--
-- Dumping data for table `email`
--

INSERT INTO `email` (`id`, `person_id`, `name`) VALUES
(00000000000000000001, 1249900399923, 'sirisaknav@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `faculty`
--

CREATE TABLE `faculty` (
  `id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสคณะ',
  `name` varchar(60) DEFAULT NULL COMMENT 'ชื่อคณะ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลคณะ';

--
-- Dumping data for table `faculty`
--

INSERT INTO `faculty` (`id`, `name`) VALUES
(02, 'คณะการจัดการธุรกิจอาหาร'),
(10, 'คณะการจัดการโลจิสติกส์และการคมนาคมขนส่ง'),
(07, 'คณะนวัตกรรมการจัดการเกษตร'),
(05, 'คณะนิเทศศาสตร์'),
(01, 'คณะบริหารธุรกิจ'),
(06, 'คณะวิทยาการจัดการ'),
(04, 'คณะวิศวกรรมศาสตร์และเทคโนโลยี'),
(03, 'คณะศิลปศาสตร์'),
(08, 'คณะศึกษาศาสตร์'),
(09, 'คณะอุตสาหกรรมเกษตร');

-- --------------------------------------------------------

--
-- Table structure for table `image_activitie`
--

CREATE TABLE `image_activitie` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสรูปกิจกรรม',
  `name` varchar(100) DEFAULT NULL COMMENT 'ชื่อรูปกิจกรรม',
  `activitie_id` bigint(18) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสกิจกรรมที่บันทึก'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บรูปภาพกิจกรรม';

-- --------------------------------------------------------

--
-- Table structure for table `info_activitie`
--

CREATE TABLE `info_activitie` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสข่าวสารกิจกรรม',
  `create_by_account_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์ผู้เพิ่มข่าวมสารกิจกรรม',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันเวลาที่เพิ่มข้อมูลข่าวสารกิจกรรม',
  `duty_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสประเภทข่าวสาร',
  `hearder` varchar(60) NOT NULL COMMENT 'ชื่อเรื่องข่าวสารกิจกรรม',
  `detail` varchar(200) NOT NULL COMMENT 'รายละเอียดข่าวสารกิจกรรม',
  `reward_money` int(6) DEFAULT NULL COMMENT 'เงินตอบแทน',
  `reward_hours` int(3) DEFAULT NULL COMMENT 'ชั่วโมงตอบแทน',
  `date_time_start` datetime NOT NULL COMMENT 'วันเวลาเริ่มกิจกรรม',
  `date_time_end` datetime NOT NULL COMMENT 'วันเวลาจบกิจกรรม',
  `location` varchar(200) NOT NULL COMMENT 'สถานที่จัดกิจกรรม',
  `holder_name` varchar(100) NOT NULL COMMENT 'ชื่อผู้จัดกิจกรรม',
  `holder_phone` varchar(15) NOT NULL COMMENT 'หมายเลขโทรศัพท์ผู้จัดเก็บกิจกรรม',
  `person_count` int(3) UNSIGNED DEFAULT '0' COMMENT 'จำนวนผู้สมัครตอนนี้',
  `person_limit` int(3) UNSIGNED DEFAULT NULL COMMENT 'จำนวนผู้สมัครที่เปิดรับ',
  `status` varchar(20) DEFAULT 'เปิดรับสมัคร' COMMENT 'สถานนะข่าวสารกิจกรรม'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลข่าวสารกิจกรรม';

-- --------------------------------------------------------

--
-- Table structure for table `info_activitie_has_account`
--

CREATE TABLE `info_activitie_has_account` (
  `info_activitie_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสข่าวสารกิจกรรม',
  `account_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันที่ลงสมัครข่าวสารกิจกรรม'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บการสมัครเข้ากิจกรรม';

-- --------------------------------------------------------

--
-- Table structure for table `major`
--

CREATE TABLE `major` (
  `id` int(4) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสสาขา',
  `faculty_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'อยู่ในสังกัดคณะ',
  `name` varchar(60) DEFAULT NULL COMMENT 'ชื่อสาขา'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตางรางจัดเก็บข้อมูลสาขา';

--
-- Dumping data for table `major`
--

INSERT INTO `major` (`id`, `faculty_id`, `name`) VALUES
(0101, 01, 'สาขาวิชาการจัดการธุรกิจการค้าสมัยใหม่'),
(0201, 02, 'สาขาวิชาการการจัดการธุรกิจอาหาร'),
(0202, 02, 'สาขาวิชาการการจัดการธุรภัตตาคาร'),
(0301, 03, 'สาขาวิชาภาษาจีนธุรกิจ'),
(0302, 03, 'สาขาวิชาภาษาญี่ปุ่นธุรกิจ'),
(0303, 03, 'สาขาวิชาภาษาอังกฤษเพื่อการสื่อสารทางธุรกิจ'),
(0401, 04, 'สาขาเทคโนโลยีสารสนเทศ'),
(0402, 04, 'สาขาวิศวกรรมคอมพิวเตอร์'),
(0403, 04, 'สาขาวิศวกรรมอุตสาหการ'),
(0404, 04, 'สาขาวิศวกรรมการผลิตยานยนต์'),
(0405, 04, 'สาขาวิชาวิศวกรรมหุ่นยนต์และระบบอัตโนมัติ'),
(0501, 05, 'สาขาวิชาเอกการสื่อสารองค์กรและแบรนด์'),
(0502, 05, 'สาขาวิชาเอกวารสารศาสตร์คอนเวอร์เจ้นท์'),
(0601, 06, 'สาขาวิชาการจัดการอสังหาริมทรัพย์และทรัพยากรอาคาร'),
(0602, 06, 'สาขาวิชาการบริหารคนและองค์การ'),
(0603, 06, 'สาขาวิชาการจัดการโรงแรมและการท่องเที่ยว'),
(0604, 06, 'สาขาวิชาการจัดการธุรกิจการบิน'),
(0701, 07, 'สาขาวิชานวัตกรรมการจัดการเกษตร'),
(0801, 08, 'สาขาวิชาการสอนภาษาจีน'),
(0802, 08, 'สาขาวิชาการสอนภาษาอังกฤษ'),
(0901, 09, 'สาขาวิชาการจัดการเทคโนโลยีฟาร์ม'),
(0902, 09, 'สาขาวิชาการจัดการเทคโนโลยีแปรรูปอาหาร'),
(1001, 10, 'สาขาวิชาการจัดการโลจิสติกส์และการคมนาคมขนส่ง');

-- --------------------------------------------------------

--
-- Table structure for table `message`
--

CREATE TABLE `message` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสข้อความ',
  `create_by_account_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์ผู้เขียนข้อความ',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันที่สร้างข้อความ',
  `header` varchar(60) NOT NULL COMMENT 'หัวข้อข้อความ',
  `body` varchar(200) NOT NULL COMMENT 'เนื้อหาข้อความ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลข้อความ';

-- --------------------------------------------------------

--
-- Table structure for table `message_has_account`
--

CREATE TABLE `message_has_account` (
  `message_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสข้อความ',
  `account_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์',
  `status` varchar(20) DEFAULT 'ยังไม่เปิดอ่าน' COMMENT 'สถานะข้อตวาม เช่น เปิดอ่านแล้ว',
  `update_date` datetime DEFAULT CURRENT_TIMESTAMP COMMENT 'วันที่เปลี่ยนแปลงสถานะข้อความ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อความของแอคเคาท์';

-- --------------------------------------------------------

--
-- Table structure for table `news`
--

CREATE TABLE `news` (
  `id` int(10) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสข่าวสาร',
  `create_by_account_id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสแอคเคาท์ผู้สร้างข่าวสาร',
  `create_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'วันเวลาที่เพิ่มข้อมูลข่าวสาร',
  `duty_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสประเภทข่าวสาร',
  `hearder` varchar(60) NOT NULL COMMENT 'ชื่อเรื่องข่าวสาร',
  `detail` varchar(200) NOT NULL COMMENT 'รายละเอียดข่าวสาร'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข่าวสารจากแอดมิน';

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสบัตรประชาชน',
  `first_name` varchar(60) NOT NULL COMMENT 'ชื่อจริง',
  `last_name` varchar(60) NOT NULL COMMENT 'นามสกุล',
  `birth_date` date NOT NULL COMMENT 'วันเกิด',
  `picture` bigint(20) DEFAULT NULL COMMENT 'รหัสรูปภาพ'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลส่วนบุคคล';

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`id`, `first_name`, `last_name`, `birth_date`, `picture`) VALUES
(1111111111111, 'พรสิริ', 'ทดสอบ', '1985-02-21', NULL),
(1249900399923, 'ศิริศักดิ์', 'นวนิตย์วรานนท์', '1996-02-21', NULL),
(2222222222222, 'เจ้าหน้าที่ทุนpim', 'ทดสอบ', '1987-02-21', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `phone`
--

CREATE TABLE `phone` (
  `id` bigint(20) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสหมายเลขโทรศัพท์',
  `person_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสบุคคลเจ้าของอีเมล',
  `number` varchar(16) NOT NULL COMMENT 'หมายเลขโทรศัพท์'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลเบอร์โทรศัพท์';

--
-- Dumping data for table `phone`
--

INSERT INTO `phone` (`id`, `person_id`, `number`) VALUES
(00000000000000000001, 1249900399923, '0882166230');

-- --------------------------------------------------------

--
-- Table structure for table `quarter`
--

CREATE TABLE `quarter` (
  `id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสเทอม',
  `name` varchar(45) NOT NULL COMMENT 'ชื่อเทอม'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลเทอม';

--
-- Dumping data for table `quarter`
--

INSERT INTO `quarter` (`id`, `name`) VALUES
(01, 'เทอม pre'),
(11, 'เทอม 1.1'),
(12, 'เทอม 1.2'),
(21, 'เทอม 2.1'),
(22, 'เทอม 2.2');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `id` bigint(10) UNSIGNED NOT NULL COMMENT 'รหัสนักศึกษา',
  `major_id` int(3) UNSIGNED ZEROFILL NOT NULL COMMENT 'นักศึกษาอยู่ในสังกัดสาขา',
  `person_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'ข้อมูลบุคคล',
  `adviser_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสบุคคลอาจารย์ที่ปรึกษา',
  `year_class_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสระดับชั้นปี'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลนักศึกษา';

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`id`, `major_id`, `person_id`, `adviser_id`, `year_class_id`) VALUES
(5852100081, 401, 1249900399923, 1111111111111, 03);

-- --------------------------------------------------------

--
-- Table structure for table `student_have_duty`
--

CREATE TABLE `student_have_duty` (
  `id` bigint(12) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสจัดเก็บข้อมูลนักศึกษาที่ผูกกับภาระหน้าทื่',
  `student_id` bigint(10) UNSIGNED NOT NULL COMMENT 'รหัสนักศึกษา',
  `duty_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสภาระหน้าที่'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลนักศึกษาที่ผูกกับภาระหน้าทื่';

--
-- Dumping data for table `student_have_duty`
--

INSERT INTO `student_have_duty` (`id`, `student_id`, `duty_id`) VALUES
(585210008101, 5852100081, 01);

-- --------------------------------------------------------

--
-- Table structure for table `student_have_duty_by_year_class`
--

CREATE TABLE `student_have_duty_by_year_class` (
  `id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นปี',
  `student_have_duty_id` bigint(12) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสจัดเก็บข้อมูลนักศึกษาที่ผูกกับภาระหน้าทื่',
  `year_class_id` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสระดับชั้นปี',
  `limit_per_study_level` int(3) DEFAULT '0' COMMENT 'ข้อกำหนดต่อปีที่นักศึกษาต้องทำหน่วยเป็นชั่วโมง',
  `status` varchar(20) DEFAULT 'ว่าง' COMMENT 'สถานะ ผ่านไม่ผ่าน'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นปี';

--
-- Dumping data for table `student_have_duty_by_year_class`
--

INSERT INTO `student_have_duty_by_year_class` (`id`, `student_have_duty_id`, `year_class_id`, `limit_per_study_level`, `status`) VALUES
(5852100081011, 585210008101, 1, 60, 'ผ่าน'),
(5852100081012, 585210008101, 2, 60, 'ผ่าน'),
(5852100081013, 585210008101, 3, 0, 'ว่าง'),
(5852100081014, 585210008101, 4, 0, 'ว่าง');

-- --------------------------------------------------------

--
-- Table structure for table `student_have_duty_by_year_class_quarter`
--

CREATE TABLE `student_have_duty_by_year_class_quarter` (
  `id` bigint(15) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสที่จัดเก็บข้อมูล',
  `student_have_duty_by_year_class_id` bigint(13) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นปี',
  `quarter_id` int(2) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสเทอม',
  `can_do` int(3) DEFAULT '0' COMMENT 'ชั่วโมงที่สามารถจัดเก็บได้',
  `average_per_quarter` int(3) UNSIGNED DEFAULT '0' COMMENT 'ข้อกำหนดต่อเทอมที่นักศึกษาต้องทำหน่วยเป็นชั่วโมง',
  `status` varchar(20) DEFAULT 'ว่าง' COMMENT 'สถานะผ่านไม่ผ่าน'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นเทอมของแต่ละปี';

--
-- Dumping data for table `student_have_duty_by_year_class_quarter`
--

INSERT INTO `student_have_duty_by_year_class_quarter` (`id`, `student_have_duty_by_year_class_id`, `quarter_id`, `can_do`, `average_per_quarter`, `status`) VALUES
(585210008101101, 5852100081011, 01, 12, 12, 'ผ่าน'),
(585210008101111, 5852100081011, 11, 12, 12, 'ผ่าน'),
(585210008101112, 5852100081011, 12, 12, 12, 'ผ่าน'),
(585210008101121, 5852100081011, 21, 12, 12, 'ผ่าน'),
(585210008101122, 5852100081011, 22, 12, 12, 'ผ่าน'),
(585210008101211, 5852100081012, 11, 15, 15, 'ผ่าน'),
(585210008101212, 5852100081012, 12, 15, 15, 'ผ่าน'),
(585210008101221, 5852100081012, 21, 15, 15, 'ผ่าน'),
(585210008101222, 5852100081012, 22, 15, 15, 'ผ่าน'),
(585210008101311, 5852100081013, 11, 0, 0, 'ว่าง'),
(585210008101312, 5852100081013, 12, 0, 0, 'ว่าง'),
(585210008101321, 5852100081013, 21, 0, 0, 'ว่าง'),
(585210008101322, 5852100081013, 22, 0, 0, 'ว่าง'),
(585210008101411, 5852100081014, 11, 0, 0, 'ว่าง'),
(585210008101412, 5852100081014, 12, 0, 0, 'ว่าง'),
(585210008101421, 5852100081014, 21, 0, 0, 'ว่าง'),
(585210008101422, 5852100081014, 22, 0, 0, 'ว่าง');

-- --------------------------------------------------------

--
-- Table structure for table `year_class`
--

CREATE TABLE `year_class` (
  `id` int(1) UNSIGNED ZEROFILL NOT NULL COMMENT 'รหัสระดับชั้นปี',
  `name` varchar(45) NOT NULL COMMENT 'ชื่อระดับชั้นปี'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='ตารางจัดเก็บข้อมูลระดับชั้นปี';

--
-- Dumping data for table `year_class`
--

INSERT INTO `year_class` (`id`, `name`) VALUES
(1, 'ชั้นปีที่ 1'),
(2, 'ชั้นปีที่ 2'),
(3, 'ชั้นปีที่ 3'),
(4, 'ชั้นปีที่ 4');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `account`
--
ALTER TABLE `account`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD KEY `fk_account_person1_idx` (`person_id`),
  ADD KEY `fk_account_account_type1_idx` (`account_type_id`);

--
-- Indexes for table `account_type`
--
ALTER TABLE `account_type`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `activitie`
--
ALTER TABLE `activitie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_activitie_student_have_duty_by_year_class_quarter1_idx` (`student_have_duty_by_year_class_quarter_id`),
  ADD KEY `fk_activitie_activitie_type1_idx` (`activitie_type_id`),
  ADD KEY `fk_activitie_account1_idx` (`verify_by_account_id`);

--
-- Indexes for table `activitie_type`
--
ALTER TABLE `activitie_type`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `address`
--
ALTER TABLE `address`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_address_person1_idx` (`person_id`);

--
-- Indexes for table `duty`
--
ALTER TABLE `duty`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `email`
--
ALTER TABLE `email`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_email_person1_idx` (`person_id`);

--
-- Indexes for table `faculty`
--
ALTER TABLE `faculty`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`);

--
-- Indexes for table `image_activitie`
--
ALTER TABLE `image_activitie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_image_activitie_activitie1_idx` (`activitie_id`);

--
-- Indexes for table `info_activitie`
--
ALTER TABLE `info_activitie`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_info_activitie_account1_idx` (`create_by_account_id`),
  ADD KEY `fk_info_activitie_duty1_idx` (`duty_id`);

--
-- Indexes for table `info_activitie_has_account`
--
ALTER TABLE `info_activitie_has_account`
  ADD PRIMARY KEY (`info_activitie_id`,`account_id`),
  ADD KEY `fk_info_activitie_has_account_account1_idx` (`account_id`),
  ADD KEY `fk_info_activitie_has_account_info_activitie1_idx` (`info_activitie_id`);

--
-- Indexes for table `major`
--
ALTER TABLE `major`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD UNIQUE KEY `name_UNIQUE` (`name`),
  ADD KEY `fk_major_faculty_idx` (`faculty_id`);

--
-- Indexes for table `message`
--
ALTER TABLE `message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_message_account1_idx` (`create_by_account_id`);

--
-- Indexes for table `message_has_account`
--
ALTER TABLE `message_has_account`
  ADD PRIMARY KEY (`message_id`,`account_id`),
  ADD KEY `fk_message_has_account_account1_idx` (`account_id`),
  ADD KEY `fk_message_has_account_message1_idx` (`message_id`);

--
-- Indexes for table `news`
--
ALTER TABLE `news`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_news_account1_idx` (`create_by_account_id`),
  ADD KEY `fk_news_duty1_idx` (`duty_id`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`);

--
-- Indexes for table `phone`
--
ALTER TABLE `phone`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_phone_person1_idx` (`person_id`);

--
-- Indexes for table `quarter`
--
ALTER TABLE `quarter`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_student_major1_idx` (`major_id`),
  ADD KEY `fk_student_person1_idx` (`person_id`),
  ADD KEY `fk_student_person2_idx` (`adviser_id`),
  ADD KEY `fk_student_year_class1_idx` (`year_class_id`);

--
-- Indexes for table `student_have_duty`
--
ALTER TABLE `student_have_duty`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_student_have_duty_student1_idx` (`student_id`),
  ADD KEY `fk_student_have_duty_duty1_idx` (`duty_id`);

--
-- Indexes for table `student_have_duty_by_year_class`
--
ALTER TABLE `student_have_duty_by_year_class`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `idstudent_have_duty_by_year_class_UNIQUE` (`id`),
  ADD KEY `fk_student_have_duty_by_year_class_student_have_duty1_idx` (`student_have_duty_id`),
  ADD KEY `fk_student_have_duty_by_year_class_year_class1_idx` (`year_class_id`);

--
-- Indexes for table `student_have_duty_by_year_class_quarter`
--
ALTER TABLE `student_have_duty_by_year_class_quarter`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `id_UNIQUE` (`id`),
  ADD KEY `fk_student_have_duty_by_year_class_quarter_student_have_dut_idx` (`student_have_duty_by_year_class_id`),
  ADD KEY `fk_student_have_duty_by_year_class_quarter_quarter1_idx` (`quarter_id`);

--
-- Indexes for table `year_class`
--
ALTER TABLE `year_class`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `account`
--
ALTER TABLE `account`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสแอคเคาท์', AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `account_type`
--
ALTER TABLE `account_type`
  MODIFY `id` int(3) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสชนิดแอคเคาท์', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `activitie`
--
ALTER TABLE `activitie`
  MODIFY `id` bigint(18) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสกิจกรรมที่บันทึก';

--
-- AUTO_INCREMENT for table `activitie_type`
--
ALTER TABLE `activitie_type`
  MODIFY `id` int(1) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสชนิดกิจกรรม', AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `address`
--
ALTER TABLE `address`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสที่อยู่', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `duty`
--
ALTER TABLE `duty`
  MODIFY `id` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสภาระหน้าที่', AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `email`
--
ALTER TABLE `email`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสอีเมล', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `faculty`
--
ALTER TABLE `faculty`
  MODIFY `id` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสคณะ', AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `image_activitie`
--
ALTER TABLE `image_activitie`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสรูปกิจกรรม';

--
-- AUTO_INCREMENT for table `info_activitie`
--
ALTER TABLE `info_activitie`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสข่าวสารกิจกรรม';

--
-- AUTO_INCREMENT for table `message`
--
ALTER TABLE `message`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสข้อความ';

--
-- AUTO_INCREMENT for table `news`
--
ALTER TABLE `news`
  MODIFY `id` int(10) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสข่าวสาร';

--
-- AUTO_INCREMENT for table `phone`
--
ALTER TABLE `phone`
  MODIFY `id` bigint(20) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสหมายเลขโทรศัพท์', AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `quarter`
--
ALTER TABLE `quarter`
  MODIFY `id` int(2) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสเทอม', AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `student_have_duty_by_year_class`
--
ALTER TABLE `student_have_duty_by_year_class`
  MODIFY `id` bigint(13) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสจัดเก็บข้อมูลชั่วโมงนักศึกษาที่ผูกกับภาระหน้าทื่แยกเป็นปี', AUTO_INCREMENT=2147483647;

--
-- AUTO_INCREMENT for table `student_have_duty_by_year_class_quarter`
--
ALTER TABLE `student_have_duty_by_year_class_quarter`
  MODIFY `id` bigint(15) UNSIGNED ZEROFILL NOT NULL AUTO_INCREMENT COMMENT 'รหัสที่จัดเก็บข้อมูล', AUTO_INCREMENT=2147483647;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `account`
--
ALTER TABLE `account`
  ADD CONSTRAINT `fk_account_account_type1` FOREIGN KEY (`account_type_id`) REFERENCES `account_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_account_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `activitie`
--
ALTER TABLE `activitie`
  ADD CONSTRAINT `fk_activitie_account1` FOREIGN KEY (`verify_by_account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_activitie_activitie_type1` FOREIGN KEY (`activitie_type_id`) REFERENCES `activitie_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_activitie_student_have_duty_by_year_class_quarter1` FOREIGN KEY (`student_have_duty_by_year_class_quarter_id`) REFERENCES `student_have_duty_by_year_class_quarter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `address`
--
ALTER TABLE `address`
  ADD CONSTRAINT `fk_address_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `email`
--
ALTER TABLE `email`
  ADD CONSTRAINT `fk_email_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `image_activitie`
--
ALTER TABLE `image_activitie`
  ADD CONSTRAINT `fk_image_activitie_activitie1` FOREIGN KEY (`activitie_id`) REFERENCES `activitie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `info_activitie`
--
ALTER TABLE `info_activitie`
  ADD CONSTRAINT `fk_info_activitie_account1` FOREIGN KEY (`create_by_account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_info_activitie_duty1` FOREIGN KEY (`duty_id`) REFERENCES `duty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `info_activitie_has_account`
--
ALTER TABLE `info_activitie_has_account`
  ADD CONSTRAINT `fk_info_activitie_has_account_account1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_info_activitie_has_account_info_activitie1` FOREIGN KEY (`info_activitie_id`) REFERENCES `info_activitie` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `major`
--
ALTER TABLE `major`
  ADD CONSTRAINT `fk_major_faculty` FOREIGN KEY (`faculty_id`) REFERENCES `faculty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `message`
--
ALTER TABLE `message`
  ADD CONSTRAINT `fk_message_account1` FOREIGN KEY (`create_by_account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `message_has_account`
--
ALTER TABLE `message_has_account`
  ADD CONSTRAINT `fk_message_has_account_account1` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_message_has_account_message1` FOREIGN KEY (`message_id`) REFERENCES `message` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `news`
--
ALTER TABLE `news`
  ADD CONSTRAINT `fk_news_account1` FOREIGN KEY (`create_by_account_id`) REFERENCES `account` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_news_duty1` FOREIGN KEY (`duty_id`) REFERENCES `duty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `phone`
--
ALTER TABLE `phone`
  ADD CONSTRAINT `fk_phone_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `fk_student_major1` FOREIGN KEY (`major_id`) REFERENCES `major` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_person1` FOREIGN KEY (`person_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_person2` FOREIGN KEY (`adviser_id`) REFERENCES `person` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_year_class1` FOREIGN KEY (`year_class_id`) REFERENCES `year_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student_have_duty`
--
ALTER TABLE `student_have_duty`
  ADD CONSTRAINT `fk_student_have_duty_duty1` FOREIGN KEY (`duty_id`) REFERENCES `duty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_have_duty_student1` FOREIGN KEY (`student_id`) REFERENCES `student` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student_have_duty_by_year_class`
--
ALTER TABLE `student_have_duty_by_year_class`
  ADD CONSTRAINT `fk_student_have_duty_by_year_class_student_have_duty1` FOREIGN KEY (`student_have_duty_id`) REFERENCES `student_have_duty` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_have_duty_by_year_class_year_class1` FOREIGN KEY (`year_class_id`) REFERENCES `year_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `student_have_duty_by_year_class_quarter`
--
ALTER TABLE `student_have_duty_by_year_class_quarter`
  ADD CONSTRAINT `fk_student_have_duty_by_year_class_quarter_quarter1` FOREIGN KEY (`quarter_id`) REFERENCES `quarter` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_student_have_duty_by_year_class_quarter_student_have_duty_1` FOREIGN KEY (`student_have_duty_by_year_class_id`) REFERENCES `student_have_duty_by_year_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
