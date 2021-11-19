package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ワード登録DAOクラス
 */
public class InsertDAO {

	// データベース接続に関する情報
	private final String DB_USER = "root";
	private final String DB_PASS = "MYSQLJUNYA";
	private final String JDBC_NAME = "com.mysql.cj.jdbc.Driver";
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/sample";

	Connection con = null;
	PreparedStatement ps = null;

	/**
	 * データベース接続してワードを登録する
	 * @param word ワード
	 * @return 登録件数
	 */
	public int insertWord(String word) {

		int count = 0;

		try {

			Class.forName(JDBC_NAME);
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);

			String sql = "INSERT INTO test1(name) VALUES(?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, word);
			count = ps.executeUpdate();

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

			} catch(SQLException e) {

				e.printStackTrace();

			}

		}

		return count;

	}

}
