package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Productbeen;

public class allDAO extends DAO{
	public List<Productbeen> all() throws Exception{
		List<Productbeen> list=new ArrayList<>();
		
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement(
				"SELECT * FROM arisaka_product");
		ResultSet rs=st.executeQuery();
		
		while(rs.next()) {
			Productbeen p=new Productbeen();
			p.setPid(rs.getInt("product_id"));
			p.setPname(rs.getString("product_name"));
			p.setPrice(rs.getInt("product_price"));
			p.setPintoro(rs.getString("products_introduction"));
			list.add(p);
		}
		st.close();
		con.close();
		
		return list;
	
	
		}
	}





