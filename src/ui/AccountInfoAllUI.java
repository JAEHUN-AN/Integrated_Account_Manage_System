package ui;

import java.util.List;

import vo.AccountVO;

public class AccountInfoAllUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("============================================================");
		System.out.println("���� ��ü ��ȸ �����Դϴ�.");
		System.out.println("============================================================");
		List<AccountVO> list = service.accountInfoAllUI();

		if(list.isEmpty()) {
			System.out.println("��ϵ� ���°� �����ϴ�.");
		} else {
			System.out.println("�����\t���¹�ȣ\t\t�����ָ�\t�ܰ�\t\t��Ī");
			
			for (AccountVO account : list) {
				System.out.println(account.getBank() + "\t" + account.getAccountNo() 
				+ "\t\t" + account.getAccountHolder() + "\t" + account.getBalance() 
				+  "\t\t" + account.getNickName());
			}
		}
		System.out.println("============================================================");
	}
}