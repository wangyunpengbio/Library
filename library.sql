# Host: localhost  (Version: 5.7.10-log)
# Date: 2016-01-05 13:07:03
# Generator: MySQL-Front 5.3  (Build 4.271)

/*!40101 SET NAMES utf8 */;

#
# Structure for table "author"
#

DROP TABLE IF EXISTS `author`;
CREATE TABLE `author` (
  `name` varchar(10) NOT NULL DEFAULT '',
  `workplace` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "author"
#

INSERT INTO `author` VALUES ('书雁','北京'),('仁毅','上海'),('向南','武汉'),('含巧','天津'),('奥然','重庆'),('如冬','大连'),('寒云','盐城'),('山彤','南京'),('张爱玲','北京'),('思乐','北京'),('李娜','北京'),('潇晗','上海');

#
# Structure for table "librarian"
#

DROP TABLE IF EXISTS `librarian`;
CREATE TABLE `librarian` (
  `nameUser` varchar(10) NOT NULL DEFAULT '',
  `password` varchar(10) NOT NULL DEFAULT 'root'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "librarian"
#

INSERT INTO `librarian` VALUES ('root','root'),('wangyp','123456');

#
# Structure for table "publisher"
#

DROP TABLE IF EXISTS `publisher`;
CREATE TABLE `publisher` (
  `name` varchar(20) NOT NULL DEFAULT '',
  `address` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "publisher"
#

INSERT INTO `publisher` VALUES ('中信出版社','上海'),('人民出版社','北京'),('华夏出版社','武汉'),('商务印书出版社','天津'),('机械工业出版社','上海'),('清华大学出版社','北京'),('百花文艺出版社','武汉');

#
# Structure for table "book"
#

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `idBook` varchar(10) NOT NULL DEFAULT '',
  `nameBook` varchar(15) DEFAULT NULL,
  `price` int(4) DEFAULT NULL,
  `kind` varchar(8) DEFAULT NULL,
  `author` varchar(10) NOT NULL DEFAULT '',
  `publisher` varchar(20) NOT NULL DEFAULT '',
  PRIMARY KEY (`idBook`),
  KEY `namePublisher` (`publisher`),
  KEY `nameAuthor` (`author`),
  CONSTRAINT `nameAuthor` FOREIGN KEY (`author`) REFERENCES `author` (`name`),
  CONSTRAINT `namePublisher` FOREIGN KEY (`publisher`) REFERENCES `publisher` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "book"
#

INSERT INTO `book` VALUES ('001','周易',23,'文学','山彤','商务印书出版社'),('002','诗经',35,'文学','寒云','华夏出版社'),('003','论语',25,'文学','书雁','中信出版社'),('004','纯粹理性批判',47,'哲学','向南','商务印书出版社'),('005','资本论',26,'哲学','仁毅','人民出版社'),('006','围城',18,'小说','思乐','人民出版社'),('007','共产党宣言',35,'哲学','潇晗','中信出版社'),('008','物种起源',39,'科学','奥然','商务印书出版社'),('009','Java开发实战经典',79,'教材','如冬','清华大学出版社'),('010','数据库实用教程',35,'教材','含巧','清华大学出版社'),('011','Java语言程序设计',65,'教材','李娜','机械工业出版社'),('012','倾城之恋',18,'文学','张爱玲','百花文艺出版社'),('013','孟子',36,'文学','山彤','商务印书出版社');

#
# Structure for table "reader"
#

DROP TABLE IF EXISTS `reader`;
CREATE TABLE `reader` (
  `idReader` varchar(10) NOT NULL DEFAULT '',
  `nameReader` varchar(10) DEFAULT NULL,
  `kind` varchar(6) DEFAULT '学生',
  `sex` varchar(4) NOT NULL DEFAULT '男',
  `password` varchar(10) NOT NULL DEFAULT 'root',
  PRIMARY KEY (`idReader`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "reader"
#

INSERT INTO `reader` VALUES ('001','初灵','学生','女','root'),('002','香晴','学生','女','root'),('003','雪丹','学生','女','root'),('004','秋竹','学生','女','root'),('005','雁雪','学生','女','root'),('006','浩宇','学生','男','root'),('007','永剑','学生','男','root'),('008','智萌','学生','男','root'),('009','传豪','教师','男','root'),('010','乐伶','教师','女','root');

#
# Structure for table "borrow"
#

DROP TABLE IF EXISTS `borrow`;
CREATE TABLE `borrow` (
  `idReader` varchar(10) NOT NULL DEFAULT '',
  `idBook` varchar(10) DEFAULT NULL,
  `lendDate` date NOT NULL DEFAULT '2015-07-25',
  `dueDate` date NOT NULL DEFAULT '2015-12-19',
  `overtime` varchar(4) NOT NULL DEFAULT '否',
  UNIQUE KEY `idBook` (`idBook`),
  KEY `idReader` (`idReader`),
  CONSTRAINT `Book` FOREIGN KEY (`idBook`) REFERENCES `book` (`idBook`),
  CONSTRAINT `Reader` FOREIGN KEY (`idReader`) REFERENCES `reader` (`idReader`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

#
# Data for table "borrow"
#

INSERT INTO `borrow` VALUES ('001','001','2016-01-01','2016-01-01','否'),('002','006','2016-01-01','2016-03-01','否'),('007','011','2016-01-01','2016-03-01','否'),('001','005','2016-01-02','2016-03-02','否');
