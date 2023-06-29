package jp.co.aforce.beans;

import java.io.Serializable;

public class CartBean implements Serializable{
	private int cart_id;
	private int product_id;
	private String product_name;
	private int product_price;
	private int product_count;

		//カートid
		public int getCid() {
			return cart_id;
		}
		public void setCid(int cart_id) {
			this.cart_id=cart_id;
		}
		//商品ID
		public int getPid() {
			return product_id;
		}
		public void setPid(int product_id) {
			this.product_id=product_id;
		}
		//商品名
		public String getPname() {
			return product_name;
		}
		public void setPname(String product_name) {
			this.product_name=product_name;
		}
		//商品値段
		public int getPrice() {
			return product_price;
		}
		public void setPrice(int product_price) {
			this.product_price=product_price;
		}
		//商品個数
		public int getPcount() {
			return product_count;
		}
		public void setPcount(int product_count) {
			this.product_count=product_count;
		}

}
