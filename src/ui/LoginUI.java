package ui;

import vo.UserVO;

public class LoginUI extends BaseUI {
	
	private  UserVO user; 
	
	@Override
	public void execute() throws Exception {
		String id = scanStr("ID �Է� : ");
		String password = scanStr("��й�ȣ �Է� : ");
		
		user = service.login(id, password);
	}
	public  UserVO user() {
		return user; 
	}
	
}