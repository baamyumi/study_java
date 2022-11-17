package ch16;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class CalendarTest {

	public static void main(String[] args) {
		
		/***
		 *  GregorianCalendar
		 */
		GregorianCalendar today = new GregorianCalendar();
		System.out.printf("%d년 %d월 %d일 %s %d시 %d분 %d초",
				today.get(Calendar.YEAR),
				today.get(Calendar.MONTH) + 1,
				today.get(Calendar.DATE),
				today.get(Calendar.AM_PM) == Calendar.AM ? "오전":"오후",
				today.get(Calendar.HOUR),
				today.get(Calendar.MINUTE),
				today.get(Calendar.SECOND)
				);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 M월 d일 a hh:mm:ss");
		String result = sdf.format(today.getTime());
		System.out.println(result);
		
		/* 날짜간의 연산 메서드 add(자리넘침 처리), roll(자리넘침 처리 X 지정한 요소만 증감) */
		today.add(Calendar.DATE, 100);
		System.out.printf("100일 후는 %d월 %d일 입니다.\n",
				today.get(Calendar.MONTH) + 1,
				today.get(Calendar.DATE)
				);
		
		/* 두 날짜 사이의 간격 : 라이브러리가 지원하지 않아서 직접 연산해야함. */
		GregorianCalendar birth = new GregorianCalendar(1993,1,6);
		long diff = today.getTimeInMillis() - birth.getTimeInMillis();
		long days = diff / (24 * 60 * 60 * 1000);
		System.out.println("오늘은 태어난지 " + days + "일째");
		
		
		/***
		 * LocaDate, LocalTime
		 */
		
		LocalDate ltoday = LocalDate.now();
		LocalTime now = LocalTime.now();
		System.out.printf("%d년 %d월 %d일 %d시 %d분 %d초\n",
				ltoday.getYear(),
				ltoday.getMonthValue(),
				ltoday.getDayOfMonth(),
				now.getHour(),
				now.getMinute(),
				now.getSecond()
				);
		
		/* plusDays, minusDays, plusMinutes, minusMinutes */
		LocalDate after100 = ltoday.plusDays(100);
		System.out.printf("100일 후는 %d월 %d일 입니다.\n",
				after100.getMonthValue() + 1,
				after100.getDayOfMonth()
				);
	}

}
