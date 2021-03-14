package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Template {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true)
    private String templateName;

    @Lob
    private String content;

    public String getContent(){
        return content;
    }
}
