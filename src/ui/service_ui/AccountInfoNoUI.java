package ui.service_ui;

import java.util.List;

import ui.BaseUI;
import vo.AccountVO;

public class AccountInfoNoUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("============================================================");
		System.out.println("���¹�ȣ�� ���¸� ��ȸ�ϴ� �����Դϴ�.");
		System.out.println("============================================================");
		String accountNO = scanStr("���¹�ȣ�� �Է����ּ��� : ");
		System.out.println("============================================================");
		
		List<AccountVO> list = service.accountInfoNoUI(accountNO);

		if(list.isEmpty()) {
			System.out.println("��ϵ� ���°� �����ϴ�.");
		} else {
			System.out.println("�����\t���¹�ȣ\t�����ָ�\t�ܰ�\t��Ī");
			for (AccountVO account : list) {
				System.out.println(account.getBank() + "\t" + account.getAccountNo() 
				+ "\t" + account.getAccountHolder() + "\t" + account.getBalance() 
				+  "\t" + account.getNickName());
			}
		}
		System.out.println("============================================================");

	}
	
	

}