package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Slide {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String image;

    private String title;

    private String caption;

    public Slide(){
        this.title = null;
        this.caption = null;
        this.image = null;
    }

    public Slide(String title, String caption, String image){
        this.title = title;
        this.caption = caption;
        this.image = image;
    }

    public Slide(Integer id, String title, String caption, String image){
        this.id=id;
        this.title = title;
        this.caption = caption;
        this.image = image;
    }

    public Integer getId(){
        return id;
    }

    public String getImage(){
        return image;
    }

    public String getTitle(){ return title; }

    public String getCaption(){
        return caption;
    }
}
