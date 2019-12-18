package Library;

import java.util.Map;

import Person_impl.CustomerImpl;

public class CustomerVIP extends Customer {
	public CustomerVIP(int num, String pwd) {
		super(num, pwd);
		// TODO Auto-generated constructor stub
	}

	public double countAll() {
		double total2 = 0;
		total2 = super.countAll() * 0.8;
		return total2;
	}
}
