import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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
    private Stack<WeekDay> stack1;
    private Stack<WeekDay> stack2;

    public Week() {
        this.stack1 = new Stack<>();
        this.stack2 = new Stack<>();
    }

    public void addDay(WeekDay weekDay) {
        stack1.push(weekDay);
    }

    public void transferBetweenStacks() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

    public Stack<WeekDay> getStack1() {
        return stack1;
    }

    public Stack<WeekDay> getStack2() {
        return stack2;
    }
}

public class CalendarWithStacks {

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
        calendarWeek.transferBetweenStacks();
        Stack<WeekDay> stack2 = calendarWeek.getStack2();

        System.out.println("Day\tDate");
        while (!stack2.isEmpty()) {
            WeekDay weekDay = stack2.pop();
            System.out.println(weekDay.getDay() + "\t" + weekDay.getDate());
        }
    }
}
