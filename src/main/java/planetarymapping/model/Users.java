/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for what the users table will look like             **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Users {

    @Id                                             //Setting this variable to be the primary key
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate
    private Long id;                                //Variable containing the primary key
    private String username;                        //Variable containing the user's username
    private String password;                        //Variable containing the user's password
    private boolean enabled;                        //Variable specifying if the user is enabled or not

    //Default constructor
    protected Users(){    }

    //Normal constructor
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
