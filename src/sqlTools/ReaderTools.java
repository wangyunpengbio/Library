package sqlTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import database.DatabaseTools;
import model.Reader;

public class ReaderTools {
	/**
	 * 
	 * @param idReader
	 * @return 返回特定编号的读者，List<Reader>，获得查找到的对象，存在Java类集list中，并返回list。
	 */
	public List<Reader> ReaderData(String idReader) {
		String sql = "select idReader,nameReader,kind,sex,password from Reader where idReader =" + idReader + "";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * 
	 * @param idReader
	 * @return 返回特定编号的读者，List<Reader>，获得查找到的对象，存在Java类集list中，并返回list。
	 */
	public List<Reader> ReaderDataSearch(String nameReader) {
		String sql = "select idReader,nameReader,kind,sex,password from Reader where nameReader like'%" + nameReader
				+ "%'";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * 
	 * @param idReader
	 * @return 返回全部读者，List<Reader>，获得查找到的对象，存在Java类集list中，并返回list。
	 * 
	 */
	public List<Reader> ReaderData() {
		String sql = "select idReader,nameReader,kind,sex,password from Reader";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		ResultSet rs = null;
		List<Reader> ls = new ArrayList<Reader>();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			rs = st.executeQuery(sql);
			while (rs.next()) {
				Reader reader = new Reader();
				reader.setIdReader(rs.getString("idReader"));
				reader.setNameReader(rs.getString("nameReader"));
				reader.setType(rs.getString("kind"));
				reader.setSex(rs.getString("sex"));
				reader.setPassword(rs.getString("password"));
				ls.add(reader);
			}
			rs.close();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ls;
	}

	/**
	 * @category Reader
	 * @param idReader
	 * @param password
	 * @return 验证用户名和密码是否正确，正确返回True，错误返回False
	 * 
	 */
	public boolean ReaderLogin(String idReader, String password) {
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			String sql = "select idReader,password from reader where idReader='" + idReader + "' and password='"
					+ password + "'";
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery(sql);
			if (rs.next()) {
				return true;
			}
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	/**
	 * 
	 * @param reader
	 * @return 进行数据插入操作，插入对应的Reader对象。 返回值： (1) SQL 数据操作语言 (DML) 语句的行数 (2)
	 *         对于无返回内容的 SQL 语句，返回 0
	 */
	public int AddReader(Reader reader) {
		int i = 0;
		String sql = "insert into reader (idReader,nameReader,kind,sex,password)values(?,?,?,?,?)";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getIdReader());
			st.setString(2, reader.getNameReader());
			st.setString(3, reader.getType());
			st.setString(4, reader.getSex());
			st.setString(5, reader.getPassword());
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @param reader
	 * @return 进行数据更新操作，更新对应的Reader对象。 返回值： (1) SQL 数据操作语言 (DML) 语句的行数 (2)
	 *         对于无返回内容的 SQL 语句，返回 0
	 */
	public int UpdateReader(Reader reader) {
		int i = 0;
		String sql = "update reader set idReader=?,nameReader=?,kind=?,sex=?,password=? where idReader=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, reader.getIdReader());
			st.setString(2, reader.getNameReader());
			st.setString(3, reader.getType());
			st.setString(4, reader.getSex());
			st.setString(5, reader.getPassword());
			st.setString(6, reader.getIdReader());
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}

	/**
	 * 
	 * @param reader
	 * @return 进行数据删除操作，删除对应的Reader对象。 返回值： (1) SQL 数据操作语言 (DML) 语句的行数 (2)
	 *         对于无返回内容的 SQL 语句，返回 0
	 */
	public int DeleteReader(String idreader) {
		int i = 0;
		String sql = "delete from reader where idReader=?";
		DatabaseTools db = new DatabaseTools();
		Connection conn = db.getConn();
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, idreader);
			i = st.executeUpdate();
			st.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return i;
	}
}
