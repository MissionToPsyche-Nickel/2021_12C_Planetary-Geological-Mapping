package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Map3d {

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

    public Map3d(){

    }

    public Map3d(String title, String link, String facts, String sliderName, String image){
        this.id = id;
        this.title = title;
        this.link = link;
        this.facts = facts;
        this.sliderName = sliderName;
        this.image = image;
        this.dimension = "3d";
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

    public void setTitle(String title){ this.title = title; }

    public void setLink(String link){
        this.link = link;
    }

    public void setFacts(String facts){ this.facts = facts; }

    public void setImage(String image){ this.image = image; }

    public void setSliderName(String sliderName){
        this.sliderName = sliderName;
    }

    public void setDimension(String dimension){ this.dimension = dimension; }
}
