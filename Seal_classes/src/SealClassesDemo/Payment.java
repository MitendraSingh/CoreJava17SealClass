package SealClassesDemo;

// Parent class that is seal
public sealed class Payment permits CreditCard, UPI, RTGS {
	
	public boolean success() {
		System.out.println("Payment is successfull");
		return false;
		
	}

}
