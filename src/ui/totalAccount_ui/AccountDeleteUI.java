package ui.totalAccount_ui;

import ui.BaseUI;

public class AccountDeleteUI extends BaseUI{

	@Override
	public void execute() throws Exception {

		
		System.out.println("���¸� ������ �� �ֽ��ϴ�.");
		// ��ü ���¸���Ʈ �����ֱ�
		String accountNo = scanStr("������ ���Ͻô� ���¹�ȣ�� �Է����ּ��� : ");
		
		service.accountDeleteUI(accountNo);
		
	}
	
}