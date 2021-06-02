package ui;

public class MainUI extends BaseUI {

	public void showFirstMenu() {
		System.out.println("==============================");
		System.out.println("\t1. �α���");
		System.out.println("\t2. ȸ������");
		System.out.println("==============================");
	}
	
	public void showSecondMenu() {
		System.out.println();
		System.out.println("==============================");
		System.out.println("1. ���� ��ü ��ȸ"); // AccountInfoAllUI
		System.out.println("2. ���¹�ȣ�� ��ȸ"); // AccountInfoNoUI
		System.out.println("3. ���ະ ���� ��ȸ"); // AccountInfoBankUI
		System.out.println("4. ���հ��� ����"); // AccountAddUI
		System.out.println("5. �Ա�"); // AccountUpdateUI
		System.out.println("6. ���"); // AccountDeleteUI
		System.out.println("7. ��ü"); // DepositUI
		System.out.println("8. ���� �ű� ����"); // WithrawUI
		System.out.println("0. ����"); // ExitUI
		System.out.println("==============================");
		System.out.println();
		System.out.print("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
	}
	
	public void showLoginUI(MyAccountUI myui, int logJoin) throws Exception {
		logJoin = scanInt("���Ͻô� ���� ��ȣ�� �Է��ϼ��� : ");
		if(logJoin == 1) {
			myui = new LoginUI();
			myui.execute();
			BaseUI.user = ((LoginUI) myui).user();
		} else if(logJoin == 2) {
			myui = new JoinUI();
			myui.execute();
		} else
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
	}
	
	@Override
	public void execute() throws Exception {
		MyAccountUI myui = null;
		
		showFirstMenu();		
		int logJoin = 0;
		while(BaseUI.user == null) { //�α��� �� user�� ���� �� ���� �ݺ�
			showLoginUI(myui, logJoin);
		}
		
		int serviceNum = 1;
		while (serviceNum != 0) {

			showSecondMenu();
			serviceNum = scanInt("");

			switch (serviceNum) {
			case 1:
				myui = new AccountInfoAllUI();
				myui.execute();
				break;
			case 2:
				myui = new AccountInfoNoUI();
				myui.execute();
				break;
			case 3:
				myui = new AccountInfoBankUI();
				myui.execute();
				break;
			case 4:
				myui = new TotalAccountUI();
				myui.execute();
				break;
			case 5:
				myui = new DepositUI();
				myui.execute();
				break;
			case 6:
				myui = new WithrawUI();
				myui.execute();
				break;
			case 7:
				myui = new TransferUI();
				myui.execute();
				break;
			case 8:
				myui = new CreateAccountUI();
				myui.execute();
				break;
			case 0:
				myui = new ExitUI();
				myui.execute();
				break;
			default:
				System.out.println("��ȣ�� �߸� �Է��ϼ̽��ϴ�.");
				System.out.println();
			}
		}
	}
}