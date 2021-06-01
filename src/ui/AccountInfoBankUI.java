package ui;

import java.util.List;

import vo.AccountVO;

public class AccountInfoBankUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("============================================================");
		System.out.println("��������� ���¸� ��ȸ�ϴ� �����Դϴ�.");
		System.out.println("============================================================");
		System.out.println("[�ϳ�], [�츮], [����], [����] �� �����մϴ�.");
		String bank = scanStr("������� �Է����ּ��� : ");
		System.out.println("============================================================");
		
		List<AccountVO> list = service.accountInfoBankUI(bank);

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