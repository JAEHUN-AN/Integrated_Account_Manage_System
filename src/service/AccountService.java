package service;

import java.util.List;

import dao.AccountDAO;
import vo.AccountVO;
import vo.UserVO;

public class AccountService {
	
	public static UserVO user;
	private AccountDAO accountDAO;
	
	
	public AccountService() {
		accountDAO = new AccountDAO();
	}
	
	public UserVO login(String id, String pw) {
		user = accountDAO.login(id,pw); 
		return user;
	}
	
	public void join(String id, String pw, String name) {
		accountDAO.join(id, pw, name);
	}
	
	public List<AccountVO> accountInfoAllUI() {
		
		return accountDAO.accountInfoAll();
	}
	
	public List<AccountVO> accountInfoNoUI(String accountNO){
		return accountDAO.accountInfoNoUI(accountNO);
	}
	
	public List<AccountVO> accountInfoBankUI(String bank){
		return accountDAO.accountInfoBankUI(bank);
	}
	
	public void accountAddUI(AccountVO account, String userId) {
		accountDAO.accountAddUI(account, userId);
	}
	
	public void accountUpdateUI(String accountNo, String nickName) {
		accountDAO.accountUpdateUI(accountNo, nickName);
	}

	public void accountDeleteUI(String accountNo) {
		accountDAO.accountDeleteUI(accountNo);
	}

	public void depositUI(String accountNo, int money) {
		accountDAO.depositUI(accountNo, money);
	}
	
	public void transferUI(String accountNoFrom, int money, String accountNoTo) {
		accountDAO.transferUI(accountNoFrom, money, accountNoTo);
	}
	
	public void withrawUI(String accountNo, int money) {
		accountDAO.withrawUI(accountNo, money);
	}
	
	public void createAccountUI(String accountNo, String bank, String accountHolder, int firstMoney, String alias) {
		accountDAO.createAccountUI(accountNo, bank, accountHolder, firstMoney, alias);
	}

	public void showAllUser() {
		accountDAO.showAllUser();
	}

	public void showAllAccount() {
		accountDAO.showAllAccount();
	}

	public boolean adminLogin(String id, String password) {
		// TODO Auto-generated method stub
		boolean isLogin = accountDAO.adminLogin(id, password);
		return isLogin;
	}

}


