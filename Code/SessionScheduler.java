import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SessionScheduler {
    private String sender, description, location, sessionTime;
    private List<String> recipients = new ArrayList<String>();

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void git  {
        String answer = "Yes";
        boolean done = false;
        String x;
        do {
            if (answer.equals("Yes")) {
                System.out.print("Enter email:");
                Scanner cs = new Scanner(System.in);
                x = cs.nextLine();
                recipients.add(x);
                cs.close();
            } else {
                done = true;
            }
        } while (!done);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void getDate() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the date (yyyy-MM-dd): ");
        String userInput = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate inputDate = LocalDate.parse(userInput, formatter);
            System.out.println("Parsed Date: " + inputDate);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter the date in the yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTime(String sessionTime) {
        this.sessionTime = sessionTime;
    }

    public void sendEmail() {

    }
}