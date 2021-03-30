package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Map2d {

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

    private String dimension;

    public Map2d(){

    }

    public Map2d(String title, String link, String facts, String sliderName, String image){
        this.id = id;
        this.title = title;
        this.link = link;
        this.facts = facts;
        this.sliderName = sliderName;
        this.image = image;
        this.dimension = "2d";
    }

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

    public String getDimension(){ return dimension; }
}
