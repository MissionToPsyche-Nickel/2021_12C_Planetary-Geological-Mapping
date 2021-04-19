package planetarymapping.model;

import javax.persistence.*;

@Entity
public class Slide {

    //Primary Key
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //Storing the image name of the background image
    private String image;

    //Storing the title of the slide
    private String title;

    //Storing the facts to display
    private String caption;

    //Default Constructor
    public Slide(){

    }

    //Constructor used for creating object without default values
    public Slide(String title, String caption, String image){
        this.title = title;
        this.caption = caption;
        this.image = image;
    }

    //Get methods
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

    //Set methods
    public void setImage(String image){ this.image = image; }

    public void setTitle(String title){ this.title = title; }

    public void setCaption(String caption){ this.caption = caption; }
}
