package Library;

import java.util.HashMap;
import java.util.Map;

import Person_impl.AdminImpl;

public class Admin extends Person implements AdminImpl {

	Map<Integer, Book> books = new HashMap<Integer, Book>();

	public Admin(int num, String pwd) {
		super(num, pwd);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void inBooks(int key, int amount) {
		// TODO Auto-generated method stub
		int tem = books.get(key).getAmount() + amount;
		books.get(key).setAmount(tem);

	}

	@Override
	public void outBooks(int key2, int amount2) {
		// TODO Auto-generated method stub
		int tem = books.get(key2).getAmount() - amount2;
		books.get(key2).setAmount(tem);

	}

	@Override
	public void addKind(String name3, int key3, String author3, String date3, double price3, int amount3) {
		Book tem = new Book(name3, key3, author3, date3, price3, amount3);
		books.put(key3, tem);
	}

}
