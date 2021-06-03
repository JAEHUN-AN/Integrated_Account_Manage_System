package ui;

import vo.UserVO;

public class LoginUI extends BaseUI {
	
	public static UserVO user = null; 
	
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID �Է� : ");
		String password = scanStr("��й�ȣ �Է� : ");
		
		user = service.login(id, password);
	}
	public static UserVO user() {
		if(user.getName() == null)
			user = null;
		return user;
	}
	
}