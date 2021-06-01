package service;

public class AccountServiceFactory {
	private static final AccountService service = new AccountService();
	
	public static AccountService getAccountInstance() {
//		if(service == null)
//			service = new BoardService();
		return service;
	}
}
