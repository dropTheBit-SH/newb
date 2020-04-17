package myProject.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jdbc.util.jdbcUtil;
/*
 * create table admin(
 * ID varchar2(10) not null,
 * PW varchar2(20) not null
 * );
 * insert into admin values ('admin', 'admin123');
 */
public class DAO {
	Connection con;
	Statement stm;
	PreparedStatement pst;
	ResultSet rst;
	String sql_admin_selectAll = "SELECT * FROM ADMIN";
	
	public void adminLogin() {
//		try {
//			con = jdbcUtil.getConnection();
//			stm = con.createStatement();
//			rst = stm.executeQuery(sql_admin_selectAll);
//			while(rst.next()){
//				if(textField.getText.equals(rst.getString("ID"));
//				admin.setPW(rst.getString("PW"));
//			}
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
	}
}
