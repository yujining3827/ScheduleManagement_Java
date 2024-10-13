import java.util.GregorianCalendar;

public class Schedule {
	private GregorianCalendar date; // 일정의 날짜와 시간을 저장
	private String content; // 일정의 내용을 저장

	public Schedule(int year, int month, int day, int hour, int minute, String content) {
		this.date = new GregorianCalendar(year, month, day, hour, minute);
		this.content = content;
	}

	public GregorianCalendar getDate() {
		return date;
	}

	public String getContent() {
		return content;
	}
}