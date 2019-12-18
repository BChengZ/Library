package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Book book = new Book("《高歌传》 ", 10001, "王根  ", "1999", 2, 200);
		Book book2 = new Book("《高歌传2》", 10002, "王根根 ", "2000", 3, 201);
		Book book3 = new Book("《高歌传3》", 10003, "王根根根", "2001", 4, 202);

		Map<Integer, Book> books = new HashMap<Integer, Book>();
		books.put(10001, book);
		books.put(10002, book2);
		books.put(10003, book3);

		Add add1 = new Add(20, "《王根与高歌》");
		Add add2 = new Add(22, "《王根与高歌2》");
		Add add3 = new Add(23, "《王根与高歌3》");

		ArrayList<Add> adds = new ArrayList();
		adds.add(add1);
		adds.add(add2);
		adds.add(add3);

		Scanner input = new Scanner(System.in);
		////////////////////////////////////////////////////////////
		PersonBiz biz = new PersonBiz();
		boolean isTrue = false;
		int num;// 输入账号
		String pwd;// 输入密码
		do {
			System.out.print("请输入账号：");
			num = input.nextInt();
			System.out.print("请输入密码：");
			pwd = input.next();
			isTrue = biz.judgeAdmin(num, pwd);
		} while (isTrue);
		Person person = biz.Login(num, pwd);
		if (person != null) {
			if (person instanceof Customer) {
//为何此处无用				person = (Customer) person;
				// 开始操作！
				person.seeAllbooks(books);
				System.out.println("================");
				System.out.print("请选择操作(1.查看图书 2.结账 3.退出):");
				switch (input.nextInt()) {
				case 1:
					person.seeAllbooks(books);
					break;
				case 2:
					System.out.println("请输入欲购买的图书信息>>");
					System.out.print("请输入书号：");
					int key = input.nextInt();
					System.out.print("请输入购买数量：");
					int amount = input.nextInt();
					String bookName = ((Customer) person).purchaseBook(key, amount, books);
					if (bookName.equals("")) {
						System.out.println("恭喜你，买不到买不到买不到");
						break;
					} else {
						System.out.println("购买成功！\n赠品列表：");
						int i = 1;
						for (Add ad1 : adds) {
							System.out.println(i + "、" + ad1.getName() + ":" + ad1.getPrice() + "元");
							i++;
						}
						System.out.print("请输入需要购买的赠品：");
						int num2 = input.nextInt();
						System.out.print("请输入要购买的数量：");
						int amount2 = input.nextInt();
						String addName = ((Customer) person).purchaseAdds(adds, num2, amount2);
						System.out.println("购买成功！");
						System.out.println("您的总共消费：");
						System.out.println(bookName + ":" + books.get(key).getPrice() + "元，数量：" + amount + "本，共："
								+ ((Customer) person).booksTotal + "元");
						System.out.println(addName + ":" + adds.get(num2 - 1).getPrice() + "元，数量：" + amount2 + "本，共："
								+ ((Customer) person).addsTotal + "元");

						double total = 0;
						if (person instanceof CustomerVIP) {
							System.out.println("由于您是会员，享受8折优惠！");
							total = ((CustomerVIP) person).countAll();
						} else {
							total = ((Customer) person).countAll();
						}
						System.out.println("总价格为：" + total + "元");
					}
					break;
				default:
					System.out.println("已退出");
					System.exit(1);
				}
			} else if (person instanceof Admin) {
				person = (Admin) person;
				person.seeAllbooks(books);
				System.out.print("请选择进行的操作(1.图书入库 2.图书出库 3.查询全部图书 4.新增图书 5.退出):");
				int choose = input.nextInt();
				((Admin) person).books = books;// 导入资料
				switch (choose) {
				case 1:
					System.out.println("执行图书入库>>");
					System.out.print("请输入书号：");
					int key = input.nextInt();
					System.out.print("请输入数量：");
					int amount = input.nextInt();
					((Admin) person).inBooks(key, amount);
					System.out.println("入库成功！");
					person.seeAllbooks(books);
					break;
				case 2:
					System.out.println("执行图书出库>>");
					System.out.print("请输入书号：");
					int key2 = input.nextInt();
					System.out.print("请输入数量：");
					int amount2 = input.nextInt();
					((Admin) person).outBooks(key2, amount2);
					System.out.println("出库成功！");
					person.seeAllbooks(books);
					break;

				case 3:
					person.seeAllbooks(books);
					break;

				case 4:
					System.out.println("执行新增图书>>");
					System.out.print("请输入书号：");
					int key3 = input.nextInt();
					System.out.print("请输入书名：");
					String name3 = input.next();
					System.out.print("请输入作者：");
					String author3 = input.next();
					System.out.print("请输入发布日期：");
					String date3 = input.next();
					System.out.print("请输入价格：");
					int price3 = input.nextInt();
					System.out.print("请输入库存：");
					int amount3 = input.nextInt();
					((Admin) person).addKind(name3, key3, author3, date3, price3, amount3);
					System.out.println("新的图书种类已添加！");
					person.seeAllbooks(books);
					break;

				default:
					System.out.println("已退出");
					System.exit(1);
					break;
				}
			}
		}
	}
}
