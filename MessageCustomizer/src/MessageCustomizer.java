import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageCustomizer {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input message
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();

        // Replace placeholders using regular expressions
        String customizedMessage = customizeMessage(message);

        // Print the modified message
        System.out.println("Modified Message:");
        System.out.println(customizedMessage);

        scanner.close();
    }

    private static String customizeMessage(String message) {
        // Replace <<name>> with first name (assuming you are the user)
        String firstName = "John"; // Replace with the actual first name
        message = message.replaceAll("<<name>>", firstName);

        // Replace <<full name>> with user full name
        String fullName = "John Doe"; // Replace with the actual full name
        message = message.replaceAll("<<full name>>", fullName);

        // Replace mobile number (assuming it's in the format 91-xxxxxxxxxx)
        String phoneNumber = "91-9876543210"; // Replace with the actual contact number
        message = message.replaceAll("91-xxxxxxxxxx", phoneNumber);

        // Replace date in the format XX/XX/XXXX with current date
        String currentDate = getCurrentDate();
        message = message.replaceAll("\\d{2}/\\d{2}/\\d{4}", currentDate);

        return message;
    }

    private static String getCurrentDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(new Date());
    }
}
