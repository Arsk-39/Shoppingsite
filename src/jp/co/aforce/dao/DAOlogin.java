package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Loginbeen;

public class DAOlogin extends DAO{
	
	public Loginbeen search(String member_id, String password)throws Exception{
		Loginbeen login =null;
		
		Connection con = getConnection();
		PreparedStatement st;
		st = con.prepareStatement("SELECT * FROM arisaka_member WHERE member_id = ? and password=?");
		
		st.setString(1, member_id);
		st.setString(2, password);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			login = new Loginbeen();
			login.setId(rs.getString("member_id"));
			login.setPassword(rs.getString("password"));
		}
		
		st.close();
		con.close();
		return login;
	}
	
	public Loginbeen userin(String member_id)throws Exception{
		Loginbeen login = null;
		
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("SELECT * FROM arisaka_member WHERE member_id = ?");
		
		st.setString(1, member_id);
		ResultSet rs = st.executeQuery();
		
		while (rs.next()) {
			login = new Loginbeen();
			login.setId(rs.getString("member_id"));
		}
		st.close();
		con.close();
		return login;
	}

}
