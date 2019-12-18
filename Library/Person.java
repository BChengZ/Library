package Library;

import java.util.Iterator;
import java.util.Map;

public abstract class Person {

	private int num;//账号
	private String pwd;//密码

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
		System.out.println("书号    \t书名      \t作者   \t发布日期\t价格\t库存");
		for (Book book : books.values()) {
			System.out.println(book.getKey() + "\t" + book.getName() + "\t" + book.getAuthor() + "\t" + book.getDate()
					+ "\t" + book.getPrice() + "\t" + book.getAmount());
		}

	}

}
