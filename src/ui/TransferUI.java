package ui;

public class TransferUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("이체 서비스입니다.");
		// 전체 계좌리스트
		String accountNoFrom = scanStr("이체하실 계좌번호를 입력해주세요 : ");
		int money = scanInt("이체하실 금액을 입력해주세요(숫자만 입력) : ");
		
		while(money <= 0) {
			System.out.println("0원 초과 금액만 이체 가능합니다.");
			money = scanInt("이체하실 금액을 입력해주세요(숫자만 입력) : ");
		}
		
		
		String accountNoTo = scanStr("받을 계좌번호를 입력해주세요 : ");
		service.transferUI(accountNoFrom, money, accountNoTo);
		
	}

}