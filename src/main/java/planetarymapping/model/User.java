package planetarymapping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    //Declaring the primary key of User
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate

    private Long id;                                //Variable containing the primary key
    private String userName;                        //Variable containing the user's username
    private String password;                        //Variable containing the user's password
    private int type;                               //Variable containing the user type, base or authorized

    protected User(){    }

    public User(String userName, String password, int type){
        this.userName = userName;
        this.password = password;
        this.type = type;
    }

    //Override of toString to make it pretty
    @Override
    public String toString() {
        return String.format("User[id=%d, userName= %s, type= %d", id, userName, type);
    }

    //Getters for private members
    public Long getId(){
        return id;
    }

    public String getUserName(){
        return userName;
    }

    public String getPassword(){
        return password;
    }

    public int getType(){
        return type;
    }

    //Setters for private members
    public void setPassword(String password){
     this.password = password;
    }

    public void setType(int type){
        this.type = type;
    }
}
