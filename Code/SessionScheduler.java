import java.util.ArrayList;
import java.time;
import java.sql.Time;

public class SessionScheduler {
    private String sender,description,location,time;
    private List<String> Recipients=new ArrayList<String>();

    public void getSender(String Sender){
        this.sender=Sender;
    }
    public void getRecipents(){
    }
    public void getDescription(String Description){
        this.description=Description;
    }
    public void getDate(){

    }
    public void getLocation(String Location){
        this.location=Location;
    }
    public void getTime(String Time){
        this.time=Time;
    }
    public void sendEmail(){

    }
}
