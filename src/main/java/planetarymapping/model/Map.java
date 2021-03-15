package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;

    @Lob
    private String link;

    @Lob
    private String facts;

    private String sliderName;

    private String image;

    public Integer getId(){
        return id;
    }

    public String getTitle(){ return title; }

    public String getLink(){
        return link;
    }

    public String getFacts(){
        return facts;
    }

    public String getImage(){
        return image;
    }

    public String getSliderName(){
        return sliderName;
    }
}
