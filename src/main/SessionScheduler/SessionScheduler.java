package SessionScheduler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    public String sendEmail(){
        String message="From:"+sender+"\n";
        String x="";
        for(int i=0;i<Recipients.size();i++){
            if(i==0){
                x= Recipients.get(i);
            }else{
                x=x+","+Recipients.get(i);
            }
        }
        message=message+"To:"+x+"\n";
        message=message+"Date:"+Date+"\n";
        message=message+"Time:"+time+"\n";
        message=message+"Location:"+location+"\n";
        message=message+description;
        return message;
    }
}
