package ui.service_ui;

import ui.BaseUI;

public class WithrawUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("���� �����Դϴ�.");
		// ��ü ���� ����Ʈ
		String accountNo = scanStr("�����Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
		int money = scanInt("�����Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		
		while(money <= 0) {
			System.out.println("0�� �ʰ� �ݾ׸� ���� �����մϴ�.");
			money = scanInt("�����Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		}
		
		service.withrawUI(accountNo, money);
	}
	
}