package SealClassesDemo;

public class SealMainClass {

	public static void main(String[] args) {
		System.out.println("Hello it my seal class");
		
		Payment p1 = new UPI();
		Payment p2 = new RTGS();
		Payment p3 = new CreditCard();
		Payment p4 = new BankTransfer();
		
		System.out.println(p1.success());
		System.out.println(p2.success());
		System.out.println(p3.success());
		System.out.println(p4.success());
		
		/* Output: 
		
		Hello it my seal class
		UPI Payment is successfull
		false
		RTGS Payment is successfull
		false
		CreditCard Payment is successfull
		false
		RTGS Payment is successfull
		Bank Transfer Successful !
		true */

	}

}
