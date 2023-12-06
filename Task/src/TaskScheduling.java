import java.util.Arrays;
import java.util.Scanner;

public class TaskScheduling {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of tasks: ");
        int T = scanner.nextInt();

        Task[] tasks = new Task[T];

        // Input the tasks
        for (int i = 0; i < T; i++) {
            System.out.print("Enter the deadline and minutes for task " + (i + 1) + ": ");
            int deadline = scanner.nextInt();
            int minutes = scanner.nextInt();
            tasks[i] = new Task(deadline, minutes);
        }

        // Sort tasks in decreasing order of deadline
        Arrays.sort(tasks, (a, b) -> Integer.compare(b.deadline, a.deadline));

        // Calculate and print the maximum overshoot for each task
        System.out.println("Maximum overshoot for each task:");

        for (int i = 0; i < T; i++) {
            int overshoot = calculateOvershoot(tasks, i);
            System.out.println(overshoot);
        }

        scanner.close();
    }

    private static int calculateOvershoot(Task[] tasks, int index) {
        int totalMinutes = 0;
        int maxOvershoot = 0;

        for (int i = 0; i <= index; i++) {
            totalMinutes += tasks[i].minutes;
            int overshoot = Math.max(0, totalMinutes - tasks[i].deadline);
            maxOvershoot = Math.max(maxOvershoot, overshoot);
        }

        return maxOvershoot;
    }
}