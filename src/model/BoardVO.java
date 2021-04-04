package model;

import java.sql.Timestamp;
import java.util.Date;

public class BoardVO {
	private int id;
	private String title;
	private String content;
	private int price;
	private char status;
	private Date time;
	private String imageUrl;
	private Date startDate;
	private Date endDate;
	private int userId;
	private int categoryId;
	

	public BoardVO() {
		
	}
	
	public BoardVO(int id, String title, int price) {
		this.categoryId=id;
		this.title=title;
		this.price=price;

	public BoardVO(int id, String title, int price, String imageUrl, Date time) {
		super();
		this.id = id;
		this.title = title;
		this.price = price;
		this.time = time;
		this.imageUrl = imageUrl;

	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public char getStatus() {
		return status;
	}
	public void setStatus(char status) {
		this.status = status;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
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
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	
}