package org.comstudy21.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import jdbc.util.jdbcUtil;

public class Dao {
	
	Statement stm = null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	String sql = "";
	
	public Vector<Vector> selectAll() {
		Connection con = jdbcUtil.getConnection();
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
			if(rst != null)
				try {rst.close();} catch (SQLException e) {e.printStackTrace();}
			if(stm != null)
				try {stm.close();} catch (SQLException e) {e.printStackTrace();}
			if(con != null)
				try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
		return all;
	}
	
	public void insert(Member dto) {
		Connection con = jdbcUtil.getConnection();
		try {
			sql = "INSERT INTO MEMBERS(name, email, phone) values(?,?,?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, dto.getName());
			pst.setString(2, dto.getEmail());
			pst.setString(3, dto.getPhone());
			if(pst.executeUpdate() > 0) System.out.println("성공"); // 처리한개수
			else System.out.println("실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pst != null)
				try {pst.close();} catch (SQLException e) {e.printStackTrace();}
			if(stm != null)
				try {stm.close();} catch (SQLException e) {e.printStackTrace();}
			if(con != null)
				try {con.close();} catch (SQLException e) {e.printStackTrace();}
		}
	}
	
//	public void insert(Member dto) {
//		JSONObject rootObject = getJsonObject();
//		int seq = rootObject.getInt("seq");
//		JSONArray array = rootObject.getJSONArray("members");
//		
//		JSONObject obj = new JSONObject();
//		obj.put("no", seq++);
//		obj.put("name", dto.getName());
//		obj.put("email", dto.getEmail());
//		obj.put("phone", dto.getPhone());
//		array.put(obj);
//		
//		rootObject.put("seq", seq);
//		
//		try {
//			File file = new File(filepath);
//			writer = new FileWriter(file);
//			writer.write(rootObject.toString(2));
//			
//			if(reader != null) reader.close();
//			if(writer != null) writer.close();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//	}

}
