package jp.co.aforce.beans;

import java.io.Serializable;

public class Loginbeen implements Serializable{
	
	private String member_id;
	private String password;
	private String member_name;
	private int birthdate;
	private int phone_number;
	private String email_address;
	private String address;
	
	//会員番号
	public String getId() {
		return member_id;
	}
	public void setId(String id) {
		this.member_id=id;
	}
	
	//パスワード
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}
	//名前
	public String getMembername() {
		return member_name;
	}
	public void setMembername(String Mname) {
		this.member_name=Mname;
	}
	//誕生日
	public int getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(int Bdate) {
		this.birthdate=Bdate;
	}
	//電話番号
	public int getPhonenumber() {
		return phone_number;
	}
	public void setPhonenmber(int Pnumber) {
		this.phone_number=Pnumber;
	}
	//メールアドレス
	public String getMail() {
		return email_address;
	}
	public void setMail(String mail) {
		this.email_address=mail;
	}
	//住所
	public String getAddres() {
	return address;
	}
	public void setAddres(String address) {
	this.address=address;
	}

}
