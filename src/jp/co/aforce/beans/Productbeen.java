package jp.co.aforce.beans;

import java.io.Serializable;

public class Productbeen implements Serializable{
	
	private int product_id;
	private String product_name;
	private int product_price;
	private String products_introduction;
	
	
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
		//商品紹介
		public String getPintro() {
			return products_introduction;
		}
		public void setPintoro(String products_introduction) {
			this.products_introduction=products_introduction;
		}
		
}
