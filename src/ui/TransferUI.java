package ui;

public class TransferUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("��ü �����Դϴ�.");
		// ��ü ���¸���Ʈ
		String accountNoFrom = scanStr("��ü�Ͻ� ���¹�ȣ�� �Է����ּ��� : ");
		int money = scanInt("��ü�Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		
		while(money <= 0) {
			System.out.println("0�� �ʰ� �ݾ׸� ��ü �����մϴ�.");
			money = scanInt("��ü�Ͻ� �ݾ��� �Է����ּ���(���ڸ� �Է�) : ");
		}
		
		
		String accountNoTo = scanStr("���� ���¹�ȣ�� �Է����ּ��� : ");
		service.transferUI(accountNoFrom, money, accountNoTo);
		
	}

}