package ui;

import java.util.List;

import vo.AccountVO;

public class AccountInfoAllUI extends BaseUI{

	@Override
	public void execute() throws Exception {
		System.out.println("============================================================");
		System.out.println("계좌 전체 조회 서비스입니다.");
		System.out.println("============================================================");
		List<AccountVO> list = service.accountInfoAllUI();

		if(list.isEmpty()) {
			System.out.println("등록된 계좌가 없습니다.");
		} else {
			System.out.println("은행명\t계좌번호\t\t계좌주명\t잔고\t\t별칭");
			
			for (AccountVO account : list) {
				System.out.println(account.getBank() + "\t" + account.getAccountNo() 
				+ "\t\t" + account.getAccountHolder() + "\t" + account.getBalance() 
				+  "\t\t" + account.getNickName());
			}
		}
		System.out.println("============================================================");
	}
}