package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * 
 * @author lygwangyp
 * @return 取得数据库的连接
 */
public class DatabaseTools {
	public Connection conn=null;
	public Connection getConn() {
		try {
			Class.forName("org.gjt.mm.mysql.Driver");					//定义MySQL的数据库驱动程序
			String DBURL= "jdbc:mysql://localhost:3306/library?useUnicode=true&characterEncoding=utf-8&useSSL=false";		//定义MySQL的数据库连接地址
			String DBUSER = "root";										//MySQL数据库的连接用户名
			String DBPASS = "root";										//MySQL数据库的连接密码
			conn=DriverManager.getConnection(DBURL, DBUSER, DBPASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
