package Library;

import java.util.Iterator;
import java.util.Map;

public abstract class Person {

	private int num;//�˺�
	private String pwd;//����

	public Person(int num, String pwd) {
		super();
		this.num = num;
		this.pwd = pwd;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public static void seeAllbooks(Map<Integer, Book> books) {
		System.out.println("���    \t����      \t����   \t��������\t�۸�\t���");
		for (Book book : books.values()) {
			System.out.println(book.getKey() + "\t" + book.getName() + "\t" + book.getAuthor() + "\t" + book.getDate()
					+ "\t" + book.getPrice() + "\t" + book.getAmount());
		}

	}

}
