package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jp.co.aforce.beans.CartBean;
public class CartDAO extends DAO{
    //カートの中身を表示する
	public List<CartBean> getCartItems() throws Exception {
	    List<CartBean> list = new ArrayList<>();

	    Connection con = getConnection();
	    PreparedStatement st = null;
	    try {
	        st = con.prepareStatement("SELECT * FROM arisaka_cart ORDER BY product_id ASC");
	        ResultSet rs = st.executeQuery();

	        while (rs.next()) {
	            CartBean item = new CartBean();
	            item.setPid(rs.getInt("product_id"));
	            item.setPname(rs.getString("product_name"));
	            item.setPrice(rs.getInt("product_price"));
	            item.setPcount(rs.getInt("product_count"));
	            list.add(item);
	        }
	    } finally {
	        if (st != null) {
	            st.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }

	    return list;
	}
   
	// カートに商品を追加する
	public void addToCart(int productId,String productName,int productPrice,int productCount) throws Exception {
	    Connection con = getConnection();
	    PreparedStatement st = null;
	    
	    try {
	        // 既に同じ商品がカート内に存在するか確認
	        st = con.prepareStatement("SELECT * FROM arisaka_cart WHERE product_id = ?");
	        st.setInt(1, productId);
	        ResultSet rs = st.executeQuery();
	        
	        if (rs.next()) {
	            // 同じ商品がカート内に存在する場合、個数を更新
	            int count = rs.getInt("product_count") + productCount;
	            st.close();
	            
	            st = con.prepareStatement("UPDATE arisaka_cart SET product_count = ? WHERE product_id = ?");
	            st.setInt(1, count);
	            st.setInt(2, productId);
	            st.executeUpdate();
	        } else {
	            // カートに新しい商品を追加
	            st.close();
	            
	            st = con.prepareStatement("INSERT INTO arisaka_cart (cart_id, product_id, product_name, product_price, product_count) VALUES (DEFAULT, ?, ?, ?, 1)");
	            st.setInt(1, productId);
	            st.setString(2, productName);
	            st.setInt(3, productPrice);
	            st.executeUpdate();
	        }
	    } finally {
	        if (st != null) {
	            st.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	}
	
	

    
 // カート内の商品の価格の合計値を取得する
    public int getTotalPrice() throws Exception {
        int totalPrice = 0;

        Connection con = getConnection();
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            st = con.prepareStatement("SELECT SUM(product_price) AS total_price FROM arisaka_cart");
            rs = st.executeQuery();

            if (rs.next()) {
                totalPrice = rs.getInt("total_price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

        return totalPrice;
    }
    //カート消去
    public void decreaseCartItem(int productId,int Count) throws Exception {
    	Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE arisaka_cart SET product_count = product_count - ? WHERE product_id = ? ");
    	try 
        {
            st.setInt(1, Count);
        	st.setInt(2, productId);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }}
        }
    //カート追加
    public void additional_feature(int productId,int Count) throws Exception{
    	Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE arisaka_cart SET product_count = product_count + ? WHERE product_id = ? ");
    	try 
        {
            st.setInt(1, Count);
        	st.setInt(2, productId);
            st.executeUpdate();
        } finally {
            if (st != null) {
                st.close();
            }
            if (con != null) {
                con.close();
            }}
        }
    public void alldelete()throws Exception{
    	Connection con = getConnection();
        PreparedStatement st = con.prepareStatement("UPDATE arisaka_cart SET product_count = 0");
        try(PreparedStatement statement = st){
        	statement.executeUpdate();
        }
    }
    }
