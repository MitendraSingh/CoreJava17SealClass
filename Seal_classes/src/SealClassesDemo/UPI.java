package SealClassesDemo;

// break the seal class inheritance
public non-sealed class UPI extends Payment {
	
	@Override
	public boolean success() {
		System.out.println("UPI Payment is successfull");
		return false;
		
	}

}
