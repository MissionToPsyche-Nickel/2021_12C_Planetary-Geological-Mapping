package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Accordion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Lob
    private String paragraph;

    public Accordion(){

    }

    public Accordion(String title, String paragraph){
        this.title = title;
        this.paragraph = paragraph;
    }

    public Integer getId(){
        return id;
    }

    public String getTitle(){ return title; }

    public String getParagraph(){
        return paragraph;
    }

    public void setTitle(String title){ this.title = title; }

    public void setParagraph(String paragraph){ this.paragraph = paragraph; }
}
