package ui;

import java.util.Random;

public class CreateAccountUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		Random r = new Random();
		
		System.out.println("���� ���� �����Դϴ�.");
		System.out.println("[ �ϳ� ] ���ุ ��� �����մϴ�.");
		String bank = "�ϳ�";
		String accountHolder = scanStr("�����ָ��� �Է��ϼ��� : ");
		String nickName = scanStr("������ ��Ī�� �Է��ϼ��� : ");
		int firstMoney = scanInt("ó�� �Ա��Ͻ� �ݾ��� �Է����ּ���(1000�� �̻�) : ");
		
		while(firstMoney < 1000) {			
			firstMoney = scanInt("ó�� �Ա��Ͻ� �ݾ��� �Է����ּ���(1000�� �̻�) : ");
		}

		StringBuilder sql = new StringBuilder();
		for(int i = 1; i <= 7; i++) {
			if(i % 4 == 0) {
				sql.append("-");
			} else {
				int num = r.nextInt(10);
				sql.append(num);
			}
		}
		String accountNo = sql.toString();
		service.createAccountUI(accountNo, bank, accountHolder, firstMoney, nickName);
		
	}

}