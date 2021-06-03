package ui;

import vo.UserVO;

public class LoginUI extends BaseUI {
	
	public static UserVO user = null; 
	
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID 입력 : ");
		String password = scanStr("비밀번호 입력 : ");
		
		user = service.login(id, password);
	}
	public static UserVO user() {
		if(user.getName() == null)
			user = null;
		return user;
	}
	
}