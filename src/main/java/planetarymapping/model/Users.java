package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;

    private String password; //Need to implement using Password Encoder

    private String role;

    int enabled;

    public Users(){

    }

    public Users(String username, String password){
        this.username = username;
        this.password = password;
        this.role = "ROLE_ADMIN";
        this.enabled = 1;
    }

    public Integer getId(){
        return id;
    }

    public String getUserName(){ return username; }

    public String getPassword(){
        return password;
    }

    public String getRole(){ return role; }

    public int getEnabled(){
        return enabled;
    }

    public void setUserName(String username){ this.username = username;  }

    public void setPassword(String password){ this.password = password; }
}
