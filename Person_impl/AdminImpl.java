package Person_impl;

import java.util.HashMap;
import java.util.Map;

import Library.Book;

public interface AdminImpl {

	void inBooks(int key, int amount);

	void outBooks(int key2, int amount2);

	void addKind(String name3, int key3, String author3, String date3, double price3, int amount3);
}
