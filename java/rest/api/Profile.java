package rest.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.classes.Achievments;
import com.classes.Careers;
import com.classes.Skills;
import com.classes.User;
import com.fasterxml.jackson.annotation.JsonView;

import zdow.classes.ProfileDao;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
@RestController
public class Profile {
	@Autowired
	private  ProfileDao dao;
	String result;
	
	
	
	//saveprofile API Url
	@CrossOrigin
	@JsonView(User.class)
	@RequestMapping(value ="/saveprofile", method = RequestMethod.GET, produces = "application/json")
	public String saveProfile(
				@RequestParam("firstname") String firstName,
				@RequestParam("lastname") String lastName,
				@RequestParam("emailid") String emailID,
				@RequestParam("phoneno") long phoneNo,
				@RequestParam("city") String city,
				@RequestParam("state") String state,
				@RequestParam("country") String country,
				@RequestParam("dateofbirth") String dateofBirth,
				@RequestParam("gender") String gender,
				@RequestParam("username") String username
			) {
		
		boolean dataSaver = dao.saveProfileData(username, firstName,  lastName,  emailID,  city,  state,  country,
				 gender,  dateofBirth,  phoneNo);
	
		
		if(dataSaver) {
			
		    return "Done";
		}
		else {
			 return "Error";
		}			
	}
	
	//save achievement API Url
	@CrossOrigin
	@JsonView(Achievments.class)
	@RequestMapping(value ="/saveAchievement", method = RequestMethod.GET, produces = "application/json")
	public boolean saveAchievement(
			@RequestParam("username") String username,
			@RequestParam("type") String type,
			@RequestParam("name") String name,
			@RequestParam("provider") String provider,
			@RequestParam("date") String date,
			@RequestParam("description") String description
			) {
		return dao.saveAchievments( type,  name,  provider,  date,  description,  username);
	}
	
	//save achievement API Url
	@CrossOrigin
	@JsonView(Skills.class)
	@RequestMapping(value ="/saveSkills", method = RequestMethod.GET, produces = "application/json")
	public boolean saveSkills(
			@RequestParam("username") String username,
			@RequestParam("level") String level,
			@RequestParam("type") String type,
			@RequestParam("name") String name,
			@RequestParam("description") String description
			) {
		return dao.saveSkills( level,  name,  type,  description,  username);
	}
	
	//save achievement API Url
	@CrossOrigin
	@JsonView(Careers.class)
	@RequestMapping(value ="/saveCareer", method = RequestMethod.GET, produces = "application/json")
	public boolean saveCareer(
			@RequestParam("username") String username,
			@RequestParam("designation") String designation,
			@RequestParam("startDate") String startDate,
			@RequestParam("endDate") String endDate,
			@RequestParam("type") String type,
			@RequestParam("description") String description,
			@RequestParam("name") String name
			) {
		return dao.saveCareer( username,  designation,  startDate,  endDate,  description,  type, name);
	}
	
	
//	--------------------------------------------------------------------------------------------------------------------------------
	
	//retrieveProfile API Url
		@SuppressWarnings("unchecked")
		@CrossOrigin
		@JsonView(Achievments.class)
		@RequestMapping(value ="/retrieveProfile", method = RequestMethod.GET, produces = "application/json")
		public JSONObject retrieveProfile(
				@RequestParam("username") String username
				) {
			User user = dao.retrieveProfile(username);
			Map<String,String> mp = ProfileDao.listToUserMap(user);
			JSONObject jo = new JSONObject();
			jo.putAll(mp);
			return jo;
		}
		
	// retrieveCareer API Url
		@CrossOrigin
		@JsonView(User.class)
		@RequestMapping(value ="/retrieveCareer", method = RequestMethod.GET, produces = "application/json")
		public JSONObject retrieveCareer(
				@RequestParam("username") String username
				) {
			return (JSONObject) dao.retrieveCareer(username);
		}
		
	// retrieveAchievment API url
		@CrossOrigin
		@JsonView(User.class)
		@RequestMapping(value ="/retrieveAchievments", method = RequestMethod.GET, produces = "application/json")
		public JSONObject retrieveAchievment(
				@RequestParam("username") String username
				) {
			return dao.retrieveAchievments(username);
		}
		
		//retrieveSkills API Url
		@CrossOrigin
		@JsonView(User.class)
		@RequestMapping(value ="/retrieveSkills", method = RequestMethod.GET, produces = "application/json")
		public JSONObject retrieveSkills(
				@RequestParam("username") String username
				) {
			return dao.retrieveSkills(username);
		}
//		-----------------------------------------------------------delete---------------------------------------
		//deleteSkills API Url
		@CrossOrigin
		@JsonView(Skills.class)
		@RequestMapping(value ="/deleteSkill", method = RequestMethod.GET, produces = "application/json")
		public boolean deleteSkill(
				@RequestParam("id") String id
				) {
			return dao.deleteSkills(id);
		}
		//deleteSkills API Url
		@CrossOrigin
		@JsonView(Careers.class)
		@RequestMapping(value ="/deleteCareer", method = RequestMethod.GET, produces = "application/json")
		public boolean deleteCareer(
				@RequestParam("id") String id
				) {
			return dao.deleteCareer(id);
		}
		//deleteSkills API Url
		@CrossOrigin
		@JsonView(Achievments.class)
		@RequestMapping(value ="/deleteAchievment", method = RequestMethod.GET, produces = "application/json")
		public boolean deleteAchievment(
				@RequestParam("id") String id
				) {
			return dao.deleteAchievment(id);
		}
//		-------------------------------uploader--------
		private static String UPLOADED_FOLDER = "C:\\Users\\shekh\\Documents\\eclipse-workspace\\demo-2\\resources";
		@CrossOrigin // //new annotation since 4.3
	    @RequestMapping(value ="/upload", method = RequestMethod.POST)
	    public String singleFileUpload(@RequestParam("file") MultipartFile file,
	                                   RedirectAttributes redirectAttributes) {

	        if (file.isEmpty()) {
	            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
	            return "redirect:uploadStatus";
	        }

	        try {

	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);
	            System.out.println("Uploaded");
	            redirectAttributes.addFlashAttribute("message",
	                    "You successfully uploaded '" + file.getOriginalFilename() + "'");

	        } catch (Exception e) {
	            e.printStackTrace();
	            return "error";
	        }

	        return "uploaded";
	    }
}
