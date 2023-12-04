import java.util.ArrayList;
import java.util.List;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class SessionScheduler {
    private String sender,description,location,time;
    private List<String> Recipients;
    private LocalDate Date;

    public SessionScheduler(){
        this.sender="";
        this.description="";
        this.location="";
        this.time="";
        this.Recipients=new ArrayList<String>();
    }
    public void setSender(String Sender){
        this.sender=Sender;
    }
    public void setRecipents(List<String> Emails){
        Recipients=Emails;
    }
    public void setDescription(String Description){
        this.description=Description;
    }
    public void setDate(LocalDate date){
        this.Date=date;
    }
    public void setLocation(String Location){
        this.location=Location;
    }
    public void setTime(String Time){
        this.time=Time;
    }
    public void sendEmail(){
        System.out.println("Email was sent");
    }
}