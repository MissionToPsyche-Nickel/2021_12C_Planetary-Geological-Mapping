package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Map3d {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Storing page headings and listing title
    private String title;

    //Storing the link generated from arcGIS to display via iFrame
    @Lob
    private String link;

    //Storing the facts to display in the side slider
    @Lob
    private String facts;

    //Storing title to display on the side slider
    private String sliderName;

    //Storing the name of the image to display on the listing
    private String image;

    //Storing the dimension of the map, always 2d
    private String dimension;

    //Default constructor
    public Map3d(){

    }

    //Constructor used for creating a new object with values that aren't default
    public Map3d(String title, String link, String facts, String sliderName, String image){
        this.title = title;
        this.link = link;
        this.facts = facts;
        this.sliderName = sliderName;
        this.image = image;
        this.dimension = "3d";
    }

    //Get methods
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

    //Set methods
    public void setTitle(String title){ this.title = title; }

    public void setLink(String link){
        this.link = link;
    }

    public void setFacts(String facts){ this.facts = facts; }

    public void setImage(String image){ this.image = image; }

    public void setSliderName(String sliderName){
        this.sliderName = sliderName;
    }
}
