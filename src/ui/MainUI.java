package ui;

public class MainUI extends BaseUI {

	public void showFirstMenu() {
		System.out.println("==============================");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 회원가입");
		System.out.println("==============================");
	}
	
	public void showSecondMenu() {
		System.out.println("==============================");
		System.out.println("1. 계좌 전체 조회"); // AccountInfoAllUI
		System.out.println("2. 계좌번호로 조회"); // AccountInfoNoUI
		System.out.println("3. 은행별 계좌 조회"); // AccountInfoBankUI
		System.out.println("4. 계좌 등록"); // AccountAddUI
		System.out.println("5. 계좌 수정"); // AccountUpdateUI
		System.out.println("6. 계좌 삭제"); // AccountDeleteUI
		System.out.println("7. 입금"); // DepositUI
		System.out.println("8. 출금"); // WithrawUI
		System.out.println("9. 이체"); // TransferUI
		System.out.println("10. 계좌 신규 생성"); // CreateAccountUI
		System.out.println("0. 종료"); // ExitUI
		System.out.println("==============================");
		
		System.out.print("원하시는 서비스 번호를 입력하세요 : ");
	}
	
	public void showLoginUI(MyAccountUI myui, int logJoin) throws Exception {
		logJoin = scanInt("원하시는 서비스 번호를 입력하세요 : ");
		if(logJoin == 1) {
			myui = new LoginUI();
			myui.execute();
			BaseUI.user = ((LoginUI) myui).user();
		} else if(logJoin == 2) {
			myui = new JoinUI();
			myui.execute();
		} else
			System.out.println("잘못 입력하셨습니다.");
	}
	
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		
		showFirstMenu();		
		int logJoin = 0;
		while(BaseUI.user == null) { //로그인 한 user가 생길 때 까지 반복
			showLoginUI(myui, logJoin);
		}
		
		int serviceNum = 1;
		while (serviceNum != 0) {

			showSecondMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new AccountInfoAllUI();
				myui.execute();
				break;
			
			case 2:
				myui = new AccountInfoNoUI();
				myui.execute();
				break;
			case 3:
				myui = new AccountInfoBankUI();
				myui.execute();
				break;
			case 4:
				myui = new AccountAddUI();
				myui.execute();
				break;
			case 5:
				myui = new AccountUpdateUI();
				myui.execute();
				break;
			case 6:
				myui = new AccountDeleteUI();
				myui.execute();
				break;
			case 7:
				myui = new DepositUI();
				myui.execute();
				break;
			case 8:
				myui = new WithrawUI();
				myui.execute();
				break;
			case 9:
				myui = new TransferUI();
				myui.execute();
				break;	
			case 10:
				myui = new CreateAccountUI();
				myui.execute();
				break;
			case 0:
				myui = new ExitUI();
				myui.execute();
				break;
			default:
				System.out.println("번호를 잘못 입력하셨습니다.");
				System.out.println();
			}
		}
	}
}