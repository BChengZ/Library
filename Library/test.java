package Library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class test {
	public static void main(String[] args) {
		Book book = new Book("���߸贫�� ", 10001, "����  ", "1999", 2, 200);
		Book book2 = new Book("���߸贫2��", 10002, "������ ", "2000", 3, 201);
		Book book3 = new Book("���߸贫3��", 10003, "��������", "2001", 4, 202);

		Map<Integer, Book> books = new HashMap<Integer, Book>();
		books.put(10001, book);
		books.put(10002, book2);
		books.put(10003, book3);

		Add add1 = new Add(20, "��������߸衷");
		Add add2 = new Add(22, "��������߸�2��");
		Add add3 = new Add(23, "��������߸�3��");

		ArrayList<Add> adds = new ArrayList();
		adds.add(add1);
		adds.add(add2);
		adds.add(add3);

		Scanner input = new Scanner(System.in);
		////////////////////////////////////////////////////////////
		PersonBiz biz = new PersonBiz();
		boolean isTrue = false;
		int num;// �����˺�
		String pwd;// ��������
		do {
			System.out.print("�������˺ţ�");
			num = input.nextInt();
			System.out.print("���������룺");
			pwd = input.next();
			isTrue = biz.judgeAdmin(num, pwd);
		} while (isTrue);
		Person person = biz.Login(num, pwd);
		if (person != null) {
			if (person instanceof Customer) {
//Ϊ�δ˴�����				person = (Customer) person;
				// ��ʼ������
				person.seeAllbooks(books);
				System.out.println("================");
				System.out.print("��ѡ�����(1.�鿴ͼ�� 2.���� 3.�˳�):");
				switch (input.nextInt()) {
				case 1:
					person.seeAllbooks(books);
					break;
				case 2:
					System.out.println("�������������ͼ����Ϣ>>");
					System.out.print("��������ţ�");
					int key = input.nextInt();
					System.out.print("�����빺��������");
					int amount = input.nextInt();
					String bookName = ((Customer) person).purchaseBook(key, amount, books);
					if (bookName.equals("")) {
						System.out.println("��ϲ�㣬�򲻵��򲻵��򲻵�");
						break;
					} else {
						System.out.println("����ɹ���\n��Ʒ�б�");
						int i = 1;
						for (Add ad1 : adds) {
							System.out.println(i + "��" + ad1.getName() + ":" + ad1.getPrice() + "Ԫ");
							i++;
						}
						System.out.print("��������Ҫ�������Ʒ��");
						int num2 = input.nextInt();
						System.out.print("������Ҫ�����������");
						int amount2 = input.nextInt();
						String addName = ((Customer) person).purchaseAdds(adds, num2, amount2);
						System.out.println("����ɹ���");
						System.out.println("�����ܹ����ѣ�");
						System.out.println(bookName + ":" + books.get(key).getPrice() + "Ԫ��������" + amount + "��������"
								+ ((Customer) person).booksTotal + "Ԫ");
						System.out.println(addName + ":" + adds.get(num2 - 1).getPrice() + "Ԫ��������" + amount2 + "��������"
								+ ((Customer) person).addsTotal + "Ԫ");

						double total = 0;
						if (person instanceof CustomerVIP) {
							System.out.println("�������ǻ�Ա������8���Żݣ�");
							total = ((CustomerVIP) person).countAll();
						} else {
							total = ((Customer) person).countAll();
						}
						System.out.println("�ܼ۸�Ϊ��" + total + "Ԫ");
					}
					break;
				default:
					System.out.println("���˳�");
					System.exit(1);
				}
			} else if (person instanceof Admin) {
				person = (Admin) person;
				person.seeAllbooks(books);
				System.out.print("��ѡ����еĲ���(1.ͼ����� 2.ͼ����� 3.��ѯȫ��ͼ�� 4.����ͼ�� 5.�˳�):");
				int choose = input.nextInt();
				((Admin) person).books = books;// ��������
				switch (choose) {
				case 1:
					System.out.println("ִ��ͼ�����>>");
					System.out.print("��������ţ�");
					int key = input.nextInt();
					System.out.print("������������");
					int amount = input.nextInt();
					((Admin) person).inBooks(key, amount);
					System.out.println("���ɹ���");
					person.seeAllbooks(books);
					break;
				case 2:
					System.out.println("ִ��ͼ�����>>");
					System.out.print("��������ţ�");
					int key2 = input.nextInt();
					System.out.print("������������");
					int amount2 = input.nextInt();
					((Admin) person).outBooks(key2, amount2);
					System.out.println("����ɹ���");
					person.seeAllbooks(books);
					break;

				case 3:
					person.seeAllbooks(books);
					break;

				case 4:
					System.out.println("ִ������ͼ��>>");
					System.out.print("��������ţ�");
					int key3 = input.nextInt();
					System.out.print("������������");
					String name3 = input.next();
					System.out.print("���������ߣ�");
					String author3 = input.next();
					System.out.print("�����뷢�����ڣ�");
					String date3 = input.next();
					System.out.print("������۸�");
					int price3 = input.nextInt();
					System.out.print("�������棺");
					int amount3 = input.nextInt();
					((Admin) person).addKind(name3, key3, author3, date3, price3, amount3);
					System.out.println("�µ�ͼ����������ӣ�");
					person.seeAllbooks(books);
					break;

				default:
					System.out.println("���˳�");
					System.exit(1);
					break;
				}
			}
		}
	}
}
