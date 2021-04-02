package view;

public class Product {

	private int category_rank;
	private String category_name;

	public Product() {
		this.category_name = "";
		this.category_rank = 0;
	}

	public Product(int category_rank, String category_name) {
		this.category_name = category_name;
		this.category_rank = category_rank;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public int getCategory_rank() {
		return category_rank;
	}

	public void setCategory_rank(int category_rank) {
		this.category_rank = category_rank;
	}
}
