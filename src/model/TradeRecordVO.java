package model;

import java.util.Date;

public class TradeRecordVO {
	private int id;
	private int memberId;
	private int boardId;
	private Date time;
	
	
	public TradeRecordVO() {
		
	}
	
	public TradeRecordVO(int id, int memberId, int baordId, Date time) {
		
	}
	
	
	public int getId() {
		return id;
	}
	public int getMemberId() {
		return memberId;
	}
	public void setMemberId(int memberId) {
		this.memberId = memberId;
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
}
