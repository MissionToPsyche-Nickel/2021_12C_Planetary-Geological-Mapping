package planetarymapping.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
public class User {

    //Declaring the primary key of User
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate

    private Long id;                                //Variable containing the primary key
    private String userName;                        //Variable containing the user's username
    private String password;
    private int roll;
    private boolean enabled;                        //Variable specifying if the user is enabled or not


    protected User(){    }

    public User(String userName){
        this.userName = userName;
    }

    //Override of toString to make it pretty
    @Override
    public String toString() {
        return String.format("User[id=%d, userName= %s, enabled = %d", id, userName, enabled);
    }

    //Getters for private members
    public Long getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public boolean getType(){
        return enabled;
    }

    //Setters for private members

    public void setPassword(String password){
     this.password = password;
    }

    public void setEnabled(boolean enabled){
        this.enabled = enabled;
    }

    public void setRoll(int roll){
        this.roll = roll;
    }

}
