import java.util.LinkedList;
import java.util.Queue;

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

class Week {
    private Queue<WeekDay> weekDays;

    public Week() {
        this.weekDays = new LinkedList<>();
    }

    public void addDay(WeekDay weekDay) {
        weekDays.add(weekDay);
    }

    public Queue<WeekDay> getWeekDays() {
        return weekDays;
    }
}

public class CalendarWithQueue {

    public static void main(String[] args) {
        Week calendarWeek = createCalendarWeek();
        displayCalendar(calendarWeek);
    }

    private static Week createCalendarWeek() {
        Week calendarWeek = new Week();

        String[] daysOfWeek = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        String[] datesOfMonth = {"1", "2", "3", "4", "5", "6", "7"};

        for (int i = 0; i < daysOfWeek.length; i++) {
            String day = daysOfWeek[i];
            String date = (i < datesOfMonth.length) ? datesOfMonth[i] : "";
            WeekDay weekDay = new WeekDay(day, date);
            calendarWeek.addDay(weekDay);
        }

        return calendarWeek;
    }

    private static void displayCalendar(Week calendarWeek) {
        Queue<WeekDay> weekDays = calendarWeek.getWeekDays();

        System.out.println("Day\tDate");
        for (WeekDay weekDay : weekDays) {
            System.out.println(weekDay.getDay() + "\t" + weekDay.getDate());
        }
    }
}
