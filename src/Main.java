import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		List<WiseSaying> wiseSayings = new ArrayList<>();

		int lastid = 0;

		while (true) {
			System.out.println("== 명언 앱 실행 ==");

			System.out.print("명령어 : ");
			String cmd = sc.nextLine().trim();

			if (cmd.equals("등록")) {

				int id = lastid + 1;
				
				System.out.print("명언 : ");
				String content = sc.nextLine();

				System.out.print("작가 : ");
				String author = sc.nextLine();
				
				String regDate = Container.getRegDate();
				
				WiseSaying wiseSaying = new WiseSaying(id, content, author, regDate);
				wiseSayings.add(wiseSaying);

				System.out.printf("%d 번 명언이 등록되었습니다.\n", id);

				lastid++;
			} else if (cmd.equals("목록")) {
				System.out.println("번호  /  작가  /  명언");
				System.out.println("========================");

				for (int i = wiseSayings.size() - 1; i >= 0; i--) {
					WiseSaying wiseSaying = wiseSayings.get(i);
					System.out.println(
							wiseSaying.getId() + " / " + wiseSaying.getContent() + " / " + wiseSaying.getAuthor());
				}

			} else if (cmd.startsWith("상세보기")) {

				String[] bits = cmd.split("\\?");
				if (bits.length == 1) {
					System.out.println("다시 입력하세요");
					continue;
				}
				String idBits = bits[1];

				String[] bits2 = idBits.split("=");

				int idNo = 0;

				try {
					idNo = Integer.parseInt(bits2[1]);
				} catch (Exception e) {
					System.out.println("다시 입력하세요");
				}

				for (int i = 0; i <= wiseSayings.size() - 1; i++) {
					WiseSaying wiseSaying = wiseSayings.get(i);
					if (wiseSaying.getId() == idNo) {
						System.out.println("번호 : " + wiseSaying.getId());
						System.out.println("날짜 : " + wiseSaying.getRegDate());
						System.out.println("작가 : " + wiseSaying.getAuthor());
						System.out.println("내용 : " + wiseSaying.getContent());
					}
				}
			} else if (cmd.startsWith("삭제")) {

				String[] bits = cmd.split("\\?");
				if (bits.length == 1) {
					System.out.println("다시 입력하세요");
					continue;
				}
				String idBits = bits[1];

				String[] bits2 = idBits.split("=");

				int idNo = -1;

				try {
					int idtestNo = Integer.parseInt(bits2[1]);
					idNo = idtestNo;
				} catch (Exception e) {
					System.out.println("다시 입력하세요");
				}

				WiseSaying wiseSaying;

				for (int i = 0; i <= wiseSayings.size() - 1; i++) {
					wiseSaying = wiseSayings.get(i);
					if (wiseSaying.getId() == idNo) {
						wiseSayings.remove(wiseSaying);
					}
				}

				System.out.println(idNo + "번 명언이 삭제되었습니다.");

			} else if (cmd.startsWith("수정")) {

				String[] bits = cmd.split("\\?");
				if (bits.length == 1) {
					System.out.println("다시 입력하세요");
					continue;
				}
				String idBits = bits[1];

				String[] bits2 = idBits.split("=");

				int idNo = -1;

				try {
					int idtestNo = Integer.parseInt(bits2[1]);
					idNo = idtestNo;
				} catch (Exception e) {
					System.out.println("다시 입력하세요");
				}

				WiseSaying wiseSaying;

				for (int i = 0; i <= wiseSayings.size() - 1; i++) {
					wiseSaying = wiseSayings.get(i);
					if (wiseSaying.getId() == idNo) {
						System.out.println("명언(기존) : " + wiseSaying.getContent());
						System.out.println("작가(기존) : " + wiseSaying.getAuthor());
						System.out.print("명언 : ");
						String content = sc.nextLine();

						System.out.print("작가 : ");
						String author = sc.nextLine();
						wiseSaying.setContent(content);
						wiseSaying.setAuthor(author);
					}
				}

			}

		}

	}

}
