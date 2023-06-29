package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.Productbeen;

public class ProductDAO extends DAO{
	public List<Productbeen> search() throws Exception{
		List<Productbeen> list=new ArrayList<>();
		
		Connection con=getConnection();
		System.out.println("データベースに接続しました。");
		PreparedStatement st;
		st=con.prepareStatement(
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
	//検索機能
	public List<Productbeen> searchProducts(String keyword) throws Exception {
	    List<Productbeen> productList = new ArrayList<>();

	    Connection con = getConnection();
	    PreparedStatement st = null;
	    ResultSet rs = null;

	    try {
	        st = con.prepareStatement("SELECT * FROM arisaka_product WHERE product_name LIKE ?");
	        st.setString(1, "%" + keyword + "%");
	        rs = st.executeQuery();

	        while (rs.next()) {
	            Productbeen product = new Productbeen();
	            product.setPid(rs.getInt("product_id"));
	            product.setPname(rs.getString("product_name"));
	            product.setPrice(rs.getInt("product_price"));
	            product.setPintoro(rs.getString("products_introduction"));
	            productList.add(product);
	        }
	    } finally {
	        if (rs != null) {
	            rs.close();
	        }
	        if (st != null) {
	            st.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }

	    return productList;
	}

}
