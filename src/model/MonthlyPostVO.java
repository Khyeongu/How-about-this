package model;

public class MonthlyPostVO {
	String title;
	int price;
	String tradeDay;
	
	public MonthlyPostVO(String title, int price, String tradeDay) {
		this.title=title;
		this.price=price;
		this.tradeDay=tradeDay;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTradeDay() {
		return tradeDay;
	}

	public void setTradeDay(String tradeDay) {
		this.tradeDay = tradeDay;
	}

	
	
	
}
