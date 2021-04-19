package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Users {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Storing the username for auth
    private String username;

    //Storing the passowrd for auth
    private String password;

    //Storing the user role for auth, always ROLE_ADMIN since we only have one authed user group
    private String role;

    //Storing a way to disable and enable users, NEED TO IMPLEMENT ON FRONT END
    int enabled;

    //Default Constructor
    public Users(){

    }

    //Constructor to use for non-default values
    public Users(String username, String password){
        this.username = username;
        this.password = password;
        this.role = "ROLE_ADMIN";
        this.enabled = 1;
    }

    //Get methods
    public Integer getId(){
        return id;
    }

    public String getUserName(){ return username; }

    public String getPassword(){
        return password;
    }

    public String getRole(){ return role; }

    public int getEnabled(){ return enabled; }

    //Set methods
    public void setUserName(String username){ this.username = username;  }

    public void setPassword(String password){ this.password = password; }
}
