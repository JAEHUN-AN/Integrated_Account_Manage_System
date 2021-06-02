package vo;

public class AccountVO {
	private String id; //아이디
	private String pw; //비밀번호
	private String bank; //은행명
	private String accountNo; //계좌번호
	private String accountHolder; //계좌주명
	private int    balance; //잔액
	private String nickName; //별칭
	
	public AccountVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccountVO(String id, String pw, String bank, String accountNo, String accountHolder, int balance,
			String nickName) {
		super();
		this.id = id;
		this.pw = pw;
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.nickName = nickName;
	}
	
	
	public AccountVO(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}
	
	public AccountVO(String bank, String accountNo, String accountHolder, int balance, String nickName) {
		super();
		this.bank = bank;
		this.accountNo = accountNo;
		this.accountHolder = accountHolder;
		this.balance = balance;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountHolder() {
		return accountHolder;
	}

	public void setAccountHolder(String accountHolder) {
		this.accountHolder = accountHolder;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		return "AccountVO [id=" + id + ", pw=" + pw + ", bank=" + bank + ", accountNo=" + accountNo + ", accountHolder="
				+ accountHolder + ", balance=" + balance + ", nickName=" + nickName + "]";
	}

	
}
