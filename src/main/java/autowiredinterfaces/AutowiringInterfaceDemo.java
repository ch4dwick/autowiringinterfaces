package autowiredinterfaces;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AutowiringInterfaceDemo {

	public static void main(String[] args) {
		SpringApplication.run(AutowiringInterfaceDemo.class, args);
	}

	/**
	 * Demonstrates that the autowired set is in the registry of beans.
	 * @param ctx
	 * @return
	 */
//	@Bean
//	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
//		return args -> {
//			// Execute all the concrete methods of the Interface.
//			Map<String, Interface> beans = ctx.getBeansOfType(Interface.class);
//			beans.forEach((k,v) -> {
//				System.out.println(k);
//				v.doSomething();
//			});
//			
//			// Load a class programmatically. Refer to unit test for another example.
//			InterfaceLoader loader = ctx.getBean(InterfaceLoader.class);
//			loader.loadClass("ConcreteClass2").doSomething();
//			
//			// Throw an exception.
//			loader.loadClass("ConcreteClass3").doSomething();
//		};
//	}
}
