package ui;


public class AdminUI extends BaseUI {
	public void showMenu() {
		System.out.println();
		System.out.println("관리자 서비스입니다.");
		System.out.println();
		System.out.println("==========================================");
		System.out.println("1. 유저 조회"); 
		System.out.println("2. SQL UI");
		System.out.println("0. 뒤로 가기"); 
		System.out.println("==========================================");
		System.out.println();
		System.out.print("원하시는 서비스 번호를 입력하세요 : ");
	}
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		
		while(true) {
			myui = new AdminLoginUI();
			myui.execute();
			if(AdminLoginUI.isLogin()) {
				//true 면 로그인
				//로그인 시 탈출
				break;
			}// 로그인 실패시 탈출 여부 질문
			System.out.println();
			System.out.println("======나가시려면 0번, 다시 시도하려면 아무 키나 입력해주세요.======");
			System.out.println();
			if(scanInt("") == 0) {
				return;
			}
		}
		
		int serviceNum = -1;
		while ( serviceNum != 0) {
			showMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new ShowAllUserUI();
				myui.execute();
				break;
			case 2:
				myui = new SqlUI();
				myui.execute();
				break;
			case 0:
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println();
			}
		}
		
	}

}
