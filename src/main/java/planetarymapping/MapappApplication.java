/*********************************************************************************/
/**                                                                             **/
/**This file is the driver of the site, DO NOT TOUCH                            **/
/**Thanks to JPA and spring, there isn't much here                              **/
/**                                                                             **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                   **/
/*********************************************************************************/

package planetarymapping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MapappApplication {

    public static void main(String[] args) {
        SpringApplication.run(MapappApplication.class, args);
    }


}
