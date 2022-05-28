package autowiredinterfaces;

import java.util.Map;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutowiringInterfaceDemo {
	private static final Logger LOGGER = Logger.getLogger(AutowiringInterfaceDemo.class.getName());

	public static void main(String[] args) {
		SpringApplication.run(AutowiringInterfaceDemo.class, args);
	}

	/**
	 * Demonstrates that the autowired set is in the registry of beans.
	 * Comment this out if you want to test using JUNIT.
	 * 
	 * @param ctx
	 * @return
	 */
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {
			// Execute all the concrete methods of the Interface.
			Map<String, Interface> beans = ctx.getBeansOfType(Interface.class);
			beans.forEach((k,v) -> {
				LOGGER.log(Level.INFO, "Executing {0}", k);
				v.doSomething();
			});
			
			// Load a class programmatically. Refer to unit test for another example.
			InterfaceLoader loader = ctx.getBean(InterfaceLoader.class);
			LOGGER.log(Level.INFO, "Programmatic loading of ConcreteClass2");
			loader.loadClass("ConcreteClass2").doSomething();
			
			try {
				// Throw an exception.
				LOGGER.log(Level.INFO, "Load non-existent class.");
				loader.loadClass("ConcreteClass3").doSomething();
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, e.getMessage());
			}
		};
	}
}
