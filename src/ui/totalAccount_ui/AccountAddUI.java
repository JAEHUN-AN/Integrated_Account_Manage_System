package ui.totalAccount_ui;

import ui.BaseUI;
import vo.AccountVO;

public class AccountAddUI extends BaseUI{
	
	@Override
	public void execute() throws Exception {
		
		System.out.println("���� ��� �����Դϴ�.");
		System.out.println(" [ ����, �츮, ���� , ��� ] ���ุ ��� �����մϴ�.");
		String bank = scanStr("������ �Է����ּ��� : ");
		
		while(!bank.equals("����") && !bank.equals("�츮") 
				&& !bank.equals("����") && !bank.equals("���")) {
			System.out.println(" [ ����, �츮, ���� , ��� ] ���ุ ��� �����մϴ�.");
			System.out.println("�ٽ� �Է����ּ���.");
			bank = scanStr("������ �Է����ּ��� : ");
		}
		
		String accountNo = scanStr("���¹�ȣ�� �Է��ϼ���(��: 110-356) : ");
		String accountHolder = scanStr("�����ָ��� �Է��ϼ��� : ");
		int balance = scanInt("�Ա� �ݾ��� �Է����ּ��� : ");
		String nickName = scanStr("������ ��Ī�� �Է��ϼ��� : ");
		
		AccountVO account = new AccountVO();
		account.setBank(bank);
		account.setAccountNo(accountNo);
		account.setAccountHolder(accountHolder);
		account.setBalance(balance);
		account.setNickName(nickName);
		
		
		service.accountAddUI(account, BaseUI.user.getId());

	}

}