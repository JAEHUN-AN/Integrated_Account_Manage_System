package ui;

import java.util.Scanner;

import service.AccountService;
import service.AccountServiceFactory;
import vo.UserVO;

public abstract class BaseUI implements MyAccountUI {
	private Scanner sc;
	protected AccountService service;
	protected static UserVO user;
	
	public BaseUI() {
		sc = new Scanner(System.in);
		service = AccountServiceFactory.getAccountInstance();
	}
	
	protected String scanStr(String msg) {
		System.out.println(msg);
		String str = sc.nextLine();
		return str;
	}
	
	protected int scanInt(String msg) {
			int num = Integer.parseInt(scanStr(msg));
			return num;
			
	}
	
}
