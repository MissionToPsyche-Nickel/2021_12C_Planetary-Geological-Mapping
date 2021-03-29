package planetarymapping.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String userName;

    private String password; //Need to implement using Password Encoder

    public User(){

    }

    public User(String userName, String password){
        this.userName = userName;
        this.password = password;
    }

    public Integer getId(){
        return id;
    }

    public String getUserName(){ return userName; }

    public String getPassword(){
        return password;
    }
}
