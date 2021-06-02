package ui.totalAccount_ui;

import ui.BaseUI;

public class AccountDeleteUI extends BaseUI{

	@Override
	public void execute() throws Exception {

		
		System.out.println("계좌를 삭제할 수 있습니다.");
		// 전체 계좌리스트 보여주기
		String accountNo = scanStr("삭제를 원하시는 계좌번호를 입력해주세요 : ");
		
		service.accountDeleteUI(accountNo);
		
	}
	
}