package ui;

public class TotalAccountUI extends BaseUI{
	public void showMenu() {
		System.out.println("���հ��� ���� �����Դϴ�.");
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. ���� ���� ���"); 
		System.out.println("2. ���� ���� ��Ī ����");
		System.out.println("3. ���� ���� ����"); 
		System.out.println("0. �ڷ� ����"); 
		System.out.println("==============================");
		System.out.println();
		System.out.print("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
	}
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		int serviceNum = -1;
		while ( serviceNum != 0) {
			showMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new AccountAddUI();
				myui.execute();
				break;
			case 2:
				myui = new AccountUpdateUI();
				myui.execute();
				break;
			case 3:
				myui = new AccountDeleteUI();
				myui.execute();
				break;
			case 0:
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				System.out.println();
			}
		}
		
	}

}