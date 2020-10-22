# THIS IS STILL BROKEN, DO NOT USE!!!! USE MASTER BRANCH INSTEAD!!!
## PSU_Project-Psyche_Planetary_Mapping
* Setup
  * Attaching a data base
  
    * So we are using MySQL so first step make sure you install all of that stuff
    * Next step you'll need to create a connection and schema
    * Go into src-> main-> resources-> application.properties
    * You will need to change the spring.datasource.url= to your url, the last bit will be the only thing that changes if you keep default settings for setup of MySQL
      * EX. jdbc:mysql://localhost:3306/(YOUR SCHEMA NAME HERE)
    * Next you will need to change the spring.datasource.username= to the username you created
      * EX. spring.datasource.username=(YOUR USERNAME HERE)
    * Finally, you will need to change the spring.datasource.password= to the password you created
      * EX. spring.datasource.password=(YOUR PASSWORD HERE)
    
  * Testing the first page
    * First thing is to run the program
    * Second thing is open a webbrowser
    * Finally go to http://localhost:9090/planetarymap/user/hello
    * You should see some text that says "Hello There!"
  
* What she do
  * So you should be able to hit a few pages that all begin with http://localhost:9090/planetarymap/user
  * You should be able to see /hello and /list/{id} from a webbrowser
    * {id} needs to be an existing id in the database or you'll get a /error which is just cover for server 404
  * The if you send a POST request to http://localhost:9090/planetarymap/user/add with the params String userName, String password, int type you can add a user
    * This only works with a POST
  
