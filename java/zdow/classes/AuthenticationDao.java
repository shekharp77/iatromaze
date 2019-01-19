package zdow.classes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.classes.Credentials;
import com.repositories.CredentialsRepo;
@Component
public class AuthenticationDao {
	@Autowired
	private CredentialsRepo credentialsrepo;
	
	//Sign in method
	public  boolean signIn(String username, String password) {
		System.out.println(" hi"+ username+" "+password);
		List<Credentials> li = credentialsrepo.findByUsername(username);
		Credentials credentials = li.get(0);
		
		if(li.size() == 0 || li.size() > 1) {
			return false;
		}
		else if(credentials.getPassword().equals(password)) {
			return true;
		}
		return false;
	}
	
	//Signup method
	public boolean signup(String username, String password, String email) {
		try {
			boolean verify = verifyUsername(username);
			
			if(verify)
				credentialsrepo.save(new Credentials(username, password, email));
			else
				return false;
		}catch(Exception ex) {
			return false;
		}
		return true;
	}
	
	//va=erifying username
	public boolean verifyUsername(String username){
		List<Credentials> li=  credentialsrepo.findByUsername(username);
		if(li.size() == 0) {
			System.out.println(li.size());
			return true;
		}
		
		return false;
	}
	
	//va=erifying username
	public boolean verifyEmail(String email){
		List<Credentials> li=  credentialsrepo.findByEmail(email);
		if(li.size() == 0) {
			return true;
		}	
			return false;
	}
}
