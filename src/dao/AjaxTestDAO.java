package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Ajaxテスト用パターンマッチDAOクラス
 */
public class AjaxTestDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sample";

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	/**
	 * データベース接続して文字列絞り込み検索する
	 * @param checkWord 絞り込み検索対象の文字列
	 * @return 合致した文字列群
	 */
	public List<String> selectChackWord(String checkWord) {

		List<String> list = new ArrayList<>();

		try {

			Class.forName(JDBC_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "SELECT * FROM test1 WHERE name LIKE \'%" + checkWord + "%\'";
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();

			while(rs.next()) {

				list.add(rs.getString("name"));

			}

		} catch(ClassNotFoundException e) {

			e.printStackTrace();

		} catch(SQLException e) {

			e.printStackTrace();

		} finally {

			try {

				if(con != null) {

					con.close();

				}

				if(ps != null) {

					ps.close();

				}

				if(rs != null) {

					rs.close();

				}

			} catch(SQLException e) {

				e.printStackTrace();

			}

		}

		return list;

	}
}
