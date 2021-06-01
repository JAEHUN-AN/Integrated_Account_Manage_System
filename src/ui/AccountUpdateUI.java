package ui;

public class AccountUpdateUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		
		System.out.println("계좌의 별칭을 수정할 수 있습니다.");
		// 전체 계좌리스트 보여주기
		String accountNo = scanStr("수정을 원하시는 계좌번호를 입력해주세요 : ");
		String alias = scanStr("변경할 별칭을 적어주세요 : ");
		
		service.accountUpdateUI(accountNo, alias);
		
	}
	

}