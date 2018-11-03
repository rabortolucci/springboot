package springbootcourse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import springbootcourse.config.CustomUserDetails;
import springbootcourse.user.User;
import springbootcourse.user.Role;
import springbootcourse.user.UserRepository;

import java.util.Arrays;

@SpringBootApplication
public class CourseApiApp {

    public static void main(String[] args){
        SpringApplication.run(CourseApiApp.class, args);
    }

    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, UserRepository userRepo) throws Exception {
        if(userRepo.count() == 0){
            userRepo.save(new User(
                    "user",
                    "user",
                    Arrays.asList(
                            new Role("USER"),
                            new Role("ACTUATOR"))));
        }

        builder.userDetailsService(s -> new CustomUserDetails(userRepo.findByUsername(s)));
    }

}
