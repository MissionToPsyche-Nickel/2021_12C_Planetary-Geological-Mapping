/*************************************************************************************/
/**                                                                                 **/
/**This file is responsible for the configuration of the site's security.           **/
/**It dictates which parts of the sites the user needs to be authenticated to use.  **/
/**It also dictates where and how it gets the user data.                            **/
/**                                                                                 **/
/** Last modified 10/23/2020  by James Lanham jrl5748@psu.edu                       **/
/*************************************************************************************/

package planetarymapping.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //Injecting the dataSource Bean
    @Autowired
    private DataSource dataSource;

    //Configuring how and where the user data comes from
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery(
                        "SELECT u.username, a.authority " +
                                "FROM user_authorities a, Users u " +
                                "WHERE u.username = ? " +
                                "AND u.id = a.user_id"
                );
    }

    //Creating the bean for the password encoder
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Securing or allowing different parts of the site to be available
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/home", "/register", "/error", "/map/*", "/Moon.svg", "/Mars.svg").permitAll() //Allows these parts to be open
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //Defining the login page
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

}
