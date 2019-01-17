package rest.api;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.classes.User;
import com.fasterxml.jackson.annotation.JsonView;

import ch.qos.logback.core.net.SyslogOutputStream;
import zdow.classes.AuthenticationDao;

@RestController
public class Authentication {
	@Autowired
	AuthenticationDao authenticationdao;
	
	//retrieveProfile API Url
			@CrossOrigin
			@JsonView(User.class)
			@RequestMapping(value ="/signin", method = RequestMethod.POST, produces = "application/json")
			public boolean sign(
					@RequestParam("username") String username,
					@RequestParam("password") String password
					) {
				System.out.println("credentials "+username+" "+password);
				return authenticationdao.signIn(username, password);
			}
			
	//retrieveProfile API Url
			@CrossOrigin
			@JsonView(User.class)
			@RequestMapping(value ="/signup", method = RequestMethod.POST, produces = "application/json")
			public boolean signup(
					@RequestParam("username") String username,
					@RequestParam("password") String password,
					@RequestParam("email") String email
					) {
				return authenticationdao.signup(username, password, email);
			}
			
	//retrieveProfile API Url
			@CrossOrigin
			@JsonView(User.class)
			@RequestMapping(value ="/verifyusername", method = RequestMethod.POST, produces = "application/json")
			public boolean verifyUsername(
					@RequestParam("username") String username
					) {
				return authenticationdao.verifyUsername(username);
			}
			
	//retrieveProfile API Url
	@CrossOrigin
	@JsonView(User.class)
	@RequestMapping(value ="/verifyemail", method = RequestMethod.POST, produces = "application/json")
	public boolean verifyEmail(
			@RequestParam("email") String email
			) {
		return authenticationdao.verifyEmail(email);
	}
}
