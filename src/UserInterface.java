import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
	public static void main(String args[]) throws Exception {
		Scanner scan = new Scanner(System.in);
		ScheduleManager manager = new ScheduleManager();
		Schedule s;

		Menu.menu(); // 메뉴 출력

		while (true) {
			System.out.println();
			System.out.print("원하시는 프로그램의 번호를 입력해 주세요: ");

			int choice = 0;

			while (true) {
				try {
					choice = scan.nextInt(); // 실행할 프로그램의 번호를 입력받음
					break;
				} catch (InputMismatchException e) {
					scan = new Scanner(System.in);
					System.out.println("잘못된 입력입니다. 다시 입력해 주세요.");
					System.out.println();
					System.out.print("원하시는 프로그램의 번호를 입력해 주세요: ");
				}
			}

			switch (choice) { // 입력된 번호에 따라 해당하는 메소드를 실행
			case 1:
				// 추가할 일정의 정보를 입력받고 객체 생성 후 일정 배열에 추가
				System.out.println("추가할 일정을 작성해 주세요.");

				while (true) {
					int year = 0, month = 0, day = 0, hour = 0, minute = 0;
					String content = null;

					try {
						System.out.print("연: ");
						year = scan.nextInt();
						if (year < 1) {
							throw new Exception();
						}

						System.out.print("월: ");
						month = scan.nextInt();
						if (month < 1 || month > 12) {
							throw new Exception();
						}

						System.out.print("일: ");
						day = scan.nextInt();
						if (day < 1 || day > 31) {
							throw new Exception();
						}

						System.out.print("시: ");
						hour = scan.nextInt();
						if (hour < 0 || hour > 23) {
							throw new Exception();
						}

						System.out.print("분: ");
						minute = scan.nextInt();
						if (minute < 0 || minute > 59) {
							throw new Exception();
						}

						scan.nextLine();

						System.out.print("내용: ");
						content = scan.nextLine();

						s = new Schedule(year, month, day, hour, minute, content);
						manager.addSchedule(s);

						System.out.println("일정이 추가되었습니다.");
						break;	
					} catch (InputMismatchException e) {
						scan.nextLine();
						System.out.println("잘못된 입력입니다. 처음부터 다시 작성해 주세요.");
						System.out.println();
					} catch (ArrayIndexOutOfBoundsException e) {
						System.out.println("더이상 일정을 추가할 수 없습니다.");
						break;
					} catch (Exception e) {
						// 입력된 날짜가 유효 범위에 해당하지 않을 시 발생
						scan.nextLine();
						System.out.println("입력 범위가 적절하지 않습니다. 처음부터 다시 작성해 주세요.");
						System.out.println();
					}
				}
				break;

			case 2:
				// 삭제할 일정을 입력받고, 해당 일정을 삭제
				System.out.println("추후 구현될 예정입니다.");
				break;

			case 3:
				// 일정 배열 출력
				Schedule[] result = manager.getSchedules();
				if (result.length == 0) {
					System.out.println("일정이 없습니다.");
				}
				else {
					System.out.println("현재 추가된 일정은 다음과 같습니다.");

					for (int i = 0; i < result.length; i++) {
						GregorianCalendar date = result[i].getDate();
						System.out.println();
						System.out.println("[" + date.get(Calendar.YEAR) + "년 " + date.get(Calendar.MONTH) + "월 " + date.get(Calendar.DAY_OF_MONTH) + "일 " + date.get(Calendar.HOUR_OF_DAY) + "시 " + date.get(Calendar.MINUTE) + "분]");
						System.out.println("일정 내용: " + result[i].getContent());
					}
				}
				break;

			case 4:
				// 날짜를 통해 일정을 검색
				System.out.println("추후 구현될 예정입니다.");
				break;

			case 5:
				// 내용을 통해 일정을 검색
				System.out.println("추후 구현될 예정입니다.");
				break;

			case 6:
				// 메뉴 출력
				System.out.println();
				Menu.menu();
				break;

			case 7:
				// 프로그램 종료 안내 출력
				System.out.println("프로그램을 종료합니다.");
				break;

			default:
				// 숫자를 잘못 입력한 경우
				System.out.println("잘못된 입력입니다. 다시 입력해 주세요."); 
				break;
			}

			if (choice == 7)
				break; // 반복문 종료 (프로그램 종료)
		}
	}
}