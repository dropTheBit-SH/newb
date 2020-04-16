package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import jdbc.util.jdbcUtil;

public class Dao {
	Connection con = jdbcUtil.getConnection();
	Statement stm = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	String sql = "";
	
	public Vector<Vector> selectAll() {
		con = jdbcUtil.getConnection();
		Vector<Vector> all = new Vector<Vector>();
		try {
			sql = "SELECT * FROM MEMBERS";
			stm = con.createStatement();
			rst = stm.executeQuery(sql);
			Vector one = null;
			while(rst.next()){
				one = new Vector();
				one.add(rst.getInt("no"));
				one.add(rst.getString("name"));
				one.add(rst.getString("email"));
				one.add(rst.getString("phone"));
				all.add(one);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return all;
	}
	
	public void insert(Member dto) {
		con = jdbcUtil.getConnection();
		try {
			sql = "INSERT INTO MEMBERS(name, email, phone) values(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getEmail());
			pst.setString(3, dto.getPhone());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
	}
	
	public void close(){
		if(pst != null)
			try {pst.close();} catch (SQLException e) {e.printStackTrace();}
		if(stm != null)
			try {stm.close();} catch (SQLException e) {e.printStackTrace();}
		if(con != null)
			try {con.close();} catch (SQLException e) {e.printStackTrace();}
	}
}
