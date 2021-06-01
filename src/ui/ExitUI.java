package ui;

public class ExitUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("서비스를 종료합니다.");
		System.exit(0);
	}

}