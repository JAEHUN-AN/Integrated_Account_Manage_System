package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import util.ConnectionFactory;
import util.JDBCClose;
import vo.AccountVO;
import vo.UserVO;


public class AccountDAO {

	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private UserVO userVO = new UserVO();//new UserVO();
	private StringBuilder sql;
	private List<AccountVO> list;

	public UserVO login(String id, String pw) {
		
		try {
			conn = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			
			sql.append("SELECT ID, PW, NAME FROM USER_TABLE WHERE ID = ? AND PW = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
		
			rs = pstmt.executeQuery();

			if(!rs.next()) {
				System.out.println(">>>해당 ID 정보가 없습니다.");
				System.out.println("다시 입력해주세요.");
			} else {
				String userId = rs.getString(1);
				String password = rs.getString(2);
				String name = rs.getString(3);
				System.out.println("==============================");
				System.out.println("[" + name + "]님! 반갑습니다.");
				System.out.println("==============================");
				userVO.setId(userId);
				userVO.setPw(password);
				userVO.setName(name);
				
				UserVO user = new UserVO();
				user.setId(userId);
				user.setPw(password);
				user.setName(name);
				//계좌 여부 체크
				List<AccountVO> list = accountInfoAll(); 
				if(list.isEmpty()) {
					System.out.println();
					System.out.println("==============================");
					System.out.println("\t[" + name + "]님! 계좌가 없습니다.");
					System.out.println("\t계좌를 생성해주시기 바랍니다.");
					System.out.println("==============================");
					System.out.println();
				}
				
				userVO.setName(null);
				return user;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
		
		return userVO;
	}

	public void join(String id, String pw, String name) {
		
		try {
			conn = new ConnectionFactory().getConnection();
			conn.setAutoCommit(false);
			sql = new StringBuilder();
			
			sql.append("SELECT ID FROM USER_TABLE WHERE ID = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				System.out.println(">>>이미 존재하는 ID입니다.");
			} else {
				sql = new StringBuilder();
				sql.append("INSERT INTO USER_TABLE(ID, PW, NAME) VALUES(?,?,?) ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				pstmt.setString(2, pw);
				pstmt.setString(3, name);
				pstmt.executeUpdate();
				conn.commit();

				System.out.println(name + "님, 회원가입이 성공적으로 완료됐습니다.");
				userVO = new UserVO(id, pw);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch(SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
	}
	
	public List<AccountVO> accountInfoAll() {
		conn = new ConnectionFactory().getConnection();
		list = new ArrayList<AccountVO>();
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM ACCOUNT_SYSTEM WHERE user_ID = ? ORDER BY BANK");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userVO.getId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
//				System.out.println(rs.getString(1));
				String bank = rs.getString("BANK");
				String accountNo = rs.getString("ACCOUNT_NO");
				String accountHolder = rs.getString("ACCOUNT_HOLDER");
				int balance = rs.getInt("BALANCE");
				String nickName = rs.getString("nickName");
				AccountVO accountVO = new AccountVO(bank, accountNo, accountHolder, balance, nickName);
				list.add(accountVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
		return list;
	}
	
	public List<AccountVO> accountInfoNoUI(String accountNO) {
		conn = new ConnectionFactory().getConnection();
		list = new ArrayList<AccountVO>();
		
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM ACCOUNT_SYSTEM WHERE ACCOUNT_NO = ? AND user_ID = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, accountNO);
			pstmt.setString(2, userVO.getId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bank = rs.getString("BANK");
				String accountNo = rs.getString("ACCOUNT_NO");
				String accountHolder = rs.getString("ACCOUNT_HOLDER");
				int balance = rs.getInt("BALANCE");
				String nickName = rs.getString("nickName");
				AccountVO accountVO = new AccountVO(bank, accountNo, accountHolder, balance, nickName);
				list.add(accountVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}	
		return list;
	}
	
	public List<AccountVO> accountInfoBankUI(String bankName) {
		conn = new ConnectionFactory().getConnection();
		list = new ArrayList<AccountVO>();
		
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM ACCOUNT_SYSTEM WHERE BANK = ? AND user_ID = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, bankName);
			pstmt.setString(2, userVO.getId());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String bank = rs.getString("BANK");
				String accountNo = rs.getString("ACCOUNT_NO");
				String accountHolder = rs.getString("ACCOUNT_HOLDER");
				int balance = rs.getInt("BALANCE");
				String nickName = rs.getString("nickName");
				AccountVO accountVO = new AccountVO(bank, accountNo, accountHolder, balance, nickName);
				list.add(accountVO);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}	
		return list;
	}
	
	
	public void accountAddUI(AccountVO account, String userId) {
		conn = new ConnectionFactory().getConnection();
		
		try {
			conn.setAutoCommit(false);
			String tableName = account.getBank();
			//은행 별 계좌 테이블에 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("INSERT INTO ACCOUNT_" + tableName 
			+ "(ACCOUNT_NO, BANK, ACCOUNT_HOLDER, BALANCE, nickName, user_ID) VALUES(?, ?, ?, ?, ?, ?) ");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, account.getAccountNo());
			pstmt.setString(2, account.getBank());
			pstmt.setString(3, account.getAccountHolder());
			pstmt.setInt(4, account.getBalance());
			pstmt.setString(5, account.getNickName());
			pstmt.setString(6, userId);
			pstmt.executeUpdate();

			//계좌시스템에 계좌 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("INSERT INTO ACCOUNT_SYSTEM (ACCOUNT_NO, BANK, ACCOUNT_HOLDER, BALANCE, nickName, user_ID) ");
			sql.append(" VALUES(?, ?, ?, ?, ?, ?)");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, account.getAccountNo());
			pstmt.setString(2, account.getBank());
			pstmt.setString(3, account.getAccountHolder());
			pstmt.setInt(4, account.getBalance());
			pstmt.setString(5, account.getNickName());
			pstmt.setString(6, userId);
			pstmt.executeUpdate();
			
			conn.commit();
			System.out.println("계좌등록이 완료됐습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
			
		}
	}
	
	public void accountUpdateUI(String accountNo, String nickName) {
		conn = new ConnectionFactory().getConnection();
		
		try {
			conn.setAutoCommit(false);
			List<AccountVO> updateList = accountInfoNoUI(accountNo);
			String tableName="";
			for(AccountVO vo : updateList) {
				tableName = vo.getBank();
			}
			//은행 별 계좌 테이블에 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("UPDATE ACCOUNT_"+ tableName 
					+ "SET nickName = ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, nickName);
			pstmt.setString(2, nickName);
			pstmt.setString(3, accountNo);
			pstmt.setString(4, userVO.getId());
			pstmt.executeUpdate();
			
			//은행 별 계좌 테이블에 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("UPDATE ACCOUNT_SYSTEM SET nickName = ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, nickName);
			pstmt.setString(2, nickName);
			pstmt.setString(3, accountNo);
			pstmt.setString(4, userVO.getId());
			pstmt.executeUpdate();
			
			conn.commit();
			System.out.println("해당 계좌의 별칭을 수정했습니다.");

			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}
		
	}
	
	public void accountDeleteUI(String accountNo) {
		conn = new ConnectionFactory().getConnection();

		try {
			conn.setAutoCommit(false);
			sql = new StringBuilder();
			
			List<AccountVO> updateList = accountInfoNoUI(accountNo);
			String tableName="";
			for(AccountVO vo : updateList) {
				tableName = vo.getBank();
			}
			//은행 별 계좌 테이블에 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("DELETE FROM ACCOUNT_"+ tableName 
					+ " WHERE ACCOUNT_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNo);
			pstmt.executeUpdate();
			
			//은행 별 계좌 테이블에 등록
			//ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
			sql = new StringBuilder();
			sql.append("DELETE FROM ACCOUNT_SYSTEM WHERE ACCOUNT_NO = ? ");

			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, accountNo);
			pstmt.executeUpdate();
			
			conn.commit();
			System.out.println("해당 계좌를 삭제했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	

	public void depositUI(String accountNo, int money) {
		conn = new ConnectionFactory().getConnection();
		try {
			conn.setAutoCommit(false);
			sql = new StringBuilder();
			sql.append("UPDATE ACCOUNT_SYSTEM SET BALANCE = BALANCE + ? WHERE ACCOUNT_NO = ? AND user_ID = ?");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1, money);
			pstmt.setString(2, accountNo);
			pstmt.setString(3, userVO.getId());
			pstmt.executeUpdate();
			conn.commit();
			System.out.println(money + "원을 입금했습니다.");

			
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}

	public void withrawUI(String accountNo, int money) {
		conn = new ConnectionFactory().getConnection();
		try {
			sql = new StringBuilder();
			sql.append("SELECT BALANCE FROM ACCOUNT_SYSTEM WHERE ACCOUNT_NO = ? AND user_ID = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, accountNo);
			pstmt.setString(2, userVO.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 해당 계좌가 있으면
				int balance = rs.getInt("BALANCE");
				
				if(money > balance) {
					System.out.println(">>>잔액이 부족합니다. ");
				} else {
					conn.setAutoCommit(false);
					sql = new StringBuilder();
					sql.append("UPDATE ACCOUNT_SYSTEM SET BALANCE = BALANCE - ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, money);
					pstmt.setString(2, accountNo);
					pstmt.setString(3, userVO.getId());
					pstmt.executeUpdate();
					conn.commit();
					System.out.println(money + "원을 인출했습니다.");
					
				}
			} else { // 해당 계좌가 없으면
				System.out.println(">>>해당 계좌가 없습니다.");
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
		}
	}
	
	public void transferUI(String accountNoFrom, int money, String accountNoTo) {
		conn = new ConnectionFactory().getConnection();
		try {
			List<AccountVO> updateList = accountInfoNoUI(accountNoFrom);
			
			//은행명 저장
			String tableName_From="";
			for(AccountVO vo : updateList) {
				tableName_From = vo.getBank();
			}
			updateList = accountInfoNoUI(accountNoTo);
			//은행명 저장
			String tableName_To="";
			for(AccountVO vo : updateList) {
				tableName_To = vo.getBank();
			}
			conn = new ConnectionFactory().getConnection();
			sql = new StringBuilder();
			sql.append("SELECT BALANCE FROM ACCOUNT_SYSTEM WHERE ACCOUNT_NO = ?");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, accountNoFrom);
			rs = pstmt.executeQuery();
			
			int balance = 0;
			while (rs.next()) {
				balance = rs.getInt("BALANCE");
			}
			
			if(money > balance) {
				System.out.println(">>>잔액이 부족합니다. ");
			} else {
				pstmt.clearParameters();
				sql = new StringBuilder();
				sql.append("SELECT * FROM ACCOUNT_SYSTEM WHERE ACCOUNT_NO = ? AND user_ID = ?");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, accountNoTo);
				pstmt.setString(2, userVO.getId());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					conn.setAutoCommit(false);
					
					// Account_SYSTEM 내의 두개 조정 
					// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
					pstmt.clearParameters();
					sql = new StringBuilder();
					sql.append("UPDATE ACCOUNT_SYSTEM SET BALANCE = BALANCE - ? WHERE ACCOUNT_NO = ? AND user_ID = ?");
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, money);
					pstmt.setString(2, accountNoFrom);
					pstmt.setString(3, userVO.getId());
					pstmt.executeUpdate();
					
					pstmt.clearParameters();
					sql = new StringBuilder();
					sql.append("UPDATE ACCOUNT_SYSTEM SET BALANCE = BALANCE + ? WHERE ACCOUNT_NO = ? AND user_ID = ?");
					pstmt = conn.prepareStatement(sql.toString());
					pstmt.setInt(1, money);
					pstmt.setString(2, accountNoTo);
					pstmt.setString(3, userVO.getId());
					pstmt.executeUpdate();
						
							
					// ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
					// 통합 계좌 은행 테이블 수정 구간
					
					if (tableName_From.equals("하나") && !tableName_To.equals("하나")) {
						
						pstmt.clearParameters();
						sql = new StringBuilder();
						sql.append("UPDATE ACCOUNT_" + tableName_To 
								+ " SET BALANCE = BALANCE + ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");
						pstmt = conn.prepareStatement(sql.toString());
						pstmt.setInt(1, money);
						pstmt.setString(2, accountNoTo);
						pstmt.setString(3, userVO.getId());
						pstmt.executeUpdate();
						
					} else if(!tableName_From.equals("하나") && tableName_To.equals("하나")) {
						pstmt.clearParameters();
						sql = new StringBuilder();
						sql.append("UPDATE ACCOUNT_" + tableName_From 
								+ " SET BALANCE = BALANCE - ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");
						pstmt = conn.prepareStatement(sql.toString());
						pstmt.setInt(1, money);
						pstmt.setString(2, accountNoFrom);
						pstmt.setString(3, userVO.getId());
						pstmt.executeUpdate();
						
					}else if(!tableName_From.equals("하나") && !tableName_To.equals("하나")) {
						pstmt.clearParameters();
						sql = new StringBuilder();
						sql.append("UPDATE ACCOUNT_" + tableName_From 
								+ " SET BALANCE = BALANCE - ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");
						pstmt = conn.prepareStatement(sql.toString());
						pstmt.setInt(1, money);
						pstmt.setString(2, accountNoFrom);
						pstmt.setString(3, userVO.getId());
						pstmt.executeUpdate();
						
						pstmt.clearParameters();
						sql = new StringBuilder();
						sql.append("UPDATE ACCOUNT_" + tableName_To 
								+ " SET BALANCE = BALANCE + ? WHERE ACCOUNT_NO = ? AND user_ID = ? ");
						pstmt = conn.prepareStatement(sql.toString());
						pstmt.setInt(1, money);
						pstmt.setString(2, accountNoTo);
						pstmt.setString(3, userVO.getId());
						pstmt.executeUpdate();
					}
					
					conn.commit();
					System.out.println("\'"+ accountNoTo +"\' 계좌로 " + money + "원 이체 완료했습니다.");
					} else {
					System.out.println(">>>이체받을 계좌번호가 정확하지 않습니다.");
				}
				
			}
	
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
	}
	
				
	public void createAccountUI(String accountNo, String bank, String accountHolder, int firstMoney, String nickName) {
		
		conn = new ConnectionFactory().getConnection();
		
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM ACCOUNT_SYSTEM WHERE user_ID = ? ");
			sql.append(" and sysdate > add_months(create_date, 1) ORDER BY Create_date DESC ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, userVO.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 결과가 없으면 새 계좌 생성
				conn.setAutoCommit(false);
				sql = new StringBuilder();
				sql.append("INSERT INTO ACCOUNT_SYSTEM(ACCOUNT_NO, BANK, ACCOUNT_HOLDER, BALANCE, nickName, user_ID) VALUES(?, ?, ?, ?, ?, ?) ");
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, accountNo);
				pstmt.setString(2, bank);
				pstmt.setString(3, accountHolder);
				pstmt.setInt(4, firstMoney);
				pstmt.setString(5, nickName);
				pstmt.setString(6, userVO.getId());
				pstmt.executeUpdate();
				conn.commit();
					
			}else {// 결과가 있으면 한 달 제한 안내
				System.out.println();
				System.out.println("한 달 뒤에 생성 가능합니다.");
				System.out.println();
			}
			System.out.println("새로운 계좌를 생성했습니다.");

		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
	}

	public void showAllUser() {
		conn = new ConnectionFactory().getConnection();
		
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM User_table ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			System.out.println("================유저 목록=================");
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				
				System.out.print("\t id : " + id);
				System.out.println("\t이름 : " + name);
			}
			System.out.println("========================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
	}


	public void showAllAccount() {
		conn = new ConnectionFactory().getConnection();
		
		try {
			sql = new StringBuilder();
			sql.append("SELECT * FROM ACCOUNT_SYSTEM ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			
			System.out.println("==================================계좌 목록===================================");
			while(rs.next()) {
				String rs1 = rs.getString(1);
				String rs2 = rs.getString(2);
				String rs3 = rs.getString(3);
				String rs4 = rs.getString(4);
				String rs5 = rs.getString(5);
				String rs6 = rs.getString(6);
				String rs7 = rs.getString(7);
				
				System.out.print("\t ACCOUNT_NO : " + rs1);
				System.out.print("\t BANK : " + rs2);
				System.out.print("\t ACCOUNT_HOLDER : " + rs3);
				System.out.print("\t BALANCE : " + rs4);
				System.out.print("\t NICKNAME : " + rs5);
				System.out.print("\t USER_ID : " + rs6);
				System.out.print("\t CREATE_DATE : " + rs7);
				System.out.println();
			}
			System.out.println("============================================================================");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
	}

	public boolean adminLogin(String id, String pw) {
		conn = new ConnectionFactory().getConnection();
		try {
			sql = new StringBuilder();
			sql.append("SELECT ID, PW, NAME FROM ADMIN_TABLE WHERE ID = ? AND PW = ? ");
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			rs = pstmt.executeQuery();
			if(!rs.next()) {
				System.out.println("==============해당 ID 정보가 없습니다.===============");
				System.out.println();
				System.out.println("=================다시 입력해주세요.=================");
				return false;
			} else {
				String name = rs.getString(3);
				System.out.println("==============================");
				System.out.println("관리자 [" + name + "]님! 반갑습니다.");
				System.out.println("==============================");
				return true;
			}
		} catch (Exception e) {
			System.out.println("====관리자 로그인이 실패하였습니다. 다시해주세요.====");
		} finally {
			JDBCClose.close(conn, pstmt);
			JDBCClose.close(rs);
		}
		return false;
	}
}
