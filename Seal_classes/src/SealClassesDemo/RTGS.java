package SealClassesDemo;

// Continue the seal class inheritance 
public sealed class RTGS extends Payment permits BankTransfer {
	
	@Override
	public boolean success() {
		System.out.println("RTGS Payment is successfull");
		return false;
		
	}

}
