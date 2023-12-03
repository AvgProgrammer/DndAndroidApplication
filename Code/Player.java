import java.util.ArrayList;
import java.util.List;

public class Player {

    private String Name, Email, Password;
    private List<CharacterSheet> Characters = new Arraylist();
    private List<SessionScheduler> Sessions = new Arraylist();

    public Player(String Name, String Email, String Password, List<CharacterSheet> Characters,
            List<SessionScheduler> Sessions) {
        Name = Email = Password = "";
        Characters = Sessions = null;
    }

    public boolean isEmpty() {
        return Characters.length();
    }

    public void SetName(String name) {
        this.Name = name;
    }

    public void SetPassword(String Password) {
        this.Password = Password;
    }

    public void SetEmail(String email) {
        this.Email = email;
    }

    public String GetName() {
        return Name;
    }

    public String GetEmail() {
        return Email;
    }

    public String GetPassword() {
        return Password;
    }

    public void AddCharacter(ChraracterSheet x) {
        Characters.add(x);
    }

    public void AddSession(SessionScheduler x) {
        Sessions.add(x);
    }
}