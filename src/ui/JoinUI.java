package ui;

public class JoinUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		System.out.println("ȸ������ �����Դϴ�.");
		String id = scanStr("����Ͻ� ID�� �Է����ּ��� : ");
		
		String password = null;
		String password2 = null;
		boolean check = true;
		
		while(check) {
			password = scanStr("����Ͻ� ��й�ȣ�� �Է����ּ��� : ");
			password2 = scanStr("�����ȣ�� �ѹ� �� �Է����ּ��� : ");
			
			if(password.equals(password2)) {
				System.out.println("��й�ȣ�� ��ġ�մϴ�.");
				System.out.println("������ �����մϴ�.");
				check = false;
			} else {
				System.out.println("��й�ȣ�� ��ġ���� �ʽ��ϴ�. �ٽ� �������ּ���.");
			}
		}
		String name = scanStr("�̸��� �Է���w�ּ��� : ");
		service.join(id, password, name);
		
	}
	
}