package ui;

public class SearchOneUI extends BaseUI{
	@Override
	public void execute() throws Exception{
		int no = scanInt("조회할 글번호를 입력하세요 : ");
		
		System.out.println("--------------------------");
		System.out.println("\t 번호 : ");
		System.out.println("\t 제목 : ");
		System.out.println("\t 글쓴이 : ");
		System.out.println("\t 등록일 : ");
		System.out.println("--------------------------");
	}
}
