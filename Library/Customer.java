package Library;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Person_impl.CustomerImpl;

public class Customer extends Person implements CustomerImpl {

	public Customer(int num, String pwd) {
		super(num, pwd);
		// TODO Auto-generated constructor stub
	}

	double booksTotal, addsTotal;// 购买”书和赠品“花的总价钱

	public String purchaseAdds(ArrayList<Add> adds, int num, int amount) {
		if (num - 1 <= adds.size()) {
			addsTotal = adds.get(num - 1).getPrice() * amount;
			return adds.get(num - 1).getName();
		}
		return " ";
	}

	@Override
	public double countAll() {
		double total = 0;
		total = addsTotal + booksTotal;
		return total;
	}

	@Override
	public String purchaseBook(int key, int amount, Map<Integer, Book> books) {
		// TODO Auto-generated method stub
		if (books.containsKey(key)) {
			if (amount > books.get(key).getAmount()) {
				return "";
			} else {
				booksTotal = books.get(key).getPrice() * amount;
				books.get(key).setAmount(books.get(key).getAmount() - amount);
				return books.get(key).getName();
			}
		}

		return "";
	}

}
