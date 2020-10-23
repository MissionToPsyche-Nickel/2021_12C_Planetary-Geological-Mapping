package planetarymapping.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Entity
public class Users {

    //Declaring the primary key of Users
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate
    private Long id;                                //Variable containing the primary key
    private String username;                        //Variable containing the user's username
    private String password;
    private boolean enabled;                        //Variable specifying if the user is enabled or not


    protected Users(){    }

    public Users(String userName){
        this.username = userName;
    }

    //Override of toString to make it pretty
    @Override
    public String toString() {
        return String.format("Users[id=%d, userName= %s, enabled = %d", id, username, enabled);
    }

    //Getters for private members
    public Long getId(){
        return id;
    }

    public String getUserName(){
        return username;
    }

    public boolean getType(){
        return enabled;
    }

    //Setters for private members
    public void setPassword(String password){
     this.password = password;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

}
