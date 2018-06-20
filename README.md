# 图书管理系统

设计人：wangyunpeng_bio

## 项目需求 ##
随着计算机的普及和应用水平的提高，经过考察比较，决定利用自己的Java知识开发小型的图书管理系统，方便图书的管理。
图书管理系统是典型的信息管理系统。本次作业利用JAVA开发工具Eclipse和MySQL数据库来开发这个图书管理系统。该系统要解决的图书管理所要解决的问题，可以满足图书管理基本要求，包括添加、管理等功能。该系统能根据用户的需求，快捷方便的为读者提供借阅服务
图书管理系统应有以下功能：
1.	读者库管理
2.	书库管理
3.	借阅管理
4.	读者信息查询

图书管理系统主要针对书库的操作功能、所以系统应尽量满足需求、同时亦不可有多余或繁复的功能、令系统的操作和功能混乱。

## 需求分析 ##

### A.业务流程： ###

No.|业务流程|需求
--- |---|---
1.|图书管理员登入系统|图书管理员需使用账号和密码登入。
2.|新增读者资料|新增读者资料，如姓名、性别、职位等。
3.|新增书籍资料|新增书籍资料，如书名、价格、种类等。
4.|读者库管理|选中读者库里的读者信息，即可更新和删除。
5.|书库管理|可以按“书编号查询”和“书名模糊查询”，继而选中书籍信息，即可更新和删除书籍分为在库和借出
6|借阅管理|输入读者编号，即可检阅读者的数据和借阅的图书，检阅顾客的数据和购买纪录。
7.|读者登入系统|读者需使用账号和密码登入。
8|借书|按书名模糊搜索，选中即可借阅图书
9|还书|检阅自己的读者信息以及已经借阅的图书，点击归还即可，不允许更改或删除读者数据，只允许查询，更改和删除功能由管理员负责。


**以下是使用 实体联系模型-Entity Relationship来分析。**

### B.归纳实体和属性 ###

No.|业务流程|对应的实体|实体的属性值
---|---|---|---
1.|图书管理员登入系统|Librarian|nameUser password
2.|新增读者资料|Reader|idReader nameReader kind sex password
3.|新增书籍资料|Book Author Publisher|idBook,nameBook,price,kind,author,publisher Author.name, Author.workplace Publisher.name, Publisher.address
4.|读者库管理|Reader|idReader nameReader kind sex password
5.|书库管理|Book|idBook nameBook price kind autor publisher
6.|借阅管理|Borrow|idReader idBook lendDate dueDate overtime
7.|读者登入系统|Reader|idReader password
8|借书|Borrow|idReader idBook lendDate dueDate overtime
9|还书|Borrow|idReader idBook lendDate dueDate overtime



### C.实体的模型 ###
![实体的模型](https://i.imgur.com/JIJH9tQ.jpg)

### D.ER-实体关系 ###
Author,Publisher To Book&Borrow&Reader To Librarian
![实体的联系](https://i.imgur.com/pEk2Ezb.jpg)

## 设计 ##
项目文件夹中，（代码总计：4800+行）
doc文件夹存放着生成的文档注释，可点击其中的index文件查看整个项目的注释

Src包下面含有五个包
- Database用于存储数据库连接操作
- Frame用于存储各个窗体界面
- Model用于存储各个实体（表）对应的数据模型
- Out_of_date用于存储初始时候写的界面，后来舍弃，不再调用。
- SqlTools用于存储操作数据库的增删改查方法

image文件夹用于存放相关的界面图片，按钮图片
备注：程序不同界面的入口已经全部注释掉了，MainFrame是程序的唯一入口

程序细节设计：
1. 登陆界面的密码回显，伴有跳转动画（此处利用了多线程，控制线程存活时间）
2. 表格直接选中即可修改数据，更新数据时候默认有原始数据，可按不同方式搜索图书；
3. 新增借阅信息时候，自动加入当前时间，并计算归还时间。（SQL函数NOW()）
4. 界面按钮，背景用Photoshop的重新设计，图形用户界面友好；
5. 数据库设计达到第三范式，去除了所有非主属性对任何候选关键字的传递信依赖，冗余度低。
6. 变量和方法命名符合规范，可读性强
7. 不同的Model实体（表）对应不同的SqlTools操作，分开存放，程序复用性好，易扩展。
使用
1. 将SQL语句导入，**字符集选utf8**，不然有可能显示不了中文，数据库名称为library
`create database library;`
2. 推荐使用Mysql Front这个MySQL的前台，支持多句sql语句一起执行，百度第一个链接即可下载。
http://dlsw.baidu.com/sw-search-sp/soft/6c/17997/MySQL-Front_V5.3.4.214_Setup.1435658094.exe
3. Java环境中加入数据库的驱动，源程序里`database`包里`DatabaseTools.java`文件是有关**数据库连接的操作**，**源程序的用户名和密码皆为root，数据库名为：library**不同电脑上运行需要稍微改一下这个代码。
4. **登陆：**
**图书管理员：用户名root密码 root**或者wangyp密码123456
**读者：用户名001密码 root **（注：数据库内读者的密码初始值皆为root）
5. 在不同计算机上Eclipse使用，可能需要重新建立Java类库的路径
本程序用1.8的jdk写的，所以最好用1.8的jre。
代码放在1.8下面运行，连警告都不会出现，1.7和1.6显示效果不好。
awt 和 swing 都依赖虚拟机的具体实现。所以不同平台表现不大一样。如果用javafx，界面才可以移植。
而且编写用的笔记本电脑是高分屏，在本机上显示大小是正好的，到别的电脑上面有可能会出现界面过大的情况。
6. 具体的文档注释已经生成，打开doc文件夹其中的index文件查看整个项目的注释
![运行效果图](https://i.imgur.com/rZF0pXM.png)
