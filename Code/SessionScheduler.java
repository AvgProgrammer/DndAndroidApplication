import java.util.ArrayList;
import java.util.List;
import java.time;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SessionScheduler {
    private String sender,description,location,time;
    private List<String> Recipients=new ArrayList<String>();

    public void getSender(String Sender){
        this.sender=Sender;
    }
    public void getRecipents(){
        String answer="Yes";
        bool done=false;
        do{
            System.out.println(x);
            if(answer=="Yes"){
                System.out.print("Enter email:");
                Scanner cs=new Scanner(System.in);
                String x = cs.nextLine();
                Recipients.add(x);
                cs.close();
            }else{
                done=true;
            }
        }
        while(done=false);
    }
    public void getDescription(String Description){
        this.description=Description;
    }
    public void getDate(){
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
    public void getLocation(String Location){
        this.location=Location;
    }
    public void getTime(String Time){
        this.time=Time;
    }
    public void sendEmail(){
        System.out.println("Email was sent");
    }
}
