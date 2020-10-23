package planetarymapping.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserAuthorities {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)  //Setting the key to auto generate

    private Long id;                                //Variable containing the primary key
    private Long user_id;
    private String authority;

    public UserAuthorities(){}

    public UserAuthorities(Long user_id, String authority){
        this.user_id = user_id;
        this.authority = authority;
    }
}
