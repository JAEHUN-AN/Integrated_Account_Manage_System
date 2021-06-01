package ui;

import java.util.List;

import vo.AccountVO;

public class AccountInfoBankUI extends BaseUI {

	@Override
	public void execute() throws Exception {
		System.out.println("============================================================");
		System.out.println("은행명으로 계좌를 조회하는 서비스입니다.");
		System.out.println("============================================================");
		System.out.println("[하나], [우리], [신한], [국민] 만 가능합니다.");
		String bank = scanStr("은행명을 입력해주세요 : ");
		System.out.println("============================================================");
		
		List<AccountVO> list = service.accountInfoBankUI(bank);

		if(list.isEmpty()) {
			System.out.println("등록된 계좌가 없습니다.");
		} else {
			System.out.println("은행명\t계좌번호\t계좌주명\t잔고\t별칭");
			for (AccountVO account : list) {
				System.out.println(account.getBank() + "\t" + account.getAccountNo() 
				+ "\t" + account.getAccountHolder() + "\t" + account.getBalance() 
				+  "\t" + account.getNickName());
			}
		}
		System.out.println("============================================================");

	}
	

}