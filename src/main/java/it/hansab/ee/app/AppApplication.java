package it.hansab.ee.app;

import it.hansab.ee.app.model.Car;
import it.hansab.ee.app.model.User;
import it.hansab.ee.app.repository.CarRepository;
import it.hansab.ee.app.repository.UserRepository;
import it.hansab.ee.app.service.CarService;
import it.hansab.ee.app.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AppApplication {

	UserService u;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Bean
	public CommandLineRunner init(UserService userService, CarService carService) {
		return args -> {

			userService.save(new User(1L,"Tim Kukk")); // 1
			userService.save(new User(2L,"Martin Varblane"));
			userService.save(new User(3L,"Martin Allikvee"));
			userService.save(new User(4L,"Karl Gustaf"));
			userService.save(new User(5L,"Jaan Poska"));
			userService.save(new User("Kristina Kuzin"));
			userService.save(new User("Margo Allikvee"));
			userService.save(new User("Karl Allik"));
			userService.save(new User("Kiril Manniste"));
			userService.save(new User("Pavel Sulga")); // 10


			carService.save(new Car(1L,"Mazda","Rx-8","123FGH",new User(1L,"Tim Kukk"))); // 1
			carService.save(new Car(2L,"BMW","M6","653ARD",new User(1L,"Tim Kukk")));
			carService.save(new Car(3L,"BMW","760Li","777FFF",new User(2L,"Martin Varblane")));
			carService.save(new Car(4L,"BMW","330XD","999FFF",new User(2L,"Martin Varblane")));
			carService.save(new Car(5L,"Audi","A8","444MMM",new User(3L,"Martin Allikvee"))); //5
			carService.save(new Car(6L,"Audi","A4","789ABC",new User(4L,"Karl Gustaf")));
			carService.save(new Car(7L,"BMW","M4","321TRY",new User(5L,"Jaan Poska")));
			carService.save(new Car(8L,"BMW","M3","321TRE",new User(6L,"Kristina Kuzin")));
			carService.save(new Car(9L,"BMW","M4","444GGG",new User(6L,"Kristina Kuzin")));
			carService.save(new Car(10L,"Lamborgini","Hurricane","581NET",new User(7L,"Margo Allikvee")));
			carService.save(new Car(11L,"Bentley","Continental","744DAT",new User(8L,"Karl Allik")));
			carService.save(new Car(12L,"Audi","Q7","215BAU",new User(9L,"Kiril Manniste")));
			carService.save(new Car(13L,"BMW","530XD","400BFX",new User(10L,"Pavel Sulga")));
			carService.save(new Car(14L,"BMW","M3","892BHP",new User(10L,"Pavel Sulga"))); //14

		};
	}
}
