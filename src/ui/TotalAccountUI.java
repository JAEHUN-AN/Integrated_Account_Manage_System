package ui;

public class TotalAccountUI extends BaseUI{
	public void showMenu() {
		System.out.println("통합계좌 관리 서비스입니다.");
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. 통합 계좌 등록"); 
		System.out.println("2. 통합 계좌 별칭 수정");
		System.out.println("3. 통합 계좌 삭제"); 
		System.out.println("0. 뒤로 가기"); 
		System.out.println("==============================");
		System.out.println();
		System.out.print("원하시는 서비스 번호를 입력하세요 : ");
	}
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		int serviceNum = -1;
		while ( serviceNum != 0) {
			showMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new AccountAddUI();
				myui.execute();
				break;
			case 2:
				myui = new AccountUpdateUI();
				myui.execute();
				break;
			case 3:
				myui = new AccountDeleteUI();
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