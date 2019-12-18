package Library;

public class Book {

	private String name;
	private int key;//  È∫≈
	private String author;
	private String date;
	private double price;
	private int amount;// ø‚¥Ê

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Book(String name, int key, String author, String date, double price, int amount) {
		super();
		this.name = name;
		this.key = key;
		this.author = author;
		this.date = date;
		this.price = price;
		this.amount = amount;
	}

}
