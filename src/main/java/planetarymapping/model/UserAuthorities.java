/*********************************************************************************/
/**                                                                             **/
/**This file is responsible for what the user_authorities table will look like  **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAuthorities {
    @Id                                             //Setting this variable to be the primary key
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate
    private Long id;                                //Variable containing the primary key
    private Long user_id;                           //Variable containing the user's id (foreign key)
    private String authority;                       //Variable containing the user's roll

    //Default constructor
    public UserAuthorities(){}

    //Normal constructor
    public UserAuthorities(Long user_id, String authority){
        this.user_id = user_id;
        this.authority = authority;
    }
}
