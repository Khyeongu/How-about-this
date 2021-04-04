package model;

import java.util.Date;

public class TradeRecordVO {
	private int boardId;
	private Date time;
	private int memberId;
	private int categoryId;
	
	public TradeRecordVO() {
		
	}
	
	public TradeRecordVO(int categoryId) {
		this.categoryId=categoryId;
	}
	
	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	
	
}
