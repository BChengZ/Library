package Person_impl;

import java.util.ArrayList;
import java.util.Map;

import Library.Add;
import Library.Book;

public interface CustomerImpl {

	String purchaseBook(int key, int amount, Map<Integer, Book> books);

	String purchaseAdds(ArrayList<Add> adds, int key, int amount);

	double countAll();// Ω·’À

}
