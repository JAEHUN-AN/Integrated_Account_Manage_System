package ui.service_ui;

import ui.BaseUI;

public class DepositUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("�Ա� �����Դϴ�.");
		// ��ü ���¸���Ʈ
		String accountNo = scanStr("�Ա��Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
		int money = scanInt("�Ա��Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		
		while(money <= 0) {
			System.out.println("0�� �ʰ� �ݾ׸� �Ա� �����մϴ�.");
			money = scanInt("�Ա��Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		}
		service.depositUI(accountNo, money);
		
	}
	

}