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
    * The default port for localhost is 8080, you can change the settings of this site to use the default by adjusting server.port=9090
      * EX. server.port=8080
    
  * Testing the first page
    * First thing is to run the program
    * Second thing is open a webbrowser
    * Finally go to http://localhost:YOUR-PORT-NUMBER/
    * If you use port 8080 you do not need to specify your port number
