package model;

import java.sql.Date;

public class RentDetailVO {
	private String title;
	private Date startDate;
	private Date endDate;
	private int price;
	private boolean status;
	private String content;
	private String nickName;
	private String phoneNumber;
	private boolean zzim;
	private String imageUrl;
	
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String url) {
		this.imageUrl = url;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isZzim() {
		return zzim;
	}
	public void setZzim(boolean zzim) {
		this.zzim = zzim;
	}
	
}
