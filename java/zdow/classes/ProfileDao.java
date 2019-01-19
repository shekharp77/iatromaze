package zdow.classes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.classes.Achievments;
import com.classes.Careers;
import com.classes.Skills;
import com.classes.User;
import com.repositories.AchieveRepository;
import com.repositories.CareerRepo;
import com.repositories.SkillsRepo;
import com.repositories.UserRepository;

@Component
public class ProfileDao {
	@Autowired
	private UserRepository repository;
	@Autowired
	private SkillsRepo skillsrepo;
	@Autowired
	private CareerRepo careerrepo;
	@Autowired
	private AchieveRepository achievmentrepo;
	
	
	//Methods to save profile user data ---------- return true on success and false on failure
	public boolean saveProfileData( String username, String firstName, String lastName, String email, String city, String state, String country,
			String gender, String dateOfBirth, long phoneNo) {
		try {
				User user = repository.findByUsername(username);
				System.out.println(user);
				if(user.getUsername().equals(username)) {
					repository.deleteByUsername(username);
				}

				repository.save(new User( username, firstName,  lastName,  email,  city,  state,  country,
					 gender,  dateOfBirth,  phoneNo));
				
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}

		return true;
	} 
	
	//Method to get all careers
	public boolean saveCareer(String username, String designation, String startDate, String endDate, String description, String type, String name){
		 careerrepo.save(new Careers( type,  designation,  startDate,  endDate,  description, username, name));
		 return true;
	}
		
	//Method to get all Achievements
	public boolean saveAchievments(String type, String name, String provider, String date, String description, String username){
			achievmentrepo.save(new Achievments( type,  name,  provider,  date,  description,  username));
		return true;
	}
		
	//Method to get all Skills
	public boolean saveSkills(String level, String name, String type, String description, String username){
			skillsrepo.save(new Skills( level,  name,  type,  description,  username));
		return true;
	}
	
//	--------------------------------------------------------------------------------------------------------------------------------------------------
	
	//Method to get all profiles
	public User retrieveProfile(String username){
		Map<String, String> map = new HashMap<String, String>();
		
		 return (User) repository.findByUsername(username);
	}
	
	//Method to get all careers
	public JSONObject retrieveCareer(String username){
		List<Careers> li = (List<Careers>) careerrepo.findByUsername(username);
		 return careerJson(li);
	}
	
	//Method to get all Achievements
	public JSONObject retrieveAchievments(String username){
		List<Achievments> li = (List<Achievments>) achievmentrepo.findByUsername(username);
		 return achievementsJson(li);
	}
	
	//Method to get all Skills
	public JSONObject retrieveSkills(String username){ 
		List<Skills> li = (List<Skills>) skillsrepo.findByUsername(username);
		return skillsJson(li);
	}
	
//	---------------------------------------------------------------------------------------------------------------------------------------------------
	
	public static Map<String, String> listToUserMap(User user) {
		
		Map<String, String> mp = new HashMap<String, String>();
		mp.put("firstname", user.getFirstName());
		mp.put("lastname", user.getLastName());
		mp.put("email", user.getEmail());
		mp.put("phone", user.getPhoneNo()+"");
		mp.put("state", user.getState());
		mp.put("city", user.getCity());
		mp.put("country", user.getCountry());
		mp.put("dob", user.getDateOfBirth());
		mp.put("gender", user.getGender());
		
		return mp;	
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject careerJson(List<Careers> li){
		JSONObject jo = new JSONObject();
	    Collection<JSONObject> items = new ArrayList<JSONObject>();
		Careers careers = null;
		Iterator<Careers> itr = li.iterator();
		 while(itr.hasNext()) {
			 careers =  (Careers) itr.next();
			 
			 JSONObject item1 = new JSONObject();
			 item1.put("type", careers.getType());
			 item1.put("description", careers.getDescription());
			 item1.put("designation", careers.getDesignation());
			 item1.put("startdate", careers.getStartDate());
			 item1.put("enddate", careers.getEndDate());
			 item1.put("name", careers.getName());
			 item1.put("id", careers.getId());
			 items.add(item1);
		 }
		 jo.put("Careers", items);
		return jo;		
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject skillsJson(List<Skills> li) {
		JSONObject jo = new JSONObject();
	    Collection<JSONObject> items = new ArrayList<JSONObject>();
		Skills skills = null;
		Iterator<Skills> itr = li.iterator();
		while(itr.hasNext()) {
			 skills =  (Skills) itr.next();
			 
			 JSONObject item1 = new JSONObject();
			 item1.put("level", skills.getLevel());
			 item1.put("name", skills.getName());
			 item1.put("type", skills.getType());
			 item1.put("description", skills.getDescription());
			 item1.put("id", skills.getId());
			 items.add(item1);
		 }
		jo.put("Skills", items);
		return jo;
	}
	
	@SuppressWarnings("unchecked")
	public static JSONObject achievementsJson(List<Achievments> li) {
		JSONObject jo = new JSONObject();
	    Collection<JSONObject> items = new ArrayList<JSONObject>();
	    Achievments achievments = null;
		Iterator<Achievments> itr = li.iterator();
		while(itr.hasNext()) {
			achievments =  (Achievments) itr.next();
			 
			 JSONObject item1 = new JSONObject();
			 item1.put("date", achievments.getDate());
			 item1.put("description", achievments.getDescription());
			 item1.put("name", achievments.getName());
			 item1.put("provider", achievments.getProvider());
			 item1.put("type", achievments.getType());
			 item1.put("id", achievments.getId());
			 items.add(item1);
		 }
		jo.put("Achievments", items);
		return jo;
	}
	
	//----------------------------------------delete--------------------------------------
	public boolean deleteAchievment(String id) {	
		achievmentrepo.deleteById(id);
		return true;
	}
	public boolean deleteCareer(String id) {	
		careerrepo.deleteById(id);
		return true;
	}
	public boolean deleteSkills(String id) {	
		skillsrepo.deleteById(id);
		return true;
	}
}
