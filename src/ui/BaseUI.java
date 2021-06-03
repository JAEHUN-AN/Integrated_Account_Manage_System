package ui;

import java.util.Scanner;

import service.AccountService;
import service.AccountServiceFactory;
import vo.UserVO;

public abstract class BaseUI implements MyAccountUI {
	private Scanner sc;
	protected AccountService service;
	protected static UserVO user = null;
	
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
		int num = -1;
		try {
			num = Integer.parseInt(scanStr(msg));
		}
		catch(Exception e){
				System.out.println("숫자가 아닙니다.");
				System.out.println("다시 입력해주세요.");
				System.out.println();
		}
		return num;
			
	}
	
}
