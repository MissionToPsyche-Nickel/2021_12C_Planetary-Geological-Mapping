package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Accordion {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Storing the H2 heading to display
    private String title;

    //Storing the facts to display
    @Lob
    private String paragraph;

    //Default constructor
    public Accordion(){

    }

    //Constructor used for creating a new object with values that aren't default
    public Accordion(String title, String paragraph){
        this.title = title;
        this.paragraph = paragraph;
    }

    //Get methods
    public Integer getId(){
        return id;
    }

    public String getTitle(){ return title; }

    public String getParagraph(){
        return paragraph;
    }

    //Set methods
    public void setTitle(String title){ this.title = title; }

    public void setParagraph(String paragraph){ this.paragraph = paragraph; }
}
