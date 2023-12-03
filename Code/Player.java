import java.util.ArrayList;
import java.util.List;

public class Player {

    private String Name, Email, Password;

    public Player(String name, String email, String password) {
        this.Name=name;
        this.Email=email;
        this.Password=password;
        this.Characters = new Arraylist();
        this.Sessions = new Arraylist();
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

    public void AddCharacter(CharacterSheet x) {
        Characters.add(x);
    }

    public void AddSession(SessionScheduler x) {
        Sessions.add(x);
    }
}