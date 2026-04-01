package SealClassesDemo;

// end the inheritance of seal class
public final class  CreditCard extends Payment  {
	
	@Override
	public boolean success() {
		System.out.println("CreditCard Payment is successfull");
		return false;
		
	}

}
