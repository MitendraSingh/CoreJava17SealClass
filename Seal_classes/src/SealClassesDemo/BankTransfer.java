package SealClassesDemo;

// break the seal class inheritance
public non-sealed class BankTransfer  extends RTGS {
	
	
	
	@Override
	public boolean success() {
		super.success();
		System.out.println("Bank Transfer Successful !");
		
		return true;
	}

}
