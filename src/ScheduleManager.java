import java.util.GregorianCalendar;

public class ScheduleManager {
	private Schedule[] schedules;
	private int count;

	public ScheduleManager() {
		schedules = new Schedule[100]; // 일정을 최대 100개로 가정
		count = 0; // 일정의 개수를 계산
	}

	// 일정을 추가하는 함수
	public void addSchedule(Schedule s) {
		schedules[count] = s;
		count++;
	}

	// 일정을 삭제하는 함수 (정의)
	public void deleteSchedule(Schedule s) {}

	// 추가되어 있는 일정을 반환하는 함수
	public Schedule[] getSchedules() {
		Schedule[] result = new Schedule[count]; // 현재 추가되어 있는 일정의 개수와 크기가 같은 배열을 선언

		for (int i = 0; i < count; i++) {
			result[i] = schedules[i];
		}

		return result;
	}

	// 날짜를 통해 일정을 검색하는 함수 (정의)
	public Schedule searchByDate(GregorianCalendar date) {
		return null;
	}

	// 내용을 통해 일정을 검색하는 함수 (정의)
	public Schedule[] searchByContent(String content) {
		return null;
	}
}