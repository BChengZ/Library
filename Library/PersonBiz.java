package Library;

public class PersonBiz {

	public Person Login(int num, String pwd) {
		Person person = null;
		if (num == 111 && pwd.equals("qwe")) {
			person = new Customer(111, "qwe");
		} else if (num == 122 && pwd.equals("asd")) {
			person = new CustomerVIP(122, "asd");
		} else if (num == 222 && pwd.equals("zxc")) {
			person = new Admin(222, "zxc");
		}
		return person;
	}

	// �жϹ���Ա��¼
	public boolean judgeAdmin(int num, String pwd) {
		boolean isTrue = false;
		if (num == 222 && !pwd.equals("zxc")) {
			System.out.println("����������������룡");
			isTrue = true;
		}
		return isTrue;
	}

}
