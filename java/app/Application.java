package app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;


@SpringBootApplication(scanBasePackages={ "com.repositories", "com.classes", "rest.Signup", "zdow.classes", "uploader.classes"})
@ComponentScan(basePackageClasses = rest.api.Authentication.class)
@ComponentScan(basePackageClasses = rest.api.Profile.class)
@EnableMongoRepositories("com.repositories")
@EnableAutoConfiguration
public class Application implements CommandLineRunner{

	public static void main(String[] args) {
		try {
			SpringApplication.run(Application.class, args);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public void run(String... args) throws Exception {
		//Write Code here to executes when application starts running
		System.out.println("********** Project Started Running");
	}

}
