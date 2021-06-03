package ui;

public class JoinUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		System.out.println("회원가입 서비스입니다.");
		String id = scanStr("사용하실 ID를 입력해주세요 : ");
		
		String password = null;
		String password2 = null;
		boolean check = true;
		
		while(check) {
			password = scanStr("사용하실 비밀번호를 입력해주세요 : ");
			password2 = scanStr("비빌번호를 한번 더 입력해주세요 : ");
			
			if(password.equals(password2)) {
				System.out.println("비밀번호가 일치합니다.");
				System.out.println("가입을 진행합니다.");
				check = false;
			} else {
				System.out.println("비밀번호가 일치하지 않습니다. 다시 설정해주세요.");
			}
		}
		String name = scanStr("이름을 입력해w주세요 : ");
		service.join(id, password, name);
		
	}
	
}