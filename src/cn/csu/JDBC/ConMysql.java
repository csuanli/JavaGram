package cn.csu.JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class ConMysql {
	/**
	 * @param basic knowledge of jdbc
	 * @author 李岸
	 * @throws Exception 
	 */
	public static void main(String[] args) throws Exception {
		//template();
		//template2();
		template_insert();
	}

	private static void template() throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:mysql:///test"; //"jdbc:mysql://localhost:3306/test"
		String userName = "root";
		String userPwd = "";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, userPwd);
			st = conn.createStatement();
			rs = st.executeQuery("select * from student");
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "-template--"
						+ rs.getObject(2));
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} finally {
					if (conn != null) {
						conn.close();
					}

				}
			}

		}
	}
	
	private static void template2() throws Exception {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		String url = "jdbc:mysql://localhost:3306/subclass";
		String userName = "root";
		String userPwd = "mcl123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, userPwd);
			st = conn.createStatement();
			rs = st.executeQuery("select * from t_users");
			while (rs.next()) {
				System.out.println(rs.getObject(1) + "-template--"
						+ rs.getObject(2));
			}
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
			} finally {
				try {
					if (st != null) {
						st.close();
					}
				} finally {
					if (conn != null) {
						conn.close();
					}

				}
			}

		}
	}

	
	private static void template_insert() throws Exception {
		Connection conn = null;
		PreparedStatement ps = null;
		String url = "jdbc:mysql://localhost:3306/subclass";
		String userName = "root";
		String userPwd = "mcl123";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, userName, userPwd);
			String sql="insert into t_users(userid,gender,age,occupation,zipcode) values (?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "3");
			ps.setString(2, "31");
			ps.setString(3, "31");
			ps.setString(4, "31");
			ps.setString(5, "31");
//			ps.addBatch();			//批处理
			System.out.println(sql);
			ps.execute();
//			ps.executeBatch();		//批处理
		} finally {
			try {
				if (ps != null) {
					ps.close();
				}
			} finally {
				if (conn != null) {
					conn.close();
				}
			}

		}
	}	

}
