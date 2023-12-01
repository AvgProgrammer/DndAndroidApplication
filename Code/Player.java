import java.util.ArrayList;
import java.util.List;

public class Player {
    private String Name,Email,Code;
    private list<CharacterSheet> Characters=new Arraylist();
    private List<SessionScheduler> Sessions=new Arraylist();
    
    public void SetName(String name){
        this.Name=name;
    }
    public void SetCode(String code){
        this.Code=code;
    }
    public void SetEmail(String email){
        this.Email=email;
    }

    public String GetName(){
        return Name;
    }
    public String GetEmail(){
        return Email;
    }
    public String GetNCode(){
        return Code;
    }

    public void AddCharacter(ChraracterSheet x){
        Characters.add(x);
    }
    public void AddSession(SessionScheduler x){
        Sessions.add(x);
    }
}

