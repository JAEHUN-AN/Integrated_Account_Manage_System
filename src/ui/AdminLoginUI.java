package ui;


public class AdminLoginUI extends BaseUI {
	public static boolean login = false; 
	@Override
	public void execute() throws Exception {
		System.out.println();
		System.out.println("===================������ �α��� �������Դϴ�====================");
		System.out.println();
		String id = scanStr("ID �Է� : ");
		String password = scanStr("��й�ȣ �Է� : ");
		
		boolean isLogin = service.adminLogin(id, password);
		login = isLogin;
	}
	
	public static boolean isLogin() {
		return login;
	}
}