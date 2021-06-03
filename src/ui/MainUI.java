package ui;

import ui.service_ui.AccountInfoAllUI;
import ui.service_ui.AccountInfoBankUI;
import ui.service_ui.AccountInfoNoUI;
import ui.service_ui.CreateAccountUI;
import ui.service_ui.DepositUI;
import ui.service_ui.TransferUI;
import ui.service_ui.WithrawUI;
import ui.totalAccount_ui.TotalAccountUI;

public class MainUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		
		int logJoin = 0;
		while(BaseUI.user == null) { //로그인 한 user가 생길 때 까지 반복
			showFirstMenu();		
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
				myui = new TotalAccountUI();
				myui.execute();
				break;
			case 5:
				myui = new DepositUI();
				myui.execute();
				break;
			case 6:
				myui = new WithrawUI();
				myui.execute();
				break;
			case 7:
				myui = new TransferUI();
				myui.execute();
				break;
			case 8:
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
	public void showFirstMenu() {
		System.out.println("========================================================");
		System.out.println("\t1. 로그인");
		System.out.println("\t2. 회원가입");
		System.out.println("\t3. 관리자 로그인");
		System.out.println("\t0. 종료");
		System.out.println("========================================================");
	}
	
	public void showSecondMenu() {
		System.out.println();
		System.out.println("========================================================");
		System.out.println("\\t1. 계좌 전체 조회"); // AccountInfoAllUI
		System.out.println("\\t2. 계좌번호로 조회"); // AccountInfoNoUI
		System.out.println("\\t3. 은행별 계좌 조회"); // AccountInfoBankUI
		System.out.println("\\t4. 통합계좌 관리"); // AccountAddUI
		System.out.println("\\t5. 입금"); // AccountUpdateUI
		System.out.println("\\t6. 출금"); // AccountDeleteUI
		System.out.println("\\t7. 이체"); // DepositUI
		System.out.println("\\t8. 계좌 신규 생성"); // WithrawUI
		System.out.println("\\t0. 종료"); // ExitUI
		System.out.println("========================================================");
		System.out.println();
		System.out.print("원하시는 서비스 번호를 입력하세요 : ");
	}
	
	public void showLoginUI(MyAccountUI myui, int logJoin) throws Exception {
		logJoin = scanInt("원하시는 서비스 번호를 입력하세요 : ");
		
		if(logJoin == 1) {
			myui = new LoginUI();
			myui.execute();
			BaseUI.user = LoginUI.user();
			
		} else if(logJoin == 2) {
			myui = new JoinUI();
			myui.execute();
			
		} else if(logJoin == 3){
			myui = new AdminUI();
			myui.execute();
			
		} else if(logJoin == 0){
			myui = new ExitUI();
			myui.execute();
			
		}else
			System.out.println("잘못 입력하셨습니다.");
	}
	
}