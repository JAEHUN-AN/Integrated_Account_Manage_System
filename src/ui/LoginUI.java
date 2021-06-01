package ui;

import vo.UserVO;

public class LoginUI extends BaseUI {
	
	private  UserVO user; 
	
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID 입력 : ");
		String password = scanStr("비밀번호 입력 : ");
		
		user = service.login(id, password);
	}
	public  UserVO user() {
		return user; 
	}
	
}