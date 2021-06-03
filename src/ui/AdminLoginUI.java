package ui;


public class AdminLoginUI extends BaseUI {
	public static boolean login = false; 
	@Override
	public void execute() throws Exception {
		System.out.println();
		System.out.println("===================관리자 로그인 페이지입니다====================");
		System.out.println();
		String id = scanStr("ID 입력 : ");
		String password = scanStr("비밀번호 입력 : ");
		
		boolean isLogin = service.adminLogin(id, password);
		login = isLogin;
	}
	
	public static boolean isLogin() {
		return login;
	}
}