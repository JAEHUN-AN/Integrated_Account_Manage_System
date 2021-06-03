package ui;


public class AdminUI extends BaseUI {
	public void showMenu() {
		System.out.println();
		System.out.println("������ �����Դϴ�.");
		System.out.println();
		System.out.println("==========================================");
		System.out.println("1. ���� ��ȸ"); 
		System.out.println("2. SQL UI");
		System.out.println("0. �ڷ� ����"); 
		System.out.println("==========================================");
		System.out.println();
		System.out.print("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
	}
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		
		while(true) {
			myui = new AdminLoginUI();
			myui.execute();
			if(AdminLoginUI.isLogin()) {
				//true �� �α���
				//�α��� �� Ż��
				break;
			}// �α��� ���н� Ż�� ���� ����
			System.out.println();
			System.out.println("======�����÷��� 0��, �ٽ� �õ��Ϸ��� �ƹ� Ű�� �Է����ּ���.======");
			System.out.println();
			if(scanInt("") == 0) {
				return;
			}
		}
		
		int serviceNum = -1;
		while ( serviceNum != 0) {
			showMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new ShowAllUserUI();
				myui.execute();
				break;
			case 2:
				myui = new SqlUI();
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
