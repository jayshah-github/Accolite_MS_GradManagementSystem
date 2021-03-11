package com.accolite.msproject;
import com.accolite.msproject.model.Grad;
import com.accolite.msproject.model.Institute;
import com.accolite.msproject.model.Location;
import com.accolite.msproject.model.Skill;
import com.accolite.msproject.repo.GradRepo;
import com.accolite.msproject.repo.InstituteRepo;
import com.accolite.msproject.repo.LocationRepo;
import com.accolite.msproject.repo.SkillRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.filter.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class MsprojectApplication implements CommandLineRunner {

	@Autowired
	GradRepo gradRepo;
	@Autowired
	InstituteRepo instituteRepo;
	@Autowired
	LocationRepo locationRepo;
	@Autowired
	SkillRepo skillRepo;


	public static void main(String[] args) {

		SpringApplication.run(MsprojectApplication.class, args);
	}


	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

	@Override
	public void run(String... args) throws Exception {

		String [] locArray=new String[]{"Mumbai","Delhi","Bangalore","Chennai","Other"};
		String [] instrArray=new String[]{"DJ","KJ","MJ","LJ","Other"};
		String [] skillArray=new String[]{"Java","Angular","Android","Spring","Other"};


		for(int i=0;i<locArray.length;i++){
				if(!locationRepo.existsById(i+1)){
					locationRepo.save(new Location(i+1,locArray[i]));
				}
				if(!instituteRepo.existsById(i+1)){
				instituteRepo.save(new Institute(i+1,instrArray[i]));
				}
				if(!skillRepo.existsById(i+1)){
					skillRepo.save(new Skill(i+1,skillArray[i]));
				}

			}

		int i=0;

		if(!gradRepo.existsById(i+1)) {
			Grad grad = new Grad();
			grad.setId(i+1);
			grad.setLoc(new Location(i+1, locArray[i]));
			grad.setInstitute(new Institute(i+1, instrArray[i]));
			grad.setJoin_loc(new Location(i+1, locArray[i]));
			grad.setContact("9082177574");
			grad.setDescription("desc.....");
			grad.setFeedback("feed...");
			grad.setName("Grad" + i+1);
			grad.setEmail("grad" + i+1 + "@gmail.com");
			grad.setTen_join_date("2021-03-11");
			Set<Skill> skillSet = new HashSet<>();
			skillSet.add(new Skill(i+1, skillArray[i]));
			skillSet.add(new Skill(i+1+ 1, skillArray[i + 1]));
			grad.setSkills(skillSet);
			gradRepo.save(grad);
		}
		}
}
