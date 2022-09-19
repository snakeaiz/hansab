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
	public CommandLineRunner init(UserService userRepository, CarService carRepository) {
		return args -> {

			userRepository.save(new User(1L,"Tim Kukk")); // 1
			userRepository.save(new User(2L,"Martin Varblane"));
			userRepository.save(new User(3L,"Martin Allikvee"));
			userRepository.save(new User(4L,"Karl Gustaf"));
			userRepository.save(new User(5L,"Jaan Poska"));
			userRepository.save(new User("Kristina Kuzin"));
			userRepository.save(new User("Margo Allikvee"));
			userRepository.save(new User("Karl Allik"));
			userRepository.save(new User("Kiril Manniste"));
			userRepository.save(new User("Pavel Sulga")); // 10


			carRepository.save(new Car(1L,"Mazda","Rx-8","123FGH",new User(1L,"Tim Kukk"))); // 1
			carRepository.save(new Car(2L,"BMW","M6","653ARD",new User(1L,"Tim Kukk")));
			carRepository.save(new Car(3L,"BMW","760Li","777FFF",new User(2L,"Martin Varblane")));
			carRepository.save(new Car(4L,"BMW","330XD","999FFF",new User(2L,"Martin Varblane")));
			carRepository.save(new Car(5L,"Audi","A8","444MMM",new User(3L,"Martin Allikvee"))); //5
			carRepository.save(new Car(6L,"Audi","A4","789ABC",new User(4L,"Karl Gustaf")));
			carRepository.save(new Car(7L,"BMW","M4","321TRY",new User(5L,"Jaan Poska")));
			carRepository.save(new Car(8L,"BMW","M3","321TRE",new User(6L,"Kristina Kuzin")));
			carRepository.save(new Car(9L,"BMW","M4","444GGG",new User(6L,"Kristina Kuzin")));
			carRepository.save(new Car(10L,"Lamborgini","Hurricane","581NET",new User(7L,"Margo Allikvee")));
			carRepository.save(new Car(11L,"Bentley","Continental","744DAT",new User(8L,"Karl Allik")));
			carRepository.save(new Car(12L,"Audi","Q7","215BAU",new User(9L,"Kiril Manniste")));
			carRepository.save(new Car(13L,"BMW","530XD","400BFX",new User(10L,"Pavel Sulga")));
			carRepository.save(new Car(14L,"BMW","M3","892BHP",new User(10L,"Pavel Sulga"))); //14

		};
	}
}
