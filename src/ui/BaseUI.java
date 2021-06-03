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
				System.out.println("���ڰ� �ƴմϴ�.");
				System.out.println("�ٽ� �Է����ּ���.");
				System.out.println();
		}
		return num;
			
	}
	
}
