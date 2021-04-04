package model;

import java.util.Date;

public class ReplyVO {
	private int id;
	private String content;
	private Date time;
	private int boardId;
	
	public ReplyVO(int id, String content, Date time, int boardId) {
		this.id = id;
		this.content = content;
		this.time = time;
		this.boardId = boardId;
	}
	
	public ReplyVO() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
}
