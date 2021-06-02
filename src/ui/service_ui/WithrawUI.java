package ui.service_ui;

import ui.BaseUI;

public class WithrawUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("인출 서비스입니다.");
		// 전체 계좌 리스트
		String accountNo = scanStr("인출하실 계좌번호를 입력해주세요 : ");
		int money = scanInt("인출하실 금액을 입력해주세요(숫자만 입력) : ");
		
		while(money <= 0) {
			System.out.println("0원 초과 금액만 인출 가능합니다.");
			money = scanInt("인출하실 금액을 입력해주세요(숫자만 입력) : ");
		}
		
		service.withrawUI(accountNo, money);
	}
	
}