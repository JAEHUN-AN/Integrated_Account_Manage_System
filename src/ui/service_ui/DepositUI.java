package ui.service_ui;

import ui.BaseUI;

public class DepositUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("입금 서비스입니다.");
		// 전체 계좌리스트
		String accountNo = scanStr("입금하실 계좌번호를 입력해주세요 : ");
		int money = scanInt("입금하실 금액을 입력해주세요(숫자만 입력) : ");
		
		while(money <= 0) {
			System.out.println("0원 초과 금액만 입금 가능합니다.");
			money = scanInt("입금하실 금액을 입력해주세요(숫자만 입력) : ");
		}
		service.depositUI(accountNo, money);
		
	}
	

}