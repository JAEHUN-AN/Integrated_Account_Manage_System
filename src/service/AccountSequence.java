package service;

public class AccountSequence {
	
	private static int accountNo = 1;
	
	public static int getAccountNo() {
		
		return AccountSequence.accountNo++;
	}
}
